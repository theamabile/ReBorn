package com.reborn.web.controller.api.care;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.reborn.web.entity.care.AnimalEntityTemp;
import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.CareWish;
import com.reborn.web.service.care.CareService;

@RestController("apiCareController")
@RequestMapping("/api/care/")
public class CareController {

	private CareService careService;
	// ============================================================
	// ============================================================
	// 테스트용 아이디, careService에서도 있음
	private int memberId = 3;
	// ============================================================
	// ============================================================
	
	@Value("${care.animalListUrl}")
	private String animalListUrl;

	@Value("${animal.apiKey}")
	private String animalApiKey;
	
	
	@Autowired
	public CareController(CareService careService) {
		this.careService = careService;
	}

	@GetMapping("list")
	public Map<String, Object> list(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", required = false) String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Principal principal){
		
		Map<String, Object> datas = new HashMap<>();
		int size = 10;
		
		// DATA LOAD ==================================================
		List<CareView> careList = careService.getViewList(page, size, field, query);
		int count = careService.getCount(field, query);
		
		// WISH LOAD ==================================================
		if( !careList.isEmpty() && memberId != 0)
			careService.getWishedList(careList);
		
		int pageCount = (int)Math.ceil( count / (float)size );
		
		datas.put("list", careList);
		datas.put("currentPage", page);
		datas.put("pageCount", pageCount);
		
		return datas;
	}
	
	@GetMapping("{careRegNo}")
	public Map<String, Object> detail(@PathVariable("careRegNo") String careRegNo) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		Map<String, Object> datas = new HashMap<>();
		
		Care care = careService.getCareByCareRegNo(careRegNo);
		
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
		datas.put("care", care);
		datas.put("animalInfoList", animalInfoList);
		
		return datas;
	}
	
	@PostMapping("wish")
	public Map<String, Object> wish(String careRegNo, Boolean wish){
		Map<String, Object> datas = new HashMap<>();
		
		if(memberId == 0) {
			datas.put("result", "fail");
			return datas;
		}
		
		CareWish cw = new CareWish();
		
		cw.setCareRegNo(careRegNo);
		cw.setMemberId(memberId);
		
		int result = 0;
		if( wish ) {
			result = careService.insertWish(cw);
		} else {
			result = careService.deleteWish(cw);
		}
		
		if(result == 0)
			datas.put("result", "fail");
		else
			datas.put("result", "sussess");
		
		datas.put("careRegNo", cw.getCareRegNo());
		
		return datas;
	}
}
