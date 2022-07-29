create table tb_atendimento (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
pet_id BIGINT,
peso varchar(255),
veterinario_id BIGINT,
data Date,
hora DATE,
foreign key (pet_id) references tb_pet (id),
foreign key (veterinario_id) references tb_medico (id)
);