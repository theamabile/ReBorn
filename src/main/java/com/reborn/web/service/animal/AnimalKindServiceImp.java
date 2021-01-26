package com.reborn.web.service.animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.reborn.web.dao.animal.AnimalKindDao;
import com.reborn.web.dao.animal.AnimalUpKindDao;
import com.reborn.web.entity.animal.AnimalKind;
import com.reborn.web.entity.animal.AnimalUpKind;

@Service
public class AnimalKindServiceImp implements AnimalKindService{
	
	@Autowired
	AnimalUpKindDao upKindDao;
	@Autowired
	AnimalKindDao kindDao;
	
	@Value("${animal.kindApiUrl}")
	private String url;
	
	@Value("${animal.apiKey}")
	private String serviceKey;
	
	@Override
	public int insert(AnimalKind kind) {
		// TODO Auto-generated method stub
		return kindDao.insert(kind);
	}

	@Override
	public int update(AnimalKind kind) {
		// TODO Auto-generated method stub
		return kindDao.update(kind);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return kindDao.delete(id);
	}

	@Override
	public AnimalKind getKind(int id) {
		// TODO Auto-generated method stub
		return kindDao.get(id);
	}

	@Override
	public List<AnimalKind> getKindList() {
		// TODO Auto-generated method stub
		return kindDao.getList();
	}

	@Override
	public AnimalUpKind getUpKind(int id) {
		// TODO Auto-generated method stub
		return upKindDao.get(id);
	}
	
	@Override
	public AnimalUpKind getUpKindByCode(String code) {
		// TODO Auto-generated method stub
		return upKindDao.getUpKindByCode(code);
	}

	@Override
	public List<AnimalUpKind> getUpKindList() {
		List<AnimalUpKind> upKindList = upKindDao.getList();
		
		for(AnimalUpKind upKind : upKindList) {
			List<AnimalKind> kindList = kindDao.getKindListByUpKindCode(upKind.getCode());
			upKind.setKindList(kindList);
		}
		
		return upKindList;
	}
	
	@Override
	public List<AnimalKind> getKindListByUpKindCode(String upKindCode) {
		// TODO Auto-generated method stub
		return kindDao.getKindListByUpKindCode(upKindCode);
	}
	
	@Override
	public AnimalKind getKindByCode(String code) {
		// TODO Auto-generated method stub
		return kindDao.getKindByCode(code);
	}

	@Override
	public int updateKindListFromAPI() {
		int result = 0;

		// DB에 저장 된 upKind 기준으로 kind를 api에게서 읽어옴 
		List<AnimalUpKind> upKindList =  getUpKindList();
			
		try {
			System.out.println("축종 갯수 : "+upKindList.size());
			for(int i=0 ; i<upKindList.size() ; i++) {
				
				AnimalUpKind upKind = upKindList.get(i);
				
				// url 만들기
				StringBuilder paramBuilder =  new StringBuilder();
				paramBuilder.append(URLEncoder.encode("up_kind_cd","UTF-8"));
				paramBuilder.append("=");
				paramBuilder.append(upKind.getCode());
				paramBuilder.append("&");	
				
				StringBuilder urlBuilder = new StringBuilder(url);
				urlBuilder.append("?");
				paramBuilder.append(URLEncoder.encode("ServiceKey","UTF-8") + "=" + serviceKey);  // 서비스키 붙이기
				
				System.out.println("api url : "+urlBuilder.toString() + paramBuilder.toString());
				
				URL url = new URL(urlBuilder.toString() + paramBuilder.toString());
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


				StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();

		        //String result = sb.toString();
		        //System.out.println("xml 데이터 : "+sb.toString());
		        
		        
		        // ---------------------------- api 데이터를 DB에 업데이트 하기 --------------------------------
		        
		        // 같은 upKind를 가진 된 모든 kind를 가져옴
				//List<AnimalKind> kindList = kindService.getKindListByUpKindID(upKind.getId());	
					        
		        JSONObject resultJSON = XML.toJSONObject(sb.toString());    // xml을 json으로 변환 후 파싱
		        System.out.println(resultJSON);
		        
		        
		        // 직접 파싱해서 데이터를 DB에 넣기	
		        JSONObject response = (JSONObject)resultJSON.get("response");
		        JSONObject items = (JSONObject) ((JSONObject)response.get("body")).get("items");
		        
		        //JSONObject item = items.get("item");

		        if ( items.get("item") instanceof JSONObject) {
					System.out.println("is JsonObject!");	
					
					// 아이템이 하나인 경우 array가 아니라 object로 던짐
					JSONObject kindObject = (JSONObject) items.get("item");
					String code = kindObject.get("kindCd").toString(); 
					String kindName = kindObject.get("KNm").toString();
					
					AnimalKind originKind = null; 
					for(AnimalKind kind : upKind.getKindList()) { 
						if(kind.getCode().equals(code) == true) {
							originKind = kind;
							break; 
						}
					}
				
					// 코드를 갖고 있는 데이터가 없으면 추가하고 있으면 받아온 데이터로 update 
					AnimalKind kind = new AnimalKind(code, upKind.getCode(), kindName); 
					if(originKind == null) {
						result += insert(kind); 
					} else { 
						result += update(kind); 
					} 
					
				} else if ( items.get("item") instanceof JSONArray)  {
					System.out.println("is Array!!!");	

					JSONArray jsonArray = (JSONArray)items.get("item");
					for(Object item : jsonArray) { 
						JSONObject kindObject = (JSONObject) item; 
						String code = kindObject.get("kindCd").toString(); 
						String kindName = kindObject.get("KNm").toString();
					
						//System.out.println(code); //System.out.println(kindName);
						
						// DB에서 code로 조회해도 되지만 질의 횟수를 줄이려고 upkind가 갖고있는 kind 리스트로 확인 
						AnimalKind originKind = null; 
						for(AnimalKind kind : upKind.getKindList()) { // api에서 읽어온 데이터를 갖고 있음 
							if(kind.getCode().equals(code) == true) {
								originKind = kind;
								break; 
							}
						}
					
						// 코드를 갖고 있는 데이터가 없으면 추가하고 있으면 받아온 데이터로 update 
						AnimalKind kind = new AnimalKind(code, upKind.getCode(), kindName); 
						if(originKind == null) {
							result += insert(kind); 
						} else { 
							result += update(kind); 
						} 
					}
					
				}
				System.out.println("====================="); 

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


}
