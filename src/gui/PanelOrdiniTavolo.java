package  gui;

import java.awt.*;
import javax.swing.*;
import  CLI.CodaOrdini;
import  CLI.Utility;
import  model.Ordine;

public class PanelOrdiniTavolo extends JPanel {

    public PanelOrdiniTavolo(CodaOrdini coda, Utility utility) {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(); // pannello per input + bottone
        JTextField inputTavolo = new JTextField(10);
        JButton btnVisualizza = new JButton("Visualizza Ordini");
        topPanel.add(new JLabel("Numero tavolo:"));
        topPanel.add(inputTavolo);
        topPanel.add(btnVisualizza);

        JTextArea output = new JTextArea();
        output.setEditable(false);

        btnVisualizza.addActionListener(e -> {
            String numeroTavolo = inputTavolo.getText().trim();
            if (numeroTavolo.isEmpty()) {
                output.setText("Inserisci un numero di tavolo.");
                return;
            }

            output.setText(""); // pulisci prima
            CodaOrdini temp = new CodaOrdini();
            boolean trovato = false;

            while (!coda.vuota()) {
                Ordine ordine = (Ordine) coda.togli();
                if (ordine.getNumeroTavola() == Integer.parseInt(numeroTavolo)) {
                    output.append(utility.stampaOrdineStringa(ordine) + "\n-----\n"); // ← scrivi diretto
                    trovato = true;
                }
                temp.aggiungi(ordine);
            }

            while (!temp.vuota()) {
                coda.aggiungi(temp.togli());
            }

            if (!trovato) {
                output.setText("Nessun ordine per la tavola " + numeroTavolo);
            }
        });

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
    }
}
