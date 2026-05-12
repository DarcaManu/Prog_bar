package gui;

import CLI.CodaOrdini;
import CLI.GestoreFile;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import model.Ordine;

public class PanelOrdinazioniPerTavolo extends JPanel {

    private CodaOrdini coda;
    private GestoreFile gestore;
    private int tavoloCorrente = -1;

    private JTextField inputTavolo;
    private JLabel labelTavoloAttivo;
    private JComboBox<String> comboProdotti;
    private JSpinner spQuantita;

    public PanelOrdinazioniPerTavolo(CodaOrdini coda, GestoreFile gestore) {
        this.coda = coda;
        this.gestore = gestore;
        setLayout(new BorderLayout());

        // NORTH: titolo
        JPanel north = new JPanel();
        north.add(new JLabel("ORDINI PER TAVOLO"));
        add(north, BorderLayout.NORTH);

        // CENTER: campi
        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        inputTavolo = new JTextField(5);// campo per inserire numero tavolo
        JButton btnImpostaTavolo = new JButton("Imposta Tavolo");
        labelTavoloAttivo = new JLabel("Nessun tavolo selezionato");// etichetta per mostrare tavolo attivo

        comboProdotti = new JComboBox<>();//come su altro panel carichiamo i prodotti dal file CSV
        ArrayList lista = gestore.leggiProdotti("data/bistro_price_list_with_header.csv");
        for (Object p : lista) comboProdotti.addItem((String) p);

        spQuantita = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));// spinner per quantità

        center.add(new JLabel("Tavolo:"));
        center.add(inputTavolo);
        center.add(btnImpostaTavolo);
        center.add(labelTavoloAttivo);
        center.add(new JLabel("Prodotto:"));
        center.add(comboProdotti);
        center.add(new JLabel("Quantità:"));
        center.add(spQuantita);
        add(center, BorderLayout.CENTER);

        // SOUTH: bottoni
        JPanel south = new JPanel();
        JButton btnConferma = new JButton("Conferma");
        JButton btnAnnulla = new JButton("Annulla");
        south.add(btnAnnulla);
        south.add(btnConferma);
        add(south, BorderLayout.SOUTH);

        // LISTENER
        btnImpostaTavolo.addActionListener(e -> {
            try {
                tavoloCorrente = Integer.parseInt(inputTavolo.getText().trim());//trim serve per rimuovere spazi bianchi
                labelTavoloAttivo.setText("Tavolo attivo: " + tavoloCorrente);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Inserisci un numero valido!");
            }
        });

        btnConferma.addActionListener(e -> {
            if (tavoloCorrente == -1) {
                JOptionPane.showMessageDialog(null, "Imposta prima un tavolo!");
                return;
            }
            String prodotto = (String) comboProdotti.getSelectedItem();
            int quantita = (Integer) spQuantita.getValue();
            coda.aggiungi(new Ordine(tavoloCorrente, prodotto, quantita));
            JOptionPane.showMessageDialog(null,
                "Ordine aggiunto: Tavolo " + tavoloCorrente + ", " + prodotto + ", x" + quantita);
            spQuantita.setValue(1);
            comboProdotti.setSelectedIndex(0);
        });

        btnAnnulla.addActionListener(e -> {
            spQuantita.setValue(1);
            comboProdotti.setSelectedIndex(0);
        });
    }
}