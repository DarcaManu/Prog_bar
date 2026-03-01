import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame {
    
    // Variabili della classe
    private MiaCodaOrdini coda;
    private GestoreFile gestore;

    public static void main(String[] args) {
        // CREAZIONE CODA E GESTORE CONDIVISI PER USARE I METODI DELLE CLASSI
        MiaCodaOrdini codaOrdinazioni = new MiaCodaOrdini();
        GestoreFile gestoreFile = new GestoreFile();

        // Creazione GUI
        GUI gui = new GUI(codaOrdinazioni, gestoreFile);
        gui.setVisible(true);
    }

    // Costruttore della GUI
    public GUI(MiaCodaOrdini codaCondivisa, GestoreFile gestoreCondiviso) {
        this.coda = codaCondivisa;
        this.gestore = gestoreCondiviso;

        // Impostazioni del frame principale (this)
        setTitle("Interfaccia Bar - Collegata alla Console");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Creazione dei pannelli
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel center = new JPanel();

        // North panel
        north.setBackground(new Color(30, 144, 255));
        JLabel titolo = new JLabel("INSERIMENTO ORDINE");
        titolo.setFont(new Font("Arial", Font.BOLD, 18));
        north.add(titolo);

        // Center panel con ComboBox
        JComboBox<String> comboProdotti = new JComboBox<>();

        // Recuperiamo la lista dal gestore (usando il tuo metodo statico)
        ArrayList<String> lista = GestoreFile.leggiProdotti("bistro_price_list_with_header.csv");

        // Usiamo il for-each per riempire il combo box
        for (String p : lista) {
            comboProdotti.addItem(p);
        }

        center.add(comboProdotti);

        // South panel con bottoni
        JButton Annulla = new JButton("Annulla");
        JButton Conferma = new JButton("Conferma");

        south.add(Annulla);
        south.add(Conferma);

        //aggiungiamo i pannelli al frame
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
    }
}
