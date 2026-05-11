package  gui;

import  CLI.CodaOrdini;
import  CLI.GestoreFile;
import  CLI.Utility;
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
    private CodaOrdini coda = new CodaOrdini();
    private GestoreFile gestoreFile = new GestoreFile();
    private Utility utility = new Utility();
    private GuiPrenotazioni panelAggiungi = new GuiPrenotazioni(coda, gestoreFile);
    private MenuGui menu = new MenuGui(this, cardLayout, cardPanel);

    public MainGui() {
        setTitle("Bar Management");
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(menu.creaMenuBar()); // costruisce la JMenuBar

        cardPanel.add(new PanelHome(),                      "home");
        cardPanel.add(panelAggiungi,                        "aggiungi");
        cardPanel.add(new PanelEstraiOrdine(coda, utility), "estrai");
        cardPanel.add(new PanelOrdiniTavolo(coda, utility), "ordinitavolo");
        //cardPanel.add(creaTuttiOrdiniPanel(), "tutti");
        //cardPanel.add(creaFilePanel(), "file");
        //cardPanel.add(creaListinoPanel(), "listino");
        //cardPanel.add(creaGuidaPanel(), "guida");
        // ... altri pannelli

        add(cardPanel);
        cardLayout.show(cardPanel, "home"); // pannello iniziale
    }

    private void mostraScheda(String nome) {
        cardLayout.show(cardPanel, nome);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGui().setVisible(true));
    }
}