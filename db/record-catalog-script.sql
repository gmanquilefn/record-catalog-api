--DROP DATABASE recordcatalog;

CREATE DATABASE recordcatalog;

--DROP TABLE public.artist;

CREATE TABLE public.artist (
    artist_id serial NOT NULL,
    code varchar NOT NULL,
    alias varchar NOT NULL,
    country varchar,
    description text,
    PRIMARY KEY (artist_id)
);

--DROP TABLE public.format;

CREATE TABLE public.format (
    format_id serial NOT NULL,
    format varchar NOT NULL,
    description text,
    PRIMARY KEY (format_id)
);

--DROP TABLE public.label;

CREATE TABLE public.label (
    label_id serial NOT NULL,
    label varchar NOT NULL,
    description text,
    image_base64 text,
    PRIMARY KEY (label_id)
);

--DROP TABLE public.album;

CREATE TABLE public.album (
    album_id serial NOT NULL,
    artist_id int8 NOT NULL,
    code varchar NOT NULL,
    title varchar NOT NULL,
    album_year numeric(4),
    genre varchar,
    style varchar,
    description text,
    track_list json,
    PRIMARY KEY (album_id),
    CONSTRAINT fk_artist FOREIGN KEY (artist_id) REFERENCES public.artist(artist_id)
);

--DROP TABLE public.album_release;

CREATE TABLE public.album_release (
    release_id serial NOT NULL,
    album_id int8 NOT NULL,
    format_id int8 NOT NULL,
    label_id int8 NOT NULL,
    code varchar NOT NULL,
    catalog_number varchar,
    release_year int4,
    country varchar,
    PRIMARY KEY (release_id),
    CONSTRAINT fk_album FOREIGN KEY (album_id) REFERENCES public.album(album_id),
    CONSTRAINT fk_format FOREIGN KEY (format_id) REFERENCES public.format(format_id),
    CONSTRAINT fk_label FOREIGN KEY (label_id) REFERENCES public.label(label_id)
);

