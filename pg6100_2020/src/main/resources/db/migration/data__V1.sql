CREATE SEQUENCE entity_id_sequence START 1 INCREMENT 1;

CREATE TABLE Boat (
     id BIGINT NOT NULL,
     name VARCHAR NOT NULL,
     builder VARCHAR NOT NULL,
     crewMembers BIGINT NOT NULL,
     PRIMARY KEY (id)
);