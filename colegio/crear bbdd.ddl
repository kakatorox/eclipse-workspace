-- Generado por Oracle SQL Developer Data Modeler 21.4.1.349.1605
--   en:        2022-03-24 20:08:24 CLST
--   sitio:      Oracle Database 12cR2
--   tipo:      Oracle Database 12cR2



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE alumno (
    id               INTEGER NOT NULL,
    nombre           VARCHAR2(25 CHAR),
    apellido         VARCHAR2(25 CHAR),
    fecha_nacimiento DATE,
    curso_id         INTEGER NOT NULL
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( id );

CREATE TABLE asignatura (
    id                 INTEGER NOT NULL,
    descripcion        VARCHAR2(25 CHAR),
    tipo_asignatura_id INTEGER NOT NULL
);

ALTER TABLE asignatura ADD CONSTRAINT asignatura_pk PRIMARY KEY ( id );

CREATE TABLE curso (
    id          INTEGER NOT NULL,
    descripcion VARCHAR2(25 CHAR)
);

ALTER TABLE curso ADD CONSTRAINT curso_pk PRIMARY KEY ( id );

CREATE TABLE curso_asignatura (
    curso_id      INTEGER NOT NULL,
    asignatura_id INTEGER NOT NULL,
    profesor_id   INTEGER NOT NULL
);

ALTER TABLE curso_asignatura
    ADD CONSTRAINT curso_asignatura_pk PRIMARY KEY ( curso_id,
                                                     asignatura_id,
                                                     profesor_id );

CREATE TABLE profesor (
    id       INTEGER NOT NULL,
    nombre   VARCHAR2(25 CHAR),
    apellido VARCHAR2(25 CHAR)
);

ALTER TABLE profesor ADD CONSTRAINT profesor_pk PRIMARY KEY ( id );

CREATE TABLE tipo_asignatura (
    id          INTEGER NOT NULL,
    descripcion VARCHAR2(25 CHAR)
);

ALTER TABLE tipo_asignatura ADD CONSTRAINT tipo_asignatura_pk PRIMARY KEY ( id );

ALTER TABLE alumno
    ADD CONSTRAINT alumno_curso_fk FOREIGN KEY ( curso_id )
        REFERENCES curso ( id );

ALTER TABLE asignatura
    ADD CONSTRAINT asignatura_tipo_asignatura_fk FOREIGN KEY ( tipo_asignatura_id )
        REFERENCES tipo_asignatura ( id );

ALTER TABLE curso_asignatura
    ADD CONSTRAINT curso_asignatura_asignatura_fk FOREIGN KEY ( asignatura_id )
        REFERENCES asignatura ( id );

ALTER TABLE curso_asignatura
    ADD CONSTRAINT curso_asignatura_curso_fk FOREIGN KEY ( curso_id )
        REFERENCES curso ( id );

ALTER TABLE curso_asignatura
    ADD CONSTRAINT curso_asignatura_profesor_fk FOREIGN KEY ( profesor_id )
        REFERENCES profesor ( id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             6
-- CREATE INDEX                             0
-- ALTER TABLE                             11
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
