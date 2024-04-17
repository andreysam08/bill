CREATE TABLE IF NOT EXISTS bill.bank
(
    id               uuid DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP NOT NULL,
    last_action_date TIMESTAMP NOT NULL,
    name             VARCHAR(100),
    ogrn             VARCHAR(500),
    inn              VARCHAR(12),
    CONSTRAINT pk_bank_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS bill.account
(
    id               uuid DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP      NOT NULL,
    last_action_date TIMESTAMP      NOT NULL,
    balance          NUMERIC(10, 3) NOT NULL,
    user_id          uuid           NOT NULL,
    bank_id          uuid           NOT NULL,
    CONSTRAINT pk_account_id PRIMARY KEY (id),
    CONSTRAINT fk_account_user_id FOREIGN KEY (user_id) REFERENCES bill.user (id),
    CONSTRAINT fk_account_bank_id FOREIGN KEY (bank_id) REFERENCES bill.bank (id)
);

CREATE TABLE IF NOT EXISTS bill.transaction
(
    id               uuid DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP      NOT NULL,
    last_action_date TIMESTAMP      NOT NULL,
    account_id       uuid           NOT NULL,
    type             VARCHAR(20),
    amount           NUMERIC(10, 3) NOT NULL
);