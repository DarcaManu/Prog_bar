package GUI;

import CLI.CodaOrdini;
import CLI.Utility;
import javax.swing.*;


public class PanelTuttiOrdini extends JPanel {
    private Utility util;
    private CodaOrdini coda;
    private JTextArea areaText;

    public PanelTuttiOrdini(Utility util, CodaOrdini coda) {
        this.coda = coda;
        this.util = util;
        this.util = new Utility();

        setLayout(new java.awt.BorderLayout());

        JLabel titolo = new JLabel("Ordini presi finora:", SwingConstants.CENTER);
        add(titolo, java.awt.BorderLayout.NORTH);


        areaText = new JTextArea();
        areaText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaText);
        add(scrollPane, java.awt.BorderLayout.CENTER);

    mostraOrdini(); // mostra gli ordini già presenti all'avvio
    }

    private void mostraOrdini() {
    areaText.setText(util.tuttiGliOrdiniStringa(coda)); // metodo in Utility che restituisce una stringa con tutti gli ordini formattati
}

 public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) mostraOrdini(); // si aggiorna ogni volta che CardLayout lo mostra
    }
}