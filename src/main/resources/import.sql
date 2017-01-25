--hibernate genererar id som börjar från 1 så inserts måste undvika värden som kan kollidera
insert into MyEntity (id, name) values(-1, 'Adam')
insert into MyEntity (id, name) values(-2, 'Bertil')
insert into MyEntity (id, name) values(-3, 'Caesar')
