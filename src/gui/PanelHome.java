package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelHome extends JPanel {

    private BufferedImage immagine;

    public PanelHome() {
        setLayout(new BorderLayout());

        //cerca di leggere l'immagine di sfondo, se non la trova stampa un messaggio di errore
        try {
            immagine = ImageIO.read(new File("data/Bar4ciFoto.png"));
        } catch (Exception e) {
            System.out.println("Immagine non trovata: " + e.getMessage());
        }

        JPanel imgPanel = new JPanel() {// Pannello personalizzato per disegnare l'immagine di sfondo

            //metodo che disegna l'immagine di sfondo, ridimensionandola per adattarla al pannello
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (immagine != null) {
                    g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        add(imgPanel, BorderLayout.CENTER);
    }
}