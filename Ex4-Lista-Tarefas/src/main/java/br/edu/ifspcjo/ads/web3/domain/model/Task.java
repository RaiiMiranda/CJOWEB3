package br.edu.ifspcjo.ads.web3.domain.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
}
