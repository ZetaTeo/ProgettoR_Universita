

INSERT INTO dipartimento (id, nome) VALUES
(1, 'Matematica'),
(2, 'Informatica');

INSERT INTO docente (id, nome, cognome, email) VALUES
(1, 'Mario', 'Rossi', 'mario.rossi@uni.it'),
(2, 'Luca', 'Bianchi', 'luca.bianchi@uni.it'),
(3, 'Giulia', 'Verdi', 'giulia.verdi@uni.it'),
(4, 'Alessandro', 'Neri', 'alessandro.neri@uni.it');

INSERT INTO docente_dipartimento (docente_id, dipartimento_id) VALUES
(1, 1), (2, 1), (3, 2), (4, 2);

INSERT INTO materia (id, nome_materia, anno, cfu, dipartimento_id) VALUES
(1, 'Analisi Matematica', 1, 9, 1),
(2, 'Geometria', 1, 6, 1),
(3, 'Programmazione I', 1, 9, 2),
(4, 'Basi di Dati', 2, 9, 2);

INSERT INTO materia_docente (materia_id, docente_id) VALUES
(1, 1), (2, 2), (3, 3), (4, 4);


INSERT INTO studente (id, nome, cognome, email, matricola, cfu_totali, dipartimento_id) VALUES
(1, 'Andrea', 'Rossi', 'andrea.rossi@studenti.uni.it', 'M100001110', 0, 1),
(2, 'Elisa', 'Bianchi', 'elisa.bianchi@studenti.uni.it', 'M100001111', 0, 1),
(3, 'Lorenzo', 'Verdi', 'lorenzo.verdi@studenti.uni.it', 'I200001110', 0, 2),
(4, 'Sara', 'Neri', 'sara.neri@studenti.uni.it', 'I200001111', 0, 2);

--INSERT INTO esame (id, data, voto, materia_id, studente_id) VALUES
--(1, '2024-01-10', 28, 1, 1),



--(2, '2024-02-15', 24, 2, 2),
--(3, '2024-03-20', 30, 3, 3),
--(4, '2024-04-10', 27, 4, 4);

--INSERT INTO esame_docente (esame_id, docente_id) VALUES
--(1, 1), (2, 2), (3, 3), (4, 4);
