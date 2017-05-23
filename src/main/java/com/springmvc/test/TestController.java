package com.springmvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(value="/showtestmessage")
	@ResponseBody
	String showMessage(){
		String message = "this is a test message";
		return message;
	}
}
