package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.PedidoDTO;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		PedidoDTO pedido = new PedidoDTO();
		pedido.setNomeProduto("Colar de aço inoxidável");
		pedido.setUrlDaImagem("https://madriacessorios.com.br/image/cache/data/aco-inox/"
				+ "Colar-em-Aco-Inoxiavel-com-Pingente-de-Clave-de-Sol-CLI0159-600x600.png");
		pedido.setUrlDoProduto("https://madriacessorios.com.br/"
				+ "colar-em-aco-inoxidavel-com-pingente-de-clave-de-sol-cli0159");
		pedido.setDescricao("Colar com pingente Clave de Sol");
		
		List<PedidoDTO> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
}
