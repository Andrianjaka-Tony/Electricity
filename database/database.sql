CREATE DATABASE _electricity;
\c _electricity;

CREATE TABLE _sector (
  _id INTEGER NOT NULL,
  _name VARCHAR NOT NULL,
  _power NUMERIC NOT NULL,
  _battery NUMERIC NOT NULL,
  PRIMARY KEY (_id)
);
CREATE SEQUENCE _sector_sequence;

CREATE TABLE _subsector (
  _id INTEGER NOT NULL,
  _name VARCHAR NOT NULL,
  _individual_consommation NUMERIC NOT NULL,
  _sector INTEGER NOT NULL,
  PRIMARY KEY (_id),
  FOREIGN KEY (_sector) REFERENCES _sector(_id)
);
CREATE SEQUENCE _subsector_sequence;

CREATE TABLE _period (
  _id INTEGER NOT NULL,
  _name VARCHAR NOT NULL,
  PRIMARY KEY (_id)
);
INSERT INTO _period
(_id, _name)
VALUES 
('1', 'Morning'),
('2', 'Afternoon');

CREATE TABLE _time_slot (
  _id INTEGER NOT NULL,
  _begin INTEGER NOT NULL,
  _end INTEGER NOT NULL,
  _period INTEGER NOT NULL,
  PRIMARY KEY (_id),
  FOREIGN KEY (_period) REFERENCES _period(_id)
);
INSERT INTO _time_slot
(_id, _begin, _end, _period)
VALUES
('1', '8', '9', '1'),
('2', '9', '10', '1'),
('3', '10', '11', '1'),
('4', '11', '12', '1'),
('7', '13', '14', '2'),
('8', '14', '15', '2'),
('9', '15', '16', '2'),
('10', '16', '17', '2');

CREATE TABLE _attendance (
  _id INTEGER NOT NULL,
  _subsector INTEGER NOT NULL,
  _period INTEGER NOT NULL,
  _number INTEGER NOT NULL,
  _date DATE NOT NULL,
  PRIMARY KEY (_id),
  FOREIGN KEY (_subsector) REFERENCES _subsector(_id),
  FOREIGN KEY (_period) REFERENCES _period(_id)
);
CREATE SEQUENCE _attendance_sequence;

CREATE TABLE _light_intensity (
  _id INTEGER NOT NULL,
  _time_slot INTEGER NOT NULL,
  _sector INTEGER NOT NULL,
  _date DATE NOT NULL,
  _value NUMERIC NOT NULL,
  PRIMARY KEY (_id),
  FOREIGN KEY (_time_slot) REFERENCES _time_slot(_id),
  FOREIGN KEY (_sector) REFERENCES _sector(_id)
);
CREATE SEQUENCE _light_intensity_sequence;
