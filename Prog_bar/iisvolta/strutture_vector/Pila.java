import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame {

    private MiaCodaOrdini coda;
    private GestoreFile gestore;

    // componenti che servono al listener
    private JSpinner spTavolo;
    private JSpinner spQuantita;
    private JComboBox<String> comboProdotti;
    private JButton btnAnnulla;
    private JButton btnConferma;

    public static void main(String[] args) {
        MiaCodaOrdini codaOrdinazioni = new MiaCodaOrdini();
        GestoreFile gestoreFile = new GestoreFile();

        GUI gui = new GUI(codaOrdinazioni, gestoreFile);
        gui.setVisible(true);
    }

    public GUI(MiaCodaOrdini codaCondivisa, GestoreFile gestoreCondiviso) {
        this.coda = codaCondivisa;
        this.gestore = gestoreCondiviso;