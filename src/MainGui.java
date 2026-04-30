import java.awt.*;
import javax.swing.*;
/**
 * Finestra principale dell'applicazione.
 * Usa CardLayout per mostrare un pannello per volta.
 * Nessuna JFrame aggiuntiva viene aperta.
 */
public class MainGui extends JFrame {

    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private CodaOrdini coda= new CodaOrdini();
    private GestoreFile gestoreFile = new GestoreFile();
    private Utility utility = new Utility();
    private GuiPrenotazioni panelAggiungi = new GuiPrenotazioni(coda, gestoreFile);
    public MainGui() {
        setTitle("Bar Management");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(creaMenuBar());         // costruisce la JMenuBar

        cardPanel.add(creaHomePanel(),           "home");
        cardPanel.add(panelAggiungi,             "aggiungi");
        cardPanel.add(creaEstraiOrdinePanel(),   "estrai");
        //cardPanel.add(creaTuttiOrdiniPanel(),    "tutti");
        //cardPanel.add(creaFilePanel(),           "file");
        //cardPanel.add(creaListinoPanel(),        "listino");
        //cardPanel.add(creaGuidaPanel(),          "guida");
        // ... altri pannelli

        add(cardPanel);
        cardLayout.show(cardPanel, "home");   // pannello iniziale
    }

    private JMenuBar creaMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    // ── HOME ──
    JMenu menuHome = new JMenu("Home");
    menuHome.add(creaMenuItem("Home", "home"));

    // ── ORDINAZIONI ──
    JMenu menuOrdinazioni = new JMenu("Ordinazioni");
    menuOrdinazioni.add(creaMenuItem("Aggiungi Ordine", "aggiungi"));
    menuOrdinazioni.add(creaMenuItem("Ordini per Tavolo", "ordinitavolo"));
    menuOrdinazioni.add(new JSeparator());
    menuOrdinazioni.add(creaMenuItem("Estrai Ordine", "estrai"));
    menuOrdinazioni.add(creaMenuItem("Visualizza Testa Coda", "testa"));

    // ── CUCINA ──
    JMenu menuCucina = new JMenu("Cucina");
    menuCucina.add(creaMenuItem("Tutti gli Ordini", "tutti"));
    menuCucina.add(creaMenuItem("Filtra per Tavolo", "filtratavolo"));

    // ── FILE ──
    JMenu menuFile = new JMenu("Gestione File");
    menuFile.add(creaMenuItem("Salva Ordini", "file"));
    menuFile.add(creaMenuItem("Carica Ordini", "file"));
    menuFile.add(new JSeparator());
    menuFile.add(creaMenuItem("Listino Prezzi", "listino"));

    // ── GUIDA ──
    JMenu menuGuida = new JMenu("Guida");
    menuGuida.add(creaMenuItem("Guida Utente", "guida"));

    // ── ESCI (voce diretta, non dropdown) ──
    JMenu menuEsci = new JMenu("Esci");
    JMenuItem itemEsci = new JMenuItem("Esci dall'applicazione");
    itemEsci.addActionListener(e -> {
        int scelta = JOptionPane.showConfirmDialog(
            this,
            "Sei sicuro di voler uscire?",
            "Conferma uscita",
            JOptionPane.YES_NO_OPTION
        );
        if (scelta == JOptionPane.YES_OPTION) System.exit(0);
    });
    menuEsci.add(itemEsci);

    menuBar.add(menuHome);
    menuBar.add(menuOrdinazioni);
    menuBar.add(menuCucina);
    menuBar.add(menuFile);
    menuBar.add(menuGuida);
    menuBar.add(menuEsci);

    return menuBar;
    }

    private JPanel creaHomePanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Benvenuto al bar-4CI");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);
        return panel;
    }

    private JPanel creaEstraiOrdinePanel() { //pannello per estrarre un ordine dalla coda e mostrarlo in una JTextArea
    JPanel panel = new JPanel();
    JTextArea output = new JTextArea(10, 40);
    JButton btnEstrai = new JButton("Estrai Ordine");

    btnEstrai.addActionListener(e -> { //e -> è una lambda che rappresenta l'evento di click sul bottone
        Ordine ord = (Ordine) coda.togli(); // estrai ordine dalla coda (downcast a Ordine)
        if (ord == null) {
            output.setText("Nessun Ordine Presente");
        } else {
            output.setText(utility.stampaOrdineStringa(ord));
        }
    });

    panel.add(btnEstrai);
    panel.add(new JScrollPane(output));
    return panel;
    }

    // ... un metodo per pannello

    private JMenuItem creaMenuItem(String etichetta, String scheda) {
    JMenuItem item = new JMenuItem(etichetta);
    item.addActionListener(e -> cardLayout.show(cardPanel, scheda));
    return item;
    }


    private void mostraScheda(String nome) {
        cardLayout.show(cardPanel, nome);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGui().setVisible(true));
    }
}