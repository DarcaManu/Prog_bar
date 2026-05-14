package GUI;

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

        //per renderlo riutilizzabile, ho creato un pannello apposito che disegna l'immagine di sfondo, e lo aggiungo al centro del panel home
        PannelImmagine imgPanel = new PannelImmagine(immagine);
        add(imgPanel, BorderLayout.CENTER);
    }
}