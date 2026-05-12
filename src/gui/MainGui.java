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
public class MainGUI extends JFrame {

    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private CodaOrdini coda = new CodaOrdini();
    private GestoreFile gestoreFile = new GestoreFile();
    private Utility utility = new Utility();
    private PanelOrdinazioni panelAggiungi = new PanelOrdinazioni(coda, gestoreFile);
    private MenuGui menu = new MenuGui(this, cardLayout, cardPanel);

    public MainGUI() {
        setTitle("Bar Management");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(menu.creaMenuBar()); // costruisce la JMenuBar

        cardPanel.add(new PanelHome(),"home");
        cardPanel.add(panelAggiungi,"aggiungi");
        cardPanel.add(new PanelEstraiOrdine(coda, utility), "estrai");
        cardPanel.add(new PanelOrdinazioniPerTavolo(coda, gestoreFile), "ordinitavolo");
        
        cardPanel.add(new PanelTuttiOrdini(coda), "tutti");
        cardPanel.add(new PanelFiltraTavolo(coda, utility), "filtratavolo");

        cardPanel.add(new PanelSalvaOrdini(coda),"salva");
    cardPanel.add(new PanelCaricaOrdini(coda),"carica");
    cardPanel.add(new PanelListinoPrezzi(gestoreFile),"listino");

    cardPanel.add(new PanelGuidaUtente(),               "guida");

        add(cardPanel);
        cardLayout.show(cardPanel, "home"); // pannello iniziale
    }

    private void mostraScheda(String nome) {
        cardLayout.show(cardPanel, nome);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}