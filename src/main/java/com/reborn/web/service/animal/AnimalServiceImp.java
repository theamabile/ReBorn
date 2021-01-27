package com.reborn.web.service.animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.taglibs.standard.extra.spath.AbsolutePath;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.reborn.web.dao.animal.AnimalDao;
import com.reborn.web.entity.animal.Animal;
import com.reborn.web.entity.animal.AnimalAPIResponseData;
import com.reborn.web.entity.animal.AnimalKind;

@Service
public class AnimalServiceImp implements AnimalService{

	@Autowired
	AnimalDao animalDao;
	
	@Value("${animal.animalApiUrl}")
	private String animalUrl;
		
	@Value("${animal.apiKey}")
	private String serviceKey;
	
	
	@Override
	public int insert(Animal animal) {
		// TODO Auto-generated method stub
		return animalDao.insert(animal);
	}

	@Override
	public int update(Animal animal) {
		// TODO Auto-generated method stub
		return animalDao.update(animal);
	}

	@Override
	public int delete(long desertionNo) {
		// TODO Auto-generated method stub
		return animalDao.delete(desertionNo);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return animalDao.getCount();
	}

	@Override
	public Animal get(long desertionNo) {
		// TODO Auto-generated method stub
		return animalDao.get(desertionNo);
	}

	@Override
	public List<Animal> getList() {
		// TODO Auto-generated method stub
		return animalDao.getList();
	}
	
	public Animal getByDesertionNo(long desertionNo) {
		// TODO Auto-generated method stub
		return animalDao.getByDesertionNo(desertionNo);
	}
	

