/* DELETE 'fullmessagesdb' database*/
DROP SCHEMA IF EXISTS fullmessagesdb;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'%';

/* CREATE 'fullmessagesdb' DATABASE */
CREATE SCHEMA fullmessagesdb;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'%' IDENTIFIED BY 'spq';

GRANT ALL ON fullmessagesdb.* TO 'spq'@'%';