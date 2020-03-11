create sequence order_id_seq;

create table orders(

id bigint primary key,
customer_id bigint not null,
order_status varchar(64)

);