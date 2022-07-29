CREATE TABLE tb_perfil (id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR (255) NOT NULL
);

CREATE TABLE tb_usuario (id BIGINT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR (255) NOT NULL,
senha VARCHAR (255) NOT NULL,
perfil_id BIGINT,
 constraint fk_perfil
	foreign key (perfil_id)
    references tb_perfil (id)
);

