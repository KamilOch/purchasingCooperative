alter table productNameQuantityPrice add column order_id bigint not null;

alter table productNameQuantityPrice
add foreign key (order_id) references orders (id) on delete cascade;