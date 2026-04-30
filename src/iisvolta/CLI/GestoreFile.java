package iisvolta.CLI;

import java.io.*;
import java.util.ArrayList;

public class GestoreFile {

    //==========================================================
    //METODI CHE SALVANO E CARICANO LA CODA DEGLI ORDINI SU FILE
    //==========================================================

    // SALVA coda su file
    public static void salva(CodaOrdini coda) {
        try (FileOutputStream f = new FileOutputStream("ordini.dat");
             ObjectOutputStream fOUT = new ObjectOutputStream(f)) {

            int n = coda.size();
            for (int i = 0; i < n; i++) {
                Object obj = coda.togli();
                fOUT.writeObject(obj);
                coda.aggiungi(obj);
            }

            System.out.println("Salvato in ordini.dat");

        } catch (IOException e) {
            System.out.println("Errore nella scrittura.");
        }
    }

    // CARICA coda da file
    public static void carica(CodaOrdini coda) {
        try (FileInputStream f = new FileInputStream("ordini.dat");
             ObjectInputStream fIN = new ObjectInputStream(f)) {

            coda.svuota();
            while (true) {
                Object obj = fIN.readObject();
                coda.aggiungi(obj);
            }

        } catch (java.io.EOFException e) {
            System.out.println("Caricato da ordini.dat");
        } catch (Exception e) {
            System.out.println("Errore nella lettura.");
        }
    }

    //==========================================================
    //METODI CHE MOSTRANO GUIDA UTENTE E IL LISTINO PREZZI
    //==========================================================

    // MOSTRA GUIDA UTENTE (TXT)
    public static void mostraGuidaUtente() {
        BufferedReader fIN = null;
        String s;

        try {
            fIN = new BufferedReader(new FileReader("data/GuidaUtente.txt"));
            System.out.println("\n=== GUIDA UTENTE ===");
            s = fIN.readLine();
            while (s != null) {
                System.out.println(s);
                s = fIN.readLine();
            }

            System.out.println("===============");

        } catch (IOException e) {
            System.out.println("Errore lettura guida_utente.txt");
        } finally {
            try {
                if (fIN != null) fIN.close();
            } catch (IOException e) {
                // ignorato
            }
        }
    }

    public ArrayList caricaListinoPrezzi() {//dal csv prende tutte le righe e le colonne e le restituisce in una lista di array di stringhe
        String file = "data/bistro_price_list_with_header.csv";
        String line;
        ArrayList listino = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] valori = line.split(",");
                listino.add(valori);
            }

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file listino prezzi: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                // ignorato
            }
        }

        return listino;
    }

    public void mostraListinoPrezzi() {//stampa a video il listino prezzi caricato dal csv
        ArrayList listino = caricaListinoPrezzi(); // legge il CSV
        System.out.println("\n=== LISTINO PREZZI ===");
        for (Object voce : listino) {
            System.out.println(String.join(" | ", (String[]) voce)); // stampa "Colazione | Cappuccino | 1.80 | COL-001"
        }

        System.out.println("=====================");
    }

    //==========================================================
    //METODI SPECIFICI PER LA GUI (ES. LEGGE SOLO I NOMI DEI PRODOTTI DAL CSV)
    //==========================================================

    public ArrayList leggiProdotti(String nomeFile) {// metodo statico per leggere solo i nomi dei prodotti da un CSV e restituirli in una lista
        ArrayList prodotti = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
            String riga;

            // 1. Saltiamo la prima riga del CSV (header)
            br.readLine();

            while ((riga = br.readLine()) != null) {
                if (!riga.trim().isEmpty()) {
                    // Usiamo lo split per dividere la riga nelle sue colonne
                    String[] valori = riga.split(",");

                    // 3. Verifichiamo che ci sia almeno la colonna Item
                    if (valori.length > 1) {
                        // Aggiungiamo solo il nome del prodotto
                        prodotti.add(valori[1].trim());
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Errore lettura: " + e.getMessage());
        }

        return prodotti;
    }
}
