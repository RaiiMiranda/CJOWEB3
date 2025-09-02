package br.edu.ifspcjo.ads.web3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// essas anotações são para o Spring conseguir escanear esses pacotes, já que eles não estão 
// sendo criados dentro do pacote principal

@SpringBootApplication
@ComponentScan(basePackages = {
    "br.edu.ifspcjo.ads.web3.resources",     // controllers
    "br.edu.ifspcjo.ads.web3.domain.model",  // modelos
    "br.edu.ifspcjo.ads.web3.repository"     // repositorios
})
@EnableJpaRepositories(basePackages = "br.edu.ifspcjo.ads.web3.repository")
@EntityScan(basePackages = "br.edu.ifspcjo.ads.web3.domain.model")
public class Ex1ListaTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex1ListaTarefasApplication.class, args);
	}

}
