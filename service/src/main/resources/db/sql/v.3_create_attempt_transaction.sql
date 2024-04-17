CREATE TABLE IF NOT EXISTS bill.attempt_transaction
(
    id               uuid DEFAULT gen_random_uuid(),
    creation_date    TIMESTAMP      NOT NULL,
    last_action_date TIMESTAMP      NOT NULL,
    account_id       uuid           NOT NULL,
    type             VARCHAR(20),
    amount           NUMERIC(10, 3) NOT NULL,
    transaction_id   UUID
);