import java.io.*;

class ProgBar {
    public static void main(String[] args) {
        //richiamiamo le classi da usare

        MiaCodaOrdini codaOrdinazioni = new MiaCodaOrdini();
        MenuOrdine mioMenu = new MenuOrdine();
        UtilOrdini utilOrdine = new UtilOrdini();
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

                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;
                
                // AGGIUNGE PIU ORDINI ALLO STESSO TAVOLO NELLA CODA
                case 2:
                    System.out.println("Inserisci tutti gli ordini per una tavola");

                    utilOrdine.acquisisciOrdiniTavolo(codaOrdinazioni);

                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
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

                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;
                
                // VISUALIZZA ORDINE IN TESTA ALLA CODA SENZA TOGLIERLO    
                case 4:
                    codaOrdinazioni.leggiVoce(utilOrdine);//legge senza togliere dalla coda
                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;
                    
                // VISUALIZZA TUTTI GLI ORDINI NELLA CODA    
                case 5:
                    System.out.println("Elenco Ordini:");
                    UtilOrdini.VisualizzaTutti(codaOrdinazioni, utilOrdine);//metodo scritto in UtilOrdini che visualizza tutti gli ordini della coda
                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;
                
                // VISUALIZZA ORDINI DI UN TAVOLO INSERITO DALL'UTENTE    
                case 6:
                    System.out.print("Inserisci numero Tavola da visualizzare: ");
                    try {

                        String numeroTavola = tastiera.readLine();//prende in input il numero tavola
                        codaOrdinazioni.visualizzaOrdiniTavolo(numeroTavola, utilOrdine);//in base al numero tavola visualizza gli ordini

                    } catch (Exception e) {
                        System.out.println("Errore input: " + e.getMessage());
                    }

                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;
                
                // SALVA ORDINI SU FILE
                case 7:
                    try {

                        GestoreFile.salva(codaOrdinazioni);

                    } catch (Exception e) {
                        System.out.println("Errore salvataggio: " + e.getMessage());
                    }

                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;
                
                // CARICA ORDINI DA FILE
                case 8:
                try {

                    GestoreFile.carica(codaOrdinazioni);

                } catch (Exception e) {
                    System.out.println("Errore carica: " + e.getMessage());
                }

                utilOrdine.premiUnTasto();
                System.out.print('\u000C');
                break;
                
                // MOSTRA GUIDA UTENTE (TESTO)
                case 9:
                    GestoreFile.mostraGuidaUtente();
                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;  
                
                // CARICA LISTINO PREZZI DA CSV E LO MOSTRA    
                case 10:
                    gestoreFile.caricaListinoPrezzi();      // legge il CSV e riempie listino interno
                    gestoreFile.mostraListinoPrezzi();      // stampa quello che c’è in listino
                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');
                    break;

                //DA IMPLEMENTARE    
                case 11:
                    System.out.println("da implementare");
                    utilOrdine.premiUnTasto();
                    System.out.print('\u000C');

                break;

                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
            
            scelta = mioMenu.scelta();
        } while (scelta != 0);
        
        System.out.println("Fine programma.");
    }
}
