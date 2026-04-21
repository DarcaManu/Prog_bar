
import javax.swing.*;

public class Bar4ci extends JFrame{
    private codaOrdini coda; //coda condivisa tra console e GUI
    private gestoreFile gestore; //gestore file condiviso tra console e GUI
    codaOrdini codaOrdini = new codaOrdini();
        menuScelte mioMenu = new menuScelte();
        Utility utilOrdine = new Utility();
        gestoreFile gestoreFile = new gestoreFile();


    public Bar4ci() {
        
        setTitle("Bar4ci - GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //obbiettivo è quello di avere una finestra con diverse scelte sull'header con i Jmenu 
        //nel centro poi mostra quella scelta, ad esempio se clicco su "inserisci ordine" mi mostrerà al centro la finestra per inserire l'ordine,senza aprire una nuova finestra,
        //  mentre se clicco su "mostra ordini" mi si apre la finestra con gli ordini presenti nella coda, ecc, questo probabilmente con card layout
        //  se clicco su "mostra ordini" mi si apre la finestra con gli ordini presenti nella coda, ecc

        JMenuBar menuBar = new JMenuBar(); //creo la barra dei menu
        JMenu menu = new JMenu("Ordinazione");//creo un menu chiamato "Ordinazione" 
        // che conterrà le voci per inserire e mostrare gli ordini

        //aggiungo le voci al menu
        JMenuItem inserisciOrdine = new JMenuItem("Inserisci ordine");
        JMenuItem mostraOrdini = new JMenuItem("Mostra ordini");

       
        

        menu.add(inserisciOrdine);
        menu.add(mostraOrdini);
        menuBar.add(menu);


        setJMenuBar(menuBar);//aggiungo la barra dei menu al frame
    }

}
