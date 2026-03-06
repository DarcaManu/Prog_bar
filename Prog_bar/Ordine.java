
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
            System.out.print("Quantità: ");
            int quantita = Integer.parseInt(tastiera.readLine());

            return new Ordine(Integer.parseInt(tavola), ordine, quantita);
            
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
                Syst