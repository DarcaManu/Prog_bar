package GUI;
import CLI.GestoreFile;
import java.awt.*;
import javax.swing.*;

public class PanelListinoPrezzi extends JPanel {
    public PanelListinoPrezzi(GestoreFile gestore) {

        setLayout(new BorderLayout());
        add(new JLabel("Listino Prezzi", SwingConstants.CENTER), BorderLayout.NORTH);

        JTextArea area = new JTextArea();
        area.setEditable(false);    

        //riusiamo un metodo già presente in GestoreFile che restituisce una stringa con il listino prezzi formattato
        area.setText(gestore.mostraListinoPrezziStringa());
        add(new JScrollPane(area), BorderLayout.CENTER);
    }


    

    
}