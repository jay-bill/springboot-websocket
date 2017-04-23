package websocket.handler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class WebSocketHandler extends AbstractWebSocketHandler{
	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	
	/**
	 * 确立连接
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("已经建立websocket连接！");
	}
	
	/**
	 * 处理文本消息
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session,TextMessage message) throws InterruptedException, IOException{
		logger.info("收到的消息："+message.getPayload());
		Thread.sleep(2000);//模拟延时
		//发送文本消息
		session.sendMessage(new TextMessage("你好，浏览器！"));
	}
	
	/**
	 * 连接状态
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("连接已经关闭；status="+status);
	}
}
