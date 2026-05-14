package CLI;

import  model.Ordine;
import  strutture_vector.Coda;

public class CodaOrdini extends Coda {

    public Ordine leggiVoce(Utility util) { //legge senza togliere dalla coda

        Ordine ord = (Ordine) this.togli();
        if (ord == null) { System.out.println("Coda vuota"); return null; }
        util.stampaOrdine(ord);
        this.aggiungi(ord);

        return ord;
    }

    public String visualizzaOrdiniTavoloStringa(String numeroTavola, Utility utilOrdini) {
        CodaOrdini temp = new CodaOrdini();
        String risultato = "";
        boolean trovato = false;

        while (!this.vuota()) {
            Ordine ordine = (Ordine) this.togli();
            if (ordine.getNumeroTavola() == Integer.parseInt(numeroTavola)) {
                risultato += utilOrdini.stampaOrdineStringa(ordine) + "\n-----\n";
                trovato = true;
            }
            temp.aggiungi(ordine);
        }

        while (!temp.vuota()) {
            this.aggiungi(temp.togli());
        }

        if (!trovato) {
            risultato = "Nessun ordine per la tavola " + numeroTavola;
        }

        return risultato;
    }   
}

