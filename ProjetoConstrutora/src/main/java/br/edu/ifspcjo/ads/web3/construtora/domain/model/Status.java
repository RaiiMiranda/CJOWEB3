package br.edu.ifspcjo.ads.web3.construtora.domain.model;

public enum Status 
{

	PLANEJADO("Planejado"),
	EM_ANDAMENTO("Em andamento"),
	CONCLUIDO("Concluído"),
	CANCELADO("Cancelado");

	private String description;

	private Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}