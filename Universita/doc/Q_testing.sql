# Restituire true o false qualora la materia appartiene allo stesso dipartimento dello studente

SELECT EXISTS (
    SELECT 1
    FROM Studente s
    JOIN Materia m ON s.dipartimento_id = m.dipartimento_id
    WHERE s.id = :studenteId AND m.id = :materiaId
);