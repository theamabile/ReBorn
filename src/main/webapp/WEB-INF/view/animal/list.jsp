<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <link rel= "stylesheet" type="text/css" href="/css/animal/list.css">
    <section class="main-container">
		<h1>유기동물 목록 </h1>
		
		<!-- ---------------------- 검색 도구 ------------------------ -->
		<section class="search-box">
			<table>
				<tr>
					<th>
						이름 검색
					</th>
					<td class="name-box " colspan="4">
						<input type="text" placeholder="검색어 입력">
						<input type="submit" value="검색" class="main-button-m">
					</td>
				</tr>
				<tr>
					<th>품종</th>
					<td>
						<select name="upkind">	
							<option>전체</option>  선택 안되면 null로 보내지게
							<option value="417000">개</option>
							<option value="422400">고양이</option>
							<option value="429900">기타</option>
						</select>
						<select name="kind">	
							<!-- 축종에 따라 api로 갖고오기 -->
						</select>
					</td>
					
					<th>이름 여부</th>
					<td>
						<div>
							<input type="radio" name="existName" checked="checked">전체</input>
						</div>
						<div>
							<input type="radio" name="existName" value="N">이름 없음</input>
						</div>
						<div>
							<input type="radio" name="existName" value="Y">이름 있음</input>
						</div>
					</td>			
				</tr>
				<tr>
					<th>유기 날짜</th>
					<td class="regdate table-td-l">
						<input type="date" name="regDateStart">
						<span>~</span>
						<input type="date" name="regDateEnd">
					</td>
					<th>중성화 여부</th>
					<td class="neuter table-td-m">
						<select name="neutralize">	
							<option>전체</option>  <!-- 선택 안되면 null로 보내지게 -->
							<option value="Y">예</option>
							<option value="N">아니오</option>
							<option value="U">미상</option>			
						</select>
					</td>	
				</tr>
			</table>
		</section>
		
		
		
		<!-- <section class="search-box">
			<div class="name-box">
				<label>이름 검색</label>
				<input type="text" placeholder="검색어 입력">
				<input type="submit" value="검색" class="main-button-m">
			</div> 
			<h3>상세 검색</h3>
			<div>
				<div class="kind">
					<label>품종</label>
					<select name="upkind">	
						<option>전체</option>  선택 안되면 null로 보내지게
						<option value="417000">개</option>
						<option value="422400">고양이</option>
						<option value="429900">기타</option>
					</select>
					<select name="kind">	
						축종에 따라 api로 갖고오기
					</select>
				</div>
				<div class="exist-name">
					<label>이름 여부</label>
					<div class="radio-btns">
						<div>
							<input type="radio" name="existName" checked="checked">전체</input>
						</div>
						<div>
							<input type="radio" name="existName" value="N">이름 없음</input>
						</div>
						<div>
							<input type="radio" name="existName" value="Y">이름 있음</input>
						</div>
					</div>
				</div>
				
			</div>
			
			<div>
				<div class="regdate">
					<label>유기 날짜</label>
					<input type="date" name="regDateStart">
					<span>~</span>
					<input type="date" name="regDateEnd">
				</div>
			
				<div class="neuter">
					<label>중성화 여부</label>
					<select name="neutralize">	
						<option>전체</option>  선택 안되면 null로 보내지게
						<option value="Y">예</option>
						<option value="N">아니오</option>
						<option value="U">미상</option>			
					</select>
				</div>
			</div> -->			
		</section>
			
			
			
			<!-- <div class="detail-box">
				<h4>상세 검색</h4>
				<div class="exist-name">
					<label>이름 여부</label>
					<div>
						<input type="radio" name="existName" checked="checked">전체</input>
					</div>
					<div>
						<input type="radio" name="existName" value="N">이름 없음</input>
					</div>
					<div>
						<input type="radio" name="existName" value="Y">이름 있음</input>
					</div>
				</div>
				<div class="regdate">
					<label>유기 날짜</label>
					<input type="date" name="regDateStart">
					<span>~</span>
					<input type="date" name="regDateEnd">
				</div>
				<div>
					<div class="kind">
						<label>품종</label>
						<select name="upkind">	
							<option>전체</option>  선택 안되면 null로 보내지게
							<option value="417000">개</option>
							<option value="422400">고양이</option>
							<option value="429900">기타</option>
						</select>
						<select name="kind">	
							축종에 따라 api로 갖고오기
						</select>
					</div>
					<div class="neuter">
						<label>중성화 여부</label>
						<select name="neutralize">	
							<option>전체</option>  선택 안되면 null로 보내지게
							<option value="Y">예</option>
							<option value="N">아니오</option>
							<option value="U">미상</option>			
						</select>
					</div>
				</div>
				
			</div>
		</section> -->




		<!-- ---------------------- 목록 ------------------------ -->
		
	<div class="animal-box">
		<img src="/images/kiki.JPG" />
		<div class="title-box">
			<span>추냥쓰</span>
			<div></div>
		</div>
		<div class="main-info-box">
			<span>외동읍 녹동원길</span>
			<span>생후 40일령</span>
		</div>
		<div class="sub-info-box">
			<span>수컷</span>
			<span>믹스견</span>
			<span>2021-01-19</span>
		</div>
	</div>

    </section>

