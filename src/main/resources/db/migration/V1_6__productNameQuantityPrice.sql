create sequence pnqp_id_seq;

create table productNameQuantityPrice(

id bigint primary key,
productId bigint not null,
productName varchar(128) not null,
productQuantity decimal not null,
productPricePerUnit decimal not null

);