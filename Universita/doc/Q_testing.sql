# Restituire true o false qualora la materia appartiene allo stesso dipartimento dello studente

SELECT EXISTS (
    SELECT 1
    FROM Studente s
    JOIN Materia m ON s.dipartimento_id = m.dipartimento_id
    WHERE s.id = :studenteId AND m.id = :materiaId
);


-- Restituire il nome, cognome, matricola, nome della materia, voto,
-- data e bocciatura degli esami sostenuti da uno studente con matricola :matricola e voto maggiore o uguale a :voto
# SELECT s.nome, s.cognome, s.matricola, m.nome_materia, e.voto, e.data, e.bocciature
# FROM Esame e
# JOIN Studente s ON e.studente_id = s.id
# JOIN Materia m ON e.materia_id = m.id
# WHERE s.matricola = :matricola AND e.voto >= :voto

SELECT *
FROM information_schema.check_constraints
WHERE constraint_name = 'studente_chk_3';
