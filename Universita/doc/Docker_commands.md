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

- **Visualizzare la versione di mysql**
```bash
docker exec -it mysql_container mysql --version
```

- **Identificare i processi**
```bash
# Cerco tutti i processi con porta 3306
C:\Users\Zteo>netstat -ano | findstr :3306
TCP    0.0.0.0:3306   0.0.0.0:0    LISTENING  8432
TCP    0.0.0.0:33060  0.0.0.0:0    LISTENING  8432
  
# Trova a quale programma appartiene il PID 8432 e chi lo sta usando
C:\Users\Zteo>tasklist | findstr 8432
mysqld.exe    8432 Services     0    266.856 K  

```


- **Docker-compose.yml**
```yaml
services:
  mysql:
    image: mysql:8.0
    container_name: mysql_container
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: GonzoSbronzo456!
      MYSQL_DATABASE: uniproj
      MYSQL_USER: zteo
      MYSQL_PASSWORD: password
    ports:
      - "3307:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

- **Docker spiegazione**

1. **MSQL_ROOT_PASSWORD**: Password per l'utente root
2. **MYSQL_USER**: Utente extra per accedere al database
3. **MYSQL_PASSWORD**: Password per l'utente extra
4. **ports:**: Porta di default di mysql è 3306, ma per evitare conflitti 3307

