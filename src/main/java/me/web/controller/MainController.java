package me.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MainController {

	@RequestMapping("/image")
	public String main(){
		
//		oFYWmuIdf91uInYXrtzwg424ii4U
		return "main";
	}
	
}
