package GUI;
import CLI.CodaOrdini;
import CLI.GestoreFile;
import java.awt.*;
import javax.swing.*;

public class PanelCaricaOrdini extends JPanel {

    public PanelCaricaOrdini(CodaOrdini coda) {
        
        setLayout(new BorderLayout());
        
        add(new JLabel("Caricamento ordini", SwingConstants.CENTER), BorderLayout.NORTH);//mette il titolo sopra e al centro

        JButton btnCarica = new JButton("Carica ordini da file");

        btnCarica.addActionListener(e ->{
            GestoreFile.carica(coda); // metodo già esistente
            JOptionPane.showMessageDialog(null, "Ordini caricati da ordini.dat!");
        });

        add(btnCarica, BorderLayout.CENTER);
    }
}