class CareList extends React.Component{
	
	constructor(){
		super();
		
		this.state = {
			list: [],
			pageCount: 0
		}
		
		this.page = getParameter("p");
		this.field = "name";
		this.query = getParameter("q");
		this.range = 5;
		this.startNum = this.page - ((this.page - 1) % this.range);
      	this.queryInput = React.createRef();

		this.invalidate();
	}
	
	invalidate(){
		console.log("fetch");
		
		fetch(`/api/care/list?p=${this.page}&f=${this.field}&q=${this.query}`)
		.then((response ) => {
			return response.json()
		})
		.then(({list, pageCount})=>{
			this.setState({list, pageCount});
			
			this.startNum = this.page - ((this.page - 1) % this.range);
		});
	}
	
	searchHandler(e){
		if( e.currentTarget.classList.contains("search-icon")){
			this.page = 1;
			this.query = this.queryInput.current.value;
			this.invalidate();
			return;
		}
			
		if( e.target.tagName == "INPUT" ){
			if( e.keyCode == 13 || e.key == "Enter" ){
				this.page = 1;
				this.query = this.queryInput.current.value;
				this.invalidate();
			}
		}
	}
	
	wishClickHandler(e){
		if( e.target.tagName != "I" || !e.target.classList.contains("fa-heart") )
			return; 
			
		let li = e.target.closest('li');
		if (!li) return; 
		if (!e.currentTarget.contains(li)) return;
		
		let careRegNo = li.dataset.careRegNo;
		let countElement = e.target.parentElement.nextElementSibling;
		
		// 채워진 하트
		if( e.target.classList.contains("fas")){
			this.postCareWish({careRegNo, wish: false})
			.then(({result, careRegNo}) => {
				if(result == "sussess"){
					e.target.className = "far fa-heart";
					countElement.innerText = parseInt(countElement.innerText) - 1;
				} 
			});
		} // 안 체워진 하트 
		else if( e.target.classList.contains("far") ){
			this.postCareWish({careRegNo, wish: true})
			.then(({result, careRegNo}) => {
				if(result == "sussess"){
					e.target.className = "fas fa-heart";
					countElement.innerText = parseInt(countElement.innerText) + 1;
				}
			});
		}
		console.log();
	}
	
	postCareWish({careRegNo, wish}){
		return (
			fetch(`/api/care/wish?careRegNo=${careRegNo}&wish=${wish}`, { method: "POST" })
			.then((response) => {
				return response.json();	
			})
		);
	}
	
	render(){
		console.log("render");
		return <section>
			<section className="search-box">
		        <div className="search-inner section-max-width">
		            <div className="search-bar backdrop-blur">
		                <div className="search-icon pointer" onClick={this.searchHandler.bind(this)}>
		                    {
								// <!-- <i className="fas fa-search"></i> -->
							}
		                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" >
		                        <path d="M508.5 481.6l-129-129c-2.3-2.3-5.3-3.5-8.5-3.5h-10.3C395 312 416 262.5 416 208 416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c54.5 0 104-21 141.1-55.2V371c0 3.2 1.3 6.2 3.5 8.5l129 129c4.7 4.7 12.3 4.7 17 0l9.9-9.9c4.7-4.7 4.7-12.3 0-17zM208 384c-97.3 0-176-78.7-176-176S110.7 32 208 32s176 78.7 176 176-78.7 176-176 176z"></path>
		                    </svg>
		                </div>
		                <div className="search-input"><input ref={this.queryInput} onKeyPress={this.searchHandler.bind(this)} className="input-reset" name="adoption-center" placeholder="보호소 이름" /></div>
		            </div>
		        </div>
		    </section>
		    <section className="adoption-center-list position-relative">
		        <div className="adoption-center-list-inner">
		            <ul onClick={this.wishClickHandler.bind(this)}>
	            		{
							this.state.list
							? this.state.list.map(
								cv => <li key={cv.careRegNo} data-care-reg-no={cv.careRegNo}>
				                    <div>
				                        <div className="thumb">
				                            <a href={cv.careRegNo}><img src="/images/care/thumb/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg" /></a>
				                        </div>
				                        <div className="name">
				                            <div className="bold"><a href={cv.careRegNo}>{cv.name}</a>{cv.auth ? <i className="fas fa-check"></i> : ``}</div>
				                            <div>{cv.addr}</div>
				                            <div>{cv.tel}</div>
				                        </div>
				                        {
											//<div className="current-animals-num">
					                        //    <div className="bold">보호중인 동물 수</div>
					                        //    <div>{cv.animalCnt}</div>
					                        //</div>
										}
										<div className="score-avg">
											<div className="star-box position-relative">
												<div><i className="far fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i></div>
												<div style={{width:`${cv.reviewScoreAvg.toFixed(1)/5*100}%`}}><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i></div>
											</div>
											{
											//<div>
												//[1, 2, 3, 4, 5].map(
												//	score => Math.round(cv.reviewScoreAvg) >= score 
												//	?<i key={score} className="fas fa-star"></i> 
												//	:<i key={score} className="far fa-star"></i>
												//)
											//</div>
											}
											<div>{cv.reviewScoreAvg.toFixed(1)} ({cv.reviewCnt})</div>
										</div>
				                        <div className="wish">
				                            <div className="pointer">
				                                {cv.wish ? <i className="fas fa-heart"></i> : <i className="far fa-heart"></i>}
				                            </div>
				                            <div>{cv.wishCnt}</div>
				                        </div>
				                    </div>
				                </li>
							)
							:<li className="search-empty">결과가 없습니다</li>
						}
		            </ul>
		        </div>
		    </section>
		</section>; 
	}
}


ReactDOM.render(
	<CareList />,
	document.getElementById("list")
);