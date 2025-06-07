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

INSERT INTO studente (id, nome, cognome, email, matricola, corso_di_laurea, cfu_totali, dipartimento_id, media_ponderata, media_di_conseguimento, media_aritmetica) VALUES
(1, 'Marco', 'Rossi', 'marcrossi@email.it', 'I202500001', 'COMPUTER_SCIENCES', 0, 1, 0.0, 0.0, 0.0),
(2, 'Giulia', 'Bianchi', 'giubianchi@email.it', 'I202500002', 'COMPUTER_SCIENCES', 0, 1, 0.0, 0.0, 0.0),
(3, 'Luca', 'Verdi', 'luverdi@email.it', 'M202500001', 'MATHEMATICAL_SCIENCES', 0, 2, 0.0, 0.0, 0.0),
(4, 'Elena', 'Gialli', 'elegialli@email.it', 'M202500002', 'MATHEMATICAL_SCIENCES', 0, 2, 0.0, 0.0, 0.0),
(5, 'Francesco', 'Neri', 'franeri@email.it', 'I202500003', 'COMPUTER_SCIENCES', 0, 1, 0.0, 0.0, 0.0),
(6, 'Alice', 'Romano', 'aliceromano@email.it', 'I202500004', 'COMPUTER_SCIENCES', 0, 1, 0.0, 0.0, 0.0),
(7, 'Matteo', 'Esposito', 'matteoespo@email.it', 'I202500005', 'COMPUTER_SCIENCES', 0, 1, 0.0, 0.0, 0.0),
(8, 'Sara', 'Greco', 'saragreco@email.it', 'M202500003', 'MATHEMATICAL_SCIENCES', 0, 2, 0.0, 0.0, 0.0),
(9, 'Andrea', 'Lombardi', 'andrealomb@email.it', 'M202500004', 'MATHEMATICAL_SCIENCES', 0, 2, 0.0, 0.0, 0.0),
(10, 'Chiara', 'Marini', 'chiaramarini@email.it', 'I202500006', 'COMPUTER_SCIENCES', 0, 1, 0.0, 0.0, 0.0),
(18, 'Davide', 'Conti', 'davideconti@email.it', 'I202500007', 'COMPUTER_SCIENCES', 24.3, 1, 24.3, 23.8, 24.0),
(19, 'Martina', 'Russo', 'martinarusso@email.it', 'M202500005', 'MATHEMATICAL_SCIENCES', 28.5, 2, 28.5, 27.9, 28.0),
(20, 'Giorgio', 'Ferrari', 'giorgiof@email.it', 'I202500008', 'COMPUTER_SCIENCES', 0, 1, 0, 0, 0),
(21, 'Alessia', 'Bianchi', 'alebianchi@email.it', 'M202500006', 'MATHEMATICAL_SCIENCES', 26.2, 2, 26.2, 25.4, 26.0),
(22, 'Simone', 'Moretti', 's.moretti@email.it', 'I202500009', 'COMPUTER_SCIENCES', 22.5, 1, 22.5, 22.0, 22.3),
(23, 'Valentina', 'Sartori', 'valsartori@email.it', 'M202500007', 'MATHEMATICAL_SCIENCES', 30.0, 2, 30.0, 29.8, 29.9),
(24, 'Fabio', 'Rinaldi', 'fabiorina@email.it', 'I202500010', 'COMPUTER_SCIENCES', 21.5, 1, 21.5, 21.1, 21.3),
(25, 'Irene', 'Villa', 'irenevilla@email.it', 'M202500008', 'MATHEMATICAL_SCIENCES', 27.0, 2, 27.0, 26.7, 26.8),
(26, 'Lorenzo', 'Testa', 'lorenzot@email.it', 'I202500011', 'COMPUTER_SCIENCES', 25.0, 1, 25.0, 24.8, 24.9),
(27, 'Beatrice', 'Fontana', 'beafont@email.it', 'M202500009', 'MATHEMATICAL_SCIENCES', 29.0, 2, 29.0, 28.5, 28.7),
(28, 'Gabriele', 'Sala', 'gabisala@email.it', 'I202500012', 'COMPUTER_SCIENCES', 0, 1, 0, 0, 0),
(29, 'Chiara', 'Grechi', 'chiaragrechi@email.it', 'M202500010', 'MATHEMATICAL_SCIENCES', 24.7, 2, 24.7, 24.2, 24.5),
(30, 'Stefano', 'Cattaneo', 'stefcat@email.it', 'I202500013', 'COMPUTER_SCIENCES', 23.4, 1, 23.4, 23.0, 23.2),
(31, 'Laura', 'Marchetti', 'lauramarchetti@email.it', 'M202500011', 'MATHEMATICAL_SCIENCES', 28.1, 2, 28.1, 27.6, 27.9),
(32, 'Nicola', 'Galli', 'nicogalli@email.it', 'I202500014', 'COMPUTER_SCIENCES', 20.5, 1, 20.5, 20.0, 20.3),
(33, 'Federica', 'Pagani', 'federicap@email.it', 'M202500012', 'MATHEMATICAL_SCIENCES', 26.5, 2, 26.5, 25.9, 26.2),
(34, 'Daniele', 'Ricci', 'danielericci@email.it', 'I202500015', 'COMPUTER_SCIENCES', 19.5, 1, 19.5, 19.0, 19.3),
(35, 'Sara', 'Ferri', 'saraferri@email.it', 'M202500013', 'MATHEMATICAL_SCIENCES', 27.9, 2, 27.9, 27.2, 27.5),
(36, 'Antonio', 'Costa', 'antoniocosta@email.it', 'I202500016', 'COMPUTER_SCIENCES', 18.0, 1, 18.0, 18.0, 18.0),
(37, 'Elisa', 'Bertoni', 'elisabert@email.it', 'M202500014', 'MATHEMATICAL_SCIENCES', 29.8, 2, 29.8, 29.4, 29.6),
(38, 'Marco', 'Leoni', 'marcoleoni@email.it', 'I202500017', 'COMPUTER_SCIENCES', 22.0, 1, 22.0, 21.5, 21.8);


INTO materia (id, nome_materia , cfu, anno ,dipartimento_id, docente_id) VALUES
(1, 'Programmazione Java', 6, 2, 1, 1),
(2, 'Database', 6, 2, 1, 3),
(3, 'Analisi Matematica 1', 9, 1, 2, 2),
(4, 'Algebra Lineare', 6, 1,  2, 4),
(5, 'Sistemi Operativi', 6, 1, 1, 5),
(6, 'Intelligenza Artificiale', 6, 3, 1, 6),
(7, 'Fisica Generale', 9, 1, 2, 7),
(8, 'Sicurezza Informatica', 6, 2, 1, 8),
(9, 'Calcolo Numerico', 6, 2, 2, 9),
(10, 'Reti di Calcolatori', 6, 3, 1, 10);
