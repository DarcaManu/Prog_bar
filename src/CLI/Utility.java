package  CLI;

import  java.io.*;
import model.Ordine;

public class Utility {

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    public Ordine acquisisciOrdine() {
        try {

            System.out.print("N° Tavola: ");
            String tavola = tastiera.readLine();
            System.out.print("Ordine: ");
            String ordine = tastiera.readLine();
            System.out.print("Quantità: ");
            int quantita = Integer.parseInt(tastiera.readLine());

            return new Ordine(Integer.parseInt(tavola), ordine, quantita);

        } catch (Exception e) {
            return null;
        }
    }

    public void acquisisciOrdiniTavolo(CodaOrdini coda) {
        try {
            System.out.print("N° Tavola: ");
            String tavola = tastiera.readLine();

            System.out.println("Inserisci gli ordini per la tavola '" + tavola + "'. Digita 'fine' per terminare.");

            String ordine;
            do {
                System.out.print("Ordine: ");
                ordine = tastiera.readLine();

                System.out.print("Quantità: ");
                String quantita = tastiera.readLine();

                if (!ordine.equals("fine")) {
                    Ordine o = new Ordine(Integer.parseInt(tavola), ordine, Integer.parseInt(quantita));
                    coda.aggiungi(o);
                }

            } while (!ordine.equals("fine"));

            System.out.println("Fine inserimento ordini tavola " + tavola);
        } catch (Exception e) {
            System.out.println("Errore durante inserimento ordini tavolo: " + e.getMessage());
        }
    }

    //=================================================
    //VISUALIZZAZIONE DEGLI ORDINI PRESENTI NELLA CODA
    //=================================================

   public String tuttiGliOrdiniStringa(CodaOrdini coda) {
    CodaOrdini temp = new CodaOrdini();
    String risultato = "";

    while (!coda.vuota()) {
        Ordine o = (Ordine) coda.togli();
        risultato += o.toString() + "\n-----\n";
        temp.aggiungi(o);
    }

    while (!temp.vuota()) {
        coda.aggiungi(temp.togli());
    }

    if (risultato.isEmpty()) {
        risultato = "Nessun ordine presente";
    }

    return risultato;
}

    //============================================
    // METODI USATI IN VARIE PARTI DEL PROGRAMMA PER VISUALIZZARE ORDINI E PREMERE UN TASTO PER CONTINUARE
    //============================================

    public void stampaOrdine(Ordine ord) {
        System.out.println("Tavola: " + ord.getNumeroTavola());
        System.out.println("Prodotto: " + ord.getProdotto());
        System.out.println("Quantità: " + ord.getQuantita());
    }

    // Utility.java — metodo nuovo per la GUI
    public String stampaOrdineStringa(Ordine ord) {
        return "Tavolo: " + ord.getNumeroTavola() + "\n" +
               "Prodotto: " + ord.getProdotto() + "\n" +
               "Quantità: " + ord.getQuantita();
    }
}
