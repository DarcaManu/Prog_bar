package  CLI;

import java.io.*;

class MenuScelte {

    private void mostraMenu() {
        System.out.println();
        System.out.println("1) Aggiungi ordine");
        System.out.println("2) Inserisci tutti gli ordini per una tavola");
        System.out.println("3) estrai ordine");
        System.out.println("4) Visualizza ordine");
        System.out.println("5) Leggi tutti gli ordini");
        System.out.println("6) mostra ordini di un tavolo");
        System.out.println("7) Salva su file");
        System.out.println("8) Carica da file");
        System.out.println("9) Mostra guida utente");
        System.out.println("10) Carica listino prezzi");
        System.out.println("11) Mostra ordini finestra GUI");
        System.out.println("12) Mostra ordini presenti finestra GUI");
        System.out.println("0) Esci");
    }

    public int scelta() {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        int scelta;

        mostraMenu();
        System.out.print("\n-> ");
        try {
            String numeroLetto = tastiera.readLine();
            scelta = Integer.parseInt(numeroLetto);
        } catch (Exception e) {
            scelta = -1;
        }

        return scelta;
    }
}