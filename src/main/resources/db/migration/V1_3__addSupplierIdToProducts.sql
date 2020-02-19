alter table products add column supplier_id bigint not null;

alter table products
add foreign key (supplier_id) references suppliers (id) on delete cascade;