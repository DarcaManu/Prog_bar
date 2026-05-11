package  gui;

import java.awt.*;
import javax.swing.*;

public class MenuGui {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JFrame frame;

    public MenuGui(JFrame frame, CardLayout cardLayout, JPanel cardPanel) {
        this.frame = frame;
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
    }

    public JMenuBar creaMenuBar() {
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
                frame,
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

    private JMenuItem creaMenuItem(String etichetta, String scheda) {
        JMenuItem item = new JMenuItem(etichetta);
        item.addActionListener(e -> cardLayout.show(cardPanel, scheda));
        return item;
    }
}