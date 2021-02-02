class BoardList extends React.Component{
	constructor(){
		super();
	}
	

	render(){
		return <div> 
				  <div className="wrapper">
	                <div className="align-wrap">
	                    <div className="align mt60">
	                        <h2 className="hidden">게시판 정렬폼</h2>
	                        <form className="category-align">
	                            <fieldset>
	                                <legend className="hidden">카테고리 정렬 필드</legend>
	                                <select className="select-box" name="c" >
	                                    <option>카테고리</option>
	                                    <option value={question}>질문</option>
	                                    <option value={post}>입양후기</option>
	                                    <option value={dog}>우리집 멍이</option>
	                                    <option value={cat}>우리집 냥이</option>
	                                </select>
	                            </fieldset>
	                        </form>
	                        <form className="view-align">
	                            <fieldset>
	                                <legend className="hidden">View 정렬 필드</legend>
	                                <select className="select-box" name="v" >
	                                    <option>보기</option>
	                                    <option value={10}>10개씩</option>
	                                    <option value={15}>15개씩</option>
	                                    <option value={30}>30개씩</option>                            
	                                </select>
	                            </fieldset>
	                        </form>
	                    </div>
	                </div>    
	                <div className="list-common mt30">
	                    <h2 className="hidden">목록</h2>
	                    <ul className="list-data">
	                    	
		                        <li className="list-article mt20">
		                            <a className="list-link" href="${n.id}">
		                                <div className="post-content has-image">
		                                    <strong className="subject bold">${n.title}</strong>
		                                    <div className="content mt10">${n.content}</div>   	                                     
		                                    <span className="meta pt15">
		                                        <span className="name-txt">댓글 </span>
		                                        <span className="num-txt dot bold">${n.comment} </span>
		                                        <span className="name-txt">좋아요 </span>
		                                        <span className="num-txt dot bold">${n.like}</span>
		                                        <span className="hit">조회수</span>
		                                        <span className="num-txt bold dot">${n.hitCnt}</span>
		                                        <span className="ico">by</span>
		                                        <span className="num-txt bold dot">${n.nickname}</span>
		                                        <span className="hit">작성일</span>
		                                        <span className="num-txt bold" >
		                                        	${n.regDate}
		                                        </span>
		                                    </span>
		                                </div>
		                                <div className="post-image">
		                                    <img src="/images/community/dog.png" />
		                                </div>
		                            </a>
		                        </li>
	
	                    </ul>
	                </div>
	                <div className="write-common pt15">                
	                    <div><span className="text-red bold">1</span> / ${pageCount} pages</div>
	                    <form>
	                    	<a className="community-button bold" type="button" href="/community/reg" >글쓰기 </a>
	                    </form>
	                </div>
	            </div>
 
	            <div className="pager-common mt30">
	                <div className="pager">                
	                
	                    <div className="prev mr15">
	                            
	                        <a className="btn btn-prev" href="p=${startNum-5}&f=${param.f}&q=${param.q}&v=${param.v}">이전</a>
	                                  
	                        <a><span className="btn btn-prev" onClick={()=>{alert('이전 페이지가 없습니다.')}}>이전</span></a>
	                  
	                    </div>
	                    <ul className="btn-center">
	                  
	                        	<li className="${current}"><a className="bold " href="?p=${i+startNum}&f=${param.f}&q=${param.q}&v=${param.v}">${i+startNum}</a></li>
							
	                    </ul>
	                    
	                    <div className="next">
	                    	
	                        	<a className="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.p}&v=${param.v}">다음</a>
	                      
	                        	<a><span className="btn btn-next" onClick={()=>{alert('다음 페이지가 없습니다.');}}>다음 </span></a>                        	
	                    
	                    </div>
	                    
	                </div>
	                <div className="search-form mt20"> 
	                    <h2 className="hidden">커뮤니케이션 검색폼</h2>    
	                    <form action="">
	                        <fieldset>
	                            <legend className="hidden">검색필드</legend>
	                            <label className="hidden">검색분류</label>
	                            <select className="search-select" name="f">
	                                <option value={title}>제목</option>
	                                <option value={nickname}>작성자</option>
	                            </select>
	                            <label className="hidden">검색어</label>
	                            <input className="search-window"  type="text" name="q" value={{q}}/>
	                            <input className="btn btn-search" type="submit" value={검색} />
	                        </fieldset>
	                    </form>
	                </div>
           	 	</div>
			</div>
	}
	
}




ReactDOM.render(
	<BoardList />
	,document.querySelector(".main-container")
);



