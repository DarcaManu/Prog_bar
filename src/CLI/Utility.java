package  CLI;

import  model.Ordine;
import java.io.*;

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

    public static void VisualizzaTutti(CodaOrdini coda, Utility util) {
        CodaOrdini temp = new CodaOrdini();

        while (!coda.vuota()) {

            Ordine o = (Ordine) coda.togli();
            util.stampaOrdine(o);
            temp.aggiungi(o);
            System.out.println("-----");
        }

        while (!temp.vuota()) {//quando finisce di stampare rimetto gli ordini nella coda originale

            coda.aggiungi(temp.togli());//aggiungo alla coda originale gli ordini tolti dalla coda temporanea
        }
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
