CREATE TABLE category (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO category (name) 
	values ('Faculdade');
INSERT INTO category (id, name) 
	values ('Trabalho');
INSERT INTO category (id, name) 
	values ('Jogos');
