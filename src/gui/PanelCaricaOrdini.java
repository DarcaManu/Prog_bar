package gui;
import CLI.CodaOrdini;
import CLI.GestoreFile;
import javax.swing.*;
import java.awt.*;

public class PanelCaricaOrdini extends JPanel {
    public PanelCaricaOrdini(CodaOrdini coda) {
        setLayout(new BorderLayout());
        add(new JLabel("Caricamento ordini", SwingConstants.CENTER), BorderLayout.NORTH);

        JButton btnCarica = new JButton("Carica ordini da file");
        btnCarica.addActionListener(e -> {
            GestoreFile.carica(coda); // metodo già esistente
            JOptionPane.showMessageDialog(null, "Ordini caricati da ordini.dat!");
        });

        add(btnCarica, BorderLayout.CENTER);
    }
}