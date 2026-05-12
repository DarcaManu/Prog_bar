# Prog_Bar — Gestione Ordini Bar

Applicazione Java per la gestione degli ordini di un bar.
Gli ordini vengono salvati in una **coda FIFO**: il primo ordine inserito è il primo ad essere servito.
Il programma è disponibile in due modalità: **console (CLI)** e **interfaccia grafica (GUI)** con Java Swing.

---

## Struttura del progetto

```
Prog_bar/
├── src/
│   ├── CLI/
│   │   ├── MainCLI.java        <- avvio modalità console, menu testuale e ciclo principale
│   │   ├── CodaOrdini.java     <- estende la classe Coda della libreria strutture_vector
│   │   ├── MenuScelte.java     <- stampa il menu CLI e legge la scelta dell'utente
│   │   ├── Utility.java        <- metodi di utilità: input ordini, stampa, "premi un tasto"
│   │   └── GestoreFile.java    <- salva/carica ordini su file, legge CSV listino, mostra guida
│   ├── gui/
│   │   ├── MainGui.java                    <- finestra principale con CardLayout e JMenuBar
│   │   ├── MenuGui.java                    <- costruisce la JMenuBar e gestisce la navigazione
│   │   ├── PanelHome.java                  <- pannello di benvenuto con immagine
│   │   ├── PanelOrdinazioni.java           <- aggiunge un singolo ordine alla coda
│   │   ├── PanelOrdinazioniPerTavolo.java  <- aggiunge più ordini per lo stesso tavolo
│   │   ├── PanelEstraiOrdine.java          <- estrae il primo ordine dalla coda
│   │   ├── PanelTuttiOrdini.java           <- mostra tutti gli ordini in coda
│   │   ├── PanelFiltraTavolo.java          <- filtra gli ordini per numero tavolo
│   │   ├── PanelSalvaOrdini.java           <- salva la coda su file binario
│   │   ├── PanelCaricaOrdini.java          <- carica gli ordini da file binario
│   │   ├── PanelListinoPrezzi.java         <- mostra il listino prezzi dal CSV
│   │   └── PanelGuidaUtente.java           <- mostra la guida utente dal file TXT
│   ├── model/
│   │   └── Ordine.java         <- classe che rappresenta un singolo ordine (tavolo, prodotto, quantità)
│   └── strutture_vector/       <- libreria scolastica con la classe Coda (non modificare)
├── data/
│   ├── ordini.dat                          <- file binario con gli ordini salvati
│   ├── bistro_price_list_with_header.csv   <- listino prezzi
│   └── GuidaUtente.txt                     <- guida testuale accessibile dal menu
├── compile_and_run.bat         <- script Windows per compilare ed eseguire il progetto
└── README.md
```

---

## Come funziona

Il programma ruota attorno a una **coda FIFO di oggetti `Ordine`**.
Ogni ordine ha tre campi: numero tavola, nome prodotto e quantità.
La coda è implementata estendendo la classe `Coda` della libreria `strutture_vector` — non usa `java.util.Queue` perché il progetto richiedeva di usare le strutture dati della scuola.

---

## Modalità di avvio

### GUI (consigliata) — `MainGui.java`

Si apre una finestra con una **JMenuBar** per navigare tra le sezioni.
Ogni voce di menu mostra il pannello corrispondente **nella stessa finestra** — nessuna JFrame aggiuntiva viene aperta (CardLayout).

| Menu | Pannello aperto |
|------|----------------|
| Ordinazioni → Aggiungi Ordine | `PanelOrdinazioni` |
| Ordinazioni → Ordini per Tavolo | `PanelOrdinazioniPerTavolo` |
| Cucina → Estrai Ordine | `PanelEstraiOrdine` |
| Cucina → Tutti gli Ordini | `PanelTuttiOrdini` |
| Cucina → Filtra per Tavolo | `PanelFiltraTavolo` |
| File → Salva Ordini | `PanelSalvaOrdini` |
| File → Carica Ordini | `PanelCaricaOrdini` |
| File → Listino Prezzi | `PanelListinoPrezzi` |
| Guida | `PanelGuidaUtente` |

### Console (CLI) — `MainCLI.java`

Appare un menu testuale numerato con le stesse funzionalità della GUI.

| N° | Cosa fa |
|----|---------|
| 1  | Aggiunge un ordine alla coda |
| 2  | Aggiunge più ordini per lo stesso tavolo in sequenza |
| 3  | Estrae e rimuove il primo ordine dalla coda |
| 4  | Mostra il primo ordine senza rimuoverlo |
| 5  | Mostra tutti gli ordini in coda |
| 6  | Filtra e mostra gli ordini di un tavolo specifico |
| 7  | Salva tutta la coda su `data/ordini.dat` |
| 8  | Carica gli ordini da `data/ordini.dat` |
| 9  | Mostra la guida utente |
| 10 | Mostra il listino prezzi dal CSV |
| 0  | Esce dal programma |

---

## Come eseguire

### Con IntelliJ IDEA / VS Code
1. Aprire la cartella del progetto come progetto Java
2. Assicurarsi che `src/strutture_vector/` sia nel classpath
3. Avviare `MainGui.java` per la GUI oppure `MainCLI.java` per la console

### Con lo script batch (Windows)
Dalla root del progetto, eseguire:
```
compile_and_run.bat
```

---

## Note tecniche

- `Ordine` implementa `Serializable` per il salvataggio su file binario con `ObjectOutputStream`
- Il file `ordini.dat` non è leggibile come testo: è serializzazione Java standard
- Il listino prezzi è un CSV con header: `Categoria, Item, Prezzo, CodiceArticolo`
- La GUI usa `CardLayout`: un unico `JFrame` mostra un pannello per volta, senza aprire finestre aggiuntive
- Il package `strutture_vector` contiene la libreria scolastica — non va modificato
