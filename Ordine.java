import java.io.Serializable;

public class Ordine implements Serializable{ 
//È un "segnale" che dici a Java: "questa classe la puoi trasformare in byte per salvarla".
//serve per poter salvare su un file gli ordini, altrimenti non riesce a salvarlo e da errore

    private String tavola;
    private String ordine;
    
    public Ordine(String tav, String ord) {
        tavola = tav;
        ordine = ord;
    }
    
    public void stampa() {
        System.out.println("Tavola: " + tavola);
        System.out.println("Ordine: " + ordine);
    }


    //GETTER E SETTER
    public String getNumeroTavola() { return tavola; }
    public String getOrdine() { return ordine; }
}

