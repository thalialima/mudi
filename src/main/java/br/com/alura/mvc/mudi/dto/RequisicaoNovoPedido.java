package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;

//classe que serve apenas para tranferir objetos
public class RequisicaoNovoPedido {

	private String nomeDoProduto;
	private String urlDoProduto;
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
		
		return pedido;
	}

}
