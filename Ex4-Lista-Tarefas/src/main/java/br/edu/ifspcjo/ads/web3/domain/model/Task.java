package br.edu.ifspcjo.ads.web3.domain.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // para o Hibernate/JPA saber que é uma tabela
@Table(name = "task") // para mapear para a tabela task
public class Task 
{

	@Id // o campo id é identificado como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // o banco vai gerar o campo id automaticamente (auto-increment)
	private Long id;
	
	private String description;
	
	@JsonFormat(pattern =  "dd/MM/yyyy")
	private LocalDate date;
	
	private String observation;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
