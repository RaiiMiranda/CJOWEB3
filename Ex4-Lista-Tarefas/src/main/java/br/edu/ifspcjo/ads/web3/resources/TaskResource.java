package br.edu.ifspcjo.ads.web3.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.web3.domain.model.Task;
import br.edu.ifspcjo.ads.web3.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController // recebe requisições HTTP e retorna respostas JSON
@RequestMapping("/tasks") // define o endpoint
public class TaskResource 
{

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping
	public List<Task> list(){
		return taskRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) 
	{
		Optional<Task> task = taskRepository.findById(id);
		
		if(task.isPresent()) {
			return ResponseEntity.ok(task.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task create(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	// testar Postman
	// POST - http://localhost:8080/tasks -> endpoint que cria uma nova task
	// Body - raw - JSON
	/*
	{
	    "description": "Corrida matinal",
	    "date": "22/09/2025",
	    "observation": "Levar o Bob junto.",
	    "status": "NOVA",
	    "user": {
	        "id": 1
	    }
	    "category": {
	    	"id": 1
	    }
	}
	*/
	
}
