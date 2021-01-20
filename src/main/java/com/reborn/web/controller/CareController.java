package com.reborn.web.controller;

import java.io.IOException;
import java.net.URLEncoder;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.reborn.web.entity.area.AreaView;
import com.reborn.web.entity.care.Care;
import com.reborn.web.service.area.AreaService;
import com.reborn.web.service.care.CareService;

@RestController("careController")
@RequestMapping("/care/")
public class CareController {

	private CareService careService;
	private AreaService areaService;
	
	@Autowired
	public CareController(CareService careService, AreaService areaService) {
		this.careService = careService;
		this.areaService = areaService;
	}

	@PostMapping("rebuildList")
	public String rebuildList() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		
		
		// 보호소 목록 API로 불러오기 ========================================================================================
		
		// 보호소
		String apiUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/shelter";
		// apiKey
		String apiKey = "EQTmsEInR3oGqKRwJPqEQfFj9RF5ljGYfS4qLKNPxyTbMh1e0GWCPIyN%2F3gAmmXjhC5xlM0E6zp4LK3vxUAqEw%3D%3D";
		List<AreaView> areaList = areaService.getAreaViewList();
		List<Care> careList = new ArrayList<>();
		
		for(AreaView av : areaList) {
			int orgCd = av.getOrgCd();
			int uprCd = av.getUprCd();
			
			// URL 합치기
			StringBuilder urlBuilder = new StringBuilder(apiUrl);
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + apiKey);
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
	

	@RequestMapping("rebuildDetail")
	public String rebuildDetail() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException, ParseException {

		
		// DB에서 리스트 가져오기 ===========================================================================================
		List<Care> careList = careService.getList(0, 999999, null, null);
		
		// 보호소 정보 API로 불러오기 ========================================================================================
		String detailURL = "http://openapi.animal.go.kr/openapi/service/rest/animalShelterSrvc/shelterInfo";
		String detailKey = "qI9VC1hzBT8RhgLR68VVG%2BKLF3rq%2BKBEJ0zgQHHI4Ofwz%2FNKeFCcM%2BfhDXHkJUyBrqiAOyYyzMN44WxDfR6Wsg%3D%3D";
		List<Care> sussessList = new ArrayList<>();
		List<Care> failList = new ArrayList<>();
		
//		int cnt = 0;
		for(Care care : careList) {
			String care_reg_no = care.getCareRegNo();
			String care_nm = care.getName();
			
			// URL 합치기
			StringBuilder urlBuilder = new StringBuilder(detailURL);
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + detailKey);
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
