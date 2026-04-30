package iisvolta.gui;

import iisvolta.CLI.CodaOrdini;
import iisvolta.model.Ordine;
import javax.swing.*;

public class InterfacciaOrdini extends JFrame {

    private CodaOrdini coda;//dovremo leggere gli ordini nella coda
    private JTextArea areaText;//area di testo per visualizzare gli ordini

    public InterfacciaOrdini(CodaOrdini coda) {

        //inizializziamo la coda
        this.coda = coda;

        //creiamo l'area di testo
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setTitle("Ordini");
        setSize(400, 300);

        areaText = new JTextArea();
        areaText.setEditable(false);
        getContentPane().add(areaText); // ← aggiungi direttamente al frame

        mostraOrdini();
    }

    private void mostraOrdini() {
        areaText.setText("");

        CodaOrdini temp = new CodaOrdini();

        while (!coda.vuota()) {
            Ordine o = (Ordine) coda.togli();
            areaText.append(o.toString() + "\n");//ho creato il toString in ordine per poterlo usare qui
            //altrimenti avrei dovuto scrivere tutto qui dentro
            areaText.append("-----" + "\n");
            temp.aggiungi(o);
        }

        while (!temp.vuota()) {
            coda.aggiungi(temp.togli());
        }
    }
}