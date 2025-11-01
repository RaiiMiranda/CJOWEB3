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

import br.edu.ifspcjo.ads.web3.construtora.domain.model.Project;
import br.edu.ifspcjo.ads.web3.construtora.repository.ProjectRepository;
import br.edu.ifspcjo.ads.web3.construtora.service.ProjectService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

// Classe para controladores REST (endpoints)

@RestController
@RequestMapping("/projects")
public class ProjectResource 
{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PROJECT')")
	public List<Project> list(){
		return projectRepository.findAll();
	}
	
	// testar Postman
	// http://localhost:8080/projects

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_REGISTER_PROJECT')")
	public Project create(@Valid @RequestBody Project project, HttpServletResponse response) {
		return projectRepository.save(project);
	}
	
	// testar Postman
	// POST - http://localhost:8080/projects
	// Body - raw - JSON
	/*
		{
    			"name": "Projeto 1",
    			"description": "descricao do projeto 1",
    			"address": "endereco do projeto 1",
    			"start_date": "10/10/2025",
    			"end_date": "01/11/2025",
    			"status": "CONCLUIDO",
    			"client_name": "Ronaldo",
    			"budget": 250.000,
    			"user": {
    				"id": 1
    			}
		}
	*/
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_REGISTER_PROJECT')")
	public ResponseEntity<Project> update(@PathVariable Long id, @Valid @RequestBody Project project) {
		Project projectSaved = projectService.update(id, project);
		return ResponseEntity.ok(projectSaved);
	}
	
	// testar Postman
	// PUT - com informações no body

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_SEARCH_PROJECT')")
	public ResponseEntity<Project> findById(@PathVariable Long id)
	{
		Optional<Project> project = projectRepository.findById(id);
		
		if(project.isPresent()) {
			return ResponseEntity.ok(project.get());
		}
		
		return ResponseEntity.notFound().build();
	}

	// testar Postman
	// GET - http://localhost:8080/projects/1
	// GET - http://localhost:8080/projects/10
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVE_PROJECT')")
	public void remove(@PathVariable Long id) {
		projectRepository.deleteById(id);
	}
	
	// testar no Postman:
	// DELETE - http://localhost:8080/projects/1
    
}
