
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
				nameCnt:3
			};
		
		this.state = {
			list: [item],
			count: 0
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
	
	pageClickHandler(e) {
		e.preventDefault();	
				
		this.page = e.target.innerText;		
		this.invalidate();
	}
	
	invalidate() {
		
		fetch(`/api/name/list?p=${this.page}&of=${this.orderField}&oq=${this.orderQuery}&f=${this.field}&q=${this.query}`)
		.then(response=>{
			return response.json();
		})
		.then(data=>{
			console.log(data);
			
			// 페이지 바뀌었으니 
			let offset = (this.page-1)%5;
			this.startNum = this.page - offset;
			this.pageCount = Math.ceil(data.count/2);  //서버에서 받아와도 되긴함

			data.list[0].rankNameList.map(
				n=>console.log("ㅎㅎ : "+n.name)
			);
			console.log(data.list[0].rankNameList[0]);

			this.setState(data);
		});
	}
	
	render() {
		console.log("render");
		return <div className="vote">
				 	<h1>투표 목록</h1>
					<form>
						<div className="filter">
							<select name="of" ref={this.orderFieldInput} onChange={this.orderChangeHandler.bind(this)} className="order-field">
								<option value="voteStartDate">투표날짜</option>
								<option value="choiceSum">참여 순</option>
							</select>
							<select name="oq" ref={this.orderQueryInput} onChange={this.orderChangeHandler.bind(this)} className="order-query">
								<option value="DESC">내림차순</option>
								<option value="ASC">오름차순</option>
							</select>
						</div>
					
						<div className="vote-list">
							{
								this.state.list.map(
									v=><div className="item" key={v.animalId}>	
									        <div className="percent">
									            <div className="gage"></div>
									        </div>
									        <button className="btn">
									        	<img />	        	
									            <div className="vote-info">
										        	<div className="regdate">
											        	<span className="font-xs">
											        		{v.voteStartDate}~
											        		{v.voteEndDate}
											        	</span>
											            <img />
										        	</div>
									            	<table className="rank font-l">
							            				<tbody>
														{v.rankNameList.map(
															n=><tr><td>n.name</td></tr>
														)}
														</tbody>
									            	</table>
									            	<div className="count">
									            		<div className="count-item">
									            			<span className="font-m">총 투표수</span>
									            			<span className="font-xl">{v.choiceSum }</span>
									            		</div>
									            		<div className="count-item">
									            			<span className="font-m">후보 수</span>
									            			<span className="font-xl">{v.nameCnt }</span>
									            		</div>
									            		<i className="fas fa-vote-yea font-xl"></i>
									            	</div>
									            </div>
									        </button>
								    </div>
								)
							}
						</div>
					</form>
					
					<div className="pager">
						<div className="prev mr15">                    
			                <a className="btn btn-prev" href="p=${startNum-5}&of=${param.of}&oq=${param.oq}&f=${param.f}&q=${param.q}"></a>	
		                    <span className="btn btn-prev" onClick={()=>alert('이전 페이지가 없습니다.')}>이전</span>  
			            </div>
						<ul className="btn-center" onClick={this.pageClickHandler.bind(this)}>		
							{
								[0,1,2,3,4].map(
									i=>	this.startNum+i <= this.pageCount &&
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
			            	<a className="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.p}&v=${param.v}"></a>
			                <span className="btn btn-next" onClick={()=>alert('다음 페이지가 없습니다.')}>다음 </span>                        	
			            </div>
					</div>	
				</div> ;
				
				/*
				 
							<li className="${current}">
								<a className="bold " href="?p=${startNum+i}&of=${param.of}&oq=${param.oq}&f=${param.f}&q=${param.q}">1</a>
							</li>
				 */
		
	}
	
}

ReactDOM.render(
	<VoteList />
	// VoteList가 사용할 rankItem을 동적으로 넣어줌. 
	// rankItem에는 Rank 컴포넌트가 들어감
	, document.querySelector(".main-container")
);







