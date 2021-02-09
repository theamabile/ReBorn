package com.reborn.web.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.reborn.web.entity.animal.Animal;
import com.reborn.web.entity.name.Name;
import com.reborn.web.entity.name.VoteView;
import com.reborn.web.service.animal.AnimalService;
import com.reborn.web.service.name.NameService;
import com.reborn.web.service.name.VoteService;

@Component
public class VoteUpdateScheduler {

	@Autowired
	VoteService voteService;
	
	@Autowired
	NameService nameService;

	@Autowired
	AnimalService animalService;
	
	// 매분 1초마다 실행
	@Scheduled(cron = "1 * * * * *", zone = "Asia/Seoul")
	//@Scheduled(fixedDelay = 1000)
	public void checkVoteEnd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		
		// 투표 시작 체크 => 투표 시작 일(voteStartDate)이 현재 날짜보다 적거나 같고, state가 NONE(투표 미시작)인 투표들
		List<VoteView> startList = voteService.getStartViewList(now, "state", "NONE");

		//System.out.println("@@@@@@@@@@@@@@@");
		for(VoteView v : startList) {
			System.out.println(v.getAnimalId()+" : "+v.getNameCnt()+"개");
			if( v.getNameCnt() <= 1) {
				// 단일 후보면 동물에게 이름 넣어주고 바로 투표 종료				
				Name resultName = nameService.getBestName(v.getAnimalId());		// 이 동물의 가장 인기 있는 이름을 갖고옴
				Animal animal = animalService.get(v.getAnimalId());
				animal.setName(resultName.getName());
				animalService.update(animal);		// 이름 지어주기
				v.setState("END");					
			} else {	
				System.out.println("start : "+v.getAnimalId());
				v.setState("START");		// 후보가 여러개면 투표 상태를 시작으로 변경
			}
			voteService.update(v);			
		}
		
		
		// 투표 종료 => 투표 종료기간에 다다른 투표를 종료상태로 변경하고, 투표 결과에 따라 동물의 이름을 넣어줌.
		List<VoteView> endList = voteService.getEndViewList(now, "state", "START");
		
		for(VoteView v : endList) {
			System.out.println("투표 종료 - 바꿔야 할 애 : "+v.getAnimalId());
			Name resultName = nameService.getBestName(v.getAnimalId());		// 이 동물의 가장 인기 있는 이름을 갖고옴
			Animal animal = animalService.get(v.getAnimalId());
			animal.setName(resultName.getName());
			animalService.update(animal);		// 이름 지어주기
			
			v.setState("END");			
			voteService.update(v);				// 투표 상태를 종료로 변경
		}
				
	}
	
	
}
