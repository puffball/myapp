--hibernate genererar id som b�rjar fr�n 1 s� inserts m�ste undvika v�rden som kan kollidera
insert into MyEntity (id, name) values(-1, 'Adam')
insert into MyEntity (id, name) values(-2, 'Bertil')
insert into MyEntity (id, name) values(-3, 'Caesar')
