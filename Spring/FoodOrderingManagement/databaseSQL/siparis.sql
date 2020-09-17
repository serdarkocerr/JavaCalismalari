CREATE TABLE "anayemek"(
	"anayemekid" SERIAL,
	"anayemekadi" VARCHAR(40),
	CONSTRAINT "anayemekidPK" PRIMARY KEY("anayemekid")
);

CREATE TABLE "corba"(
	"corbaid" SERIAL,
	"corbaadi" VARCHAR(40),
	CONSTRAINT "corbaidPK" PRIMARY KEY("corbaid")
);

CREATE TABLE "salata"(
	"salataid" SERIAL,
	"salataadi" VARCHAR(40),
	CONSTRAINT "salataidPK" PRIMARY KEY("salataid")
);
CREATE TABLE "tatli"(
	"tatliid" SERIAL,
	"tatliadi" VARCHAR(40),
	CONSTRAINT "tatliidPK" PRIMARY KEY("tatliid")
);

CREATE TABLE "masa"(
	"masaid" SERIAL,
	"masaadi" VARCHAR(40),
	CONSTRAINT "masaidPK" PRIMARY KEY("masaid")
);

CREATE TABLE "kullanicitur"(
	"kullaniciturid" SERIAL,
	"kullanicituradi" VARCHAR(40),
	CONSTRAINT "kullanicituridPK" PRIMARY KEY("kullaniciturid")
);

CREATE TABLE "kullanici"(
    "kullaniciid" SERIAL,
    "kullaniciadi" VARCHAR(40) ,
    "kullanicisoyadi" VARCHAR(40) ,
	"kullaniciturid" INT,
    CONSTRAINT "kullanicinoPK" PRIMARY KEY("kullaniciid"),
    CONSTRAINT "kullanicituridFK" FOREIGN KEY("kullaniciturid") REFERENCES "kullanicitur"("kullaniciturid")

);

CREATE TABLE "siparis"(
    "siparisid" SERIAL,
    "kullaniciid" INT,
    "masaid" INT,

    CONSTRAINT "siparisidPK" PRIMARY KEY("siparisid"),
    CONSTRAINT "kullaniciidFK" FOREIGN KEY("kullaniciid") REFERENCES "kullanici"("kullaniciid"),
    CONSTRAINT "masaidFK" FOREIGN KEY("masaid") REFERENCES "masa"("masaid")

);
CREATE TABLE "anayemeksiparis"(
    "siparisid" INT,
    "anayemekid" INT,
    CONSTRAINT "anayemeksiparisPK" PRIMARY KEY("siparisid","anayemekid"),
    CONSTRAINT "siparisidFK" FOREIGN KEY("siparisid") REFERENCES "siparis"("siparisid"),
   CONSTRAINT "anayemekidFK" FOREIGN KEY("anayemekid") REFERENCES "anayemek"("anayemekid")

);

CREATE TABLE "corbasiparis"(
    "siparisid" INT,
    "corbaid" INT,
    CONSTRAINT "corbasiparisPK" PRIMARY KEY("siparisid","corbaid"),
    CONSTRAINT "siparisidFK" FOREIGN KEY("siparisid") REFERENCES "siparis"("siparisid"),
   CONSTRAINT "corbaidFK" FOREIGN KEY("corbaid") REFERENCES "corba"("corbaid")

);

CREATE TABLE "salatasiparis"(
    "siparisid" INT,
    "salataid" INT,
    CONSTRAINT "salatasiparisPK" PRIMARY KEY("siparisid","salataid"),
    CONSTRAINT "siparisidFK" FOREIGN KEY("siparisid") REFERENCES "siparis"("siparisid"),
   CONSTRAINT "salataidFK" FOREIGN KEY("salataid") REFERENCES "salata"("salataid")
);
CREATE TABLE "tatlisiparis"(
    "siparisid" INT,
    "tatliid" INT,
    CONSTRAINT "tatlisiparisPK" PRIMARY KEY("siparisid","tatliid"),
    CONSTRAINT "siparisidFK" FOREIGN KEY("siparisid") REFERENCES "siparis"("siparisid"),
   CONSTRAINT "tatliidFK" FOREIGN KEY("tatliid") REFERENCES "tatli"("tatliid")
);

