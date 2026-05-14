package  GUI;

import CLI.CodaOrdini;
import CLI.Utility;
import  java.awt.*;
import  javax.swing.*;

public class PanelFiltraTavolo extends JPanel {

    public PanelFiltraTavolo(CodaOrdini coda, Utility utility) {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(); // pannello per input + bottone

        JLabel lblTavolo= new JLabel("Numero tavolo:");
        JTextField inputTavolo = new JTextField(10);

        topPanel.add(lblTavolo);
        topPanel.add(inputTavolo);
        
        JTextArea output = new JTextArea();
        //creiamo un text area per visualizzare gli ordini filtrati senza poterla modificare
        output.setEditable(false);

        // bottone per visualizzare gli ordini filtrati
        JButton btnVisualizza = new JButton("Visualizza Ordini");
        topPanel.add(btnVisualizza);

        btnVisualizza.addActionListener(e -> {
            //riuso un metodo già presente in CodaOrdini che restituisce una stringa con gli ordini filtrati per tavolo
            output.setText(coda.visualizzaOrdiniTavoloStringa(inputTavolo.getText().trim(), utility));
        });

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
    }
}
