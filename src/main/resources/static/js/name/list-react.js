
// VoteList에 추가 되는 순위 아이템
class Rank extends React.Component {
	constructor(props) {
		super(props);
		
		this.vote = this.props.vote;	// 외부에서 보내준 데이터(Rank안에서 사용할 데이터) 
	}
	
	
	componentDidMount() {
		console.log("rank - componentDidMount");
		console.log("rank " + this.vote);
		this.invalidate();		// 처음에 로드 해야함
	}
	
	render() {
		return <tr>
	    			<th className="bold"><i className="fas fa-medal font-m"></i>위</th>
	    			<td>{this.vote}</td>
	    	   </tr>;
	}
	
}

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
		console.log(`/name/${animalId}`);
		
		location.href = `/name/${animalId}`;	
	}	
	
	pageClickHandler(e) {
		e.preventDefault();	
				
		this.page = e.target.innerText;		
		this.invalidate();
	}
	
	invalidate() {
		console.log(`url : /api/name/list?p=${this.page}&of=${this.orderField}&oq=${this.orderQuery}&f=${this.field}&q=${this.query}`);
		fetch(`/api/name/list?p=${this.page}&of=${this.orderField}&oq=${this.orderQuery}&f=${this.field}&q=${this.query}`)
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
				let startDate = new Date(v.voteStartDate);
				let endDate = new Date(v.voteEndDate);
				
				var voteDate = 1 + Math.round( (endDate.getTime()-startDate.getTime())/(1000*3600*24) );	
				var takeDate = 1 + Math.round( (today.getTime()-startDate.getTime())/(1000*3600*24) );		
								
				let takePercent = Math.round((takeDate / voteDate) * 100);
				
				v.takePercent = takePercent;
			}
			

			this.setState(data);
		});
	}
	
	render() {
		console.log("render");
				
		return <div className="vote">
				 	<h1>이름 투표</h1>
					<form>
						<div className="filter">
							<label>정렬</label>
							<select name="of" ref={this.orderFieldInput} onChange={this.orderChangeHandler.bind(this)} className="order-field">
								<option value="voteStartDate">투표날짜</option>
								<option value="choiceSum">투표 참여 순</option>
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
											        		{v.voteStartDate}~
											        		{v.voteEndDate}
											        	</span>
											            <img/>
										        	</div>
									            	<table className="rank font-xl">
							            				<tbody>
															{
																v.rankNameList.map(
																	(n, index)=><tr key={index}>
															            			<th>
																						<i className="fas fa-medal font-m"></i>{index+1}위
																					</th>
															            			<td className="bold">{n.name}</td>
															            		</tr>
																)
															}
														</tbody>
									            	</table>
									            	<div className="count">
									            		<div className="count-item">
									            			<span className="font-l">총 투표수</span>
									            			<span className="font-xl">{v.choiceSum }</span>
									            		</div>
									            		<div className="count-item">
									            			<span className="font-l mr-1">후보 수</span>
									            			<span className="font-xl">{v.nameCnt }</span>
									            		</div>
														{
															v.choiced ?
															<i className="fas fa-vote-yea font-xl red-pink"></i>
															:
															<i className="fas fa-vote-yea font-xl gray"></i>
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
	// rankItem에는 Rank 컴포넌트가 들어감
	, document.querySelector(".main-container")
);







