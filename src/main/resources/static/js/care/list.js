class CareList extends React.Component{
	
	constructor(){
		super();
		
		this.state = {
			list: [],
			careCount: 0,
			pageCount: 0,
			autoCompleteList: []
		}
		
		this.page = getParameter("p") || 1;
		this.field = "name";
		this.query = getParameter("q");
		this.range = 5;
		this.startNum = this.page - ((this.page - 1) % this.range);
      	this.queryInput = React.createRef();

		this.invalidate();
		window.careNameList = window.careNameList.sort();
			
		window.onpopstate = (e)=>{
			console.log("onpopstate=====================================");
			console.log(JSON.stringify(e.state));
			console.log(e);
			this.page = e.state?.p || 1;
			this.field = e.state?.f || "name";
			this.query = e.state?.q || "";
			this.queryInput.current.value = this.query;
			this.invalidate();
			
		}
	}
	
	invalidate(){
		fetch(`/api/care/list?p=${this.page}&f=${this.field}&q=${this.query}`)
		.then((response ) => {
			return response.json();
		})
		.then(({list, pageCount, careCount})=>{
			this.startNum = this.page - ((this.page - 1) % this.range);
			this.setState({list, pageCount, careCount});
		});
		
	}
	
	searchHandler(e){
		if( e.currentTarget.classList.contains("search-icon")){
			this.page = 1;
			this.query = this.queryInput.current.value;
			history.pushState({p: this.page, f: this.field, q: this.query}, "", `?p=${this.page}&f=${this.field}&q=${this.query}`);
			this.invalidate();
			
			return;
		}
			
		if( e.target.tagName == "INPUT" ){
			if( e.keyCode == 13 || e.key == "Enter" ){
				this.page = 1;
				this.query = this.queryInput.current.value;
				history.pushState({p: this.page, f: this.field, q: this.query}, "", `?p=${this.page}&f=${this.field}&q=${this.query}`);
				this.invalidate();
				this.setState({autoCompleteList: []});
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
			this.postCareWish({careRegNo, action: "delete"})
			.then(({result, careRegNo}) => {
				if(result == "success"){
					e.target.className = "far fa-heart";
					countElement.innerText = parseInt(countElement.innerText) - 1;
				} 
			});
		} // 안 체워진 하트 
		else if( e.target.classList.contains("far") ){
			this.postCareWish({careRegNo, action: "insert"})
			.then(({result, careRegNo}) => {
				if(result == "success"){
					e.target.className = "fas fa-heart";
					countElement.innerText = parseInt(countElement.innerText) + 1;
				}
			});
		}
	}
	
	postCareWish({careRegNo, action}){
		return (
			fetch(`/api/care/${careRegNo}/wish/${action}`, { method: "POST" })
			.then((response) => {
				return response.json();	
			})
		);
	}
	
	pagerHandler(e){
		if( e.target.tagName == "A" ){
			e.preventDefault();
			
			this.page = e.target.dataset.page;
			history.pushState({p: this.page, f: this.field, q: this.query}, "", `?p=${this.page}&f=${this.field}&q=${this.query}`);
			this.invalidate();
			window.scrollTo(0, 0);
		}		
	}
	
	autoCompleteHandler(e){
		let value = e.target.value;
		let result = [];
		if(value.length == 0){
			this.setState({autoCompleteList : result})
			return;
		}
		let valueChars = this.toKorChars(value).join("");
//		console.log(valueChars);
		
		for(let care of careNameList){
			let chars = this.toKorChars(care).join("");
			let match = chars.match("^" + new RegExp(valueChars, "i"))
//			if( match )
//			result.push(match);
			if( match ){
				let escape = value.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
				if(escape.length > 1)
					escape = escape.replace(new RegExp("[ㄱ-ㅎ]$"),"");
				let exec = new RegExp(`(.*)(${escape})(.*)`, "i").exec(care);
				if( exec )
					result.push(exec);
			}
//				result.push(<li>{care.replace(value, <span>${value}</span>)}</li>);
			
			if( result.length >= 10)
				break;
		};
		
		if(result.length <= 10){
			for(let care of careNameList){
				let chars = this.toKorChars(care).join("");
				let match = chars.match(new RegExp(valueChars, "i"))
//				if( match )
//				result.push(match);
				if( match ){
					let escape = value.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
					if(escape.length > 1)
						escape = escape.replace(new RegExp("[ㄱ-ㅎ]$"),"");
					let exec = new RegExp(`(.*)(${escape})(.*)`, "i").exec(care);
					if( exec )
						result.push(exec);
				}
				if( result.length >= 10)
					break;
			};
		}
		
//		console.log(result);
		
		if( result.length != 0 ){
			this.setState({autoCompleteList: result});
			return;
		}
			
		if( result.length == 0 && 
				this.state.autoCompleteList.length != 0 )
			this.setState({autoCompleteList: result});
	}
    
	toKorChars(value){ 
        var cCho = [ 'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' ], 
        cJung = [ 'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ' ], 
        cJong = [ '', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' ], cho, jung, jong; 
        var str = value, 
        cnt = str.length, 
        chars = [], 
        cCode; 
        for (var i = 0; i < cnt; i++) {
            cCode = str.charCodeAt(i); 
            if (cCode == 32) { 
             	//chars.push(" ");
              continue;
            } // 한글이 아닌 경우 
            if (cCode < 0xAC00 || cCode > 0xD7A3) { 
                chars.push(str.charAt(i)); continue; 
            } 
            cCode = str.charCodeAt(i) - 0xAC00; 

            jong = cCode % 28; 
            // 종성 
            jung = ((cCode - jong) / 28 ) % 21 

            // 중성 
            cho = (((cCode - jong) / 28 ) - jung ) / 21 
            // 초성 

            //기본 코드 테스트가 ㅌㅔㅅ-ㅌ- 형식으로 저장됨 
             chars.push(cCho[cho], cJung[jung]); 
             if (cJong[jong] !== '') { 
                 chars.push(cJong[jong]); 
                 } 

			// 이부분을 원하는 방향으로 바꿈.
            // 테스트라는 문장이 
            // ㅌ,ㅔ,ㅅ,-,ㅌ,- 형식으로 저장되던 코드를 
            // ㅌ,테,ㅅ,스,ㅌ,트 형식으로 저장되도록함 (타이핑효과를 위해서)
//            chars.push(cCho[cho]);
//            chars.push(String.fromCharCode( 44032 + (cho * 588) + (jung  * 28)));
//            if (cJong[jong] !== '') { 
//                chars.push(String.fromCharCode( 44032 + (cho * 588) + (jung  * 28) + jong ));
//            }
        }
        return chars; 
    }
	
	render(){
		console.log("render");
		return <section>
			<section className="search-box">
		        <div className="search-inner section-max-width position-relative">
		            <div className="search-bar backdrop-blur  position-absolute">
		                <div className="search-input"><input defaultValue={this.query} ref={this.queryInput} onInput={this.autoCompleteHandler.bind(this)} onKeyPress={this.searchHandler.bind(this)} className="input-reset" name="adoption-center" placeholder="보호소 이름" /></div>
		                <div className="search-icon pointer" onClick={this.searchHandler.bind(this)}>
		                    {
								// <!-- <i className="fas fa-search"></i> -->
							}
		                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" >
		                        <path d="M508.5 481.6l-129-129c-2.3-2.3-5.3-3.5-8.5-3.5h-10.3C395 312 416 262.5 416 208 416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c54.5 0 104-21 141.1-55.2V371c0 3.2 1.3 6.2 3.5 8.5l129 129c4.7 4.7 12.3 4.7 17 0l9.9-9.9c4.7-4.7 4.7-12.3 0-17zM208 384c-97.3 0-176-78.7-176-176S110.7 32 208 32s176 78.7 176 176-78.7 176-176 176z"></path>
		                    </svg>
		                </div>
						{
							this.state.autoCompleteList.length != 0
							?<div className="auto-complete">
								<ul>
								{
									this.state.autoCompleteList.map(
										 str => <li key={str}>{str[1]}<span className="bold">{str[2]}</span>{str[3]}</li>
									)
//									if( match )
//									result.push(care);
//										str => <li key={str}>{str}</li>
									
								}
								</ul>
							</div>
							: ""
						}
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
						this.startNum + 5 <= this.state.pageCount
						? <a className="btn btn-next" data-page={`${parseInt(this.startNum) + this.range}`} href={`?p=${parseInt(this.startNum) + this.range}&f=${this.field}&q=${this.query}`}>다음</a>
						: <span className="btn btn-next" onClick={()=>{new ModalBox({content:"다음 페이지가 없습니다.", cancelBtnHide: true})}}>다음 </span>
					}
					</div>
                </div>
				<div className="pager-info">검색된 보호소 수: {this.state.careCount}, 페이지 수: {this.state.pageCount}</div>
            </div>
		</section>; 
	}
}


ReactDOM.render(
	<CareList />,
	document.getElementById("list")
);