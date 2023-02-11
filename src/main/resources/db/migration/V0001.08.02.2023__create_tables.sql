CREATE SEQUENCE atm_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE card_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE client_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE operation_seq
START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS atms
(
    id bigint PRIMARY KEY NOT NULL,
    address varchar(100) NOT NULL,
    created_at timestamp(6) NOT NULL,
    updated_at timestamp(6) NOT NULL
);

CREATE TABLE IF NOT EXISTS cards
(
    id bigint primary key not null,
    card_number varchar(100) not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    client_id bigint not null
);

CREATE TABLE IF NOT EXISTS clients
(
    id bigint primary key not null,
    name varchar(20) not null,
    passport_number varchar(20) not null,
    surname varchar(255) not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null
);

CREATE TABLE IF NOT EXISTS operations
(
    id bigint primary key not null,
    amount float4 not null,
    operation_date timestamp(6),
    atm_id bigint not null,
    card_id bigint not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null
);

ALTER TABLE if EXISTS cards
    ADD CONSTRAINT fk_cards_clients FOREIGN KEY (client_id) REFERENCES clients (id);

ALTER TABLE if EXISTS operations
    ADD CONSTRAINT fk_operations_atms FOREIGN KEY (atm_id) REFERENCES atms (id);

ALTER TABLE if EXISTS operations
    ADD CONSTRAINT fk_operations_cards FOREIGN KEY (card_id) REFERENCES cards (id);
