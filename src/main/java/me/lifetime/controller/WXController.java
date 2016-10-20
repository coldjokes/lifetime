package me.lifetime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WXController {

	
	@RequestMapping("/hello")
	public void test(){
		System.out.println(112233);
	}
}
