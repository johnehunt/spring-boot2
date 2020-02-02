package com.jjh.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public GreetingResponse greeting(MessageRequest message) throws Exception {
		Thread.sleep(1000); // simulate some processing
		return new GreetingResponse("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
