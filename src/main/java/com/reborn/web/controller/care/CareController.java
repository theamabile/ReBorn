package com.reborn.web.controller.care;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.reborn.web.entity.area.AreaView;
import com.reborn.web.entity.care.Care;
import com.reborn.web.entity.care.CareView;
import com.reborn.web.entity.care.AnimalEntityTemp;
import com.reborn.web.service.area.AreaService;
import com.reborn.web.service.care.CareService;

@Controller("careController")
@RequestMapping("/care/")
public class CareController {


	@Value("${animal.apiKey}")
	private String animalApiKey;
	
	@Value("${care.infoApiKey}")
	private String careApiKey;
	
	
	@Value("${care.listApiUrl}")
	private String listApiUrl;
	
	@Value("${care.listApiUrl}")
	private String infoApiUrl;
	
	@Value("${care.animalListUrl}")
	private String animalListUrl;

	private CareService careService;
	private AreaService areaService;
	
	@Autowired
	public CareController(CareService careService, AreaService areaService) {
		this.careService = careService;
		this.areaService = areaService;
	}
	
	@GetMapping("list")
	public String list(
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "f", required = false) String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model, Principal principal){
		
//		int size = 10;
//		
//		// DATA LOAD ==================================================
//		List<CareView> careList = careService.getViewList(page, size, field, query);
//		int count = careService.getCount(field, query);
//		
//		// WISH LOAD ==================================================
//		
//		// ============================================================
//		// ============================================================
//		// 테스트용 아이디, careService에서도 있음
//		int memberId = 3;
//		// ============================================================
//		// ============================================================
//		
//		if( !careList.isEmpty() && memberId != 0)
//			careService.getWishedList(careList);
//		
//		model.addAttribute("currentPage", page);
//		model.addAttribute("list", careList);
//		
//		int pageCount = (int)Math.ceil( count / (float)size );
//		model.addAttribute("pageCount", pageCount);
		
		return "home.care.list";
	}
	
	@GetMapping("{careRegNo}")
	public String detail( @PathVariable("careRegNo") String careRegNo,
			Model model) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		
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
		model.addAttribute("care", care);
		model.addAttribute("animalInfoList", animalInfoList);
		
		return "home.care.detail";
	}

	@PostMapping("rebuildList")
	@ResponseBody
	public String rebuildList() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		// 보호소 목록 API로 불러오기 ========================================================================================
		List<AreaView> areaList = areaService.getAreaViewList();
		List<Care> careList = new ArrayList<>();
		
		for(AreaView av : areaList) {
			int orgCd = av.getOrgCd();
			int uprCd = av.getUprCd();
			
			// URL 합치기
			StringBuilder urlBuilder = new StringBuilder(listApiUrl);
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + animalApiKey);
			urlBuilder.append("&" + URLEncoder.encode("upr_cd","UTF-8") + "=" + uprCd);
			urlBuilder.append("&" + URLEncoder.encode("org_cd","UTF-8") + "=" + orgCd);
			
			// URL로 GET 요청 보냄
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
			                                       .parse(urlBuilder.toString());
			XPath xpath = XPathFactory.newInstance().newXPath();
	        
			// 받은걸로 데이터 추출
	        NodeList itemNodes = (NodeList)xpath.evaluate("//body/items/item", document, XPathConstants.NODESET);
	        for( int i = 0; i < itemNodes.getLength(); i++ ){
	            XPathExpression careNmExpression = xpath.compile("careNm");
	            XPathExpression careRegNoExpression = xpath.compile("careRegNo");
	            
				Node careNmNode = (Node) careNmExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				Node careRegNoNode = (Node) careRegNoExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				
				String careNm = careNmNode.getTextContent();
				String careRegNo = careRegNoNode.getTextContent();
				
				Care c = new Care();
				c.setCareRegNo(careRegNo);
				c.setName(careNm);
				c.setOrgCd(orgCd);
				c.setUprCd(uprCd);
				
				careList.add(c);
	        }
