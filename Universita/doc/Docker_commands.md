Per configurare docker correttamente e non creare conflitto con il servizio di mysql interno
è necessario cambiare porta di default di mysql da 3306 a 3307.

Comandi che utilizzo per gestire i container docker:

- **Avviare il container:**
```bash 
docker-compose up -d
```
- **Fermare il container:**
```bash
docker-compose down
```

- **Visualizzare i container attivi:**
```bash
docker ps
```
- **Entrare nel container docker:**
```bash
docker exec -it nome_container mysql -uroot -p
```

- **Selezionare utente e db:**
```sql
SELECT host, user FROM mysql.user;
USE nome_db;
``` 
- **Verifico la password di root qualora non la conoscessi**
```bash
docker exec -it mysql_container printenv MYSQL_ROOT_PASSWORD
```

-- **Visualizzare la versione di mysql**
```bash
docker exec -it mysql_container mysql --version
```

