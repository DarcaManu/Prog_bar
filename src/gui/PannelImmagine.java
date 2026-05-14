package GUI;
import java.awt.*;
import javax.swing.*;

//cercando online un modo per mettere un'immagine di sfondo, ho trovato questa soluzione 
public class PannelImmagine extends JPanel {
    private Image immagine;

    public PannelImmagine(Image immagine) {
        this.immagine = immagine;
    }

    @Override
    //metodo che disegna l'immagine di sfondo, ridimensionandola per adattarla al pannello
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (immagine != null) {
            g.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
        }
    }
}