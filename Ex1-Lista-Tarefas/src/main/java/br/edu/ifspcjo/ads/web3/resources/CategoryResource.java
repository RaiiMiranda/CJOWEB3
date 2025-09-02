package br.edu.ifspcjo.ads.web3.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.web3.domain.model.Category;
import br.edu.ifspcjo.ads.web3.repository.CategoryRepository;
import jakarta.servlet.http.HttpServletResponse;

// package de controller ou resource

@RestController // recebe requisições HTTP e retorna respostas JSON
@RequestMapping("/categories") // define o endpoint
public class CategoryResource 
{
	
	@Autowired // o Spring injeta automaticamente uma instância do CategoryRepository
	private CategoryRepository categoryRepository;
	
	// Lista todas as categorias
	@GetMapping
	public List<Category> list() {
		return categoryRepository.findAll();
	}
	
	// testar Postman
	// http://localhost:8080/categories -> endpoint que lista todas as categorias

	
	// Cria uma nova categoria
	@PostMapping
	public Category create(@RequestBody Category category, HttpServletResponse response) {
		return categoryRepository.save(category);
	}
	
	// testar Postman
	// POST - http://localhost:8080/categories -> endpoint que cria uma nova categoria
	// Body - raw - JSON
	/*
		{
			"name": "Faculdade"
		}
	*/

	
	// Busca pelo id da categoria
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id)
	{
		Optional<Category> category = categoryRepository.findById(id); // busca a categoria pelo id no banco de dados
		
		// se ela foi encontrada
		if(category.isPresent()) {
			return ResponseEntity.ok(category.get()); // então, retorna o user com status 200 OK
		}
		
		return ResponseEntity.notFound().build(); // se não, retorna 404 Not Found
	}

	// testar Postman
	// GET - http://localhost:8080/categories/1  -> endpoint que busca categoria com id 1

}
