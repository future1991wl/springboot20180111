/**
 * 
 */
package com.ld.net.spider.demo.ws;

import org.apache.catalina.ha.backend.Sender;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
/**
 * @author zhjh256@163.com
 * {@link} http://www.cnblogs.com/zhjh256
 */
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.ld.net.spider.demo.ws.service.UserService;

public class MyHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		System.out.println("我的=======测试");
		ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext(new String[] {"spring-websocket.xml"});
		UserService userService=(UserService)cc.getBean("userService");
		String age = userService.getStr();
		TextMessage textMessage = new TextMessage("{\"name\":\"zhangsan\",\"age\":"+age+"}");
		
		session.sendMessage(textMessage);
	}
}