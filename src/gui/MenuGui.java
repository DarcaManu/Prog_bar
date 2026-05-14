package  GUI;

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

        // HOME
        JMenu menuHome = new JMenu("Home");

        //visto che non voglio un dropdown, ma solo un click diretto, uso un MouseListener invece di un ActionListener
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        cardLayout.show(cardPanel, "home"); }

        });

        // ORDINAZIONI
        // menu con più voci che mostrano pannelli diversi
        JMenu menuOrdinazioni = new JMenu("Ordinazioni");
        
        menuOrdinazioni.add(creaMenuItem("Aggiungi Ordine", "aggiungi"));//
        menuOrdinazioni.add(creaMenuItem("Ordinazioni per un tavolo", "ordinitavolo"));
        menuOrdinazioni.add(creaMenuItem("Estrai Ordine", "estrai"));

        // CUCINA
        JMenu menuCucina = new JMenu("Cucina");
        menuCucina.add(creaMenuItem("Tutti gli Ordini", "tutti"));
        menuCucina.add(creaMenuItem("Filtra per Tavolo", "filtratavolo"));

        // GESTIONE FILE
        JMenu menuFile = new JMenu("Gestione File");
        menuFile.add(creaMenuItem("Salva Ordini", "salva"));
        menuFile.add(creaMenuItem("Carica Ordini", "carica"));
        menuFile.add(new JSeparator());
        menuFile.add(creaMenuItem("Listino Prezzi", "listino"));

        // GUIDA
        JMenu menuGuida = new JMenu("Guida");
        menuGuida.add(creaMenuItem("Guida Utente", "guida"));

        // ── ESCI (voce diretta, non dropdown) ──
        JMenu menuEsci = new JMenu("Esci");
        JMenuItem itemEsci = new JMenuItem("Esci dall'applicazione");
        itemEsci.addActionListener(e -> {
            //sfruttiamo il confirm dialog per evitare chiusure accidentali
            int scelta = JOptionPane.showConfirmDialog(frame, "Sei sicuro di voler uscire?", "Conferma uscita", JOptionPane.YES_NO_OPTION);
            if (scelta == JOptionPane.YES_OPTION) System.exit(0);
        });


        // aggiungo tutte le voci alla barra
        menuEsci.add(itemEsci);
        menuBar.add(menuHome);
        menuBar.add(menuOrdinazioni);
        menuBar.add(menuCucina);
        menuBar.add(menuFile);
        menuBar.add(menuGuida);
        menuBar.add(menuEsci);

        return menuBar;
    }

    private JMenuItem creaMenuItem(String etichetta, String scheda) { // scheda = nome del pannello da mostrare, etichetta = testo del menu
        JMenuItem item = new JMenuItem(etichetta);// crea un JMenuItem con l'etichetta specificata
        item.addActionListener(e -> cardLayout.show(cardPanel, scheda));// quando cliccato, mostra la scheda corrispondente
        return item;
    }
}