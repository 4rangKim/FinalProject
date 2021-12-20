package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ServerEndpoint(value = "/ws2") //ws라는 이름으로 Ws라는 클래스를 사용하겠다.
public class Wsforplates {

	private static final List<Session> sessionList = new ArrayList<Session>();; //List -> 동시에 여러명이 접속했을때 각각의 브라우저들에 대한 정보를 List에 담겠다. List에 담긴 브라우저에 동시다발적으로 메시지를 뿌리기 위해서

	public Wsforplates() {
		// TODO Auto-generated constructor stub
		System.out.println("웹소켓(서버) 객체생성");
	}

	@RequestMapping(value = "/plateNotification.mc")
	@ResponseBody
	public void getData(HttpServletRequest request) { // 뭔가가 들어오면(템프와 휴미를 받을것임) 
		String platenum = request.getParameter("platenum");
		String p_id= request.getParameter("p_id");
		System.out.println("입차한 차량번호판:" + platenum);
		sendAllMessage(p_id+"차량번호 :" + platenum); // 메세지로 뿌려주고 있음 
	}

	private void sendAllMessage(String message) {
		System.out.println("웹소켓(서버) sendAllMessage");
		try {
			for (Session session : Wsforplates.sessionList) {
					session.getBasicRemote().sendText(message);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@OnOpen
	public void onOpen(Session session) { //브라우저에서 웹소켓으로 접속을 요청하게 되면 자동으로 Onopen요청이 됨.
		System.out.println("Open session id:" + session.getId());  //접속된 세션의 아이디를 가져오단다.

		try {
			final Basic basic = session.getBasicRemote();  
			//basic.sendText("Connection Established--------------------");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		sessionList.add(session); // 어레이리스트의 세션의 정보가 차곡차곡 쌓임.
	}

	/*
	 * 모든 사용자에게 메시지를 전달한다.
	 * 
	 * @param self
	 * 
	 * @param message
	 */
	private void sendAllSessionToMessage(Session self, String message) { // 내 자신을 제외하고 현재들어온 메세지를 모든이에게 전송해라.
		System.out.println("웹소켓(서버) sendAllSessionToMessage");
		try {
			for (Session session : Wsforplates.sessionList) {
				if (!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText(message);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@OnMessage
	public void onMessage(String message, Session session) { // 브라우저에서 메시지가 올라오면 자동으로 onMessage가 자동으로 호출됨 
		System.out.println("웹소켓(서버) onMessage");
		System.out.println("Message From " + message);
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("sent Messge : " + message); // 쏜사람한테 다시 메세지를 보냄
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sendAllSessionToMessage(session, message); 
	}

	@OnError
	public void onError(Throwable e, Session session) {

	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("웹소켓(서버) onClose");
		sessionList.remove(session);
	}
}
