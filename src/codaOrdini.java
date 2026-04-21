import iisvolta.strutture_vector.Coda;


public class codaOrdini extends Coda {

    public Ordine leggiVoce(Utility util) { //legge senza togliere dalla coda

        Ordine ord = (Ordine) this.togli();
        if (ord == null) { System.out.println("Coda vuota"); return null; }
        util.stampaOrdine(ord);
        this.aggiungi(ord);

        return ord;

    }

    public void visualizzaOrdiniTavolo(String numeroTavola, Utility utilOrdini) {
        codaOrdini temp = new codaOrdini(); // coda temporanea per salvare gli ordini mentre li controlliamo
    
        System.out.println("=== ORDINI TAVOLO " + numeroTavola + " ===");
    
        while (!this.vuota()) {
            Ordine ordine = (Ordine) this.togli();
            if (ordine.getNumeroTavola() == Integer.parseInt(numeroTavola)) {
                utilOrdini.stampaOrdine(ordine);
                System.out.println("-----");
            }
            temp.aggiungi(ordine);  // ← SALVA IN TEMP
        }
    
        // serve per rimettere gli ordini nella coda originale
        while (!temp.vuota()) {
            this.aggiungi(temp.togli());
        }
    
        if (this.size() == 0) {  // Corretto: controlla dopo rimessa
            System.out.println("Nessun ordine per la tavola " + numeroTavola);
        }
    }

}


