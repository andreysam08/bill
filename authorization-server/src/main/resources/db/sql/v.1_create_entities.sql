CREATE SCHEMA IF NOT EXISTS auth_server;

CREATE TABLE IF NOT EXISTS auth_server.user
(
    id               uuid                  DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP    NOT NULL,
    last_action_date TIMESTAMP    NOT NULL,
    username         VARCHAR(100) NOT NULL,
    surname          VARCHAR(100),
    name             VARCHAR(100),
    patronymic       VARCHAR(100),
    password         VARCHAR(128) NOT NULL DEFAULT '{noop}test',
    role             varchar(128),
    CONSTRAINT pk_user_id PRIMARY KEY (id)
);