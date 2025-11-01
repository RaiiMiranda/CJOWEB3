package br.edu.ifspcjo.ads.web3.construtora.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifspcjo.ads.web3.construtora.domain.model.Project;
import br.edu.ifspcjo.ads.web3.construtora.domain.model.User;
import br.edu.ifspcjo.ads.web3.construtora.repository.ProjectRepository;
import br.edu.ifspcjo.ads.web3.construtora.repository.UserRepository;
import br.edu.ifspcjo.ads.web3.construtora.service.exception.NonExistentOrInactiveUserException;

// Classe para regras de negócio

@Service
public class ProjectService 
{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Project save(Project project) {
		Optional<User> user = userRepository.findById(project.getUser().getId());
		if(!user.isPresent() || !user.get().getActive()) {
			throw new NonExistentOrInactiveUserException();
		}
		return projectRepository.save(project);
	}
	
	public Project update(Long id, Project project) 
	{
		Project projectSaved = findProjectById(id);
		BeanUtils.copyProperties(project, projectSaved, "id");
		return projectRepository.save(projectSaved);
	}
	
	public Project findProjectById(Long id) 
	{
		Project projectSaved = projectRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return projectSaved;
	}
	
}
