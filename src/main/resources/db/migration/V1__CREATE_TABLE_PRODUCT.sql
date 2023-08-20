CREATE TABLE tb_product (
   code BIGINT NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_tb_product PRIMARY KEY (code)
);

CREATE SEQUENCE public.tb_product_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE public.tb_product_seq OWNER TO "compose-postgres";
GRANT ALL ON SEQUENCE public.tb_product_seq TO "compose-postgres";