INSERT INTO "anayemek"("anayemekadi") VALUES('KuruFasuklye');
INSERT INTO "corba"("corbaadi") VALUES('Mercimek');
INSERT INTO "salata"("salataadi") VALUES('Coban');
INSERT INTO "tatli"("tatliadi") VALUES('Revani');
INSERT INTO "masa"("masaadi") VALUES('Masa1');
INSERT INTO "kullanicitur"("kullanicituradi") VALUES('Garson');

INSERT INTO "kullanici"("kullaniciadi","kullanicisoyadi","kullaniciturid") VALUES('Serdar','Kocer',1);
INSERT INTO "siparis"("kullaniciid","masaid") VALUES(1,1);

INSERT INTO "anayemeksiparis"("siparisid","anayemekid") VALUES(1,1);
INSERT INTO "corbasiparis"("siparisid","corbaid") VALUES(1,1);
INSERT INTO "salatasiparis"("siparisid","salataid") VALUES(1,1);
INSERT INTO "tatlisiparis"("siparisid","tatliid") VALUES(1,1);


SELECT * FROM "siparis" 
INNER JOIN "anayemeksiparis" ON "siparis"."siparisid" = "anayemeksiparis"."siparisid"
INNER JOIN "corbasiparis" ON "siparis"."siparisid" = "corbasiparis"."siparisid"
INNER JOIN "salatasiparis" ON "siparis"."siparisid" = "salatasiparis"."siparisid"
INNER JOIN "tatlisiparis" ON "siparis"."siparisid" = "tatlisiparis"."siparisid";


SELECT * FROM "siparis" 
INNER JOIN "anayemek" ON "siparis"."siparisid" =(SELECT "siparisid" FROM "anayemeksiparis" WHERE "anayemeksiparis"."anayemekid" = "anayemek"."anayemekid")
INNER JOIN "corba" ON "siparis"."siparisid" = (SELECT "siparisid" FROM "corbasiparis" WHERE "corbasiparis"."corbaid" = "corba"."corbaid")
INNER JOIN "salata" ON "siparis"."siparisid" = (SELECT "siparisid" FROM "salatasiparis" WHERE "salatasiparis"."salataid" = "salata"."salataid")
INNER JOIN "tatli" ON "siparis"."siparisid" = (SELECT "siparisid" FROM "tatlisiparis" WHERE "tatlisiparis"."tatliid" = "tatli"."tatliid")
INNER JOIN "masa" ON "siparis"."masaid" = "masa"."masaid"
INNER JOIN (SELECT * FROM "kullanici" INNER JOIN "kullanicitur" ON "kullanici"."kullaniciturid" ="kullanicitur"."kullaniciturid" ) AS "kullaniciAll" ON "siparis"."kullaniciid" = "kullaniciAll"."kullaniciid";

SELECT * FROM "siparis" 
INNER JOIN (SELECT * FROM "anayemek" INNER JOIN "anayemeksiparis" ON "anayemeksiparis"."anayemekid" = "anayemek"."anayemekid" ) AS "anayemekAll" ON "siparis"."siparisid" = "anayemekAll"."siparisid"
INNER JOIN (SELECT * FROM "corba" INNER JOIN "corbasiparis" ON "corbasiparis"."corbaid" = "corba"."corbaid" ) AS "corbaAll" ON "siparis"."siparisid" = "corbaAll"."siparisid"
INNER JOIN (SELECT * FROM "salata" INNER JOIN "salatasiparis" ON "salatasiparis"."salataid" = "salata"."salataid" ) AS "salataAll" ON "siparis"."siparisid" = "salataAll"."siparisid"
INNER JOIN (SELECT * FROM "tatli" INNER JOIN "tatlisiparis" ON "tatlisiparis"."tatliid" = "tatli"."tatliid" ) AS "tatliAll" ON "siparis"."siparisid" = "tatliAll"."siparisid"
INNER JOIN "masa" ON "siparis"."masaid" = "masa"."masaid"
INNER JOIN (SELECT * FROM "kullanici" INNER JOIN "kullanicitur" ON "kullanici"."kullaniciturid" ="kullanicitur"."kullaniciturid" ) AS "kullaniciAll" ON "siparis"."kullaniciid" = "kullaniciAll"."kullaniciid";




ALTER TABLE "siparis" ADD COLUMN "siparisDurumu" VARCHAR(40);

CREATE TABLE "test"(
	"testid" SERIAL,
	"testadi" VARCHAR(40),
	CONSTRAINT "testidPK" PRIMARY KEY("testid")
);
INSERT INTO "test"("testadi") VALUES('TestRecord');
ALTER TABLE "kullanici" ADD COLUM ifre" VARCHAR(40);
