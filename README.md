#Minimal JEE 7 applikation
Enkel app för deployment på JBoss/Wildfly 10. Publicerar ett REST API på /myapp/api

Använder JBoss default DataSource för JPA. Det är en in-memory H2-instans som initieras med några värden från filen import.sql i src/main/resources. Databasen är inte persistent så den rensas efter omstart.

##Hämta alla entiteter
GET http://localhost:8080/myapp/api/myentities

Accept: application/json

###Resultat
En lista med alla entiteter som JSON.

##Hämta specifik entitet
GET http://localhost:8080/myapp/api/myentities/7

Accept: application/json

###Resultat
Status 200 och den efterfrågade entiteten som JSON om den finns. Annars 404.

##Spara entitet
POST http://localhost:8080/myapp/api/myentities

Accept: application/json
Content-Type: application/json

###Body
{ "name":"Erik" }

###Resultat
Den sparade entiteten returneras som JSON i response body och Location-header pekar på den URI där entiteten kan hämtas.

##Healthcheck
GET http://localhost:8080/myapp/api/healthcheck

Accept: application/json

###Resultat
Status 200 och ett JSON-objekt med tidsstämpel (servertid) då anropet togs emot.
