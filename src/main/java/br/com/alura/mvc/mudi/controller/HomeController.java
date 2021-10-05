package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

//controller principal
//essa classe não possui instâncias e é gerenciada pelo Spring
@Controller
@RequestMapping("/home")
public class HomeController {
	
	//Autowired pede uma instância de PedidoRepository para o Spring
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		//acesso ao BD com Spring Data
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
	//Consultas por status
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}

	//se algum errro acontecer o usuário vai ser direcionado para a home
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	


}
