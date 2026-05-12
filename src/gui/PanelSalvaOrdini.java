package GUI;
import CLI.CodaOrdini;
import CLI.GestoreFile;
import java.awt.*;
import javax.swing.*;

public class PanelSalvaOrdini extends JPanel {
    public PanelSalvaOrdini(CodaOrdini coda) {
        setLayout(new BorderLayout());
        add(new JLabel("Salvataggio ordini", SwingConstants.CENTER), BorderLayout.NORTH);

        JButton btnSalva = new JButton("Salva ordini su file");
        btnSalva.addActionListener(e -> {
            GestoreFile.salva(coda); // metodo già esistente
            JOptionPane.showMessageDialog(null, "Ordini salvati in ordini.dat!");
        });

        add(btnSalva, BorderLayout.CENTER);
    }
}