import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GuiPrenotazioni extends JPanel {

    private CodaOrdini coda;
    private GestoreFile gestore;

    // componenti che servono al listener
    private JSpinner spTavolo;
    private JSpinner spQuantita;
    private JComboBox<String> comboProdotti;
    private JButton btnAnnulla;
    private JButton btnConferma;

    public GuiPrenotazioni(CodaOrdini codaCondivisa, GestoreFile gestoreCondiviso) {
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
        ArrayList<String> lista = gestore.leggiProdotti("data/bistro_price_list_with_header.csv");
        for (String p : lista) {
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
        btnConferma.addActionListener(
        new GestoreEventi(spTavolo, comboProdotti, spQuantita, coda));
        
    }
}
