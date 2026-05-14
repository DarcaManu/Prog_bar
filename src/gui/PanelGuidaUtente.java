package GUI;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class PanelGuidaUtente extends JPanel {
    public PanelGuidaUtente() {

        setLayout(new BorderLayout());

        add(new JLabel("Guida Utente", SwingConstants.CENTER), BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        try (BufferedReader br = new BufferedReader(new FileReader("data/GuidaUtente.txt"))) {

            String riga;
            while ((riga = br.readLine()) != null) area.append(riga + "\n");
            
        } catch (IOException e) {
            area.setText("Guida non disponibile.");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}