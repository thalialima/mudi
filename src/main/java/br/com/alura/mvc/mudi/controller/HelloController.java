package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	
	//action
	//processa uma requisição do usuário e redireciona para uma view
	@GetMapping("/hello")
	//a interface Model permite add valores na requisição
	public String hello(Model model) {
		
		//adiciona o valor na requisição
		model.addAttribute("nome", "Mundo");
		return "hello";
	}

}
