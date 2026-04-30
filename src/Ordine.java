import java.io.Serializable;

public class Ordine implements Serializable{ 
//È un "segnale" che dici a Java: "questa classe la puoi trasformare in byte per salvarla".
//serve per poter salvare su un file gli ordini, altrimenti non riesce a salvarlo e da errore

    private int tavola;
    private String prodotto;
    private int quantita;
    
    public Ordine(int tav, String prod, int quant) {
        tavola = tav;
        prodotto = prod;
        quantita = quant;
    }


    //GETTER E SETTER
    public int getNumeroTavola() { return tavola; }
    public String getProdotto() { return prodotto; }
    public int getQuantita() { return quantita; }

    @Override
    public String toString() {
    return "Tavola: " + tavola + "\n" + 
           "Prodotto: " + prodotto + "\n" + 
           "Quantità: " + quantita;
}

}

