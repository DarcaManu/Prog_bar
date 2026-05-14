package  GUI;

import  CLI.CodaOrdini;
import  CLI.GestoreFile;
import  CLI.Utility;
import java.awt.*;
import javax.swing.*;

/**
 Finestra principale dell'applicazione.
 Usa CardLayout per mostrare un pannello per volta.
 Nessuna JFrame aggiuntiva viene aperta.
 */

    public class MainGUI extends JFrame {


    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private CodaOrdini coda = new CodaOrdini();
    private GestoreFile gestoreFile = new GestoreFile();
    private Utility utility = new Utility();
    private MenuGui menu = new MenuGui(this, cardLayout, cardPanel);

    public MainGUI() {
        setTitle("Bar Management");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);// chiude l'app quando si chiude la finestra

        setJMenuBar(menu.creaMenuBar()); // costruisce la JMenuBar

        cardPanel.add(new PanelHome(),"home");
        cardPanel.add(new PanelOrdinazioni(coda, gestoreFile), "aggiungi");
        cardPanel.add(new PanelEstraiOrdine(coda, utility), "estrai");
        cardPanel.add(new PanelOrdinazioniPerTavolo(coda, gestoreFile), "ordinitavolo");
        
        cardPanel.add(new PanelTuttiOrdini(utility, coda), "tutti");
        cardPanel.add(new PanelFiltraTavolo(coda, utility), "filtratavolo");

        cardPanel.add(new PanelSalvaOrdini(coda),"salva");
        cardPanel.add(new PanelCaricaOrdini(coda),"carica");
        cardPanel.add(new PanelListinoPrezzi(gestoreFile),"listino");

        cardPanel.add(new PanelGuidaUtente(),               "guida");

        // aggiungo il pannello con CardLayout alla finestra
        add(cardPanel);
        cardLayout.show(cardPanel, "home"); // quando apro l'app, mostro la home
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}