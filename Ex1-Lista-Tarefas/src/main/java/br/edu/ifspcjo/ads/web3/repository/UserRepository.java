package br.edu.ifspcjo.ads.web3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifspcjo.ads.web3.domain.model.User;

// UserRepository é uma interface que estende JpaRepository, ou seja,
// ela tem todos os métodos prontos de JpaRepository que conecta a aplicação com o banco de dados
// garantindo o CRUD (Create, Read, Update, Delete) completo sem precisar escrever SQL
public interface UserRepository extends JpaRepository<User, Long>{

}