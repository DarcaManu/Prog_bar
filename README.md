# Gestione Bar - ProgBar

Programma Java per la gestione degli ordini di un bar.
Gli ordini vengono salvati in una coda FIFO: il primo ordine inserito è il primo ad essere servito.
Il programma funziona sia da console che con una finestra grafica (Java Swing).

---

## Struttura del progetto

```
Prog_bar/
├── src/
│   ├── ProgBar.java          <- main, contiene il menu e il ciclo principale
│   ├── Ordine.java           <- classe che rappresenta un singolo ordine (tavolo, prodotto, quantità)
│   ├── MiaCodaOrdini.java    <- estende la classe Coda della libreria iisvolta
│   ├── MenuOrdine.java       <- stampa il menu e legge la scelta dell'utente
│   ├── UtilOrdini.java       <- metodi di utilità: input ordini, stampa, "premi un tasto"
│   ├── GestoreFile.java      <- salva/carica ordini su file, legge CSV listino, mostra guida
│   ├── GUI.java              <- finestra Swing per inserire un ordine graficamente
│   ├── GestioneEventi.java   <- ActionListener del pulsante Conferma nella GUI
│   └── MostraOrdini.java     <- finestra Swing che mostra tutti gli ordini in coda
├── data/
│   ├── ordini.dat                          <- file binario con gli ordini salvati
│   ├── bistro_price_list_with_header.csv   <- listino prezzi (letto dalla GUI e dal menu console)
│   └── GuidaUtente.txt                     <- guida testuale accessibile dal menu
├── iisvolta/                <- libreria scolastica con la classe Coda (non modificare)
└── README.md
```

---

## Come funziona

Il programma ruota intorno a una **coda FIFO di oggetti `Ordine`**.
Ogni ordine ha tre campi: numero tavola, nome prodotto e quantità.
La coda è implementata estendendo la classe `Coda` della libreria `iisvolta` — non usa `java.util.Queue` perché il progetto richiedeva di usare le strutture dati della scuola.

La GUI è collegata alla stessa coda della console: se aggiungi un ordine dalla finestra grafica, lo vedi anche facendo "Leggi tutti gli ordini" dal menu testuale.

---

## Opzioni del menu

| N° | Cosa fa |
|----|---------|
| 1  | Aggiunge un ordine alla coda (inserisci tavolo, prodotto, quantità) |
| 2  | Aggiunge più ordini per lo stesso tavolo in sequenza |
| 3  | Estrae e rimuove il primo ordine dalla coda |
| 4  | Mostra il primo ordine senza rimuoverlo |
| 5  | Mostra tutti gli ordini in coda |
| 6  | Filtra e mostra gli ordini di un tavolo specifico |
| 7  | Salva tutta la coda su `data/ordini.dat` |
| 8  | Carica gli ordini da `data/ordini.dat` |
| 9  | Mostra la guida utente dal file TXT |
| 10 | Carica e mostra il listino prezzi dal CSV |
| 11 | Apre la finestra GUI per inserire un ordine |
| 12 | Apre una finestra con l'elenco degli ordini in coda |
| 0  | Esce dal programma |

---

## Come eseguire

Aprire il progetto con IntelliJ IDEA e avviare `ProgBar.java` come classe principale.
Assicurarsi che la libreria `iisvolta` sia nel classpath (è già inclusa nella cartella del progetto).

---

## Note tecniche

- `Ordine` implementa `Serializable` perché gli oggetti vengono scritti su file binario con `ObjectOutputStream`
- Il salvataggio su file usa la serializzazione Java standard — il file `ordini.dat` non è leggibile come testo
- Il listino prezzi è un CSV con header: `Categoria, Item, Price, CodiceArticolo`
- La GUI legge il CSV per popolare la combo box dei prodotti, quindi se si modifica il listino la GUI si aggiorna automaticamente al prossimo avvio
