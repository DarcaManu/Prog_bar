package  CLI;

import  java.io.*;
import  model.Ordine;

class MainCLI {
    public static void main(String[] args) {
        //richiamiamo le classi da usare

        CodaOrdini codaOrdinazioni = new CodaOrdini();
        MenuScelte mioMenu = new MenuScelte();
        Utility utilOrdine = new Utility();
        GestoreFile gestoreFile = new GestoreFile();

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        int scelta;
        scelta = mioMenu.scelta();//mostra menu e legge scelta

        do {

            switch (scelta) {

                // AGGIUNGE 1 ORDINE ALLA CODA
                case 1:
                Ordine ord = utilOrdine.acquisisciOrdine();//chiede dati ordine e crea oggetto ordine
                codaOrdinazioni.aggiungi(ord);
                break;

                // AGGIUNGE PIU ORDINI ALLO STESSO TAVOLO NELLA CODA
                case 2:
                System.out.println("Inserisci tutti gli ordini per una tavola");
                utilOrdine.acquisisciOrdiniTavolo(codaOrdinazioni);
                break;

                // ESTRAE ORDINE DALLA CODA E LO VISUALIZZA
                case 3:
                //estrae ordine dalla coda facendo un downcast a Ordine
                Ordine ord2 = (Ordine) codaOrdinazioni.togli();

                if (ord2 == null) {//gestisce se non ci sono ordini da estrarre
                    System.out.println("Nessun Ordine Presente");
                } else {
                    utilOrdine.stampaOrdine(ord2);//stampa ordine estratto
                }
                break;

                // VISUALIZZA ORDINE IN TESTA ALLA CODA SENZA TOGLIERLO
                case 4:
                codaOrdinazioni.leggiVoce(utilOrdine);//legge senza togliere dalla coda
                break;

                // VISUALIZZA TUTTI GLI ORDINI NELLA CODA
                case 5:
                System.out.println(utilOrdine.tuttiGliOrdiniStringa(codaOrdinazioni));
                break;

                // VISUALIZZA ORDINI DI UN TAVOLO INSERITO DALL'UTENTE
                case 6:
                    System.out.print("Inserisci numero Tavola da visualizzare: ");
                    try {
                        String numeroTavola = tastiera.readLine();
                        System.out.println(codaOrdinazioni.visualizzaOrdiniTavoloStringa(numeroTavola, utilOrdine));
                    } catch (Exception e) {
                        System.out.println("Errore input: " + e.getMessage());}
                break;

                // SALVA ORDINI SU FILE
                case 7:
                try {
                    gestoreFile.salva(codaOrdinazioni);
                } catch (Exception e) {
                    System.out.println("Errore salvataggio: " + e.getMessage());
                }
                break;

                // CARICA ORDINI DA FILE
                case 8:
                try {
                    gestoreFile.carica(codaOrdinazioni);
                } catch (Exception e) {
                    System.out.println("Errore carica: " + e.getMessage());
                }
                break;

                // MOSTRA GUIDA UTENTE (TESTO)
                case 9:
                gestoreFile.mostraGuidaUtente();
                break;

                // CARICA LISTINO PREZZI DA CSV E LO MOSTRA
                case 10:
                gestoreFile.caricaListinoPrezzi(); // legge il CSV e riempie listino interno
                System.out.println(gestoreFile.mostraListinoPrezziStringa()); // stampa quello che c'è in listino
                break;

                default:
                System.out.println("Scelta non valida. Riprova."); 
            }

            scelta = mioMenu.scelta();
        } while (scelta != 0);

        System.out.println("Fine programma.");
    }
}