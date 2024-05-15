CREATE SCHEMA IF NOT EXISTS client;

CREATE TABLE IF NOT EXISTS client.statistic
(
    id               uuid DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP NOT NULL,
    last_action_date TIMESTAMP NOT NULL,
    start_time       TIMESTAMP NOT NULL,
    end_time         TIMESTAMP NOT NULL,
    enrollment       numeric(10, 3),
    withdrawal       numeric(10, 3),
    CONSTRAINT pk_statistics_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS client.user
(
    id               uuid DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP    NOT NULL,
    last_action_date TIMESTAMP    NOT NULL,
    username            VARCHAR(100) NOT NULL,
    password         VARCHAR(128) NOT NULL DEFAULT '{noop}test123',
    CONSTRAINT pk_user_id PRIMARY KEY (id)
);