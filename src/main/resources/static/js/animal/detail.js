window.addEventListener("load", e=>{
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  
	
	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	
	
	let happenPlace = document.querySelector('.happenPlace');
	
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(happenPlace.innerText, function(result, status) {
	
	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
	
	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">발견 장소</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } else {
		
			console.log("fail to search - happenPlace : "+happenPlace.innerText);
			
	        var coords = new kakao.maps.LatLng(37.572078, 126.987300);
			  // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });

   			// 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;color:red;">발견 장소를 찾지 못했습니다</div>'
	        });
	        infowindow.open(map, marker);
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
			
		}
	});    
	
	 
	let container = document.querySelector('.main-container');
	let callBtn = container.querySelector('.callBtn');
	callBtn.addEventListener("click", e=>{
		let officetel = container.querySelector('.officetel');
		let createInput = document.createElement("input");
		createInput.setAttribute("type","text");
		createInput.value = officetel.innerText;
		
		console.log("createInput.value : "+createInput.value);
		//container.insertAdjacentElement('afterend', createInput);
		container.appendChild(createInput);
		
		createInput.select();
		document.execCommand('copy');
		container.removeChild(createInput);
		
 		// document.body.removeChild(tempElem);

		alert("클립보드에 복사되었습니다.");
	});
});
