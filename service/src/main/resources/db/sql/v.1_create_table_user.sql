CREATE SCHEMA IF NOT EXISTS bill;

CREATE TABLE IF NOT EXISTS bill.user
(
    id               uuid DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP    NOT NULL,
    last_action_date TIMESTAMP    NOT NULL,
    email            VARCHAR(100) NOT NULL,
    surname          VARCHAR(100),
    name             VARCHAR(100),
    patronymic       VARCHAR(100),
    CONSTRAINT pk_user_id PRIMARY KEY (id)
);