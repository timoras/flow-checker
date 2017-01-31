CREATE SEQUENCE responses_id_seq INCREMENT  BY 1;

CREATE TABLE responses
(
    id INTEGER DEFAULT nextval('responses_id_seq'::regclass) PRIMARY KEY NOT NULL,
    response VARCHAR(255) NOT NULL,
    answered_at TIMESTAMP NOT NULL,
    asked_at TIMESTAMP
);