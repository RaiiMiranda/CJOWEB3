package br.edu.ifspcjo.ads.web3.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web3.domain.model.Category;
import br.edu.ifspcjo.ads.web3.repository.CategoryRepository;

// O package service concentra a lógica de negócio, processando dados entre o controller e o repository

// CategoryService faz o processamento e persistência, mantendo o CategoryResource limpo
// útil para caso queira usar esses métodos em outros controllers

@Service
public class CategoryService 
{

	@Autowired
	private CategoryRepository categoryRepository;
	
	// método para atualizar categoria existente
	public Category update(Long id, Category category) 
	{
		Category categorySaved = findCategoryById(id);
		BeanUtils.copyProperties(category, categorySaved, "id");
		
		return categoryRepository.save(categorySaved);
	}

	// método para buscar categoria pelo id ou lançar uma exceção
	public Category findCategoryById(Long id) 
	{
		Category categorySaved = categoryRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return categorySaved;
	}
	
	// método para deletar uma categoria existente
	public void deleteCategoryById(Long id) 
	{
	    Category categorySaved = findCategoryById(id); // se não existir o id, lança uma exceção
	    categoryRepository.delete(categorySaved);
	}
}
