package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
//permite mapear todos os tipos de requisição
@RequestMapping("pedido")
public class PedidoController {

	@Autowired //pede para o Spring fazer a injeção de dependência
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	//método que retorna a página que deve ser renderizada
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	//os dados da requisição vão ser colocados dentro do objeto dessa classe
	//RequisicaoNovoPedido
	public String novo(RequisicaoNovoPedido requisicao) {
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		
		return "pedido/formulario";
	}
}
