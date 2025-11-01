CREATE TABLE project (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	description VARCHAR(300) NOT NULL, 
	address VARCHAR(200) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	status ENUM('PLANEJADO', 'EM_ANDAMENTO', 'CONCLUIDO', 'CANCELADO') DEFAULT 'PLANEJADO' NOT NULL,
	client_name VARCHAR(100) NOT NULL,
	budget DECIMAL(15,2) NOT NULL,
	user_id BIGINT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO project (name, description, address, start_date, end_date, status, client_name, budget, user_id) VALUES
('Residencial Sustentável Campos do Jordão', 'Condomínio residencial de alto padrão com foco em sustentabilidade', 'Av. das Flores, 1000 - Campos do Jordão/SP', 
'2024-01-15', '2024-12-20', 'EM_ANDAMENTO', 'Construtora Verde Vida', 2500000.00, 1);