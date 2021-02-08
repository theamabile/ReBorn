
class AnimalList extends React.Component {
	
	constructor() {
		super();

		this.page = 1;
		this.field = "";
		this.query = "";
		
		let offset = (this.page-1)%5;	// 현재 페이지 기준으로 스코프 첫번째 넘버인 startNum과의 차이를 알아냄
		this.startNum = this.page - offset;	// 1보다 클 경우에는 앞으로 갈 수 있따
		this.pageCount = 0;
		
		this.state = {
			list: [],
			pageCount: 0
		}
	}
	
	componentDidMount() {
		//console.log("componentDidMount");
		this.invalidate();		// 처음에 로드 해야함
	}
	
	pageClickHandler(e) {
		e.preventDefault();	
				
		this.page = e.target.innerText;		
		this.invalidate();
	}
	
	
	invalidate() {
		console.log(`url : /api/animal/list?p=${this.page}&s=10`);
		fetch(`/api/animal/list?p=${this.page}&s=10`)
		.then(response=>{
			return response.json();
		})
		.then(data=>{
			console.log(data);
			
			// 페이지 바뀌었으니 
			let offset = (this.page-1)%5;
			this.startNum = this.page - offset;

			this.setState(data);
		});
	}
	
	
	
	render() {
		return <section className="container-item">
					<h1>유기동물 목록</h1>
					<section>
						<h1 className="d-none">회원 목록</h1>
						<table>
							<thead>
								<tr>
									<th className="table-width-m">유기번호</th>
									<th className="table-width-m">공고번호</th>
									<th className="table-width-m">접수일</th>
									<th className="table-width-s">축종 코드</th>
									<th className="table-width-s">품종 코드</th>
									<th className="table-width-m">발견장소</th>
									<th className="table-width-m">공고시작일</th>
									<th className="table-width-m">공고종료일</th>
								</tr>
							</thead>
							<tbody className="table-body">
								{
									this.state.list.map(
										a=><tr key={a.desertionNo}>
												<td>{a.desertionNo}</td>
												<td>{a.noticeNo}</td>
												<td>{a.happenDt}</td>
												<td>{a.kindCd}</td>
												<td>{a.upKindCd}</td>
												<td>{a.happenPlace}</td>
												<td>{a.noticeSdt}</td>
												<td>{a.noticeEdt}</td>
											</tr>
									)									
								}
							</tbody>
						</table>
		
		
						<div className="pager-common mt30">
							<div className="pager">
								<div className="prev mr15">    
									{ 
										this.startNum==1 ?
										<span className="btn btn-prev" onClick={()=>{new ModalBox({content:"이전 페이지가 없습니다.", cancelBtnHide: true})}} >이전</span>  											
										:
										<a className="btn btn-prev" href="p=${startNum-5}&of=${param.of}&oq=${param.oq}&f=${param.f}&q=${param.q}"></a>
									}    			                    
					            </div>
								<ul className="btn-center" onClick={this.pageClickHandler.bind(this)}>		
									{
										[0,1,2,3,4].map(
											i=>	this.startNum+i <= this.state.pageCount &&
												<li key={this.startNum+i} className={ this.page==this.startNum+i ? "current" : ""}>
													<a className="bold ">{this.startNum+i}</a>
												</li>
										)
									}		
								</ul>
								<div className="next">
									{ 
										this.startNum+5 > this.state.pageCount ?
										<span className="btn btn-next" onClick={()=>{new ModalBox({content:"다음 페이지가 없습니다.", cancelBtnHide: true})}} >다음 </span>             
										:
					            		<a className="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.p}&v=${param.v}"></a>  
									}          	
					            </div>
							</div>
						</div>	
						
					</section>	
				</section>;
		
		
		/*<tr>
			<td colspan="9">'${query}'에 대한 검색 결과가 없습니다.</td>
		</tr>
		
		
		<div className="pager">
							<div className="pager-btn prevScopeBtn">    
							{ 
								this.startNum==1 ?
								<span className="btn btn-prev" onClick={()=>{new ModalBox({content:"이전 페이지가 없습니다.", cancelBtnHide: true})}} >이전</span>  											
								:
								<a className="btn btn-prev" href="p=${startNum-5}&of=${param.of}&oq=${param.oq}&f=${param.f}&q=${param.q}"></a>
							}    			                    
			            	</div>
															
							<ul className="pageList" onClick={this.pageClickHandler.bind(this)}>		
								{
									[0,1,2,3,4].map(
										i=>	this.startNum+i <= this.state.pageCount &&
											<li key={this.startNum+i}>
												<a className={ this.page==this.startNum+i ? "current-page" : ""}>
													{this.startNum+i}
												</a>
											</li>
									)
								}		
							</ul>
							<div className="nextScopeBtn">
								{ 
									this.startNum+5 > this.state.pageCount ?
									<span className="btn btn-next" onClick={()=>{new ModalBox({content:"다음 페이지가 없습니다.", cancelBtnHide: true})}} >다음 </span>             
									:
				            		<a className="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.p}&v=${param.v}"></a>  
								}          	
				            </div>							
						</div>
		*/
	}
	
}


ReactDOM.render(
	<AnimalList />
	, document.querySelector('.container')	
);