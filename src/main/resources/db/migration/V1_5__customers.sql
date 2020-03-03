create sequence customer_id_seq;

create table customers(

id bigint primary key,
email varchar(128) not null

);