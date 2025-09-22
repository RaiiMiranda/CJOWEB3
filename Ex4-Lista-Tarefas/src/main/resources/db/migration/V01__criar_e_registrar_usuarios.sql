CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(150) NOT NULL,
  active tinyint(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (name, email, password, birth_date, gender, active) VALUES
('Fernando Duarte', 'fernandoduarte@ifsp.edu.br', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '1975-11-16', 'MASCULINO', 1),
('Juliana Silva', 'julianasilva@ifsp.edu.br', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '1980-01-01', 'FEMININO', 1),
('Fernanda Donatella', 'fernandadonatella@ifsp.edu.br', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '2000-05-05', 'FEMININO', 1);
