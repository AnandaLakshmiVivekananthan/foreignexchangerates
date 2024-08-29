CREATE SEQUENCE IF NOT EXISTS migrations.er_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 50000000
    CACHE 1;

ALTER SEQUENCE migrations.er_seq
    OWNED BY migrations.exchangerates.id;

ALTER SEQUENCE migrations.er_seq
    OWNER TO postgres;