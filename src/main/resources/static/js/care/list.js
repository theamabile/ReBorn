class CareList extends React.Component{
	
	constructor(){
		super();
		
		this.state = {
			list: [],
			careCount: 0,
			pageCount: 0,
			memberId: 0,
			autoCompleteList: []
		}
		
		this.page = getParameter("p") || 1;
		this.field = "name";
		this.query = getParameter("q");
		this.range = 5;
		this.startNum = this.page - ((this.page - 1) % this.range);
      	this.queryInput = React.createRef();
		this.autoCompleteUl = React.createRef();
		this.queryInputValueTemp = ""; 
		this.autoCompleteIndex = 0;

		this.invalidate();
		window.careNameList = window.careNameList.sort();
			
		window.onpopstate = (e)=>{
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
		.then(({list, pageCount, careCount, memberId})=>{
			this.startNum = this.page - ((this.page - 1) % this.range);
			this.setState({list, pageCount, careCount, memberId});
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
			
	}
	
	searchKeyDownHandler(e){
		const ARROW_UP = 38;
		const ARROW_DOWN = 40;
		const ENTER = 13;
		const BACKSPACE = 8;
		
		if( e.keyCode == ENTER ){
			if(this.autoCompleteIndex != 0){
				let ul = this.autoCompleteUl.current;
				let li = ul.querySelector(".active");
				
				if( li ){
					this.queryInput.current.value = li.innerText;
					this.query = li.innerText;
					history.pushState({p: this.page, f: this.field, q: this.query}, "", `?p=${this.page}&f=${this.field}&q=${this.query}`);
					this.invalidate();
				}
			}
			
			this.page = 1;
			this.query = this.queryInput.current.value;
			history.pushState({p: this.page, f: this.field, q: this.query}, "", `?p=${this.page}&f=${this.field}&q=${this.query}`);
			this.invalidate();
		}
		
		// 자동완성 Ul 이벤트 ===========================================
		if( !this.autoCompleteUl.current ){
			return;
		}
		
		let ul = this.autoCompleteUl.current;
		let li = ul.querySelector(".active");
		
		switch(e.keyCode){
			case BACKSPACE:{
				if( this.queryInput.current.value != this.queryInputValueTemp){
					e.preventDefault();
					this.queryInput.current.value = this.queryInputValueTemp;
					this.autoCompleteIndex = 0;
					li.className="";	
				}
				break;
			}
			case ARROW_UP:{
				if( this.autoCompleteIndex - 1 <= 0)	{	
					if(li){
						this.queryInput.current.value = this.queryInputValueTemp;
						li.className = "";
					}
					return;
				}
				if(li)
					li.className = "";
				
				this.autoCompleteIndex--;
				li = ul.children[this.autoCompleteIndex - 1];
				li.className = "active";
				this.queryInput.current.value = li.innerText;
				break;
			}
			case ARROW_DOWN:{
				if(this.state.autoCompleteList.length <= this.autoCompleteIndex)
					return;
				if(li)
					li.className = "";
				
				this.autoCompleteIndex++;

				li = ul.children[this.autoCompleteIndex - 1];
				li.className = "active";
				this.queryInput.current.value = li.innerText;
				break;
			}
			
		}
	}
	
	wishClickHandler(e){
		if( e.target.tagName != "I" || !e.target.classList.contains("fa-heart") )
			return; 
			
		if( !this.state.memberId ){
			new ModalBox({content: "로그인을 먼저 해주세요", cancelBtnHide: true});
			return;
		}
		
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
		this.autoCompleteIndex = 0;
		this.queryInputValueTemp = e.target.value;
		if(value.length == 0){
			if(this.state.autoCompleteList.length != 0)
				this.setState({autoCompleteList : result})
			return;
		}
		let valueChars = this.toKorChars(value).join("");
		
		let careNameListFilter = careNameList.filter(
			care => {
				if(care[0] != value[0])
					return true;
				let chars = this.toKorChars(care).join("");
				let match = chars.match(new RegExp("^" + this.escapeStr(valueChars), "i"));
				
	//			console.log(valueChars, chars)
				if( match != null ){
					let searchIndex = 0;
					let valueTemp = value.replace(/\s/gi, "").toUpperCase().split("");
					let careTemp = care.toUpperCase().split("");
					let j = 0;
					let k = 0;
					
					for(let i = 0; i < careTemp.length; i++){
						if( careTemp[i] == valueTemp[j] ){
							j++;
							continue;
						}
						if( j > 0 && careTemp[i] == " "){
							k++;
							continue;
						}
						// 문자열이 이어지지 않으면 멈춤
						if( j >= 0 )
							break;
					}
						
					let str = [];
					str[0] = (careTemp.splice(0, searchIndex)).join("");
					str[1] = (careTemp.splice(0, j + k)).join("");
					str[2] = (careTemp.splice(0, careTemp.length)).join("");
	//				console.log(1,searchIndex,j,k,str);
					result.push(str);
					return false;
				}
				
				if( result.length >= 10)
					return false;
			}
		)
			
		
		if(result.length < 10){
			for(let care of careNameListFilter){
				let chars = this.toKorChars(care).join("");
				let match = (chars.slice(1,chars.length)).match(new RegExp(this.escapeStr(valueChars), "i"));
				if( match != null ){
					let searchIndex = care.search(new RegExp(this.escapeStr(value[0]), "i"));
					let valueTemp = value.replace(/\s/gi, "").toUpperCase().split("");
					let careTemp = care.toUpperCase().split("");
					let j = 0;
					let k = 0;
					for(let i = searchIndex; i < careTemp.length; i++){
						if( careTemp[i] == valueTemp[j] ){
							j++;
							continue;
						}
						if( j > 0 && careTemp[i] == " "){
							k++;
							continue;
						}
						// 문자열이 이어지지 않으면 멈춤
						if( j >= 0 )
							break;
					}
					
					let str = [];
					str[0] = (careTemp.splice(0, searchIndex)).join("");
					str[1] = (careTemp.splice(0, j + k)).join("");
					str[2] = (careTemp.splice(0, careTemp.length)).join("");
//					console.log(1,searchIndex,j,k,str);
//					console.log(careTemp);
//					console.log(valueTemp);
//					console.log(str);
					result.push(str);
				}
				
				if( result.length >= 10)
					break;
			}
		}
		
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

	escapeStr(str){
		return str.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
	}

	autoCompleteListClickHandler(e){
		let li = e.target.closest('li');
		if (!li) return; 
		if (!e.currentTarget.contains(li)) return;
		
		this.queryInput.current.value = li.innerText;
		this.query = li.innerText;
		history.pushState({p: this.page, f: this.field, q: this.query}, "", `?p=${this.page}&f=${this.field}&q=${this.query}`);
		this.invalidate();
	}
	
	queryInputClearHandler(e){
		this.queryInput.current.value = "";
		this.setState({autoCompleteList: []});
	}
	
	autoCompleteCloseHandler(e){
//		console.log(e.target);
		if(this.state.autoCompleteList.length == 0)
			return;
		
		let div = e.target.closest('div.search-bar');
//		console.log(div);
		if (div) return; 
		if (e.currentTarget.contains(div)) return;
		
//		console.log(div);
		
		this.setState({autoCompleteList: []});
	}
	
	autoCompleteMouseOverHandler(e){
		let current = e.target.closest('li');
		if (!current) return; 
		if (!e.currentTarget.contains(current)) return;
		
		let ul = this.autoCompleteUl.current;
		let li = ul.querySelector(".active");
		
		if(li)
			li.className = ""; 
		
		
		let list = ul.children;
		
		for( let i = 0; i < list.length; i++){
			if( list[i] === current){
				this.autoCompleteIndex = i + 1;
				break;
			}
		}
		
		this.queryInput.current.value = current.innerText;
		current.classList.add("active");
	}
	
	autoCompleteMouseOutHandler(e){
		let current = e.target.closest('li');
		if (!current) return; 
		if (!e.currentTarget.contains(current)) return;
		
		this.autoCompleteIndex = 0;
		
		this.queryInput.current.value = this.queryInputValueTemp;
		current.classList.remove("active");
	}
	
	render(){
		//console.log("render");
		return <section onClick={this.autoCompleteCloseHandler.bind(this)}>
			<section className="search-box">
		        <div className="search-inner section-max-width position-relative">
		            <div className="search-bar backdrop-blur  position-absolute">
		                <div className="search-input"><input defaultValue={this.query} ref={this.queryInput} onInput={this.autoCompleteHandler.bind(this)} onKeyDown={this.searchKeyDownHandler.bind(this)} onClick={this.autoCompleteHandler.bind(this)}  className="input-reset" name="adoption-center" placeholder="보호소 이름" /></div>
		                <div className={"search-clear pointer" + (this.queryInput.current?.value ? "" : " d-none")} onClick={this.queryInputClearHandler.bind(this)}><i className="fas fa-times-circle"></i></div>
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
								<ul ref={this.autoCompleteUl}onClick={this.autoCompleteListClickHandler.bind(this)} onMouseOver={this.autoCompleteMouseOverHandler.bind(this)} onMouseOut={this.autoCompleteMouseOutHandler.bind(this)}>
								{
									this.state.autoCompleteList.map(
										 str => <li key={str}>{str[0]}<span>{str[1]}</span>{str[2]}</li>
									)
								}
								</ul>
							</div>
							:""
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
				                            <a href={cv.careRegNo}>
												{
													cv.thumb
													? <img src={`../images/care/thumb/${cv.careRegNo}/${cv.thumb}`} /> 
													: <img className="thumb-none" src="../images/care/search-back.png"/>
														
												}
											</a>
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
						this.startNum + this.range <= this.state.pageCount
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