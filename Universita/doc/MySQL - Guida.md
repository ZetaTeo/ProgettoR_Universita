# MySQL - Workbench

Aprire cmd da amministratore e digitare i seguenti comandi che pianificheranno le attività

**Descrizione:** Questo comando crea una task pianificata che esegue il comando `net stop mysql80` / net start mysql80 per fermare/avviare il servizio MySQL. È stata impostata per essere eseguita manualmente (`/sc ONCE`), ed eseguita con i privilegi più alti (`/rl HIGHEST`).

```bash
schtasks /create /tn "Start_MySQL80" /tr "cmd.exe /c net start mysql80" /rl HIGHEST /sc ONCE /st 23:59 /f

schtasks /create /tn "Stop_MySQL80" /tr "cmd.exe /c net stop mysql80" /rl HIGHEST /sc ONCE /st 23:59 /f

```

Comandi per avviare le tasks

```bash
schtasks /run /tn "Stop_MySQL80"

schtasks /run /tn "Start_MySQL80"

schtasks /delete /tn "Stop_MySQL80" /f

schtasks /delete /tn "Start_MySQL80" /f

sc query mysql80 "Mostra se il servizio è attivo o disattivato"

NOME_SERVIZIO: mysql80
        TIPO                   : 10  WIN32_OWN_PROCESS
        STATO                  : 4  RUNNING
                                (STOPPABLE, PAUSABLE, ACCEPTS_SHUTDOWN)
        CODICE_USCITA_WIN32    : 0  (0x0)
        CODICE_USCITA_SERVIZIO : 0  (0x0)
        PUNTO_CONTROLLO          : 0x0
        INDICAZIONE_ATTESA     : 0x0
```

- **Apertura delle Impostazioni di IntelliJ:**
    - Andato su **File > Settings** (o **Preferences** su macOS).
    - Navigato in **Tools > External Tools** per configurare le task come strumenti esterni.
- **Configurazione della Task per Fermare MySQL in IntelliJ:**
    - Nome: **"Stop MySQL80"**
    - Programma: `C:\Windows\System32\schtasks.exe`
    - Argomenti: `/run /tn "Stop_MySQL80"`
    - Directory di Lavoro: Lasciata vuota.
- **Configurazione della Task per Avviare MySQL in IntelliJ:**
    - Nome: **"Start MySQL80"**
    - Programma: `C:\Windows\System32\schtasks.exe`
    - Argomenti: `/run /tn "Start_MySQL80"`
    - Directory di Lavoro: Lasciata vuota.

Eventualmente che si vuole interrompere o avviare il servizio manualmente senza automazione, 
avviare sempre cmd da amministratore

- **net start MySQL80**
- **net stop MySQL80**