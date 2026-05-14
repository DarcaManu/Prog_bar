package  GUI;

import CLI.CodaOrdini;
import CLI.Utility;
import  java.awt.*;
import  javax.swing.*;
import  model.Ordine;

public class PanelEstraiOrdine extends JPanel {

    public PanelEstraiOrdine(CodaOrdini coda, Utility utility) {

        setLayout(new BorderLayout());

        JTextArea output = new JTextArea();
        output.setEditable(false);

        JButton btnEstrai = new JButton("Estrai Ordine");

        btnEstrai.addActionListener(e -> {
            Ordine ord = (Ordine) coda.togli();
            if (ord == null) {
                output.setText("Nessun Ordine Presente");//settext serve per far scrivere nel text area

            } else {

                output.setText(utility.stampaOrdineStringa(ord));
            }
        });

        add(btnEstrai, BorderLayout.NORTH); // bottone in alto
        add(new JScrollPane(output), BorderLayout.CENTER); // text area al centro con scroll
    }
}
