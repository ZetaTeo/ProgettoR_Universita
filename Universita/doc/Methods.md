# Esame Service: aggiungi Esame


Controlli orElseThrow:
- Lo studente matricola n. esiste?
- La materia nome xyz esiste?
- Verifico se all'interno della tabella "esame" esiste esso con matricola e materia valida riferita allo studente
-----------------------------------------------------
Esame != null
- Qualora |esiste| già un esame devo identificarlo e confrontarlo con i dati in input

**Siamo nel caso in cui l'esame esiste già!**
- Il voto >= 18. significa che è gia stato superato !
- La data uguale a quella della richiesta ? Eccezione
- Aggiorno voto e data con i nuovi dati poiché aggiorneremo dati già esistenti

**Caso votoEsame < 18**
- Aumento le bocciature e aggiorno quelle esistenti

**Caso Else "L'esame non esiste"**
- Creo un nuovo esame con i dati in input passati durante la richiesta
- Se l'esame che sto aggiungendo ha voto < 18 allora aumento le bocciature dello studente

**Caso voto > 18**
- Aumento i cfu dello studente e salvo l'aggiornamento nella tabella studente

# Aggiornamento per nuova implementazione:

- Considerando che le materie sono legate ai dipartimenti cosi come gli studenti è necessario controllare che l'esame aggiunto
  sia effettivamente legato al dipartimento corretto.

La query svolge i seguenti passaggi:

- Si verifica in primis se il dipartimento dello studente è uguale a quello della materia.
- La condizione WHERE dice (l'id dello studente/materia deve essere uguale a quello in ingresso
- Si verifica se esiste almeno una riga (SELECT 1) che soddisfa la condizione
- EXISTS restituisce un wrapper (Long, Integer) essendo un valore booleano (0,1) può essere trattato come tale successivamente

```sql
    @Query(value = """
    SELECT EXISTS (
        SELECT 1 
        FROM studente s 
        JOIN materia m ON s.dipartimento_id = m.dipartimento_id
        WHERE s.id = :studenteId AND m.id = :materiaId
    )
""", nativeQuery = true)
Integer verificaAppartenenzaDipartimento( int studenteId,  int materiaId);
```

```java
  boolean esiste = esameRepository.verificaAppartenenzaDipartimento(studente.getId(), materia.getId()) != 0;
        if(!esiste)
        throw new IllegalStateException("Studente e materia non appartengono allo stesso dipartimento");
```
Casi che posso ritrovare:
- esiste = 0 != 0 -> false
- esiste = 1 != 0 -> true

Di conseguenza:

- Se il valore di esiste è false ovvero 0, allora l'eccezione viene lanciata.
- Se il valore di esiste è true ovvero 1, il codice continua senza problemi.


