CREATE TABLE tb_endereco (id BIGINT AUTO_INCREMENT PRIMARY KEY,
cep VARCHAR(255) not null,
logradouro VARCHAR (255),
bairro VARCHAR (255) ,
localidade VARCHAR (255) ,
uf VARCHAR (255),
numero VARCHAR (255) ,
complemento VARCHAR (255));


CREATE TABLE tb_medico (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
registroCRMV VARCHAR (255),
nome VARCHAR (255),
endereco_id BIGINT,
FOREIGN KEY (endereco_id) references tb_endereco (id)
);