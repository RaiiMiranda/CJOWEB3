CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
	id_user BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_user, id_permission),
	FOREIGN KEY (id_user) REFERENCES user(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- admin
INSERT INTO user (id, name, email, password, active) 
	values (3, 'Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 1);

-- user
INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_USER');
INSERT INTO permission (id, description) values (2, 'ROLE_REMOVE_USER');
INSERT INTO permission (id, description) values (3, 'ROLE_SEARCH_USER');

-- project
INSERT INTO permission (id, description) values (4, 'ROLE_REGISTER_PROJECT');
INSERT INTO permission (id, description) values (5, 'ROLE_REMOVE_PROJECT');
INSERT INTO permission (id, description) values (6, 'ROLE_SEARCH_PROJECT');

-- users comuns
INSERT INTO permission (id, description) VALUES (7, 'ROLE_VIEW_PROJECT');
INSERT INTO permission (id, description) VALUES (8, 'ROLE_COMMENT_PROJECT');

-- admin
INSERT INTO user_permission (id_user, id_permission) values (3, 1);
INSERT INTO user_permission (id_user, id_permission) values (3, 2);
INSERT INTO user_permission (id_user, id_permission) values (3, 3);
INSERT INTO user_permission (id_user, id_permission) values (3, 4);
INSERT INTO user_permission (id_user, id_permission) values (3, 5);
INSERT INTO user_permission (id_user, id_permission) values (3, 6);

-- barbara miranda
INSERT INTO user_permission (id_user, id_permission) VALUES (1, 7); -- ver projeto
INSERT INTO user_permission (id_user, id_permission) VALUES (1, 8); -- comentar

-- raissa leticia
INSERT INTO user_permission (id_user, id_permission) VALUES (2, 7); -- ver projeto
INSERT INTO user_permission (id_user, id_permission) VALUES (2, 8); -- comentar