	@Override
	public AnimalAPIResponseData getListFromAPI(int page, int size, String upkind, String kind, Date startDate, Date endDate,
			String neuter) {
		// TODO Auto-generated method stub
		
		Runnable sub = new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println("@@@@@@@@@@@@@@@@@ 로드 스레드 종료 ################");
			}
		};
		
		Thread th = new Thread(sub);
		th.start();
		
		String state = "protect";		//- 전체 : null(빈값) / - 공고중 : notice / - 보호중 : protect
		StringBuilder sb = new StringBuilder();
        String result = "";
		StringBuilder urlBuilder = new StringBuilder(animalUrl);
		
		Map<String, Object> urlMap = new TreeMap<>();
		urlMap.put("pageNo", page);
		urlMap.put("numOfRows", size);
		urlMap.put("state", state);
		urlMap.put("upkind", upkind);
		urlMap.put("kind", kind);
		urlMap.put("bgnde", startDate);
		urlMap.put("endde", endDate);
		urlMap.put("neuter", neuter);
		
		try {
			
			// url 만들기
			urlBuilder.append("?");
			
			for( String key : urlMap.keySet()) {
				Object value = urlMap.get(key);
				urlBuilder.append(URLEncoder.encode(key,"UTF-8"));
				urlBuilder.append("=");
				if(value == null) {
					value = "";
				}	
				
				urlBuilder.append(value);
				urlBuilder.append("&");			// 어차피 마지막에 서비스 키 붙음
			}
			
			// 서비스키 붙이기
			//urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
			urlBuilder.append(URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
			
			System.out.println("api url : "+urlBuilder.toString());
			
			
			URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/xml");
	        System.out.println("Response code: " + conn.getResponseCode());
	        
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }

	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        
	        result = sb.toString();
	        System.out.println(sb.toString());
	 
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		// xml 통째로 json화
		JSONObject xmlJSON = XML.toJSONObject(result);
		String json = xmlJSON.toString();
		
		
		// ---------------------------- api 데이터 파싱 --------------------------------
		
        JSONObject resultJSON = XML.toJSONObject(sb.toString());    // xml을 json으로 변환 후 파싱
        System.out.println(resultJSON);
        
        
        // 직접 파싱해서 데이터를 DB에 넣기	
        JSONObject response = (JSONObject)resultJSON.get("response");
        JSONObject body = (JSONObject)response.get("body");
        int totalCount = body.getInt("totalCount");
        
        JSONObject items = (JSONObject)body.get("items");
        
        JSONArray jsonArray = (JSONArray)items.get("item");
        
        List<Animal> list = new ArrayList<Animal>();
        
        for(Object obj : jsonArray) {
        	Animal a = new Animal();
			JSONObject item = (JSONObject)obj; 
									
			a.setSexCd(item.getString("sexCd"));         
			a.setKindCd(item.getString("kindCd"));           
			a.setNoticeNo(item.getString("noticeNo"));       
			a.setCareAddr(item.getString("careAddr"));        
			a.setProcessState(item.getString("processState"));    
			a.setNoticeSdt(toDate(item.getInt("noticeSdt")));        
			a.setWeight(item.getString("weight"));              
			a.setCareNm(item.getString("careNm"));          
			a.setDesertionNo((long)item.get("desertionNo"));          
			a.setCareTel(item.getString("careTel"));          
			a.setHappenPlace(item.getString("happenPlace"));      
			a.setOfficetel(item.getString("officetel"));        
			a.setOrgNm(item.getString("orgNm"));           
			a.setPopfile(item.getString("popfile"));          
			a.setNoticeEdt(toDate(item.getInt("noticeEdt")));        
			a.setNeuterYn(item.getString("neuterYn"));         
			a.setSpecialMark(item.getString("specialMark"));      
			a.setColorCd(item.getString("colorCd"));          
			a.setHappenDt(toDate(item.getInt("happenDt")));        
			a.setAge(item.getString("age"));          
			
			
			System.out.println("notice starte date - "+a.getNoticeSdt());
			
			
			list.add(a);
        }
        
       return new AnimalAPIResponseData(list, totalCount); 
	}
	

	@Override
	public List<Animal> getList(int page, int size, String upkind, String kind, Date startDate, Date endDate,
			String neuter) {
		// TODO Auto-generated method stub
		return animalDao.getList(page, size, upkind, kind, startDate, endDate, neuter);
	}
	
	
	public void updateListFromAPI(int page, int size, String upkind, String kind, 
			Date startDate, Date endDate, String neuter) {
		
		Runnable sub = new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				String state = "protect";		//- 전체 : null(빈값) / - 공고중 : notice / - 보호중 : protect
				StringBuilder sb = new StringBuilder();
		        String result = "";
				StringBuilder urlBuilder = new StringBuilder(animalUrl);
				
				Map<String, Object> urlMap = new TreeMap<>();
				urlMap.put("pageNo", page);
				urlMap.put("numOfRows", size);
				urlMap.put("state", state);
				urlMap.put("upkind", upkind);
				urlMap.put("kind", kind);
				urlMap.put("bgnde", startDate);
				urlMap.put("endde", endDate);
				urlMap.put("neuter", neuter);
				
				try {
					
					// url 만들기
					urlBuilder.append("?");
					
					for( String key : urlMap.keySet()) {
						Object value = urlMap.get(key);
						urlBuilder.append(URLEncoder.encode(key,"UTF-8"));
						urlBuilder.append("=");
						if(value == null) {
							value = "";
						}	
						
						urlBuilder.append(value);
						urlBuilder.append("&");			// 어차피 마지막에 서비스 키 붙음
					}
					
					// 서비스키 붙이기
					//urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
					urlBuilder.append(URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);
					
					System.out.println("api url : "+urlBuilder.toString());
					
					
					URL url = new URL(urlBuilder.toString());
			        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			        conn.setRequestMethod("GET");
			        conn.setRequestProperty("Content-type", "application/xml");
			        System.out.println("Response code: " + conn.getResponseCode());
			        
			        BufferedReader rd;
			        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			        } else {
			            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			        }

			        String line;
			        while ((line = rd.readLine()) != null) {
			            sb.append(line);
			        }
			        rd.close();
			        conn.disconnect();
			        
			        result = sb.toString();
			        System.out.println(sb.toString());
			 
			        
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				
				// xml 통째로 json화
				JSONObject xmlJSON = XML.toJSONObject(result);
				String json = xmlJSON.toString();
				
				
				// ---------------------------- api 데이터 파싱 --------------------------------
				
		        JSONObject resultJSON = XML.toJSONObject(sb.toString());    // xml을 json으로 변환 후 파싱
		        System.out.println(resultJSON);
		        
		        
		        // 직접 파싱해서 데이터를 DB에 넣기	
		        JSONObject response = (JSONObject)resultJSON.get("response");
		        JSONObject body = (JSONObject)response.get("body");
		        int totalCount = body.getInt("totalCount");
		        
		        JSONObject items = (JSONObject)body.get("items");
		        
		        JSONArray jsonArray = (JSONArray)items.get("item");
		        
		        List<Animal> list = new ArrayList<Animal>();
		        
		        int i=0;
		        for(Object obj : jsonArray) {
		        	Animal a = new Animal();
					JSONObject item = (JSONObject)obj; 
											
					a.setSexCd(item.getString("sexCd"));         
					a.setKindCd(item.getString("kindCd"));           
					a.setNoticeNo(item.getString("noticeNo"));       
					a.setCareAddr(item.getString("careAddr"));        
					a.setProcessState(item.getString("processState"));    
					a.setNoticeSdt(toDate(item.getInt("noticeSdt")));        
					a.setWeight(item.getString("weight"));              
					a.setCareNm(item.getString("careNm"));          
					a.setDesertionNo((long)item.get("desertionNo"));          
					a.setCareTel(item.getString("careTel"));          
					a.setHappenPlace(item.getString("happenPlace"));      
					a.setOfficetel(item.getString("officetel"));        
					a.setOrgNm(item.getString("orgNm"));           
					a.setPopfile(item.getString("popfile"));          
					a.setNoticeEdt(toDate(item.getInt("noticeEdt")));        
					a.setNeuterYn(item.getString("neuterYn"));         
					a.setSpecialMark(item.getString("specialMark"));      
					a.setColorCd(item.getString("colorCd"));          
					a.setHappenDt(toDate(item.getInt("happenDt")));        
					a.setAge(item.getString("age"));          
					
										
					
					list.add(a);
		        }
				
				
		        for(Animal apiItem : list) {
			        // api로 받아온 공고번호와 일치하는 animal을 db에서 가져옴
					Animal origin = getByDesertionNo(apiItem.getDesertionNo());
					
					if(origin == null ) {		// db에 없으면
						// insert
						insert(apiItem);					// api 데이터를 DB에 insert
					} else {
						// update
						update(apiItem);
					}
		        }
				
				System.out.println("@@@@@@@@@@@@@@@@@ 로드 스레드 종료 ################");
			}
		};
		
		Thread th = new Thread(sub);
		th.start();
		

		
		System.out.println("@@@@@@@@@@@@@@@@@ ㅎㅅㅎ ################");
	}
	

	// api 받아올 때 int to Date 매번 하기 귀찮아서 만든 함수
	private Date toDate(int value) {
		String strValue = String.valueOf(value);
		
		String year = strValue.substring(0, 4);
		String month = strValue.substring(4, 6);
		String day = strValue.substring(6, 8);

		String strDate = String.format("%s-%s-%s", year, month, day);

		Date date = Date.valueOf(strDate);
		
		return date;
	}

}
