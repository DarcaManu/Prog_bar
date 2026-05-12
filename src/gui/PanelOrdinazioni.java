package  GUI;

import  CLI.CodaOrdini;
import  CLI.GestoreFile;
import  java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import model.Ordine;

public class PanelOrdinazioni extends JPanel {

    private CodaOrdini coda;
    private GestoreFile gestore;
    private Ordine ordine;

    // componenti che servono al listener
    private JSpinner spTavolo;
    private JSpinner spQuantita;
    private JComboBox comboProdotti;
    private JButton btnAnnulla;
    private JButton btnConferma;

    public PanelOrdinazioni(CodaOrdini codaCondivisa, GestoreFile gestoreCondiviso) {
        this.coda = codaCondivisa;
        this.gestore = gestoreCondiviso;
        setLayout(new BorderLayout());

        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        // NORTH: titolo
        north.setBackground(new Color(30, 144, 255));
        JLabel titolo = new JLabel("INSERIMENTO ORDINE");
        titolo.setFont(new Font("Arial", Font.BOLD, 18));
        north.add(titolo);

        // CENTER: layout semplice orizzontale/verticale
        center.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Spinner tavolo (contatore: da 1 a 50)
        center.add(new JLabel("Tavolo:"));
        spTavolo = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
        //il primo numero è il valore iniziale, il secondo è il minimo, il terzo è il massimo e l'ultimo è l'incremento
        //cercato online per comodità nel farlo
        center.add(spTavolo);

        // Combo prodotti
        center.add(new JLabel("Prodotto:"));
        comboProdotti = new JComboBox<>();
        ArrayList lista = gestore.leggiProdotti("data/bistro_price_list_with_header.csv");
        for (Object p : lista) {
            comboProdotti.addItem(p);
        }
        center.add(comboProdotti);

        // Spinner quantità (contatore: da 1 a 20)
        center.add(new JLabel("Quantità:"));
        spQuantita = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        center.add(spQuantita);

        // SOUTH: bottoni
        btnAnnulla = new JButton("Annulla");
        btnConferma = new JButton("Conferma");
        south.add(btnAnnulla);
        south.add(btnConferma);

        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        // collega il gestore eventi esterno
        // ANNULLA: resetta i campi al valore iniziale
        btnAnnulla.addActionListener(e -> {
            spTavolo.setValue(1);
            spQuantita.setValue(1);
            comboProdotti.setSelectedIndex(0);
});

// CONFERMA: crea l'ordine e lo aggiunge alla coda
    btnConferma.addActionListener(e -> {
        int numeroTavolo = (Integer) spTavolo.getValue();
        String prodotto = (String) comboProdotti.getSelectedItem();
        int quantita = (Integer) spQuantita.getValue();

        if (prodotto == null) {
            //message dialog per avvertire l'utente di selezionare un prodotto
            JOptionPane.showMessageDialog(null, "Seleziona un prodotto!");
        return;
    }

    // Crea un nuovo ordine e lo aggiunge alla coda
    Ordine ordine = new Ordine(numeroTavolo, prodotto, quantita);
    coda.aggiungi(ordine);

    JOptionPane.showMessageDialog(null,
        "Ordine inserito: Tavolo " + numeroTavolo +
        ", " + prodotto + ", x" + quantita);
    });
    }
}
