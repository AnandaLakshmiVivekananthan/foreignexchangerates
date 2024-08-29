CREATE TABLE IF NOT EXISTS migrations.exchangerates
(
    id integer NOT NULL,
    date date NOT NULL DEFAULT CURRENT_DATE,
    source character varying(10) COLLATE pg_catalog."default",
    gbp double precision DEFAULT 0.0,
    usd double precision DEFAULT 0.0,
    jpy double precision DEFAULT 0.0,
    czk double precision DEFAULT 0.0,
    CONSTRAINT exchangerates_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS migrations.exchangerates
    OWNER to postgres;