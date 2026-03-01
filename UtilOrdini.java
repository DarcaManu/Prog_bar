
import java.io.*;
class UtilOrdini {

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);
    
    public Ordine acquisisciOrdine() {
        try {

            System.out.print("N° Tavola: ");
            String tavola = tastiera.readLine();
            System.out.print("Ordine: ");
            String ordine = tastiera.readLine();

            return new Ordine(tavola, ordine);
            
        } catch (Exception e) {
            return null;
        }
    }

    public void acquisisciOrdiniTavolo(MiaCodaOrdini coda) {
        try {
            System.out.print("N° Tavola: ");
            String tavola = tastiera.readLine();

            System.out.println("Inserisci gli ordini per la tavola '" + tavola + "'. Digita 'fine' per terminare.");

            String ordine;
            do {
                System.out.print("Ordine: ");
                ordine = tastiera.readLine();

                if (!ordine.equals("fine")) {
                    Ordine o = new Ordine(tavola, ordine);
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


    public static void VisualizzaTutti(MiaCodaOrdini coda, UtilOrdini util) {
        MiaCodaOrdini temp = new MiaCodaOrdini();

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

    public void stampaOrdine(Ordine o) {//la o sarebbe l'ordine dopo il downcast da object a ordine
    
        if (o != null) o.stampa();
        
    }
    
    public void premiUnTasto() {
        try {
            System.out.print("Premi tasto...");
            tastiera.readLine();
        } catch (Exception e) {}
    }


}
