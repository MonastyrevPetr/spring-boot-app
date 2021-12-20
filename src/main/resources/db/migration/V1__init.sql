create table if not exists product
(
    id    bigserial primary key,
    title  varchar(255),
    cost int
);

insert into product(title, cost)
values ('Товар1', 1000),
       ('Товар2', 2000),
       ('Товар3', 3000),
       ('Товар4', 4000),
       ('Товар5', 5000),
       ('Товар6', 6000),
       ('Товар7', 7000),
       ('Товар8', 8000),
       ('Товар9', 9000),
       ('Товар10', 10000);