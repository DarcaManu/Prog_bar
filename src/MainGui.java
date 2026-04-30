import javax.swing.*;
import java.awt.*;
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

    public MainGui() {
        setTitle("Bar Management");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(creaMenuBar());         // costruisce la JMenuBar

        cardPanel.add(creaHomePanel(),           "home");
        cardPanel.add(creaAggiungiOrdinePanel(), "aggiungi");
        cardPanel.add(creaEstraiOrdinePanel(),   "estrai");
        cardPanel.add(creaTuttiOrdiniPanel(),    "tutti");
        cardPanel.add(creaFilePanel(),           "file");
        cardPanel.add(creaListinoPanel(),        "listino");
        cardPanel.add(creaGuidaPanel(),          "guida");
        // ... altri pannelli

        add(cardPanel);
        cardLayout.show(cardPanel, "home");   // pannello iniziale
    }

    private JMenuBar creaMenuBar() { ... }

    private JPanel creaHomePanel() { ... }

    private JPanel creaAggiungiOrdinePanel() { ... }

    private JPanel creaEstraiOrdinePanel() { ... }

    // ... un metodo per pannello

    private void mostraScheda(String nome) {
        cardLayout.show(cardPanel, nome);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGui().setVisible(true));
    }
}