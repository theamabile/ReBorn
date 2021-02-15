
class VoteList extends React.Component {
	
	constructor(props) {
		super(props);
		
		console.log("construct");
		
		this.orderFieldInput = React.createRef();		// 참조 연결을 만들것
		this.orderQueryInput = React.createRef();		
	
		this.page = 1;
		this.orderField = "";
		this.orderQuery = "";
		this.field = "";
		this.query = "";
		
		let offset = (this.page-1)%5;	// 현재 페이지 기준으로 스코프 첫번째 넘버인 startNum과의 차이를 알아냄
		this.startNum = this.page - offset;	// 1보다 클 경우에는 앞으로 갈 수 있따
		this.pageCount = 0;
		
		let item = {
				animalId:"서울-구로-001",
				voteStartDate:"2021-01-24", 
				voteEndDate:"2021-01-27",
				choiceSum: 152,
				nameCnt:3,
				rankNameList:[],
				takePercent:0
		};
		
		this.state = {
			list: [item],
			pageCount: 0
		}
	}
	
	componentDidMount() {
		//console.log("componentDidMount");
		this.invalidate();		// 처음에 로드 해야함
	}
	
	componentWillUnmount(){
		//console.log("componentWillUnmount");
	}
	
	// 정렬 방식이 변경 되었을 때 호출 되는 함수, 변경 된 input 값을 this 변수에 넣어줌
	orderChangeHandler(e){
		/* ref는 자신을 전달받은 DOM 엘리먼트를 current 프로퍼티의 값으로서 받습니다. */
		// select 박스의 경우 선택 된 옵션의 index를 셀박.selectedIndex 로 얻을 수 있음
		let fieldIndex = this.orderFieldInput.current.options.selectedIndex;		
		let queryIndex = this.orderQueryInput.current.options.selectedIndex;	
			
		this.orderField = this.orderFieldInput.current.options[fieldIndex].value;
		this.orderQuery = this.orderQueryInput.current.options[queryIndex].value;
	
		this.invalidate();
	}
	
	itemClickHandler(animalId) {
		location.href = `/name/${animalId}/add`;		
	}	
	
	pageClickHandler(e) {
		e.preventDefault();	
				
		this.page = e.target.innerText;		
		this.invalidate();
	}
	
	invalidate() {
		console.log(`url : /api/name/recruit?p=${this.page}&of=${this.orderField}&oq=${this.orderQuery}&f=${this.field}&q=${this.query}`);
		fetch(`/api/name/recruit?p=${this.page}&of=${this.orderField}&oq=${this.orderQuery}&f=${this.field}&q=${this.query}`)
		.then(response=>{
			return response.json();
		})
		.then(data=>{
			console.log(data);
			
			// 페이지 바뀌었으니 
			let offset = (this.page-1)%5;
			this.startNum = this.page - offset;

			let today = new Date();   
			for(let v of data.list) {
				let startDate = new Date(v.recruitStartDate);
				let endDate = new Date(v.recruitEndDate);

				var recruitDate = 1 + Math.round( (endDate.getTime()-startDate.getTime())/(1000*3600*24) );	
				var takeDate = 1 + Math.round( (today.getTime()-startDate.getTime())/(1000*3600*24) );		
								
				let takePercent = Math.round((takeDate / recruitDate) * 100);
				
				//console.log(`recruitDate:${recruitDate} / takeDate: ${takeDate} / takePercent: ${takePercent}`);
				
				v.takePercent = takePercent;
			}
			

			this.setState(data);
		});
	}
	
	render() {
	
		/*<div className="section-info">
			<span>이름을 정하기 위해 이름 후보를 기다리고 있는 동물들입니다.</span>
			<span>관심과 애정을 담아 동물에게 이름을 선사해주세요.</span>
		</div>*/
		
		return <div className="vote">
				 	<h1>이름 지어주기</h1>
					<form>
						<div className="filter">
							<label>정렬</label>
							<select name="of" ref={this.orderFieldInput} onChange={this.orderChangeHandler.bind(this)} className="order-field">
								<option value="recruitStartDate">등록 날짜</option>
								<option value="nameCnt">이름 갯수</option>
							</select>
							<select name="oq" ref={this.orderQueryInput} onChange={this.orderChangeHandler.bind(this)} className="order-query">
								<option value="DESC">내림차순</option>
								<option value="ASC">오름차순</option>
							</select>
						</div>
					
						<div className="vote-list">
							{
								this.state.list.length > 0 ?								
								this.state.list.map(
									v=><div className="item" key={v.animalId}>	
									        <div className="progress">
									            <div className="progress-bar" style={ {width:v.takePercent+"%", height:"100%", background:"var(--main)", transition: "width 2s ease-in-out"} }></div>
									        </div>
									        <div className="btn" onClick={this.itemClickHandler.bind(this, v.animalId)} >
									        	<img src={v.popfile} />	        	
									            <div className="vote-info">
										        	<div className="regdate">
											        	<span className="font-s">
											        		{v.recruitStartDate}~
											        		{v.recruitEndDate}
											        	</span>
											            <img/>
										        	</div>
									            	<table className="font-xl name">
							            				<tbody>
															{
																v.rankNameList.map(
																	(n, index)=><tr key={index}>
																					<td>
																						<i className="fas fa-user fs-4"></i>
																					</td>
																					<td>
																						{n.writerNickname}
																					</td>
															            			<td className="bold">{n.name}</td>
															            		</tr>
																)
															}
														</tbody>
									            	</table>
									            	<div className="count">
									            		<div className="count-item">
									            			<span className="font-l mr-1">후보 수</span>
									            			<span className="font-xl">{v.nameCnt }</span>
									            		</div>
														{
															v.added?
															<i className="fab fa-gratipay font-xl red-pink"></i>
															:
															<i className="fab fa-gratipay font-xl gray"></i>
														}
									            	</div>
									            </div>
									        </div>
								    </div>
								)
								:
								( <span className ="bold m-auto gray fs-1">항목이 존재하지 않습니다</span>)
							}
						</div>
					</form>
					
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
									/*[0,1,2,3,4].map(
										i=><li key={this.startNum+i} className="${current}">
												<a className="bold ">{this.startNum+i}</a>
											</li>
									)*/
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
				</div> ;
		
	}
	
}

ReactDOM.render(
	<VoteList />
	// VoteList가 사용할 rankItem을 동적으로 넣어줌. 
	, document.querySelector(".main-container")
);







