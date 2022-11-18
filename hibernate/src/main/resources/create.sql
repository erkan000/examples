/*

create schema IF NOT EXISTS GSS;
create table IF NOT EXISTS GSS.ISLEM  (
    id BIGINT,
    islem_id int,
    aciklama varchar(255),
    degistirme_zamani TIMESTAMP
);
insert into GSS.ISLEM (id, aciklama, islem_id, degistirme_zamani) values (1,'Aciklama',123,'2019-11-20 15:41:07.681');

*/