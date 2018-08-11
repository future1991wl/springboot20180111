package chatroom.web.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/** * 消息处理控制器 * @author zhang * */
@Controller("websocket")
@RequestMapping("/websocket")
public class WebSocketHandler extends TextWebSocketHandler {
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		
		
		System.out.println("you are a fool");
		TextMessage returnMessage = new TextMessage(message.getPayload() + " recieved at server");
		session.sendMessage(returnMessage);
	}
}
