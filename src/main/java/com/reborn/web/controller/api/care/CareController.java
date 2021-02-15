package com.reborn.web.controller.api.care;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.reborn.web.entity.animal.Animal;
import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareReview;
import com.reborn.web.entity.care.CareReviewView;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;
import com.reborn.web.entity.member.Member;
import com.reborn.web.service.animal.AnimalService;
import com.reborn.web.service.care.CareService;
import com.reborn.web.service.member.MemberService;

@RestController("apiCareController")
@RequestMapping("/api/care/")
public class CareController {

	private CareService careService;
	private AnimalService animalService;
	private MemberService memberService;
	
	@Value("${care.animalListUrl}")
	private String animalListUrl;

	@Value("${animal.apiKey}")
	private String animalApiKey;
	
	
	@Autowired
	public CareController(CareService careService, AnimalService animalService, MemberService memberService) {
		this.careService = careService;
		this.animalService = animalService;
		this.memberService = memberService;
	}

	@GetMapping("list")
	public Map<String, Object> list(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", required = false) String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			HttpSession session){
		
		Map<String, Object> datas = new HashMap<>();
		int size = 10;
		
		// DATA LOAD ==================================================
		List<CareView> careList = careService.getViewList(page, size, field, query);
		int careCount = careService.getCount(field, query);
		
		// WISH LOAD ==================================================
		int memberId = 0;
		Object memberId_ = session.getAttribute("id");
		if( !careList.isEmpty() && memberId_ != null) {
			memberId = (int) memberId_;
			careService.getWishedList(memberId, careList);
		}
			
		
		int pageCount = (int)Math.ceil( careCount / (float)size );
		datas.put("memberId", memberId);
		datas.put("list", careList);
		datas.put("currentPage", page);
		datas.put("pageCount", pageCount);
		datas.put("careCount", careCount);
		
		
		return datas;
	}

	@GetMapping("{careRegNo}")
	public Map<String, Object> detail(
			@PathVariable("careRegNo") String careRegNo,
			HttpSession session){
		Map<String, Object> datas = new HashMap<>();
		List<CareReviewView> reviewList = new ArrayList<>();
		int size = 10;
		
		Care care = careService.getCareByCareRegNo(careRegNo);		
		reviewList = careService.getReviewViewList(1, size, careRegNo);
		double reviewScoreAvg = careService.getReviewAvg(careRegNo); 
		
//		List<Animal> animalList = new ArrayList<>();
		
		List<Animal> animalList = null;
		animalList = animalService.getListByCareRegNo(careRegNo);

		Object loginId_ = session.getAttribute("loginId");
		if( loginId_ != null && !loginId_.equals("") ) {
			String loginId = (String) loginId_;
			Member m = memberService.get(loginId);
			datas.put("nickname", m.getNickname());
			datas.put("memberId", m.getId());
		}
		
		int reviewCnt = 0;
		int reviewPageCnt = 0;
		reviewCnt = careService.getReviewCount(careRegNo);
		reviewPageCnt = (int)Math.ceil( reviewCnt / (float)size );
		
		datas.put("care", care);
		datas.put("reviewList", reviewList);
		datas.put("reviewCnt", reviewCnt);
		datas.put("reviewPageCnt", reviewPageCnt);
		datas.put("reviewScoreAvg", reviewScoreAvg);
		datas.put("animalList", animalList);
		
		return datas;
	}
	
