CREATE TABLE tb_perfil
(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   nome VARCHAR (255) NOT NULL
);
INSERT INTO `desafioapi`.`tb_perfil` (`nome`) VALUES ('Admin');
INSERT INTO `desafioapi`.`tb_perfil` (`nome`) VALUES ('Usuario');
CREATE TABLE tb_usuario
(
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   email VARCHAR (255) NOT NULL,
   senha VARCHAR (255) NOT NULL,
   perfil_id BIGINT,
   constraint fk_perfil foreign key (perfil_id) references tb_perfil (id)
);
INSERT INTO `desafioapi`.`tb_usuario`
(
   `email`,
   `senha`,
   `perfil_id`
)
VALUES
(
   'administrador@gft.com',
   '$2a$10$kLbsjPmkw8yqrBclVfiPeeyCzXmjFEyUhjKKBaZph5uDLY.V.5UKG',
   '1'
);