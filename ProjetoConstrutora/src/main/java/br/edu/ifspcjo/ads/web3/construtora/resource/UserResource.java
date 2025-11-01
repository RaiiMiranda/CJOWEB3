package br.edu.ifspcjo.ads.web3.construtora.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.web3.construtora.domain.model.User;
import br.edu.ifspcjo.ads.web3.construtora.repository.UserRepository;
import br.edu.ifspcjo.ads.web3.construtora.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

//Classe para controladores REST (endpoints)

@RestController
@RequestMapping("/users")
public class UserResource 
{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_USER')")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	// testar Postman
	// http://localhost:8080/users

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USER')")
	public User create(@Valid @RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user);
	}
	
	// testar Postman
	// POST - http://localhost:8080/users
	// Body - raw - JSON
	/*
		{
    			"name": "raiane",
    			"email": "raiane@gmail.com",
    			"password": "1234",
    			"comment": "muito bem feito esse predio",
    			"active": 1
		}
	*/
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USER')")
	public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User user) {
		User userSaved = userService.update(id, user);
		return ResponseEntity.ok(userSaved);
	}
	
	@PutMapping("/{id}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_USER')")
	public void updateActiveProperty(@PathVariable Long id, @RequestBody Boolean active) {
		userService.updateActiveProperty(id, active);
	}
	
	// testar Postman
	// PUT - true/false no body

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_USER')")
	public ResponseEntity<User> findById(@PathVariable Long id)
	{
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		return ResponseEntity.notFound().build();
	}

	// testar Postman
	// GET - http://localhost:8080/users/1
	// GET - http://localhost:8080/users/10
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_USER')")
	public void remove(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	// testar no Postman:
	// DELETE - http://localhost:8080/users/1

}