	/* API로 받아오는 버전 
	@GetMapping("{careRegNo}")
	public Map<String, Object> detail(@PathVariable("careRegNo") String careRegNo) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		Map<String, Object> datas = new HashMap<>();
		List<CareReviewView> reviewList = new ArrayList<>();
		int size = 10;
		
		Care care = careService.getCareByCareRegNo(careRegNo);		
		reviewList = careService.getReviewViewList(1, size, careRegNo);
		
		// API 보호동물들 가져오기
		List<AnimalEntityTemp> animalInfoList = new ArrayList<>();
		try {
			StringBuilder urlBuilder = new StringBuilder(animalListUrl);
		
			int getSize = 100;
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + animalApiKey);
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + getSize);
			urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + careRegNo);
			urlBuilder.append("&" + URLEncoder.encode("state","UTF-8") + "=" + "protect");
			
			// URL로 GET 요청 보냄
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
			                                       .parse(urlBuilder.toString());
			XPath xpath = XPathFactory.newInstance().newXPath();

			// 받은걸로 데이터 추출
	        NodeList itemNodes = (NodeList)xpath.evaluate("//body/items/item", document, XPathConstants.NODESET);
	        for( int i = 0; i < itemNodes.getLength(); i++ ){
	            XPathExpression noticeNoExpression = xpath.compile("noticeNo");
	            XPathExpression popfileExpression = xpath.compile("popfile");
	            
				Node noticeNoNode = (Node) noticeNoExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				Node popfileNode = (Node) popfileExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				
				String noticeNo = noticeNoNode.getTextContent();
				String popfile = popfileNode.getTextContent();
				
				AnimalEntityTemp aet = new AnimalEntityTemp();
				aet.setNoticeNo(noticeNo);
				aet.setPopfile(popfile);
				
				animalInfoList.add(aet);
	        }
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
//		System.out.println(animalInfoList);
		int reviewCnt = 0;
		int reviewPageCnt = 0;
		reviewCnt = careService.getReviewCount(careRegNo);
		reviewPageCnt = (int)Math.ceil( reviewCnt / (float)size );
		
		datas.put("care", care);
		datas.put("reviewList", reviewList);
		datas.put("reviewCnt", reviewCnt);
		datas.put("reviewPageCnt", reviewPageCnt);
		datas.put("animalInfoList", animalInfoList);
		
		return datas;
	}
	*/
	
	@PostMapping("{careRegNo}/wish/insert")
	public Map<String, Object> wishInsert(
			@PathVariable("careRegNo") String careRegNo,
			HttpSession session){
		Map<String, Object> datas = new HashMap<>();
		Object memberId_ = session.getAttribute("id");
		
		if(memberId_ == null) {
			datas.put("result", "fail");
			return datas;
		}
		
		int memberId = (int) memberId_;
		CareWish cw = new CareWish();
		
		cw.setCareRegNo(careRegNo);
		cw.setMemberId(memberId);
		
		int result = careService.insertWish(cw);
		
		if(result == 0)
			datas.put("result", "fail");
		else
			datas.put("result", "success");
		
		datas.put("careRegNo", cw.getCareRegNo());
		
		return datas;
	}

	@PostMapping("{careRegNo}/wish/delete")
	public Map<String, Object> wishDelete(
			@PathVariable("careRegNo") String careRegNo,
			HttpSession session){
		Map<String, Object> datas = new HashMap<>();
		Object memberId_ = session.getAttribute("id");
		
		if(memberId_ == null) {
			datas.put("result", "fail");
			return datas;
		}
		
		int memberId = (int) memberId_;
		CareWish cw = new CareWish();
		
		cw.setCareRegNo(careRegNo);
		cw.setMemberId(memberId);
		
		int result = careService.deleteWish(cw);
		
		if(result == 0)
			datas.put("result", "fail");
		else
			datas.put("result", "success");
		
		datas.put("careRegNo", cw.getCareRegNo());
		
		return datas;
	}

