CREATE DATABASE db_lavacar_sweb;

USE db_lavacar_sweb;

CREATE TABLE clientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    celular VARCHAR(40) NOT NULL,
    data_cadastro DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE veiculos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    placa VARCHAR(255) NOT NULL,
    observacoes VARCHAR(255) NOT NULL,
    modelo_id BIGINT NOT NULL,
    cor_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE modelos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    marca_id BIGINT NOT NULL,
    ecategoria ENUM NOT NULL,
    motor_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cores (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE marcas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE motores (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    e_tipo_combustivel ENUM('GASOLINA', 'ETANOL', 'FLEX',
        'DIESEL', 'GNV', 'OUTRO'),
    PRIMARY KEY (id)
);

ALTER TABLE veiculos
ADD FOREIGN KEY (modelo_id)
REFERENCES modelos(id);

ALTER TABLE veiculos
    ADD FOREIGN KEY (cor_id)
        REFERENCES cores(id);

ALTER TABLE veiculos
    ADD FOREIGN KEY (cliente_id)
        REFERENCES clientes(id)

ALTER TABLE modelos
    ADD FOREIGN KEY (marca_id)
    REFERENCES marcas(id)

ALTER TABLE modelos
    ADD FOREIGN KEY (motor_id)
    REFERENCES motores(id)