//	       	테스트할때 break
//			break;
		}
		
		System.out.println("com.reborn.web.controller.CareController Message: " + careList.size() + "개 보호소를 찾았습니다.");
		
		// 보호소 목록 DB INSERT ========================================================================================
		List<Care> failList = new ArrayList<>();
		List<Care> updateList = new ArrayList<>();
		List<Care> sussessList = new ArrayList<>();
		
		for(Care care : careList) {
			int insert = 0;
			
			try {
				insert = careService.insert(care);
			} catch(Exception e) {
//				System.out.println(e);
			} finally {
				if( insert == 0) {
					
//					int update = 0;
//					try {
//						Care origin = careService.getCareByCareRegNo(care.getCareRegNo());
//						
//						update = careService.update(origin);
//					} catch(Exception e) {
////						System.out.println(e);
//					} finally {
//						if( update == 0 )
//							failList.add(care);
//						else
//							updateList.add(care);	
//					}
					failList.add(care);
				} else {
					sussessList.add(care);
				}
			}
			
			
		}
		StringBuilder result = new StringBuilder(); 
		Gson gson = new Gson();
		
		
		result.append("{");
		result.append("\"findCareSize\":" + careList.size());
		result.append(",");
		result.append("\"sussess\":" + gson.toJson(sussessList));
		result.append(",");
		result.append("\"update\":" + gson.toJson(updateList));
		result.append(",");
		result.append("\"fail\":" + gson.toJson(failList));
		result.append("}");
		
		return result.toString();
	}
	

	@PostMapping("rebuildDetail")
	@ResponseBody
	public String rebuildDetail() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, ParseException {

		
		// DB에서 리스트 가져오기 ===========================================================================================
		List<Care> careList = careService.getList(0, 999999, null, null);
		
		// 보호소 정보 API로 불러오기 ========================================================================================
		List<Care> sussessList = new ArrayList<>();
		List<Care> failList = new ArrayList<>();
		
//		int cnt = 0;
		for(Care care : careList) {
			String care_reg_no = care.getCareRegNo();
			String care_nm = care.getName();
			
			// URL 합치기
			StringBuilder urlBuilder = new StringBuilder(infoApiUrl);
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + careApiKey);
			urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + URLEncoder.encode(care_reg_no,"UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("care_nm","UTF-8") + "=" + URLEncoder.encode(care_nm,"UTF-8"));
			
			// URL로 GET 요청 보냄
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
			                                       .parse(urlBuilder.toString());
			XPath xpath = XPathFactory.newInstance().newXPath();
	        
			// 받은걸로 데이터 추출
	        NodeList itemNodes = (NodeList)xpath.evaluate("//body/items/item", document, XPathConstants.NODESET);
	        for( int i = 0; i < itemNodes.getLength(); i++ ){
	            XPathExpression telExpression = xpath.compile("careTel");
	            XPathExpression addrExpression = xpath.compile("careAddr");
	            XPathExpression jibunAddrExpression = xpath.compile("jibunAddr");
	            XPathExpression latExpression = xpath.compile("lat");
	            XPathExpression lngExpression = xpath.compile("lng");
	            XPathExpression dataStdDtExpression = xpath.compile("dataStdDt");
	            
				Node telNode = (Node) telExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				Node addrNode = (Node) addrExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				Node jibunAddrNode = (Node) jibunAddrExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				Node latNode = (Node) latExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				Node lngNode = (Node) lngExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				Node dataStdDtNode = (Node) dataStdDtExpression.evaluate(itemNodes.item(i), XPathConstants.NODE);
				
				String tel = "";
				String addr = "";
				String jibunAddr = "";
				String lat = "";
				String lng = "";

				Care origin = careService.getCareByCareRegNo(care_reg_no);
				
				if( telNode != null ) {
					tel = telNode.getTextContent();
					origin.setTel(tel);
				}
				if( addrNode != null ) {
					addr = addrNode.getTextContent();
					origin.setAddr(addr);
				}
				if( jibunAddrNode != null ) {
					jibunAddr = jibunAddrNode.getTextContent();
					origin.setJibunAddr(jibunAddr);
				}
				if( latNode != null ) {
					lat = latNode.getTextContent();
					origin.setLatitude(lat);
				}
				if( lngNode != null ) {
					lng = lngNode.getTextContent();
					origin.setLongitude(lng);
				}
				if( dataStdDtNode != null ) {
					String dataStdDt_ = dataStdDtNode.getTextContent();

					SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date dataStdDt = transFormat.parse(dataStdDt_);
					origin.setDataStdDt(dataStdDt);
				}
				
				int result = careService.update(origin);
				
				if( result == 0 ) {
					failList.add(origin);
				} else {
					sussessList.add(origin);
				}
	        }
	        
//	      	테스트
//	        if(cnt == 6)
//	        	break;
//
//	        cnt++;
		}
		
		StringBuilder result = new StringBuilder(); 
		Gson gson = new Gson();
		
		result.append("{");
		result.append("\"findCareSize\":" + careList.size());
		result.append(",");
		result.append("\"sussessSize\":" + sussessList.size());
		result.append(",");
		result.append("\"sussess\":" + gson.toJson(sussessList));
		result.append(",");
		result.append("\"failSize\":" + failList.size());
		result.append(",");
		result.append("\"fail\":" + gson.toJson(failList));
		result.append("}");
		
		return result.toString();
		
	}
	
}
