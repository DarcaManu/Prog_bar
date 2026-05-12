package gui;

import CLI.CodaOrdini;
import javax.swing.*;
import model.Ordine;

public class PanelTuttiOrdini extends JPanel {

    private CodaOrdini coda;
    private JTextArea areaText;

    public PanelTuttiOrdini(CodaOrdini coda) {
        this.coda = coda;

        setLayout(new java.awt.BorderLayout());

        JLabel titolo = new JLabel("Ordini presi finora:");
        titolo.setHorizontalAlignment(SwingConstants.CENTER);
        add(titolo, java.awt.BorderLayout.NORTH);


        areaText = new JTextArea();
        areaText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaText);
        add(scrollPane, java.awt.BorderLayout.CENTER);

        
    }

    
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) mostraOrdini(); // si aggiorna ogni volta che CardLayout lo mostra
    }

    private void mostraOrdini() {
        areaText.setText("");

        CodaOrdini temp = new CodaOrdini();

        while (!coda.vuota()) {
            Ordine o = (Ordine) coda.togli();
            areaText.append(o.toString() + "\n");
            areaText.append("-----\n");
            temp.aggiungi(o);
        }

        while (!temp.vuota()) {
            coda.aggiungi(temp.togli());
        }
    }
}