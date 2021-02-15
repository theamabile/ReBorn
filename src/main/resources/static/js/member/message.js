class Message extends React.Component {
	constructor(props) {
		super(props);

		this.queryInput = React.createRef();	//검색

		this.state = {
			list: [],
			page: 0,
			count: 0
		};

		this.page = getParameter("p") || 1;
		this.field = "senderId";
		this.query = getParameter("q")||"";
		
		
		let offset = (this.page-1)%5;   // 페이저 시작과 현재 페이지 차이
		this.startNum = this.page-offset;   

	}
	componentDidMount() {
		this.invalidate();
		console.log("Did Mount");
	}
invalidate() {
		fetch(`/api/message/list?p=${this.page}&f=${this.field}&q=${this.query}`)
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{   //쓸 변수 이름도 다 동일하면 한번에 넣어주면 됨.
			//console.log(data.response.body);		/// body까지가 페이지 정보 + 리스트 담고 있는 객체
			
			console.log(data);
			//let list = data.response.body.items.item;
		/*	//let size = numOfRows;		// 1페이지 당 띄울 갯수 = size
			let page = data.response.body.pageNo;
			let count = data.response.body.totalCount;*/
			
			
			this.setState(data);
			
			console.log(data);			
		});
	}
	
		pagerHandler(e){
		e.preventDefault();
		//this.setState({page:e.target.innerText});
		this.page = e.target.innerText;
		console.log(e)
		e.target.className.append="current"
		this.invalidate();

	}
	
	
	render() {
		return <div>
			<h1>쪽지</h1>
			<div className="ms-content">
				<select name="message-type" className="input">
					<option value="받은쪽지함">받은쪽지함</option>
					<option value="보낸쪽지함">보낸쪽지함</option>
					<option value="보관쪽지함">보관쪽지함</option>
				</select> <a>쪽지쓰기</a> <a>내게쓰기</a>
				<div><div>
					<input type="button" value="신고 " className="main-button-s" />
					<input type="button" value="삭제"  className="main-button-s"/>
					<input type="button" value="보관"  className="main-button-s"/>
				</div>
				<div>
				<select name="message-type" className="input">
					<option value="아이디">아이디</option>
					<option value="제목">제목</option>
				</select>
				 <input type="text"  className="input"/> <input type="button" value="검색" className="main-button-s" />
				</div>
				</div>
				<table>
					<thead>
						<tr>
							<th><input type="checkbox" /></th>
							<th>보낸사람</th>
							<th>제목</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
					{
						this.state.list.map(n=><tr key={n.id}>
																				<td><input type="checkbox" /></td>
																				<td>{n.senderId}</td>
																				<td><a>{n.title}</a></td>
																				<td>{n.regDate}</td>
																				</tr>)
					}
					</tbody>
				</table>
				
				

            <div className="pager-common mt30">
                <div className="pager" onClick={this.pagerHandler.bind(this)}>
                
                    <div className="prev mr15">

					{
						this.startNum > 1
						? <a className="btn btn-prev" data-page={`${parseInt(this.startNum) - this.range}`} href={`?p=${parseInt(this.startNum) - this.range}&f=${this.field}&q=${this.query}`}>이전</a>
						: <span className="btn btn-prev" onClick={()=>{new ModalBox({content:"이 페이지가 없습니다.", cancelBtnHide: true})}}>이전</span>
					}   
                        
                    </div>
                    <ul className="btn-center">

					{
						[0, 1, 2, 3, 4].map(
							i => 
							this.startNum + i <= this.state.pageCount  
							?<li key={i} className={i + this.startNum == this.page ? "current" : ""}>
								<a className="bold " data-page={`${parseInt(this.startNum) + i}`} href={`?p=${parseInt(this.startNum) + i}&f=${this.field}&q=${this.query}`}>{i+this.startNum}</a>
							</li>
							:""
						)
					}
                    </ul>
                    
                    <div className="next mr15">
					{
						this.startNum + this.range <= this.state.pageCount
						? <a className="btn btn-next" data-page={`${parseInt(this.startNum) + this.range}`} href={`?p=${parseInt(this.startNum) + this.range}&f=${this.field}&q=${this.query}`}>다음</a>
						: <span className="btn btn-next" onClick={()=>{new ModalBox({content:"다음 페이지가 없습니다.", cancelBtnHide: true})}}>다음 </span>
					}
					</div>
                </div>
            </div>

			</div>
		</div>
	}
}


ReactDOM.render(
	<Message />
	, document.querySelector(".main-container")
);
