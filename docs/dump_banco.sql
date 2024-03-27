-- Sistema de Agendamento de Notebooks
-- Definição do banco de dados

CREATE TABLE usuario (
    id bigserial PRIMARY KEY,
    nivel integer,
    nome varchar(100) NOT NULL,
    matricula integer,
    senha varchar(255),
    email varchar(255)
);

CREATE TABLE categoria (
    id bigserial PRIMARY KEY,
    nome varchar(50) NOT NULL,
	softwares varchar(1000),
    prioridade integer,
    quantidade integer
);

CREATE TABLE notebook (
    id bigserial PRIMARY KEY,
    numero integer,
    patrimonio bigint,
    categoria_id bigint not null references categoria
);

CREATE TABLE agendamento (
    id bigserial PRIMARY KEY,
    usuario_id bigint not null references usuario,
    data_agendada date,
    hora_retirada timestamp,
    hora_devolvida timestamp,
    turno integer,
    datahora_criacao timestamp DEFAULT now(),
    status integer
);

CREATE TABLE agendamento_note (
    id bigserial PRIMARY KEY,
    agendamento_id bigint not null references agendamento,
    notebook_id bigint not null references notebook
);

CREATE TABLE notificacao (
    id bigserial PRIMARY KEY,
    usuario_id bigint NOT NULL,
    texto varchar(500) NOT NULL,
    link varchar(500),
    data_hora timestamp DEFAULT now(),
    lida boolean
);
