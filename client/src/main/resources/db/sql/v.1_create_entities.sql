CREATE TABLE IF NOT EXISTS statistic
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