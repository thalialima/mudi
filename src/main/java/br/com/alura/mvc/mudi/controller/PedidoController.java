package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;
import br.com.alura.mvc.mudi.model.User;

@Controller
//permite mapear todos os tipos de requisição
@RequestMapping("pedido")
public class PedidoController {

	@Autowired //pede para o Spring fazer a injeção de dependência
	private PedidoRepository pedidoRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	//método que retorna a página que deve ser renderizada
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	//os dados da requisição vão ser colocados dentro do objeto dessa classe
	//RequisicaoNovoPedido
	//@Valid //integra a spring com o pedido de execução de validação
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		//se teve erro
		if(result.hasErrors()) {
			//o formulário será apresentado de novo para o usuário
			return "pedido/formulario";
		}
		
		//retorna qual usuário esta logado
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(userName);
		
		Pedido pedido = requisicao.toPedido();
		
		pedido.setUser(user);
		pedidoRepository.save(pedido);
		
		//retorna para a home
		return "redirect:/home";
	}
}
