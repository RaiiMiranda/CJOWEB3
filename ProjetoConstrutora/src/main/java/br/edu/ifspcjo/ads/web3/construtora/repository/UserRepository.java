package br.edu.ifspcjo.ads.web3.construtora.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifspcjo.ads.web3.construtora.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	
	public Optional<User> findByEmail(String email);
	
}