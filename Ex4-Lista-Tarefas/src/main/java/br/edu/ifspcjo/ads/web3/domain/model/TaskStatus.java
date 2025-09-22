package br.edu.ifspcjo.ads.web3.domain.model;

public enum TaskStatus 
{

	NOVA ("NOVA"),
	EM_ANDAMENTO ("EM_ANDAMENTO"),
	CONCLUIDA ("CONCLUIDA");
	
	private String status;
	
	TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
    
}
