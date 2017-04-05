package br.com.webaplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeApplicationController {

	@RequestMapping("/")
	public String home(){
		System.out.println("acessando");
		return "index";
	}
}
