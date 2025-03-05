## Entità principali

### Studente
- **PK: id**
- **nome**
- **cognome**
- **email**
- **matricola**
- **dipartimento**
- **corso_di_laurea**
- **cfu_totali**
- **FK: dipartimento_id**

### Esame con chiave composta
- **PK, FK1: materia_id**
- **PK, FK2: studente_id**
- **voto**
- **data**
- **bocciature**

### Docente
- **PK: id**
- **nome**
- **cognome**
- **email**
- **FK: dipartimento_id**

### Dipartimento
- **PK: id**
- **nome**


# Da implementare successivamente

### Aula
- **id**
- **nome**
- **capienza**
- **dipartimento_id**

## Relazioni

Relazioni:
- Ogni Studente è associato a un Dipartimento.
- Ogni Docente è assegnato a un Dipartimento.
- Ogni Materia ha un Docente e appartiene a un Dipartimento.
- Ogni "Esame" è identificato univocamente dalla combinazione di "studente_id" e "materia_id". Questo significa che:

Un singolo studente può sostenere più esami per diverse materie.
Una singola materia può essere sostenuta da più studenti. Perciò, entrambe 
le chiavi primarie sono necessarie per garantire l'unicità di ogni record di esame e 
per rappresentare correttamente la relazione tra gli studenti e le materie che studiano.

# Metodo interessante: inserimento esame

1. Controllo se lo studente ha già sostenuto l'esame
-  Qualora fosse così bisognerà aggiornare il voto e la data
   controllando se il voto è <>= 18, inoltre la data deve essere diversa
   poichè non si possono sostenere due esami della stessa materia lo stesso giorno.
2. Se il voto < 18, incremento il numero di bocciature
3. Se il voto >= 18, incremento il numero di cfu totali dello studente
4. Qualora l'esame non sia mai stato sostenuto dallo studente si procederà con 
   l'inserimento di tutti i parametri dell'entità esame.


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