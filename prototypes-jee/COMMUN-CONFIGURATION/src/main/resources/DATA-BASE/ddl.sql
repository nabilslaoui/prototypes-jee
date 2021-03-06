-- Généré par Oracle SQL Developer Data Modeler 4.1.2.1.899
--   à :        2017-02-24 17:11:21 CET
--   site :      Oracle Database 10g
--   type :      Oracle Database 10g




CREATE TABLE SG_ADMAA.TRANSACTIONS
  (
    ID_TRANSAC        NUMBER (11) NOT NULL ,
    ID_AUTOMATE       NUMBER (11) NOT NULL ,
    CODE_REGATE       VARCHAR2 (6 CHAR) NOT NULL ,
    DATE_TRANSAC      DATE NOT NULL ,
    MONTANT_HT        NUMBER (9,2) NOT NULL ,
    MONTANT_TTC       NUMBER (9,2) NOT NULL ,
    ID_TRANSAC_GENERE NUMBER (11) NOT NULL ,
    MODE_PAIEMENT     NUMBER ,
    NUM_FACTURE       VARCHAR2 (32 CHAR) ,
    ID_CLIENT         VARCHAR2 (12 CHAR) ,
    ID_CONTRAT        VARCHAR2 (12 CHAR) ,
    ETAT              NUMBER NOT NULL ,
    ETAT_SI           NUMBER NOT NULL ,
    MODEAUDIO         NUMBER ,
    LANGUE            CHAR (2 CHAR) ,w
    DOSSIERPREPAYE    NUMBER ,
    ETAT_OP           NUMBER (1)
  ) ;
COMMENT ON TABLE SG_ADMAA.TRANSACTIONS
IS
  'Table des transactions' ;
  COMMENT ON COLUMN SG_ADMAA.TRANSACTIONS.ID_AUTOMATE
IS
  'Identifiant de l''automate du point de viue SI Automates' ;
  COMMENT ON COLUMN SG_ADMAA.TRANSACTIONS.ID_TRANSAC_GENERE
IS
  'ID de transaction généré par l''automate' ;
  COMMENT ON COLUMN SG_ADMAA.TRANSACTIONS.ETAT_OP
IS
  'L''état de la transaction de l''offre prépayée.(0 : valide, 2 : OK partiel, 3: Annulé )' ;
  CREATE INDEX SG_ADMAA.I_TRANSAC_DATE ON SG_ADMAA.TRANSACTIONS
    (
      DATE_TRANSAC ASC
    ) ;
  CREATE INDEX SG_ADMAA.I_TRANSACTIONS_ID_AUTOMATE ON SG_ADMAA.TRANSACTIONS
    (
      ID_AUTOMATE ASC
    ) ;
CREATE UNIQUE INDEX SG_ADMAA.PK_TRANSACTIONS ON SG_ADMAA.TRANSACTIONS
  (
    ID_TRANSAC ASC
  )
  ;
ALTER TABLE SG_ADMAA.TRANSACTIONS ADD CONSTRAINT PK_TRANSACTIONS PRIMARY KEY ( ID_TRANSAC ) ;



CREATE TABLE SG_ADMAA.TRANSAC_DETAILS
  (
    ID_TRANSAC_DETAIL NUMBER (11) NOT NULL ,
    ID_TRANSAC        NUMBER (11) NOT NULL ,
    IDREFPRODSERV     CHAR (10 CHAR) NOT NULL ,
    QTE               NUMBER NOT NULL ,
    QTE_DISTR         NUMBER ,
    DESTINATION       VARCHAR2 (32 CHAR) ,
    POIDS             NUMBER (9,3) ,
    MONTANT_UNITAIRE  NUMBER (9,2) NOT NULL ,
    MONTANT_HT        NUMBER (9,2) NOT NULL ,
    MONTANT_TTC       NUMBER (9,2) NOT NULL ,
    ETAT              NUMBER NOT NULL ,
    CPLMTAFFRAN       NUMBER ,
    CPMLTMONTINITIAL  NUMBER (9,2) ,
    ETAT_OP           NUMBER (1) ,
    PROD_PANIER_MIXTE NUMBER (1)
  ) ;
COMMENT ON TABLE SG_ADMAA.TRANSAC_DETAILS
IS
  'Associations des transactions et des produits' ;
  CREATE INDEX SG_ADMAA.I_TRANSAC_DETAILS_ID_TRANSAC ON SG_ADMAA.TRANSAC_DETAILS
    (
      ID_TRANSAC ASC
    ) ;
CREATE UNIQUE INDEX SG_ADMAA.PK_TRANSAC_DETAILS ON SG_ADMAA.TRANSAC_DETAILS
  (
    ID_TRANSAC_DETAIL ASC
  )
  ;
ALTER TABLE SG_ADMAA.TRANSAC_DETAILS ADD CONSTRAINT PK_TRANSAC_DETAILS PRIMARY KEY ( ID_TRANSAC_DETAIL ) ;


CREATE TABLE SG_ADMAA.TRANSAC_DETAIL_OPTIONS
  (
    ID_TRANSAC_DETAIL NUMBER (11) NOT NULL ,
    IDREFPRODSERV     CHAR (10 CHAR) NOT NULL ,
    QTE               NUMBER NOT NULL ,
    MONTANT_UNITAIRE  NUMBER (9,2) ,
    MONTANT_HT        NUMBER (9,2) ,
    MONTANT_TTC       NUMBER (9,2)
  ) ;
COMMENT ON TABLE SG_ADMAA.TRANSAC_DETAIL_OPTIONS
IS
  'Associations des TRANSAC_DETAILS et des OPTIONS' ;
  CREATE INDEX SG_ADMAA.I_TRANS_DET_OPT_ID_TRANS_DET ON SG_ADMAA.TRANSAC_DETAIL_OPTIONS
    (
      ID_TRANSAC_DETAIL ASC
    ) ;
CREATE UNIQUE INDEX SG_ADMAA.PK_TRANSAC_DETAIL_OPTIONS ON SG_ADMAA.TRANSAC_DETAIL_OPTIONS
  (
    ID_TRANSAC_DETAIL ASC , IDREFPRODSERV ASC
  )
  ;
ALTER TABLE SG_ADMAA.TRANSAC_DETAIL_OPTIONS ADD CONSTRAINT PK_TRANSAC_DETAIL_OPTIONS PRIMARY KEY ( ID_TRANSAC_DETAIL, IDREFPRODSERV ) ;


ALTER TABLE SG_ADMAA.TRANSAC_DETAILS ADD CONSTRAINT FK_TRSC_DETAILS_TRSC FOREIGN KEY ( ID_TRANSAC ) REFERENCES SG_ADMAA.TRANSACTIONS ( ID_TRANSAC ) ;

ALTER TABLE SG_ADMAA.TRANSAC_DETAIL_OPTIONS ADD CONSTRAINT FK_TRSC_DET_OPT_TRSC_DETAILS FOREIGN KEY ( ID_TRANSAC_DETAIL ) REFERENCES SG_ADMAA.TRANSAC_DETAILS ( ID_TRANSAC_DETAIL ) ;


-- Rapport récapitulatif d'Oracle SQL Developer Data Modeler : 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             7
-- ALTER TABLE                              5
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
