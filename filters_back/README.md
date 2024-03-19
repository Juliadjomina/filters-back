# Wisercat filters Backend

## Run
### Prerequisites

* JDK 21

## Lokaalne arendus

Dockeri andmebaasi jooksutamine

```
docker-compose up
```

Käivita rakendust

Rakendus jookseb pordil 8080


## Swagger

Swagger UI

```
http://localhost:8080/api/swagger-ui/index.html#/
```


## Lokaalne testide jooksutamine

Liikuda kataloogi kus asub docker-compose fail ja käivatada

```
docker-compose up
```

Pärast testide jooksutamist eemaldada containerid (ka volumed ja orphan containerid)
```
docker-compose down -v --remove-orphans
```

