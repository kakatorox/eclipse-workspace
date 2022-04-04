-- Generado por Oracle SQL Developer Data Modeler 21.4.1.349.1605
--   en:        2022-04-01 09:30:18 CLST
--   sitio:      Oracle Database 12cR2
--   tipo:      Oracle Database 12cR2



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE categoria (
    id_categoria     INTEGER NOT NULL,
    nombre_categoria VARCHAR2(50 CHAR)
)
LOGGING;

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( id_categoria );

CREATE TABLE producto (
    id_producto          INTEGER NOT NULL,
    nombre_producto      VARCHAR2(75 CHAR),
    precio_producto      INTEGER,
    descripcion_producto VARCHAR2(200 CHAR),
    id_categoria         INTEGER NOT NULL
)
LOGGING;

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id_producto );

ALTER TABLE producto
    ADD CONSTRAINT producto_categoria_fk FOREIGN KEY ( id_categoria )
        REFERENCES categoria ( id_categoria )
            ON DELETE CASCADE
    NOT DEFERRABLE;

CREATE SEQUENCE CATEGORIA_id_categoria_SEQ 
START WITH 1 
INCREMENT BY   1
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER CATEGORIA_id_categoria_TRG 
BEFORE INSERT ON CATEGORIA 
FOR EACH ROW 
WHEN (NEW.id_categoria IS NULL) 
BEGIN
:new.id_categoria := categoria_id_categoria_seq.nextval;

end;
/

CREATE SEQUENCE PRODUCTO_id_producto_SEQ 
START WITH 1 
INCREMENT BY   1
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER PRODUCTO_id_producto_TRG 
BEFORE INSERT ON PRODUCTO 
FOR EACH ROW 
BEGIN
:new.id_producto := producto_id_producto_seq.nextval;

end;
/

CREATE TABLE users (
    id            INTEGER NOT NULL,
    nombreusuario VARCHAR2(50 CHAR),
    password      VARCHAR2(50 CHAR)
)
LOGGING;

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY ( id );
/

CREATE SEQUENCE USERS_id_SEQ 
START WITH 1 
INCREMENT BY   1
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER USERS_id_TRG 
BEFORE INSERT ON USERS 
FOR EACH ROW 
WHEN (NEW.id IS NULL) 
BEGIN
:new.id := users_id_seq.nextval;

end;
/

-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             2
-- CREATE INDEX                             0
-- ALTER TABLE                              3
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           2
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
-- CREATE SEQUENCE                          2
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
