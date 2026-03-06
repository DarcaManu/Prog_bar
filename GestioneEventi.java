import java.awt.event.*;
import javax.swing.*;

public class GestioneEventi implements ActionListener {

    private JSpinner spTavolo;
    private JComboBox<String> comboProdotti;
    private JSpinner spQuantita;
    private MiaCodaOrdini coda;

    public GestioneEventi(JSpinner spTavolo,
                          JComboBox<String> comboProdotti,
                          JSpinner spQuantita,
                          MiaCodaOrdini coda) {
        this.spTavolo = spTavolo;
        this.comboProdotti = comboProdotti;
        this.spQuantita = spQuantita;
        this.coda = coda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numeroTavolo = (Integer) spTavolo.getValue();
        String prodotto = (String) comboProdotti.getSelectedItem();
        int quantita = (Integer) spQuantita.getValue();

        if (prodotto == null) {
            //message dialog per avvertire l'utente di selezionare un prodotto
            JOptionPane.showMessageDialog(null, "Seleziona un prodotto!");
            return;
        }

        // Crea un nuovo ordine e lo aggiunge alla coda
        Ordine ordine = new Ordine(numeroTavolo, prodotto, quantita);
        coda.aggiungi(ordine);




        JOptionPane.showMessageDialog(null,
            "Ordine inserito: Tavolo " + numeroTavolo +
            ", " + prodotto + ", x" + quantita);
    }
}
