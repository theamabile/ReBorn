<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/css/community/reg.css" type="text/css" rel="stylesheet" />
<!-- <link href="/css/community/reset.css" type="text/css" rel="stylesheet" /> -->
<link href="/css/community/cummunity-style.css" type="text/css" rel="stylesheet" />

	<section class="main-container">
            <section class="item-tool-bar">
                <div class="item-toolkit">
                    <span class="image-item mr15">image</span>
                    <span class="video-item mr15">video</span>
                    <select class="category-item mr10" name="글꼴" id="">
                        <option value="">나눔고딕</option>
                        <option value="">고딕</option>
                        <option value="">신명조</option>
                        <option value="">궁서</option>
                    </select>
                    <span class="bold-item">bold</span>
                    <span class="italic-item">italic</span>
                    <span class="underline-item">underline</span>
                    <span class="align-left-item">align-left</span>
                    <span class="align-center-item">align-center</span>
                    <span class="align-right-item">align-right</span>                    
                </div>
            </section>
            <section class="wrapper">
                <div class="category-option mt60">
                    <select name="" id="">
                        <option value="question">질문</option>
                        <option value="post">입양후기</option>
                        <option value="dog">강아지와함께</option>
                        <option value="cat">고양이와함께</option>
                    </select>
                </div>
                <form action="post">
                    <div class="article-title mt30">
                        <input type="text" name="" id="" placeholder="제목을 입력해주세요.">
                        
                    </div>
                    <div class="article-content mt30">
                        <textarea name="" id="" cols="30" rows="10">

                        </textarea>
                    </div>
                </section>
                    <div class="article-confirm mt20">
                        <div>
                            <input class="reg-button" type="submit" value="완료"></input>
                        </div>
                    </div>
                </form>

        </section>
      