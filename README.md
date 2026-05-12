# Prog_Bar — Gestione Ordini Bar

Applicazione Java per la gestione degli ordini di un bar.
Gli ordini vengono salvati in una **coda FIFO**: il primo ordine inserito è il primo ad essere servito.
Il programma è disponibile in due modalità: **console (CLI)** e **interfaccia grafica (GUI)** con Java Swing.

---

## Struttura del progetto

```
Prog_bar/
├── src/
│   ├── Main.java                           <- avvio CLI, menu testuale e ciclo principale
│   ├── MainGui.java                        <- avvio GUI, finestra principale con CardLayout e JMenuBar
│   ├── Ordine.java                         <- classe che rappresenta un singolo ordine (tavolo, prodotto, quantità)
│   ├── CodaOrdini.java                     <- estende la classe Coda della libreria iisvolta
│   ├── MenuScelte.java                     <- stampa il menu CLI e legge la scelta dell'utente
│   ├── Utility.java                        <- metodi di utilità: input ordini, stampa, "premi un tasto"
│   ├── GestoreFile.java                    <- salva/carica ordini su file, legge CSV listino, mostra guida
│   ├── GuiPrenotazioni.java                <- pannello Swing per inserire un ordine graficamente
│   ├── GestoreEventi.java                  <- ActionListener del pulsante Conferma nella GUI
│   └── InterfacciaOrdini.java              <- pannello Swing che mostra tutti gli ordini in coda
├── src/iisvolta/                           <- libreria scolastica con la classe Coda (non modificare)
├── data/
│   ├── ordini.dat                          <- file binario con gli ordini salvati
│   ├── bistro_price_list_with_header.csv   <- listino prezzi (letto dalla GUI e dal menu console)
│   └── GuidaUtente.txt                     <- guida testuale accessibile dal menu
└── README.md
```

---

## Come funziona

Il programma ruota attorno a una **coda FIFO di oggetti `Ordine`**.
Ogni ordine ha tre campi: numero tavola, nome prodotto e quantità.
La coda è implementata estendendo la classe `Coda` della libreria `iisvolta` — non usa `java.util.Queue` perché il progetto richiedeva di usare le strutture dati della scuola.

La GUI condivide la stessa coda della console: un ordine aggiunto dalla finestra grafica è immediatamente visibile anche dal menu testuale.

---

## Modalità di avvio

### GUI (consigliata)
Avvia `MainGui.java` come classe principale.
Si apre una finestra con una **JMenuBar** nella parte superiore per navigare tra le sezioni:

| Menu | Voci |
|------|------|
| **Ordinazioni** | Aggiungi Ordine, Ordini per Tavolo, Estrai Ordine, Visualizza Testa Coda |
| **Cucina** | Tutti gli Ordini, Filtra per Tavolo |
| **Gestione File** | Salva Ordini, Carica Ordini, Listino Prezzi |
| **Guida** | Guida Utente |
| **Esci** | Chiude l'applicazione |

Ogni voce di menu mostra il pannello corrispondente nella finestra principale — **nessuna finestra aggiuntiva viene aperta**.

### Console (CLI)
Avvia `Main.java` come classe principale.
Appare un menu testuale numerato con le stesse funzionalità della GUI.

| N° | Cosa fa |
|----|---------|
| 1  | Aggiunge un ordine alla coda |
| 2  | Aggiunge più ordini per lo stesso tavolo in sequenza |
| 3  | Estrae e rimuove il primo ordine dalla coda |
| 4  | Mostra il primo ordine senza rimuoverlo |
| 5  | Mostra tutti gli ordini in coda |
| 6  | Filtra e mostra gli ordini di un tavolo specifico |
| 7  | Salva tutta la coda su `ordini.dat` |
| 8  | Carica gli ordini da `ordini.dat` |
| 9  | Mostra la guida utente dal file TXT |
| 10 | Carica e mostra il listino prezzi dal CSV |
| 11 | Apre il pannello GUI per inserire un ordine |
| 12 | Apre il pannello GUI con l'elenco degli ordini |
| 0  | Esce dal programma |

---

## Come eseguire

1. Aprire il progetto con **IntelliJ IDEA** o **VS Code** con l'estensione Java
2. Assicurarsi che la libreria `iisvolta` sia nel classpath (è già inclusa nella cartella `src/iisvolta/`)
3. Avviare `MainGui.java` per la GUI oppure `Main.java` per la CLI

---

## Note tecniche

- `Ordine` implementa `Serializable` per permettere il salvataggio su file binario con `ObjectOutputStream`
- Il file `ordini.dat` non è leggibile come testo — è un file binario con serializzazione Java standard
- Il listino prezzi è un CSV con header: `Categoria, Item, Prezzo, CodiceArticolo`
- La GUI legge il CSV per popolare la combo box dei prodotti — se si modifica il listino, la GUI si aggiorna automaticamente al prossimo avvio
- La `MainGui` usa `CardLayout` per mostrare un pannello per volta senza aprire nuovi `JFrame`
