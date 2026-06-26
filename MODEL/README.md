# Install DB
## Docker compose
User ./start-db.sh

The instance starts on localhost:3307
## Add KLS user
From [__V0.8.0.0_create_user.sql](migration/src/main/resources/game-score/migration/admin/__V0.8.0.0_create_user.sql)
And [V0.7.0.1__use.sql](migration/src/main/resources/game-score/migration/admin/V0.7.0.1__use.sql)

```bash
docker exec -i model-db-1 mysql -u root - p < migration/src/main/resources/game-score/migration/admin/__V0.8.0.0_create_user.sql
```
or
```bash
docker exec -it model-db-1 mysql -u root - p 
# and copy the __V0.8.0.0_create_user.sql and V0.7.0.1__use.sql
```

