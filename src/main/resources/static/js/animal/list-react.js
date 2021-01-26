


class AnimalList extends React.Component {
	
	constructor(props) {
		super(props);
		
		
		this.queryInput = React.createRef();	//참조할거야!
		
		this.page = 1;
		this.field = "title";
		this.query = "";
		
		let offset = (this.page-1)%5;   // 현재 페이지 기준으로 스코프 첫번째 넘버인 startNum과의 차이를 알아냄
		this.startNum = this.page-offset;   // 1보다 클 경우에는 앞으로 갈 수 있따
		
		this.state = {
			list: {},
			page: 0,
			count: 0
		};
/*		this.state = {
	        list:[
	           {"id":92032472,"title":"eff","writerId":"newlec","content":"af"}
	        ],
	        count:0
      	};*/
	}
	
	componentDidMount() {
		this.invalidate();
		console.log("Did Mount");
	}
	
	pageClickHandler(e) {
		e.preventDefault(); 
		console.log(e.target.innerText+'클릭했습니다');
		
		this.page = e.target.innerText;
		this.invalidate();
		
		// state를 쓸 때 안쓸 때 구분해야함, 한번에 몰아서 변경할거면 state 말고 일반 변수 쓰기
		//this.setState({page:e.target.innerText});		
		//this.invalidate();
	}
	
	searchButtonClickHandler(e) {
		e.preventDefault();
		console.log('검색 버튼 클릭 '+this.queryInput.current.value);
		
		this.query = this.queryInput.current.value;
		
		this.invalidate();
	}
	
	
	invalidate() {
		//fetch(`/api/notice/list?p=${this.state.page}&f=${this.state.field}&q=${this.state.title}`)
		fetch(`/api/animal/list?p=${this.page}&f=${this.field}&q=${this.query}`)
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{   //쓸 변수 이름도 다 동일하면 한번에 넣어주면 됨.
			//console.log(data.response.body);		/// body까지가 페이지 정보 + 리스트 담고 있는 객체
			
			
			let list = data.response.body.items.item;
			//let size = numOfRows;		// 1페이지 당 띄울 갯수 = size
			let page = data.response.body.pageNo;
			let count = data.response.body.totalCount;
			
			
			this.setState({list, page, count});
			
			console.log(this.state.list[0]);
			//console.log(data.response.body);
			
			
		});
		/*.then(({list,count})=>{   //뽀개긔
			console.log(list);
			this.setState({list,count});
		});*/
	}
	
	
	render() {
		
		console.log(this.state);
		
		return <div className="animal-list">
			<h1>유기동물 목록 </h1>
    		<section className="search-box">		
					<div className="box-row">
						<lable>품종</lable>
						<div className="breed-box">
							<select name="upkind">	
								<option>전체</option>  
								<option value="417000">개</option>
								<option value="422400">고양이</option>
								<option value="429900">기타</option>
							</select>
							<select name="kind">	
							</select>
						</div>
					</div>
					<div className="box-row">
						<lable>유기 날짜</lable>
						<div className="regdate">
							<input type="date" name="bgnde"/>
							<span>~</span>
							<input type="date" name="endde"/>
						</div>
						<lable>중성화 여부</lable>
						<div className="neuter">
							<select name="neuter">	
								<option>전체</option>  
								<option value="Y">예</option>
								<option value="N">아니오</option>
								<option value="U">미상</option>			
							</select>
						</div>	
					</div>
			</section>
			
			<section className="animal-box">
			<div className="animal-item">
			
			{
				this.state.list.map(
					n=><div className="animal-item">
						<img src="/images/kiki.JPG" />
						<div className="title-box">
							<span>{n.happenPlace}</span>
							<div></div>
						</div>
						<div className="main-info-box">
							<span>외동읍 녹동원길</span>
							<span>생후 40일령</span>
						</div>
						<div className="sub-info-box">
							<span>수컷</span>
							<span>믹스견</span>
							<span>2021-01-19</span>
						</div>
					</div>
				)
			}
			</div>
				
			</section>
    	</div>;
	}
	
}

/*

{
					this.state.list.map(
						n=><div className="animal-item">
							<img src="/images/kiki.JPG" />
							<div className="title-box">
								<span>{n.noticeNo}</span>
								<div></div>
							</div>
							<div className="main-info-box">
								<span>외동읍 녹동원길</span>
								<span>생후 40일령</span>
							</div>
							<div className="sub-info-box">
								<span>수컷</span>
								<span>믹스견</span>
								<span>2021-01-19</span>
							</div>
						</div>
					)
				}
				






{
				//popfile
				this.state.items.item.map(
					n=><div className="animal-item">
						<img src="/images/kiki.JPG" />
						<div className="title-box">
							<span>{n.noticeNo}</span>
							<div></div>
						</div>
						<div className="main-info-box">
							<span>외동읍 녹동원길</span>
							<span>생후 40일령</span>
						</div>
						<div className="sub-info-box">
							<span>수컷</span>
							<span>믹스견</span>
							<span>2021-01-19</span>
						</div>
					</div>
				)
			}


 */


ReactDOM.render(
	<AnimalList />	
	, document.querySelector('.main-container')
);






















/* 유기동물 목록 페이지 */
window.addEventListener("load", (e)=>{

	// document으로 읽어오기
/*	var xhr = new XMLHttpRequest();
	xhr.onload = function() {
	  console.log(xhr.responseXML.documentElement.nodeName);
	}
	xhr.onerror = function() {
	  console.log("Error while getting XML.");
	}
	xhr.open("GET", "/api/animal/list");
	xhr.responseType = "document";
	xhr.send();*/


	// 원래 있던거
/*	fetch("/api/animal/list")	
	.then(response=>{
		return response.text();
	})
	.then(xmlText=>{
		console.log(xmlText);
		
		let parser = new DOMParser()
		let doc = parser.parseFromString(xmlText, "application/xml");
		for( let v of doc.childNodes) {
			console.log(v);
		}
	
	});*/
	
});





/*window.addEventListener("load", (e)=>{
	
	var xhr = new XMLHttpRequest();
	var url = 'http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/sido';
	var queryParams = '?' + encodeURIComponent('ServiceKey') + '='+'EQTmsEInR3oGqKRwJPqEQfFj9RF5ljGYfS4qLKNPxyTbMh1e0GWCPIyN%2F3gAmmXjhC5xlM0E6zp4LK3vxUAqEw%3D%3D'; 
	fetch(url+queryParams,{
		 mode: 'cors', // no-cors, cors, *same-origin
		credentials: 'include'
	})
	  .then(function(response) {
	    return response;
	  })
	  .then(function(myJson) {
	    console.log(myJson);
	  });
		
});*/
