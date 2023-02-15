-- Names in SQL must begin with a letter (a-z) or underscore (_).
-- Subsequent characters in a name can be letters, digits (0-9), or underscores.

-- Dette eksemplet innholder en 1:N-forbindelse mellom entitetstypene ansatt og avdeling.

-- Sletter hele sulamitten og oppretter på nytt.
DROP SCHEMA IF EXISTS Selskap CASCADE;
CREATE SCHEMA Selskap;
SET search_path TO Selskap;

CREATE TABLE Utleiekontor
(
    id SERIAL PRIMARY KEY,
    addresse VARCHAR(30) NOT NULL,
    telefonnr char(8) NOT NULL
);


CREATE TABLE Bil
(
    regnr char(7) PRIMARY KEY,
    merke varchar(30) NOT NULL,
    model varchar(30) NOT NULL,
    farge varchar(30) NOT NULL,
    utleiegr char(1),
    størrelse varchar(30) NOT NULL,
    erledig BOOLEAN,
    utleiekontor_id INTEGER,
    FOREIGN KEY (utleiekontor_id) REFERENCES utleiekontor(id)
);

CREATE TABLE Kunde
(
    fornavn VARCHAR(20) NOT NULL,
    etternavn VARCHAR(20) NOT NULL,
    mobil CHAR(8) PRIMARY KEY,
    addresse varchar(30) NOT NULL,
    kortnr char(16)
);

CREATE TABLE Utleie
(
    kunde char(8) PRIMARY KEY,
    utleiested INTEGER NOT NULL,
    retursted INTEGER NOT NULL,
    datofra varchar(20) NOT NULL,
    tidfra varchar(20) NOT NULL,
	datotil varchar(20) NOT NULL,
    tidtil varchar(20) NOT NULL,
    regnr char(7),
    FOREIGN KEY (regnr) REFERENCES bil(regnr),
    FOREIGN KEY (kunde) REFERENCES kunde(mobil),
    FOREIGN KEY (utleiested) REFERENCES utleiekontor(id),
    FOREIGN KEY (retursted) REFERENCES utleiekontor(id)
);

CREATE TABLE Retur
(
  kunde char(8) PRIMARY KEY,
  dato varchar(20) NOT NULL,
  tid varchar(20) NOT NULL,
  FOREIGN KEY (kunde) REFERENCES kunde(mobil)
);

INSERT INTO
  Utleiekontor(addresse, telefonnr)
VALUES
    ('Flyplassvegen 555', '11100111'),
    ('Edvard Munchs veg', '12345678'),
    ('7500 stjørdal', '87654321');

INSERT INTO
  Bil(regnr, merke, model, farge, utleiegr, størrelse, erledig,utleiekontor_id)
VALUES
    ('WN12345', 'Toyota', 'RAV4', 'hvit', 'B', 'mellomstor', true,1),
    ('EP67890', 'Tesla', 'Y', 'hvit', 'B', 'mellomstor', true,1),
    ('EQ34691', 'Tesla', 'Y', 'sølv', 'B', 'mellomstor', true,2),
    ('AP23510', 'Toyota', 'RAV4', 'sølv', 'B', 'mellomstor', true,2),
    ('LP12670', 'Toyata', 'RAV4', 'svart', 'B', 'mellomstor', true,3),
    ('EP22334', 'Tesla', 'S', 'svart', 'B', 'mellomstor', true,3);
