package br.edu.ifspcjo.ads.web3.domain.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // para o Hibernate/JPA saber que é uma tabela
@Table(name = "users") // para mapear para a tabela users
public class User 
{
	
	@Id // o campo id é identificado como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // o banco vai gerar o campo id automaticamente (auto-increment)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String phone;
	private Boolean active;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	// hashCode() e equals() - garantem que objetos com mesmo id sejam tratados como mesmo usuário
	
	@Override
	public int hashCode() 
	{
		// hashCode() -> Decide o balde (posição na tabela) que o id vai ficar
		// Se ocorrer colisão na tabela hash, ele chama equals(user1) e equals(user2) para ver se são iguais
		
		return Objects.hash(id); // transforma o id em um número
	}

	@Override
	public boolean equals(Object obj) 
	{
		// equals() -> Confirma se o objeto já existe naquele balde
		
		// se for mesmo objeto na memória, então são iguais
		// HashSet() vai entender que o obj já existe, então não adiciona no balde
		if (this == obj)
			return true; 
		
		// se comparar com null, não são iguais
		// HashSet() vai entender que o obj não é igual a nada, então adiciona
		if (obj == null)
			return false;
		
		// se forem classes diferentes, não são iguais
		// HashSet() vai entender que não existe obj igual, então adiciona
		if (getClass() != obj.getClass()) 
			return false;
		
		User other = (User) obj; // converte o objeto para User
		
		// Se equals() retornar true  -> não adiciona (objeto já existe)
		// Se equals() retornar false -> adiciona (objeto é diferente)
		return Objects.equals(id, other.id); // compara o id de dois obj
	}
	
}
