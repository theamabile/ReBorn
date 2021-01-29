package com.reborn.web.service.animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.reborn.web.entity.animal.AnimalKind;
import com.reborn.web.entity.animal.AnimalUpKind;

@Service
public class AnimalServiceImp implements AnimalService{

	@Autowired
	AnimalDao animalDao;
	
	@Value("${animal.animalApiUrl}")
	private String animalUrl;
		
	@Value("${animal.apiKey}")
	private String serviceKey;
	
	@Autowired
	private AnimalKindService kindService;
	
	
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
	public int getCount(String upkind, String kind, Date startDate, Date endDate, String neuter) {
		// TODO Auto-generated method stub
		return animalDao.getCount(upkind, kind, startDate, endDate, neuter);
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
	public List<Animal> getList(int page, int size, String upKindCd, String kindCd, Date startDate, Date endDate,
			String neuter) {
		// TODO Auto-generated method stub
		int offset = (page-1) * size;
		return animalDao.getList(offset, size, upKindCd, kindCd, startDate, endDate, neuter);
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
			        //System.out.println(sb.toString());
			 
			        
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				
				// xml 통째로 json화
				JSONObject xmlJSON = XML.toJSONObject(result);
				String json = xmlJSON.toString();
				
				
				// ---------------------------- api 데이터 파싱 --------------------------------
				
		        JSONObject resultJSON = XML.toJSONObject(sb.toString());    // xml을 json으로 변환 후 파싱
		        //System.out.println(resultJSON);
		        
		        
		        // 직접 파싱해서 데이터를 DB에 넣기	
		        JSONObject response = (JSONObject)resultJSON.get("response");
		        JSONObject body = (JSONObject)response.get("body");
		        
		        JSONObject items = (JSONObject)body.get("items");
		        
		        JSONArray jsonArray = (JSONArray)items.get("item");
		        
		        List<Animal> list = new ArrayList<Animal>();
		        
		        int i=0;
		        for(Object obj : jsonArray) {
		        	Animal a = new Animal();
					JSONObject item = (JSONObject)obj; 
											

					String apiKind = item.getString("kindCd");	
					String[] arrKind = apiKind.split("]");
					String strUpKindName = arrKind[0].substring(1, arrKind[0].length());
					AnimalUpKind upKind = null;
					AnimalKind kind = null;
					// 축종+품종 항목 데이터 파싱 => 합쳐서 옴
					try {			
						
						// 받아온 품종에 맞는 DB 품종 데이터 찾기
						if(arrKind.length <= 1) {		// 품종이 같이 오지 않는 애는 기타				
							upKind = kindService.getUpKind("name", "기타");
							kind = kindService.getKind("000117");				// 기타 축종의 기타 품종
						} else {						// 축종과 품종이 같이 옴			
							if(strUpKindName.contains("기타") == true) {		// 동물 api와 축종 api의 기타 항목이 다르게 전달되어서 예외처리 
								strUpKindName = "기타";
							}
							
							upKind = kindService.getUpKind("name", strUpKindName);
							List<AnimalKind> kindList = kindService.getKindListByUpKindCd(upKind.getCd());
							String strKindName = arrKind[1].trim();	
							for(AnimalKind k :  kindList) {
								if( k.getName().equals(strKindName) == true ) {		// db에 저장 된 품종과 동물의 품종이 같으면
									kind = k;
								}
							}							
						}
						
						
						// 품종이 없는경우
						if(kind == null) {
							// 추가해주기				
							String strKindName = arrKind[1].trim();	
							
							// 1. 축종 코드 구하기
							upKind = kindService.getUpKind("name", strUpKindName);
							if(upKind == null) {
								upKind = kindService.getUpKind("name", "기타");  // 찾는 축종이 없으면 기타로 설정
							}
							
							AnimalKind lastKind = kindService.getLastCustomKind();		// 우리가 따로 추가한 kind의 마지막 꺼 가져오기 
							String lastCustomCd = "900";
							if(lastKind != null) {
								int newCd = Integer.parseInt(lastKind.getCd()) + 1;
								lastCustomCd = String.valueOf(newCd);
							}
							
							AnimalKind newKind = new AnimalKind(lastCustomCd, upKind.getCd(), strKindName);
							kindService.insert(newKind);					
							kind = newKind;				
						}
						
						a.setSexCd(item.getString("sexCd"));         
						a.setUpKindCd(upKind.getCd()); 
						a.setKindCd(kind.getCd());           	// 받아오거나 새로 추가 된 품종의 code를 넣음
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
						try {
							a.setSpecialMark(item.getString("specialMark"));    							
						} catch (Exception e) {
							a.setSpecialMark("없음");
						}  
						a.setColorCd(item.getString("colorCd"));          
						a.setHappenDt(toDate(item.getInt("happenDt")));        
						a.setAge(item.getString("age"));          
						
											
						
						list.add(a);
						
						i++;
						
					} catch (Exception e) {
						// TODO: handle exception
						
						System.out.println("이상한 apiKind : "+apiKind);
						System.out.printf("arrKind Length : "+arrKind.length );
						System.out.printf("strUpKindName : "+strUpKindName );
						e.printStackTrace();
					}
					
		        }
				
				
		        for(Animal apiItem : list) {
			        // api로 받아온 공고번호와 일치하는 animal을 db에서 가져옴
					Animal origin = get(apiItem.getDesertionNo());
					
					if(origin == null ) {		// db에 없으면
						// insert
						try {
							insert(apiItem);					// api 데이터를 DB에 insert							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("문제있는 kindCd : "+apiItem.getKindCd());
							e.printStackTrace();
						}
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
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date =  new Date();
		try {
			date = inputFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
