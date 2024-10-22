CREATE TABLE app."user"
(
    login character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    registration_date timestamp without time zone NOT NULL,
    name character varying(255) NOT NULL,
    birthday date NOT NULL,
    role character varying(50) NOT NULL,
    CONSTRAINT "user_PK" PRIMARY KEY (login)
);

ALTER TABLE IF EXISTS app."user"
    OWNER to postgres;



CREATE SEQUENCE app.message_sequence AS bigint
INCREMENT 1;


CREATE TABLE app.message
(
    id bigint NOT NULL DEFAULT nextval('app.message_sequence'),
    sending_time timestamp without time zone NOT NULL,
    from_user character varying(255) NOT NULL,
    to_user character varying(255) NOT NULL,
    text text,
    CONSTRAINT "message_PK" PRIMARY KEY (id),
    CONSTRAINT "from_user_FK" FOREIGN KEY (from_user)
        REFERENCES app."user" (login) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "to_user_FK" FOREIGN KEY (to_user)
        REFERENCES app."user" (login) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE IF EXISTS app.message
    OWNER to postgres;


ALTER SEQUENCE IF EXISTS app.message_sequence OWNED BY app.message.id;