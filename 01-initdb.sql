-- SEQUENCE 
CREATE SEQUENCE public.hibernate_sequence
    INCREMENT 1
    START 20
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.hibernate_sequence
    OWNER TO foodie;


-- Table: public.consumer

CREATE TABLE public.consumer
(
    id integer NOT NULL,
    created_by_id bigint,
    created_datetime timestamp without time zone,
    modified_by_id bigint,
    modified_datetime timestamp without time zone,
    status character(1) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    addr01 character varying(255) COLLATE pg_catalog."default",
    addr02 character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    postcode character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    first character varying(255) COLLATE pg_catalog."default",
    last character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT consumer_pkey PRIMARY KEY (id)
);

ALTER TABLE public.consumer OWNER to foodie;


-- Table: public.kitchen

-- DROP TABLE public.kitchen;

CREATE TABLE public.kitchen
(
    id integer NOT NULL,
    created_by_id bigint,
    created_datetime timestamp without time zone,
    modified_by_id bigint,
    modified_datetime timestamp without time zone,
    status character(1) COLLATE pg_catalog."default",
    order_id integer,
    progress integer,
    CONSTRAINT kitchen_pkey PRIMARY KEY (id)
);

ALTER TABLE public.kitchen OWNER to foodie;

-- Table: public.odr

-- DROP TABLE public.odr;

CREATE TABLE public.odr
(
    id integer NOT NULL,
    created_by_id bigint,
    created_datetime timestamp without time zone,
    modified_by_id bigint,
    modified_datetime timestamp without time zone,
    status character(1) COLLATE pg_catalog."default",
    consumer_id integer,
    addr01 character varying(255) COLLATE pg_catalog."default",
    addr02 character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    postcode character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    progress integer,
    restaurant_id integer,
    CONSTRAINT odr_pkey PRIMARY KEY (id)
);

ALTER TABLE public.odr OWNER to foodie;

-- Table: public.odr_det

-- DROP TABLE public.odr_det;

CREATE TABLE public.odr_det
(
    id integer NOT NULL,
    created_by_id bigint,
    created_datetime timestamp without time zone,
    modified_by_id bigint,
    modified_datetime timestamp without time zone,
    status character(1) COLLATE pg_catalog."default",
    menu_id integer,
    order_id integer,
    price double precision NOT NULL,
    quantity integer,
    CONSTRAINT odr_det_pkey PRIMARY KEY (id),
    CONSTRAINT fkpyrdsed34cwbpoicfbhm3a3tl FOREIGN KEY (order_id)
        REFERENCES public.odr (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE public.odr_det OWNER to foodie;


-- Table: public.restaurant

-- DROP TABLE public.restaurant;

CREATE TABLE public.restaurant
(
    id integer NOT NULL,
    created_by_id bigint,
    created_datetime timestamp without time zone,
    modified_by_id bigint,
    modified_datetime timestamp without time zone,
    status character(1) COLLATE pg_catalog."default",
    addr01 character varying(255) COLLATE pg_catalog."default",
    addr02 character varying(255) COLLATE pg_catalog."default",
    country character varying(255) COLLATE pg_catalog."default",
    postcode character varying(255) COLLATE pg_catalog."default",
    state character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT restaurant_pkey PRIMARY KEY (id)
);

ALTER TABLE public.restaurant OWNER to foodie;

-- Table: public.menu

-- DROP TABLE public.menu;

CREATE TABLE public.menu
(
    id integer NOT NULL,
    created_by_id bigint,
    created_datetime timestamp without time zone,
    modified_by_id bigint,
    modified_datetime timestamp without time zone,
    status character(1) COLLATE pg_catalog."default",
    descriptions character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    price double precision NOT NULL,
    restaurant_id integer,
    type integer,
    CONSTRAINT menu_pkey PRIMARY KEY (id),
    CONSTRAINT fkblwdtxevpl4mrds8a12q0ohu6 FOREIGN KEY (restaurant_id)
        REFERENCES public.restaurant (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE public.menu OWNER to foodie;



-- INSERT

-- CONSUMER
INSERT INTO public.consumer(id,  status, email, addr01, addr02, country, postcode, state, first, last)
	VALUES (1, 'A', 'test@email', 'Jalan Kayu', null, 'Singapore' , 555555 ,'Singapore', 'Tanzu' , 'Working Group');


-- Restaurant
INSERT INTO public.restaurant(
	id,  status, addr01, addr02, country,  name)
	VALUES (2, 'A', 'Compassvale One' , '18-234', 'Singapore' , 'Mcdonald');


-- Menu
INSERT INTO public.menu(
	id,  status, name, price, restaurant_id, type)
	VALUES (31,'A' ,'Big Mac' , 3.2 , 2 ,1 ) ,
            (42,'A' ,'Chicken Burger' , 2 , 2 ,1 ) ,
            (51,'A' ,'Beef Burger' , 4 , 2 ,1 );

