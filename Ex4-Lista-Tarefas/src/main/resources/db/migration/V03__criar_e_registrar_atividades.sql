CREATE TABLE task (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	date DATE NOT NULL,
	observation VARCHAR(50) NOT NULL,
	status VARCHAR(20) NOT NULL,
	user_id BIGINT(20) NOT NULL,
	category_id BIGINT(20) NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user(id)
	FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO task (description, date, observation, status, user_id, category_id) 
	values ('Estudando', '2025-04-18', 'De noite', 'NOVA', 1, 1);
INSERT INTO task (description, date, observation, status, user_id, category_id) 
	values ('Trabalhando', '2025-04-16', 'De dia', 'EM_ANDAMENTO', 2, 2);
INSERT INTO task (description, date, observation, status, user_id, category_id) 
	values ('Jogando', '2025-04-14', 'De tarde', 'CONCLUIDA', 3, 3);
