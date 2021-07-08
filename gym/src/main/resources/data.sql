INSERT INTO ADMINISTRATOR (KORISNICKO_IME,lozinka,ime,prezime,kontakt,email,datum_rodjenja,aktivan,obrisan) VALUES ('dead','12','Dea','Simic','0644509200','dea@gmail.com', '14.07.2000',TRUE,FALSE)
INSERT INTO CLAN (KORISNICKO_IME,lozinka,ime,prezime,kontakt,email,datum_rodjenja,aktivan,obrisan) VALUES ('mikis','mikica','Milos','Ivanovic','0662546802','milos@gmail.com', '19.02.2001',FALSE,FALSE)
INSERT INTO CLAN (KORISNICKO_IME,lozinka,ime,prezime,kontakt,email,datum_rodjenja,aktivan,obrisan) VALUES ('dzoni','dzon123','Nikola','Jelic','0642918222','nikolaj@gmail.com', '01.07.1989',TRUE,FALSE)



INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_tel_centrale,email) VALUES ('MyscleGym','Stevana Sindjelica 32','0621209200','musclegym@gmail.com')
INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_tel_centrale,email) VALUES ('StrongGym','Jovice Markovica 2','06212872110','stronggym@gmail.com')
INSERT INTO FITNESS_CENTAR (naziv,adresa,broj_tel_centrale,email) VALUES ('BigGym','Jevrejska 94','0631569200','biggym@gmail.com')

INSERT INTO TRENER (KORISNICKO_IME,lozinka,ime,prezime,kontakt,email,datum_rodjenja,aktivan,obrisan,FITNESSCENTAR_ID) VALUES ('Stefa','stef','Stefan','Simic','0644509200','stefan@gmail.com', '31.09.1996',TRUE,FALSE,1)
INSERT INTO TRENER (KORISNICKO_IME,lozinka,ime,prezime,kontakt,email,datum_rodjenja,aktivan,obrisan,FITNESSCENTAR_ID) VALUES ('Marijagym','maka','Marija','Kitic','0644509200','maki@gmail.com', '22.08.1992',FALSE,FALSE,2)


INSERT INTO  SALA (kapacitet,oznaka,FITNESSCENTAR_ID) VALUES (30,1,2)
INSERT INTO  SALA (kapacitet,oznaka,FITNESSCENTAR_ID) VALUES (32,223,2)
INSERT INTO  SALA (kapacitet,oznaka,FITNESSCENTAR_ID) VALUES (50,11,3)
INSERT INTO  SALA (kapacitet,oznaka,FITNESSCENTAR_ID) VALUES (110,22,1)

INSERT INTO TRENING(cena,naziv,opis,tip_treninga,trajanje,TRENER_KORISNICKO_IME) VALUES (2100,'BodyPump','Lagan','Kardio',35,'Stefa')
INSERT INTO TRENING(cena,naziv,opis,tip_treninga,trajanje,TRENER_KORISNICKO_IME) VALUES (1110,'HIIT','Tezak','Sa tegovima',35,'Marijagym')
INSERT INTO TRENING(cena,naziv,opis,tip_treninga,trajanje,TRENER_KORISNICKO_IME) VALUES (2510,'Muscle','Tezak','Sa tegovima',45,'Stefa')

INSERT INTO TERMIN(datum,FITNESSCENTAR_ID,SALA_ID,TRENER_KORISNICKO_IME,TRENING_ID) VALUES('2021-3-6 12:30:00',1,2,'Stefa',1)
INSERT INTO TERMIN(datum,FITNESSCENTAR_ID,SALA_ID,TRENER_KORISNICKO_IME,TRENING_ID) VALUES('2023-5-4 13:30:00',1,2,'Marijagym',2)
INSERT INTO TERMIN(datum,FITNESSCENTAR_ID,SALA_ID,TRENER_KORISNICKO_IME,TRENING_ID) VALUES('2019-7-12 15:30:00',2,3,'Stefa',3)