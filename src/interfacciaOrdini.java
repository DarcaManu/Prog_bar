import javax.swing.*;
public class interfacciaOrdini extends JFrame{


    private codaOrdini coda;//dovremo leggere gli ordini nella coda
    private JTextArea areaText;//area di testo per visualizzare gli ordini


    public interfacciaOrdini(codaOrdini coda){

         //inizializziamo la coda 
        this.coda = coda;

        //creiamo l'area di testo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        setTitle("Ordini");
        setSize(400, 300); //TODO: dimensioni   

        areaText = new JTextArea();
        areaText.setEditable(false);
        getContentPane().add(areaText);  // ← aggiungi direttamente al frame

        mostraOrdini();
    }    

    private void mostraOrdini() {
        areaText.setText("");
    
        codaOrdini temp = new codaOrdini();
    
        while (!coda.vuota()) {
            Ordine o = (Ordine) coda.togli();
            areaText.append(o.toString() + "\n");//ho creato il toString in ordine per poterlo usare qui
            //altrimenti avrei dovuto scrivere tutto qui dentro
            areaText.append("-----"+"\n");           
            temp.aggiungi(o);
        }
    
        while (!temp.vuota()) {
            coda.aggiungi(temp.togli());
        }
    }


}

