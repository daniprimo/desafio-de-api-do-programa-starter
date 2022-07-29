create table tb_cliente (
id BIGINT AUTO_INCREMENT NOT NULL primary key,
cpf VARCHAR (255) NOT NULL,
nome VARCHAR (255),
telefone VARCHAR (255),
endereco_id BIGINT,
FOREIGN KEY (endereco_id) REFERENCES tb_endereco (id)
);

CREATE TABLE tb_pet (
id BIGINT AUTO_INCREMENT NOT NULL primary key,
nome VARCHAR (255),
cor VARCHAR (255),
especie VARCHAR (255),
sexo VARCHAR (255),
pelugem VARCHAR (255),
cliente_id BIGINT,
FOREIGN KEY (cliente_id) REFERENCES tb_cliente (id)
);

Alter table tb_cliente
add column pet_id bigint,
add foreign key (pet_id) references tb_pet (id);