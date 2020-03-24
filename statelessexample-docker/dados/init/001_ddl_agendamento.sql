/*Use o schema Criado */
create schema "agendamento"

CREATE SEQUENCE agendamento.agendamento_seq;

CREATE TABLE agendamento.agendamento(
  ID int not null default nextval('agendamento.agendamento_seq'),
  EMAIL varchar(255) not null,
  ENVIADO boolean not null default false,
  PRIMARY KEY ( ID )
);