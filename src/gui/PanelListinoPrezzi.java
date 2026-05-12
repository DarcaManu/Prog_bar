package gui;
import CLI.GestoreFile;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelListinoPrezzi extends JPanel {
    public PanelListinoPrezzi(GestoreFile gestore) {
        setLayout(new BorderLayout());
        add(new JLabel("Listino Prezzi", SwingConstants.CENTER), BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        ArrayList listino = gestore.caricaListinoPrezzi(); // metodo già esistente
        for (Object voce : listino) {
            area.append(String.join(" | ", (String[]) voce) + "\n");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        // non serve refresh: il listino non cambia a runtime
    }
}