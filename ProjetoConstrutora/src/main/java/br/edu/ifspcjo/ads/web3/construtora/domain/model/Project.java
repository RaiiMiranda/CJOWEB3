package br.edu.ifspcjo.ads.web3.construtora.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "project")
public class Project 
{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 200)
	private String name;

  	@NotNull
  	@Size(min = 3, max = 300)
  	private String description;
  
  	@NotNull
  	@Size(min = 3, max = 200)
  	private String address;

  	@NotNull
	@Column(name = "start_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate start_date;

  	@NotNull
	@Column(name = "end_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate end_date;

  	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

  	@NotNull
	@Size(min = 3, max = 100)
	private String client_name;

  	@NotNull
  	@Column(precision = 15, scale = 2)
  	private BigDecimal budget;
  	
  	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

  	// getters e setters
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Project other = (Project) obj;
		return Objects.equals(id, other.id);
	}
	
}
