--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Ubuntu 16.2-1.pgdg20.04+1)
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: agendamento_note; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.agendamento_note (
    id integer NOT NULL,
    id_agendamento bigint,
    id_notebook bigint
);


ALTER TABLE public.agendamento_note OWNER TO postgres;

--
-- Name: agendamento_note_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.agendamento_note_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.agendamento_note_id_seq OWNER TO postgres;

--
-- Name: agendamento_note_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.agendamento_note_id_seq OWNED BY public.agendamento_note.id;


--
-- Name: agendamentos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.agendamentos (
    id integer NOT NULL,
    id_usuario bigint,
    data_agendada date,
    hora_retirada timestamp without time zone,
    hora_devolvida timestamp without time zone,
    turno integer,
    datahora_criacao timestamp without time zone DEFAULT now(),
    status smallint
);


ALTER TABLE public.agendamentos OWNER TO postgres;

--
-- Name: agendamentos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.agendamentos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.agendamentos_id_seq OWNER TO postgres;

--
-- Name: agendamentos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.agendamentos_id_seq OWNED BY public.agendamentos.id;


--
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id integer NOT NULL,
    nome character varying(255),
    prioridade integer,
    quantidade smallint
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- Name: categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categoria_id_seq OWNER TO postgres;

--
-- Name: categoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;


--
-- Name: notebooks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notebooks (
    id integer NOT NULL,
    numero bigint,
    patrimonio bigint,
    id_categoria bigint
);


ALTER TABLE public.notebooks OWNER TO postgres;

--
-- Name: notebooks_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notebooks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.notebooks_id_seq OWNER TO postgres;

--
-- Name: notebooks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notebooks_id_seq OWNED BY public.notebooks.id;


--
-- Name: noticacoes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.noticacoes (
    id integer NOT NULL,
    id_usuario integer NOT NULL,
    texto character varying(500),
    link character varying(500),
    data_hora time without time zone DEFAULT now(),
    lida boolean
);


ALTER TABLE public.noticacoes OWNER TO postgres;

--
-- Name: noticacoes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.noticacoes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.noticacoes_id_seq OWNER TO postgres;

--
-- Name: noticacoes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.noticacoes_id_seq OWNED BY public.noticacoes.id;


--
-- Name: noticacoes_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.noticacoes_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.noticacoes_id_usuario_seq OWNER TO postgres;

--
-- Name: noticacoes_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.noticacoes_id_usuario_seq OWNED BY public.noticacoes.id_usuario;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    nivel smallint,
    nome character varying(255),
    n_identificacao bigint,
    senha character varying(64),
    email character varying(255)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_seq OWNER TO postgres;

--
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- Name: agendamento_note id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agendamento_note ALTER COLUMN id SET DEFAULT nextval('public.agendamento_note_id_seq'::regclass);


--
-- Name: agendamentos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agendamentos ALTER COLUMN id SET DEFAULT nextval('public.agendamentos_id_seq'::regclass);


--
-- Name: categoria id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.categoria_id_seq'::regclass);


--
-- Name: notebooks id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notebooks ALTER COLUMN id SET DEFAULT nextval('public.notebooks_id_seq'::regclass);


--
-- Name: noticacoes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.noticacoes ALTER COLUMN id SET DEFAULT nextval('public.noticacoes_id_seq'::regclass);


--
-- Name: noticacoes id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.noticacoes ALTER COLUMN id_usuario SET DEFAULT nextval('public.noticacoes_id_usuario_seq'::regclass);


--
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- Data for Name: agendamento_note; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.agendamento_note (id, id_agendamento, id_notebook) FROM stdin;
\.


--
-- Data for Name: agendamentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.agendamentos (id, id_usuario, data_agendada, hora_retirada, hora_devolvida, turno, datahora_criacao, status) FROM stdin;
\.


--
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id, nome, prioridade, quantidade) FROM stdin;
\.


--
-- Data for Name: notebooks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notebooks (id, numero, patrimonio, id_categoria) FROM stdin;
\.


--
-- Data for Name: noticacoes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.noticacoes (id, id_usuario, texto, link, data_hora, lida) FROM stdin;
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, nivel, nome, n_identificacao, senha, email) FROM stdin;
\.


--
-- Name: agendamento_note_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.agendamento_note_id_seq', 1, false);


--
-- Name: agendamentos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.agendamentos_id_seq', 1, false);


--
-- Name: categoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_id_seq', 1, false);


--
-- Name: notebooks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notebooks_id_seq', 1, false);


--
-- Name: noticacoes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.noticacoes_id_seq', 1, false);


--
-- Name: noticacoes_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.noticacoes_id_usuario_seq', 1, false);


--
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);


--
-- Name: agendamento_note agendamento_note_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agendamento_note
    ADD CONSTRAINT agendamento_note_pkey PRIMARY KEY (id);


--
-- Name: agendamentos agendamentos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agendamentos
    ADD CONSTRAINT agendamentos_pkey PRIMARY KEY (id);


--
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);


--
-- Name: notebooks notebooks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notebooks
    ADD CONSTRAINT notebooks_pkey PRIMARY KEY (id);


--
-- Name: noticacoes noticacoes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.noticacoes
    ADD CONSTRAINT noticacoes_pkey PRIMARY KEY (id_usuario);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: agendamento_note fk_agenda; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agendamento_note
    ADD CONSTRAINT fk_agenda FOREIGN KEY (id_agendamento) REFERENCES public.agendamentos(id) NOT VALID;


--
-- Name: agendamento_note fk_note; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agendamento_note
    ADD CONSTRAINT fk_note FOREIGN KEY (id_notebook) REFERENCES public.notebooks(id) NOT VALID;


--
-- Name: agendamentos fk_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.agendamentos
    ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id) NOT VALID;


--
-- Name: notebooks notebooks_id_categoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notebooks
    ADD CONSTRAINT notebooks_id_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES public.categoria(id) NOT VALID;


--
-- Name: noticacoes noticacoes_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.noticacoes
    ADD CONSTRAINT noticacoes_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id) NOT VALID;


--
-- PostgreSQL database dump complete
--

