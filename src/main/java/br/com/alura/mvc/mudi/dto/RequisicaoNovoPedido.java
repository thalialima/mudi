package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

//classe que serve apenas para tranferir objetos
public class RequisicaoNovoPedido {

	@NotBlank //gera um erro de validação caso esse campo seja nulo
	//NotBlank.requisicaoNovoPedido.nomeDoProduto
	private String nomeDoProduto;
	
	@NotBlank //gera um erro de validação caso esse campo seja nulo
	private String urlDoProduto;
	
	@NotBlank //gera um erro de validação caso esse campo seja nulo
	private String urlDaImagem;
	
	private String descricao;

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public String getUrlDoProduto() {
		return urlDoProduto;
	}

	public void setUrlDoProduto(String urlDoProduto) {
		this.urlDoProduto = urlDoProduto;
	}

	public String getUrlDaImagem() {
		return urlDaImagem;
	}

	public void setUrlDaImagem(String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		
		pedido.setNomeProduto(nomeDoProduto);
		pedido.setUrlDoProduto(urlDoProduto);
		pedido.setUrlDaImagem(urlDaImagem);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);		
		return pedido;
	}

}
