# Esame Service: aggiungi Esame


Controlli:
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

# Nozioni





# Studente Service: cerca studente per dipartimento

- Se si vuole restituire un dto è necessario effettuare una conversione
  da studente a studenteDto