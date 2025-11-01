package br.edu.ifspcjo.ads.web3.construtora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifspcjo.ads.web3.construtora.domain.model.Project;

// Para acesso ao banco de dados
public interface ProjectRepository extends JpaRepository<Project, Long>{

}