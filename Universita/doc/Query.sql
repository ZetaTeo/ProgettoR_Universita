INSERT INTO dipartimento (id, nome) VALUES
(1, 'Informatica'),
(2, 'Matematica');

INSERT INTO docente (id, nome, cognome, email, dipartimento_id) VALUES
(1, 'Paolo', 'Ferrari', 'paolofer@email.it', 1),
(2, 'Alessandra', 'Conti', 'aleconti@email.it', 2),
(3, 'Stefano', 'Russo','steruss@email.it', 1),
(4, 'Giovanna', 'Mancini', 'gioman@email.it', 2),
(5, 'Lorenzo', 'De Luca', 'loredeluca@email.it', 1),
(6, 'Marta', 'Serra', 'martaserra@email.it', 1),
(7, 'Roberto', 'Colombo', 'robertocol@email.it', 2),
(8, 'Anna', 'Gatti', 'annagatti@email.it', 1),
(9, 'Davide', 'Moretti', 'davidemoretti@email.it', 2),
(10, 'Simona', 'Ferri', 'simonaferri@email.it', 1);

INSERT INTO studente (id, nome, cognome, email ,matricola, corso_di_laurea ,cfu_totali, dipartimento_id) VALUES
(1, 'Marco', 'Rossi', 'marcrossi@email.it' ,'I202500001', 'Scienze e Tecnologie Informatiche' ,0, 1),
(2, 'Giulia', 'Bianchi', 'giubianchi@email.it' ,'I202500002', 'Scienze e Tecnologie Informatiche' ,0, 1),
(3, 'Luca', 'Verdi', 'luverdi@email.it' ,'M202500001', 'Scienze Matematiche' ,0, 2),
(4, 'Elena', 'Gialli', 'elegialli@email.it' ,'M202500002', 'Scienze Matematiche' ,0, 2),
(5, 'Francesco', 'Neri','franeri@email.it' ,'I202500003', 'Scienze e Tecnologie Informatiche' ,0, 1),
(6, 'Alice', 'Romano', 'aliceromano@email.it', 'I202500004', 'Scienze e Tecnologie Informatiche', 0, 1),
(7, 'Matteo', 'Esposito', 'matteoespo@email.it', 'I202500005', 'Scienze e Tecnologie Informatiche', 0, 1),
(8, 'Sara', 'Greco', 'saragreco@email.it', 'M202500003', 'Scienze Matematiche', 0, 2),
(9, 'Andrea', 'Lombardi', 'andrealomb@email.it', 'M202500004', 'Scienze Matematiche', 0, 2),
(10, 'Chiara', 'Marini', 'chiaramarini@email.it', 'I202500006', 'Scienze e Tecnologie Informatiche', 0, 1);


INSERT INTO materia (id, nome_materia , cfu, anno ,dipartimento_id, docente_id) VALUES
(1, 'Programmazione Java', 6, 2, 1, 1),
(2, 'Database', 6, 2, 1, 3),
(3, 'Analisi Matematica', 9, 1, 2, 2),
(4, 'Algebra Lineare', 6, 1,  2, 4),
(5, 'Sistemi Operativi', 6, 1, 1, 5),
(6, 'Intelligenza Artificiale', 6, 3, 1, 6),
(7, 'Fisica Generale', 9, 1, 2, 7),
(8, 'Sicurezza Informatica', 6, 2, 1, 8),
(9, 'Calcolo Numerico', 6, 2, 2, 9),
(10, 'Reti di Calcolatori', 6, 3, 1, 10);



