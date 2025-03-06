# Loop Json

- Quando si genera ?

Quando si prova a convertire un oggetto in una stringa Json, dietro le quinte la libreria jackson 
cerca di effettuare questa procedura. Quando si trova un riferimento circolare, ovvero un oggetto 
che si riferisce a se stesso, la libreria non sa come gestire questa situazione e genera un loop.
Precisamente si tratta di relazione bidirezionale tra due entità, nel nostro caso si ha una relazione @OneToMany
tra Studente e Dipartimento.

- Cosa si intende per "si riferisce a se stesso" ?

Se Jackson prova a serializzare uno Studente, troverà un Dipartimento, 
che contiene altri Studenti, che contengono nuovamente lo stesso Dipartimento, 
e così via... Creando un loop infinito! La serializzazione è il processo di conversione di un oggetto 
in un formato che può essere memorizzato o trasmesso.

Studente --> Dipartimento --> Studente --> Dipartimento --> Studente --> Dipartimento --> ∞ 

Prendiamo come esempio l'entità Studente:

```java
@Entity
public class Studente {
    @ManyToOne
    @JoinColumn(nullable = false)
    private Dipartimento dipartimento;
}

@Entity
public class Dipartimento {
    @OneToMany(mappedBy = "dipartimento")
    private List<Studente> studenti;
}
```

# DTO

Un dto genera numerosi vantaggi all'interno di un'applicazione, tra cui:

- Meno esposizione di dati sensibili
- Riduzione del traffico di rete
- Riduzione del carico di lavoro del server
- Riduzione del tempo di caricamento della pagina

Quando invece restituisco l'intera entità anzichè il dto si potrà avere un loop infinito e anche un payload più pesante.

- Come gestisco la conversione da entità a dto ?

```java
public static StudenteDto fromEntityToDto(Studente studente)
    {
        return new StudenteDto
                (
                  studente.getNome(),
                  studente.getCognome(),
                  studente.getEmail(),
                  studente.getMatricola(),
                  studente.getCorsoDiLaurea(),
                  studente.getCfuTotali(),
                  studente.getDipartimento().getNome()

                );
    }
```

- EXTRA: Come gestisco la conversione da dto a entità ?

```java
public static Studente fromDtoToEntity(StudenteDto studenteDto)
    {
        return new Studente
                (
                  studenteDto.getNome(),
                  studenteDto.getCognome(),
                  studenteDto.getEmail(),
                  studenteDto.getMatricola(),
                  studenteDto.getCorsoDiLaurea(),
                  studenteDto.getCfuTotali(), 
                  studente.getDipartimento().getNome()
                );
    }
```
- Voglio restituire una lista di dto, come posso fare ?

Si può  svolgere l'operazione con gli stream o con un ciclo for, i metodi risultano entrambi validi ma con alcune
differenze:

- Stream: è più leggibile e conciso, ma è più difficile da debuggare.
- Ciclo for: è più lungo e meno leggibile, ma è più facile da debuggare.

```java
 return listaStudenti.stream()
          .map(StudenteDto::fromEntityToDto)
          .collect(Collectors.toList());
```

```java
  for (Studente studente : listaStudenti) 
  {
    studentiDto.add(StudenteDto.fromEntityToDto(studente));
  }
```
In termini di prestazioni con ad  esempio 100k di dati chi vince ?

| Metodo            | Piccolo dataset (100-1K) | Medio dataset (10K) | Grande dataset (100K) |
|-------------------|--------------------------|---------------------|-----------------------|
| **for-each**      | ✅ Veloce                | ✅ Efficiente        | ❌ Non sfrutta CPU multi-core |
| **Stream**        | ✅ Pulito                | ✅ Simile al for-each| ❌ Stesso problema del for-each |
| **Parallel Stream**| ❌ Overhead inutile      | ✅ Ottimo            | 🚀 **Il più veloce su CPU multi-core** |


 