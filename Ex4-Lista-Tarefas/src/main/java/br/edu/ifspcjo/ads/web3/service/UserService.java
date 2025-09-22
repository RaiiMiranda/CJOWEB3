package br.edu.ifspcjo.ads.web3.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web3.domain.model.User;
import br.edu.ifspcjo.ads.web3.repository.UserRepository;

// O package service concentra a lógica de negócio, processando dados entre o controller e o repository

// UserService faz o processamento e persistência, mantendo o UserResource limpo
// útil para caso queira usar esses métodos em outros controllers

@Service
public class UserService 
{
	
	@Autowired
	private UserRepository userRepository;
	
	// método para atualizar user existente
	public User update(Long id, User user) 
	{
		User userSaved = findUserById(id);
		BeanUtils.copyProperties(user, userSaved, "id");
		
		return userRepository.save(userSaved);
	}

	// método para atualizar status ativo do user existente
	public void updateActiveProperty(Long id, Boolean active) 
	{
		User userSaved = findUserById(id);
		
		userSaved.setActive(active);
		userRepository.save(userSaved);
	}

	// método para buscar user pelo id ou lançar uma exceção
	public User findUserById(Long id) 
	{
		User userSaved = userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return userSaved;
	}

}
