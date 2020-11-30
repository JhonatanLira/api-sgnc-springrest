create table empresas(
id_empresa bigint not null auto_increment,
cnpj varchar(14) not null,
razao_social varchar(100) not null,
nome_fantasia varchar(100) not null,
primary key(id_empresa)); 