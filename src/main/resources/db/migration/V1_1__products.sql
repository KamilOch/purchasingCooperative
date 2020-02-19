create sequence product_id_seq;

create table products(

id bigint primary key,
name varchar(128) not null,
unit varchar(128) not null

);