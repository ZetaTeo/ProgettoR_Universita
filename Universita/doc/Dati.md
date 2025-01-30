## Entità principali

### Studente
- **id**
- **nome**
- **cognome**
- **email**
- **matricola**
- **corso_di_laurea**

### Corso
- **id**
- **nome**
- **codice**
- **docente_id**

### Docente
- **id**
- **nome**
- **cognome**
- **email**
- **dipartimento**
- **codice_fiscale**

### Esame
- **id**
- **corso_id**
- **studente_id**
- **voto**
- **data**

### Dipartimento
- **id**
- **nome**
- **sede**

### Aula
- **id**
- **nome**
- **capienza**
- **dipartimento_id**

## Relazioni

- Uno studente può essere iscritto a più corsi (**relazione N:N**).
- Un docente può insegnare più corsi (**relazione 1:N**).
- Un corso può avere più studenti (**relazione N:N**).
- Gli esami sono associati a studenti e corsi (**relazione N:1**).
- Le aule appartengono a un dipartimento (**relazione N:1**).

## Esempio di 10 endpoint da implementare

1. **POST /studenti** - Aggiungi un nuovo studente
2. **GET /studenti/{id}** - Recupera uno studente per ID
3. **PUT /studenti/{id}** - Aggiorna i dati di uno studente
4. **DELETE /studenti/{id}** - Elimina uno studente
5. **GET /corsi** - Lista di tutti i corsi
6. **POST /esami** - Registra un esame per uno studente
7. **GET /docenti/{id}/corsi** - Ottieni i corsi di un docente
8. **GET /dipartimenti** - Lista dei dipartimenti disponibili
9. **GET /aule** - Lista delle aule disponibili
10. **GET /studenti/{id}/esami** - Ottieni gli esami di uno studente

## EXTRA
1. Assegnare ad un docente quel corso
2. Far iscrivere lo studente a quel corso