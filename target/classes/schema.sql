DROP TABLE IF EXISTS PERSON;
create table if not exists PERSON
(
   id integer not null,
   name varchar(255) not null,
   primary key(id)
);