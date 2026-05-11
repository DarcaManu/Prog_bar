package  strutture_vector;

import java.util.*;

public class Coda {

    private Vector elementi;

    public Coda() {
        elementi = new Vector<>();
    }

    public void aggiungi(Object obj) {
        elementi.addElement(obj);
    }

    public Object togli() {
        Object obj = null;
        int size = elementi.size();

        if (size > 0) {
            obj = elementi.elementAt(0);
            elementi.removeElementAt(0);
        }
        return obj;
    }

    public int size() {
        return elementi.size();
    }

    public boolean vuota() {
        return elementi.isEmpty();
    }

    public void svuota() {
        elementi.clear();
    }
}
