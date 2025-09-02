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

import br.edu.ifspcjo.ads.web3.domain.model.User;
import br.edu.ifspcjo.ads.web3.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;

// package de controller ou resource

@RestController // recebe requisições HTTP e retorna respostas JSON
@RequestMapping("/users") // define o endpoint
public class UserResource 
{
	
	// o Spring injeta automaticamente uma instância do CategoryRepository
	@Autowired 
	private UserRepository userRepository;
	
	// Lista todos os users
	@GetMapping
	public List<User> list() {
		return userRepository.findAll(); // pega a lista de users no banco e retorna como JSON
	}
	
	// testar Postman
	// GET - http://localhost:8080/users -> endpoint que lista todos os users

	
	// Cria um novo user
	@PostMapping
	public User create(@RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user); // persiste o novo user no banco de dados
	}
	
	// testar Postman
	// POST - http://localhost:8080/users -> endpoint que cria um novo user
	// Body - raw - JSON
	/*
		{
			"name": "Raiane Dias",
			"email": "raianedias@ifsp.edu.br",
			"password": "$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji",
			"phone": "(12) 99111-8888",
			"active": true
		}
	*/

	
	// Busca pelo id do user
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id)
	{
		Optional<User> user = userRepository.findById(id); // busca o user pelo id no banco de dados
		
		// se ele foi encontrado
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get()); // então, retorna o user com status 200 OK
		}
		
		return ResponseEntity.notFound().build(); // se não, retorna 404 Not Found
	}

	// testar Postman
	// GET - http://localhost:8080/users/1  -> endpoint que busca user com id 1

}
