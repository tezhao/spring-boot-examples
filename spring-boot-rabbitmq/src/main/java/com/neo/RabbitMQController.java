package com.neo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.User;
import com.neo.rabbit.hello.HelloSender;
import com.neo.rabbit.hello.HelloReceiver;

@RestController
@RequestMapping(value = "/test-rabbitmq/")
public class RabbitMQController {

	@Autowired
	HelloSender hellosender;

	@GetMapping(value = "/sender")
	public String sender(@RequestParam("name") String name, @RequestParam("pass") String pass) {
		User use = new User();
		use.setName(name);
		use.setPass(pass);
		hellosender.send();
		return "Message sent to the RabbitMQ test Successfully";
	}
	
	

}
