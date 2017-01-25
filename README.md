#Minimal JEE 7 applikation
Enkel app f�r deployment p� JBoss/Wildfly 10. Publicerar ett REST API p� /myapp/api

Anv�nder JBoss default DataSource f�r JPA. Det �r en in-memory H2-instans som initieras med n�gra v�rden fr�n filen import.sql i src/main/resources. Databasen �r inte persistent s� den rensas efter omstart.

##H�mta alla entiteter
GET http://localhost:8080/myapp/api/myentities

Accept: application/json

###Resultat
En lista med alla entiteter som JSON.

##H�mta specifik entitet
GET http://localhost:8080/myapp/api/myentities/7

Accept: application/json

###Resultat
Status 200 och den efterfr�gade entiteten som JSON om den finns. Annars 404.

##Spara entitet
POST http://localhost:8080/myapp/api/myentities

Accept: application/json
Content-Type: application/json

###Body
{ "name":"Erik" }

###Resultat
Den sparade entiteten returneras som JSON i response body och Location-header pekar p� den URI d�r entiteten kan h�mtas.

##Healthcheck
GET http://localhost:8080/myapp/api/healthcheck

Accept: application/json

###Resultat
Status 200 och ett JSON-objekt med tidsst�mpel (servertid) d� anropet togs emot.
