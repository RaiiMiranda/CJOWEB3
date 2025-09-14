package br.edu.ifspcjo.ads.web3.domain.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // para o Hibernate/JPA saber que é uma tabela
@Table(name = "categories") // para mapear para a tabela categories
public class Category 
{
	
	@Id // o campo id é identificado como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // o banco vai gerar o campo id automaticamente (auto-increment)
	private Long id;
	
	@NotNull
	@Size(max = 255)
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// hashCode() e equals() - garantem que objetos com mesmo id sejam tratados como mesmo usuário
	
	@Override
	public int hashCode() 
	{
		// hashCode() -> Decide o balde (posição na tabela) que o id vai ficar
		
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		// equals() -> Confirma se o objeto já existe naquele balde
		
		if (this == obj)
			return true; 

		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass()) 
			return false;
		
		Category other = (Category) obj;
		
		return Objects.equals(id, other.id);
	}
	
}