	@GetMapping("{careRegNo}/review/list")
	public Map<String, Object> reviewList(
			@PathVariable("careRegNo") String careRegNo,
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "s", defaultValue = "10") Integer size
			){
		Map<String, Object> datas = new HashMap<>();
		if(careRegNo == null || careRegNo.equals("")) {
			return datas;
		}
		
		List<CareReviewView> list = new ArrayList<>();
		int reviewCnt = 0;
		int reviewPageCnt = 0;
		double reviewScoreAvg = 0; 
		list = careService.getReviewViewList(page, size, careRegNo);
		reviewCnt = careService.getReviewCount(careRegNo);
		reviewPageCnt = (int)Math.ceil( reviewCnt / (float)size );
		reviewScoreAvg = careService.getReviewAvg(careRegNo);
		
		datas.put("reviewList", list);
		datas.put("reviewCnt", reviewCnt);
		datas.put("reviewPageCnt", reviewPageCnt);
		datas.put("reviewScoreAvg", reviewScoreAvg);
		
		return datas;
	}

	@PostMapping("{careRegNo}/review/insert")
	public Map<String, Object> reviewInsert(
			@PathVariable("careRegNo") String careRegNo,
			HttpSession session,
			String title, String content, int score){
		Map<String, Object> datas = new HashMap<>();
		Object memberId_ = session.getAttribute("id");
		
		if(memberId_ == null) {
			datas.put("result", "fail");
			return datas;
		}
		
		int memberId = (int) memberId_;
		int result = 0;
		
		CareReview cr = new CareReview();
		cr.setCareRegNo(careRegNo);
		cr.setMemberId(memberId);
		cr.setTitle(title);
		cr.setContent(content);
		cr.setScore(score);
		
		result = careService.insertReview(cr);
		
		if(result == 0)
			datas.put("result", "fail");
		else {
			datas.put("result", "success");

			int size = 10;
			int page = 1;
			int reviewCnt = 0;
			int reviewPageCnt = 0;
			double reviewScoreAvg = 0;
			
			List<CareReviewView> list = careService.getReviewViewList(page, size, careRegNo);
			reviewCnt = careService.getReviewCount(careRegNo);
			reviewScoreAvg = careService.getReviewAvg(careRegNo); 
			reviewPageCnt = (int)Math.ceil( reviewCnt / (float)size);
			
			datas.put("reviewCnt", reviewCnt);
			datas.put("reviewPageCnt", reviewPageCnt);
			datas.put("reviewScoreAvg", reviewScoreAvg);
			datas.put("reviewList", list);
		}

		datas.put("careReviewId", cr.getId());
		
		return datas;
	}

	@PostMapping("{careRegNo}/review/{reviewId}/edit")
	public Map<String, Object> reviewEdit(
			@PathVariable("reviewId") int reviewId,
			String title, String content, int score,
			HttpSession session){
		Map<String, Object> datas = new HashMap<>();
		Object memberId_ = session.getAttribute("id");
		
		if(memberId_ == null) {
			datas.put("result", "fail");
			return datas;
		}
		
		int memberId = (int) memberId_;
		int result = 0;

		CareReview origin = careService.getReview(reviewId);
		
		origin.setTitle(title);
		origin.setContent(content);
		origin.setScore(score);
		
		result = careService.updateReview(origin);
		
		if(result == 0)
			datas.put("result", "fail");
		else {
			double reviewScoreAvg = careService.getReviewAvg(origin.getCareRegNo());
			datas.put("result", "success");
			datas.put("review", origin);
			datas.put("reviewScoreAvg", reviewScoreAvg);
		}
		
		return datas;
	}

	@PostMapping("{careRegNo}/review/{reviewId}/delete")
	public Map<String, Object> reviewDelete(
			@PathVariable("careRegNo") String careRegNo,
			@PathVariable("reviewId") int reviewId,
			HttpSession session){
		Map<String, Object> datas = new HashMap<>();
		Object memberId_ = session.getAttribute("id");
		
		if(memberId_ == null) {
			datas.put("result", "fail");
			return datas;
		}
		
		int memberId = (int) memberId_;
		int result = 0;
		
		result = careService.deleteReview(reviewId);
		
		if(result == 0) {
			datas.put("result", "fail");
		} else {
			double reviewScoreAvg = careService.getReviewAvg(careRegNo);
			int reviewCnt = careService.getReviewCount(careRegNo);
			int reviewPageCnt = (int)Math.ceil( reviewCnt / (float)10);
			datas.put("result", "success");
			datas.put("reviewId", reviewId);
			datas.put("reviewCnt", reviewCnt);
			datas.put("reviewPageCnt", reviewPageCnt);
			datas.put("reviewScoreAvg", reviewScoreAvg);
		}
		
		return datas;
	}
}
