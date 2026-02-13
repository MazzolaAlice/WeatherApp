# Weather App
Applicazione web sviluppata con **Spring Boot + Thymeleaf** che consente agli utenti di cercare il meteo attuale e il forecast utilizzando l’API Open-Meteo.
## Panoramica del Progetto
Weather App permette di inserire il nome di una città per ottenere informazioni meteo in tempo reale.
L’app recupera:

* Temperatura attuale
* Velocità del vento
* Umidità
* Previsioni (forecast multi-giorno – in sviluppo)
I dati vengono ottenuti tramite chiamate API a Open-Meteo, con gestione degli errori e logging delle risposte.
---
##  Funzionalità
* Ricerca meteo per città
* Geocoding automatico (latitudine/longitudine)
* Visualizzazione temperatura e vento
* Background dinamico in base alla temperatura
* Layout responsive mobile
* Gestione errori città non valide
* Logging risposte API
* Struttura MVC (Controller / Service / DTO)
---

## Tecnologie Utilizzate
* Java 21
* Spring Boot
* Thymeleaf
* REST API (Open-Meteo)
* HTML5 / CSS3
* Maven
---

## Istruzioni di Installazione
### Clona il repository
```bash
git clone https://github.com/tuo-username/weather-app.git
cd weather-app
```
### Apri il progetto
Con:
* IntelliJ / VS Code / Eclipse
### Installa dipendenze
```bash
mvn clean install
```
### Avvia l’app
```bash
mvn spring-boot:run
```
Oppure esegui la classe:
```
Main.java
```
### Apri nel browser
```
http://localhost:8080
```
---

## Guida all’Utilizzo
1. Inserisci il nome di una città nel campo di ricerca
2. Clicca **Cerca**
3. Visualizza i dati meteo aggiornati

## Output di Esempio
```
Città: Roma

Temperatura: 28°C
Vento: 12 km/h
Umidità: 60%
```

## Gestione degli Errori
L’app gestisce:
* Città non trovate
* Risposte API nulle
* Errori di parsing
Esempio:
```
RuntimeException: "Città non trovata"
```
Le risposte vengono registrate nei log per debug.
---

## Informazioni API
API utilizzata:
**Open-Meteo**
Documentazione:
https://open-meteo.com/

---

## Miglioramenti Futuri
* Icone meteo dinamiche
* Ricerca multipla città
* Salvataggio preferiti
* Dark mode
* Grafici temperature
* Cache richieste API
---

## Licenza
Progetto a scopo didattico.

---

## Autore
Alice Mazzola

GitHub:
https://github.com/MazzolaAlice
# WeatherApp
