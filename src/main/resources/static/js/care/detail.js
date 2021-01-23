class CareDetail extends React.Component{
	
	constructor(){
		super();
		
		this.state = {
			care: {},
			animalInfoList: [],
			reviewList: []
		}
		this.review = {
			title: "",
			content: "",
			score: 5,
		}
		this.titleInput = React.createRef();
		this.contentInput =  React.createRef();
		this.careRegNo = /([0-9]*)$/.exec(window.location.pathname)[0];
		
		this.invalidate();
	}
	
	invalidate(){
		console.log("invalidate");
		
		fetch(`/api/care/${this.careRegNo}`)
		.then((response ) => {
			return response.json()
		})
		.then(({care, animalInfoList, reviewList})=>{
			this.setState({care, animalInfoList, reviewList});
			
			//this.startNum = this.page - ((this.page - 1) % this.range);
		});
	}
	
	getReviewList(){
		console.log("getReviewList");
		
		fetch(`/api/care/${this.careRegNo}/review/list`)
		.then((response ) => {
			return response.json()
		})
		.then((reviewList)=>{
			this.setState({reviewList});
			
			//this.startNum = this.page - ((this.page - 1) % this.range);
		});
	}
	
	componentDidMount(){
		
	}
	
	reviewSubmitHandler(e){
		e.preventDefault();
	}
	
	scoreClickHandler(e){
		if(e.target.tagName != "I" || !e.target.classList.contains("fa-star"))
			return;

		let li = e.currentTarget;
		let scoreBox = e.target.parentElement;
		let finded = false;
		this.review.score = 0;
		
		let faceIcon = li.firstElementChild.firstElementChild;
		
		for(let i = 0; i < 5; i++){
			scoreBox.children[i].classList.remove("fas", "far");

			if( finded ){
				scoreBox.children[i].classList.add("far");
			} else {
				scoreBox.children[i].classList.add("fas");
				this.review.score++;
			}

			if( scoreBox.children[i] === e.target ){
				finded = true;
			}
		}
		faceIcon.className = scoreToFace(this.review.score);
	}
	
	scoreToFace(score){
		let face = "";
		switch(score){
			case 5:
			case 4:
				face = "far fa-smile";
				break;
			case 3:
			case 2:
				face = "far fa-meh";
				break;
			case 1:
				face = "far fa-frown";
				break;
		}
		return face;
	}
	
	render(){
		console.log("render");
		return <div>
			<section className="intro-height position-relative" style={{backgroundColor:"transparent", padding: 0}}>
		        <section className="intro intro-height position-absolute position-top position-left">
		            <div className="intro-blur-image position-absolute position-top position-left" style={{backgroundImage: "url('/images/care/info/1/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg')"}}>
		                {
		                    // <!-- <img src="/images/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg"> -->
		                }
		            </div>
		            <div className="intro-image position-absolute position-center section-max-width" style={{backgroundImage: "url('/images/care/info/1/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg')"}}>
		                {
		                    // <!-- <img src="/images/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg"> -->
		                }
		            </div>
		            <div className="intro-inner">
		                <div className="intro-title box-center section-max-width">
		                    {this.state.care.name}
		                </div>
		            </div>
		        </section>
		        <div className="cloud position-absolute position-bottom position-left">
		            <svg xmlns="http://www.w3.org/2000/svg" width="100%" height="50" viewBox="0 0 192.22 33.99" preserveAspectRatio="none">
		                <path d="M0,8C33.65-10.84,50.37,29.77,68.88,29.77S117.26,0,149.26,0,200,25.55,200,25.55V45.68H0Z"/>
		            </svg>
		        </div>
		    </section>
		    <section className="greeting">
		        <div className="greeting-inner box-center section-max-width">
		            <div><img className="greeting-logo"src="/images/care/info/1/카라동물권교육로고.75a97ef1.png" alt="" /></div>
		            <h1>인권을 넘어 생명권으로!</h1>
		            <div className="greeting-text">
		                <br />
		                2002년 4월 15일, “아름품”을 설립하였습니다.<br />
		                2006년“KARA” (Korea Animal Rights Advocates)란 새 이름으로<br />
		                비영리 시민단체로 등록하고, 2010년 3월에는 농림부에 사단법인으로 등록하여<br />
		                보다 강력하고 효율적인 동물권 활동의 발판을 만들게 되었습니다.<br />
		            </div>
		        </div>
		    </section>
		    <section className="animal-list">
		        <div className="animal-list-inner box-center section-max-width">
		            <h1>보호중인 동물</h1>
		            <div className="">
		                <ul>
		                    {
		                        this.state.animalInfoList.length == 0
		                        ? <li style={{flexGrow: 1, fontSize: "6vw"}} className="search-empty">보호중인 동물 없습니다</li>
		                        : this.state.animalInfoList.map(
		                            animal => <li key={animal.noticeNo}><div><img src={animal.popfile} alt={animal.noticeNo} /></div><div>{animal.noticeNo}</div></li>
		                        )
		                    }
		                </ul>
		            </div>
		        </div>
		    </section>
		    <section id="kakao-map" className="map" ref={this.kakaoMapContainer}>
		        <div className="map-inner box-center section-max-width">
		            <div className="flex-center">
		            </div>
		            <div>
		                <br /><br />
		                {this.state.care.addr}<br />
		                <br /><br />
		                <span className="bold">Tel.</span> {this.state.care.tel}<br />
		                <br />
		                <span className="bold">Email.</span> info@ekara.org<br />
		                <br />
		                <span className="bold">Page.</span> <a href="http://ekara.org/">http://ekara.org/</a><br />
		            </div>
		        </div>
		    </section>
		    <section className="review">
		        <div className="review-inner box-center section-max-width">
		            <h1>리뷰</h1>
		            <ul>
		                <li onClick={this.scoreClickHandler.bind(this)}>
		                    <div className="icon"><i className="far fa-smile"></i></div>
		                    <div className="container">
		                        <div className="writer">Lorem ipsum</div>
		                        <div className="box">
		                            <form method="POST" onSubmit={this.reviewSubmitHandler.bind(this)}>
		                                <div className="score"><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i></div>
										<input className="d-none" type="range" name="score" value={this.review.score} min="1" max="5" step="1" onChange={(e)=>{this.review.score = e.target.value}} placeholder="제목"/>
		                                <div className="title"><input required type="text" name="title" ref={this.titleInput} placeholder="제목"/></div>
		                                <div className="content"><textarea required placeholder="내용" ref={this.contentInput}></textarea></div>
		                                <div className="submit-icon"><label htmlFor="review-submit" className="pointer"><i className="fas fa-arrow-alt-circle-down"></i></label></div>
		                                <input id="review-submit" className="d-none" type="submit" value="전송" />
		                            </form>
		                        </div>
		                    </div>
		                </li>
		                <li className="line"></li>
						{
							this.state.reviewList.map(
								review => <li key={review.id}>
			                    <div className="icon"><i className={this.scoreToFace(review.score)}></i></div>
			                    <div className="container">
			                        <div className="writer">{review.nickname}</div>
			                        <div className="box">
			                            <div className="title">{review.title}</div>
			                            <div className="score">
											{
												[1, 2, 3, 4, 5].map(
													score => review.score >= score 
													?<i key={score} className="fas fa-star"></i> 
													:<i key={score} className="far fa-star"></i>
												)
											}
										</div>
			                            <div className="content">{review.content}</div>
			                            <div className="regDate">{MMddHHmm(new Date(review.regDate.slice(0,19)))}</div>
			                        </div>
			                    </div>
			                </li>
							)
						}
		                <li>
		                    <div className="icon"><i className="far fa-smile"></i></div>
		                    <div className="container">
		                        <div className="writer">Lorem ipsum</div>
		                        <div className="box">
		                            <div className="title">Lorem ipsum dolor sit amet</div>
		                            <div className="score"><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i></div>
		                            <div className="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
		                        </div>
		                    </div>
		                </li>
		                <li>
		                    <div className="icon"><i className="far fa-smile"></i></div>
		                    <div className="container">
		                        <div className="writer">Lorem ipsum</div>
		                        <div className="box">
		                            <div className="title">Lorem ipsum dolor sit amet</div>
		                            <div className="score"><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="far fa-star"></i></div>
		                            <div className="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
		                        </div>
		                    </div>
		                </li>
		                <li>
		                    <div className="icon"><i className="far fa-meh"></i></div>
		                    <div className="container">
		                        <div className="writer">Lorem ipsum</div>
		                        <div className="box">
		                            <div className="title">Lorem ipsum dolor sit amet</div>
		                            <div className="score"><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i></div>
		                            <div className="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
		                        </div>
		                    </div>
		                </li>
		                <li>
		                    <div className="icon"><i className="far fa-meh"></i></div>
		                    <div className="container">
		                        <div className="writer">Lorem ipsum</div>
		                        <div className="box">
		                            <div className="title">Lorem ipsum dolor sit amet</div>
		                            <div className="score"><i className="fas fa-star"></i><i className="fas fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i></div>
		                            <div className="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
		                        </div>
		                    </div>
		                </li>
		                <li>
		                    <div className="icon"><i className="far fa-frown"></i></div>
		                    <div className="container">
		                        <div className="writer">Lorem ipsum</div>
		                        <div className="box">
		                            <div className="title">Lorem ipsum dolor sit amet</div>
		                            <div className="score"><i className="fas fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i><i className="far fa-star"></i></div>
		                            <div className="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
		                        </div>
		                    </div>
		                </li>
		            </ul>
		        </div>
		    </section>
		</div>;
	}
}

ReactDOM.render(
	<CareDetail />,
	document.getElementById("detail")
);