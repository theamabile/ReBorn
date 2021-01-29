package com.reborn.web.socket.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.reborn.web.controller.chat.ChatController;
import com.reborn.web.service.chat.ChatService;


public class ChatWebSocketHandler implements WebSocketHandler {
		
	private ChatService service;
	
	public ChatWebSocketHandler(ChatService service) {
		this.service = service;
		//System.out.println("생서자 서비스" + service);
	}
	
	//private List<WebSocketSession> sessions = new CopyOnWriteArrayList();
	List<HashMap<String, Object>> roomListSession = new ArrayList<>(); //웹소켓 세션을 담아둘 리스트
	

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(roomListSession);
		// 연결되었을떄.
		String url = session.getUri().toString(); //접속한 사람 url
		//System.out.println(url); 
		String roomId = url.split("chatting/")[1]; //접속한 사람 방번호
		System.out.println("roomId:" + roomId);
		boolean flag = false;
		System.out.println(roomListSession.size());
		
		int idx = roomListSession.size();//방사이즈
		
		//존재하는 방인지 확인
		for(int i = 0; i< idx; i++) {
			//System.out.println(roomListSession.get(i));
			System.out.println("bb");
			String roomIdCheck = (String) roomListSession.get(i).get("roomId");
			if(roomIdCheck.equals(roomId)) {
				System.out.println("존재하는 방이 있음");
				flag = true;
				idx=i;
				break;
			}
		}
		
		
		//방이 존재하면 세션추가 아니면 세션방번호 생성
		if(flag){
			HashMap<String, Object> map = roomListSession.get(idx);
			map.put(session.getId(), session);
		}
		else {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("roomId", roomId);
			map.put(session.getId(), session);
			roomListSession.add(map);
		}
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// 메세지 전달할떄.
		System.out.println(message.getPayload());
		String msg =  (String) message.getPayload();
		//String json = new Gson().toJson(msg);
		
		/*
		JsonElement jsonElement = new JsonParser().parse(msg);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
		System.out.println(jsonObject.get("roomId"));
		*/
		
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject)parser.parse(msg);
		int userId = Integer.parseInt((String) obj.get("userId"));
		System.out.println("1"+userId);
		int roomId = Integer.parseInt((String) obj.get("roomId"));
		System.out.println("2"+roomId);
		String chatData = (String) obj.get("chatData");
		
		
		System.out.println("3"+chatData);
		
		System.out.println("service : " +service);
		service.sendMsg(userId, chatData, roomId);

		
		HashMap<String, Object> temp = new HashMap<String, Object>();
		if(roomListSession.size() > 0) {
			for(int i = 0; i<roomListSession.size(); i++){
				int sessionRoomId = Integer.parseInt((String) roomListSession.get(i).get("roomId")); //세션리스트의 저장된 방번호를 가져와서
				if(sessionRoomId == roomId) { //같은값의 방이 존재한다면
					System.out.println("같은방.");
					temp = roomListSession.get(i); //해당 방번호의 세션리스트의 존재하는 모든 object값을 가져온다.
					break;
				}
			}
			

			//해당 방의 세션들만 찾아서 메시지를 발송해준다.
			for(String k : temp.keySet()) { 
				if(k.equals("roomId")) { //다만 방번호일 경우에는 건너뛴다.
					continue;
				}
				
				WebSocketSession wss = (WebSocketSession) temp.get(k);
				if(wss != null) {
					try {
						wss.sendMessage(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				 
			}
		}
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// 연결끓음
		System.out.println("연결끊음");
		
		//소켓 종료
		if(roomListSession.size() > 0) { //소켓이 종료되면 해당 세션값들을 찾아서 지운다.
			for(int i=0; i<roomListSession.size(); i++) {
				roomListSession.get(i).remove(session.getId());
			}
		}
		//System.out.println(roomListSession);
	}

	
	
	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
//	public static Object getKey(HashMap<Integer, String> m, Object value) { 
//		for(Object o: m.keySet()) { 
//			if(m.get(o).equals(value)) { 
//				return o; 
//			} 
//		} 
//		return null; 
//	}


}
