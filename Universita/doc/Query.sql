INSERT INTO corso (id, nome, cfu, docente_id) VALUES
(1, 'Programmazione Java', 'CS101', 1),
(2, 'Analisi Matematica', 'MATH202', 2),
(3, 'Fisica I', 'PHY303', 3),
(4, 'Letteratura Italiana', 'LIT404', 4),
(5, 'Microeconomia', 'ECO505', 5);


INSERT INTO studente (id, nome, cognome, email, matricola, corso_di_laurea) VALUES
(1, 'Giulia', 'Verdi', 'giulia.verdi@studenti.uni.it', '123456', 'Informatica'),
(2, 'Marco', 'Neri', 'marco.neri@studenti.uni.it', '654321', 'Matematica'),
(3, 'Luca', 'Bianchi', 'luca.bianchi@studenti.uni.it', '789012', 'Fisica'),
(4, 'Sara', 'Russo', 'sara.russo@studenti.uni.it', '345678', 'Lettere'),
(5, 'Alessandro', 'Ferrari', 'alessandro.ferrari@studenti.uni.it', '901234', 'Economia');


INSERT INTO esame (id, corso_id, studente_id, voto, data) VALUES
(1, 1, 1, 28, '2024-01-10'),
(2, 2, 2, 30, '2024-01-15'),
(3, 3, 3, 24, '2024-01-20'),
(4, 4, 4, 27, '2024-01-22'),
(5, 5, 5, 29, '2024-01-25');


INSERT INTO aula (id, nome, capienza, dipartimento_id) VALUES
(1, 'Aula Magna', 200, 1),
(2, 'Aula 101', 50, 2),
(3, 'Laboratorio Fisica', 30, 3),
(4, 'Sala Conferenze', 100, 4),
(5, 'Aula Economia', 75, 5);

INSERT INTO dipartimento (id, nome, sede) VALUES
(1, 'Informatica', 'Edificio A'),
(2, 'Matematica', 'Edificio B'),
(3, 'Fisica', 'Edificio C'),
(4, 'Lettere', 'Edificio D'),
(5, 'Economia', 'Edificio E');


INSERT INTO docente (id, nome, cognome, email, dipartimento) VALUES
(1, 'Mario', 'Rossi', 'mario.rossi@uni.it', 1),
(2, 'Luca', 'Bianchi', 'luca.bianchi@uni.it', 2),
(3, 'Anna', 'Verdi', 'anna.verdi@uni.it', 3),
(4, 'Paolo', 'Neri', 'paolo.neri@uni.it', 4),
(5, 'Elena', 'Russo', 'elena.russo@uni.it', 5);
