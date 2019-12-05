drop database if exists concessionaria_wtt;

create database concessionaria_wtt;

use concessionaria_wtt;

CREATE TABLE concessionaria_wtt.funcionario (
id_funcionario BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
funcao VARCHAR(100),
id_pessoa BIGINT NOT NULL
);

CREATE TABLE concessionaria_wtt.cliente (
id_cliente BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nivel_desconto VARCHAR(100),
id_pessoa BIGINT NOT NULL
);

CREATE TABLE concessionaria_wtt.pedido (
id_pedido BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
dt_compra VARCHAR(100),
valor VARCHAR(100),
observacao VARCHAR(100),
status VARCHAR(100),
id_funcionario BIGINT NOT NULL,
id_carro BIGINT NOT NULL,
FOREIGN KEY(id_funcionario) REFERENCES funcionario (id_funcionario)
);

CREATE TABLE concessionaria_wtt.carro (
id_carro BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
modelo VARCHAR(100),
marca VARCHAR(100),
ano VARCHAR(100),
cor VARCHAR(100),
valor VARCHAR(100)
);

CREATE TABLE concessionaria_wtt.cliente_pedido (
id_cliente_pedido BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_cliente BIGINT NOT NULL,
id_pedido BIGINT NOT NULL,
FOREIGN KEY(id_cliente) REFERENCES cliente (id_cliente),
FOREIGN KEY(id_pedido) REFERENCES pedido (id_pedido)
);

CREATE TABLE concessionaria_wtt.pessoa (
id_pessoa BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
CPF VARCHAR(100),
login VARCHAR(100),
senha VARCHAR(100),
situacao VARCHAR(100)
);

CREATE TABLE concessionaria_wtt.endereco (
id_endereco BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
CEP VARCHAR(100),
numero VARCHAR(100),
complemento VARCHAR(100),
id_pessoa BIGINT NOT NULL,
FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa)
);

CREATE TABLE concessionaria_wtt.contato (
id_contato BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
tel_fixo VARCHAR(100),
tel_celular VARCHAR(100),
email VARCHAR(100),
id_pessoa BIGINT NOT NULL,
FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa)
);

ALTER TABLE funcionario ADD FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa);
ALTER TABLE cliente ADD FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa);
ALTER TABLE pedido ADD FOREIGN KEY(id_carro) REFERENCES carro (id_carro);


INSERT INTO `concessionaria_wtt`.`pessoa` (`id_pessoa`, `nome`, `CPF`, `login`, `senha`, `situacao`) VALUES ('1', 'Renato Barros','123456781', 'renato', '121', 'ATIVO');
INSERT INTO `concessionaria_wtt`.`pessoa` (`id_pessoa`, `nome`, `CPF`, `login`, `senha`, `situacao`) VALUES ('2', 'Alexandre Bittencourt Faria','123456782', 'bit', '122', 'ATIVO');

INSERT INTO `concessionaria_wtt`.`contato` (`id_contato`, `tel_fixo`, `tel_celular`, `email`, `id_pessoa`) VALUES ('1', '5555-5551', '11 9 7222-2221','re@re.com', '1');
INSERT INTO `concessionaria_wtt`.`contato` (`id_contato`, `tel_fixo`, `tel_celular`, `email`, `id_pessoa`) VALUES ('2', '5555-5552', '11 9 7222-2222','bi@re.com', '2');

INSERT INTO `concessionaria_wtt`.`endereco` (`id_endereco`, `CEP`, `numero`, `complemento`, `id_pessoa`) VALUES ('1', '01244561','11','c1', '1');
INSERT INTO `concessionaria_wtt`.`endereco` (`id_endereco`, `CEP`, `numero`, `complemento`, `id_pessoa`) VALUES ('2', '01244562','12','c2', '2');

INSERT INTO `concessionaria_wtt`.`funcionario` (`id_funcionario`, `funcao`, `id_pessoa`) VALUES ('1', 'ADM', '1');
INSERT INTO `concessionaria_wtt`.`cliente` (`id_cliente`, `nivel_desconto`, `id_pessoa`) VALUES ('1', '3', '2');

INSERT INTO `concessionaria_wtt`.`carro` (`id_carro`, `modelo`, `marca`, `ano`, `cor`, `valor`) VALUES ('1', 'celta', 'chevrolet', '2010', 'preto', '10.000');

INSERT INTO `concessionaria_wtt`.`pedido` (`id_pedido`, `dt_compra`, `valor`, `observacao`, `status`, `id_funcionario`, `id_carro`) VALUES ('1','26/10/2019', '10.000', 'carro', 'EM ANDAMENTO', '1', '1');

INSERT INTO `concessionaria_wtt`.`cliente_pedido` (`id_cliente_pedido`, `id_cliente`, `id_pedido`) VALUES ('1', '1', '1');