INSERT INTO studente (id, nome, cognome, email, matricola, corso_di_laurea, cfu_totali, dipartimento_id, media_ponderata, media_di_conseguimento, media_aritmetica) VALUES
(18, 'Davide', 'Conti', 'davideconti@email.it', 'I202500007', 'Scienze e Tecnologie Informatiche', 24.3, 1, 24.3, 23.8, 24.0),
(19, 'Martina', 'Russo', 'martinarusso@email.it', 'M202500005', 'Scienze Matematiche', 28.5, 2, 28.5, 27.9, 28.0),
(20, 'Giorgio', 'Ferrari', 'giorgiof@email.it', 'I202500008', 'Scienze e Tecnologie Informatiche', 0, 1, 0, 0, 0),
(21, 'Alessia', 'Bianchi', 'alebianchi@email.it', 'M202500006', 'Scienze Matematiche', 26.2, 2, 26.2, 25.4, 26.0),
(22, 'Simone', 'Moretti', 's.moretti@email.it', 'I202500009', 'Scienze e Tecnologie Informatiche', 22.5, 1, 22.5, 22.0, 22.3),
(23, 'Valentina', 'Sartori', 'valsartori@email.it', 'M202500007', 'Scienze Matematiche', 30.0, 2, 30.0, 29.8, 29.9),
(24, 'Fabio', 'Rinaldi', 'fabiorina@email.it', 'I202500010', 'Scienze e Tecnologie Informatiche', 21.5, 1, 21.5, 21.1, 21.3),
(25, 'Irene', 'Villa', 'irenevilla@email.it', 'M202500008', 'Scienze Matematiche', 27.0, 2, 27.0, 26.7, 26.8),
(26, 'Lorenzo', 'Testa', 'lorenzot@email.it', 'I202500011', 'Scienze e Tecnologie Informatiche', 25.0, 1, 25.0, 24.8, 24.9),
(27, 'Beatrice', 'Fontana', 'beafont@email.it', 'M202500009', 'Scienze Matematiche', 29.0, 2, 29.0, 28.5, 28.7),
(28, 'Gabriele', 'Sala', 'gabisala@email.it', 'I202500012', 'Scienze e Tecnologie Informatiche', 0, 1, 0, 0, 0),
(29, 'Chiara', 'Grechi', 'chiaragrechi@email.it', 'M202500010', 'Scienze Matematiche', 24.7, 2, 24.7, 24.2, 24.5),
(30, 'Stefano', 'Cattaneo', 'stefcat@email.it', 'I202500013', 'Scienze e Tecnologie Informatiche', 23.4, 1, 23.4, 23.0, 23.2),
(31, 'Laura', 'Marchetti', 'lauramarchetti@email.it', 'M202500011', 'Scienze Matematiche', 28.1, 2, 28.1, 27.6, 27.9),
(32, 'Nicola', 'Galli', 'nicogalli@email.it', 'I202500014', 'Scienze e Tecnologie Informatiche', 20.5, 1, 20.5, 20.0, 20.3),
(33, 'Federica', 'Pagani', 'federicap@email.it', 'M202500012', 'Scienze Matematiche', 26.5, 2, 26.5, 25.9, 26.2),
(34, 'Daniele', 'Ricci', 'danielericci@email.it', 'I202500015', 'Scienze e Tecnologie Informatiche', 19.5, 1, 19.5, 19.0, 19.3),
(35, 'Sara', 'Ferri', 'saraferri@email.it', 'M202500013', 'Scienze Matematiche', 27.9, 2, 27.9, 27.2, 27.5),
(36, 'Antonio', 'Costa', 'antoniocosta@email.it', 'I202500016', 'Scienze e Tecnologie Informatiche', 18.0, 1, 18.0, 18.0, 18.0),
(37, 'Elisa', 'Bertoni', 'elisabert@email.it', 'M202500014', 'Scienze Matematiche', 29.8, 2, 29.8, 29.4, 29.6),
(38, 'Marco', 'Leoni', 'marcoleoni@email.it', 'I202500017', 'Scienze e Tecnologie Informatiche', 22.0, 1, 22.0, 21.5, 21.8);


UPDATE studente SET corso_di_laurea = 'COMPUTER_SCIENCES' WHERE corso_di_laurea = 'Scienze e Tecnologie Informatiche';
UPDATE studente SET corso_di_laurea = 'MATHEMATICAL_SCIENCES' WHERE corso_di_laurea = 'Scienze Matematiche';
