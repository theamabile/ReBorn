class Message extends React.Component {
	constructor(props) {
		super(props);

		this.queryInput = React.createRef();	//검색

		this.page = 1;

		let offset = (this.page-1)%5;   // 페이저 시작과 현제ㅍ 페이지 차이
		this.startNum = this.page-offset;   
		
		this.state = {
			list: [],
			page: 0,
			count: 0
		};
	}
	componentDidMount() {
		this.invalidate();
		console.log("Did Mount");
	}
invalidate() {
		fetch(`/api/message/list?p=${this.state.page}&f=${this.state.field}&q=${this.state.title}`)
		.then((response)=>{
			return response.json();
		})
		.then((list)=>{   //쓸 변수 이름도 다 동일하면 한번에 넣어주면 됨.
			//console.log(data.response.body);		/// body까지가 페이지 정보 + 리스트 담고 있는 객체
			
			console.log(list);
			//let list = data.response.body.items.item;
		/*	//let size = numOfRows;		// 1페이지 당 띄울 갯수 = size
			let page = data.response.body.pageNo;
			let count = data.response.body.totalCount;*/
			
			
			this.setState({list});
			
			console.log(this.state.list[0]);			
		});
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
					<option value="받은쪽지함">받은쪽지함</option>
					<option value="보낸쪽지함">보낸쪽지함</option>
					<option value="보관쪽지함">보관쪽지함</option>
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
																				<td>{n.title}</td>
																				<td>{n.regDate}</td>
																				</tr>)
					}
					</tbody>
				</table>

			</div>
		</div>
	}
}


ReactDOM.render(
	<Message />
	, document.querySelector(".main-container")
);
