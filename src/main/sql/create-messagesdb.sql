CREATE DATABASE messagesDB;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON messagesDB.*
           TO sd@'%'
           IDENTIFIED BY 'sd';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON messagesDB.*
           TO sd@localhost
           IDENTIFIED BY 'sd';