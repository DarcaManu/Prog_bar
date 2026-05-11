package  strutture_vector;

import java.util.*;

public class Pila {

    private Vector elementi;

    public Pila() {
        elementi = new Vector<>();
    }

    public void push(Object obj) {
        elementi.addElement(obj);
    }

    public Object pop() {
        Object obj = null;
        int size = elementi.size();

        if (size > 0) {
            obj = elementi.elementAt(size-1);
            elementi.removeElementAt(size-1);
        }
        return obj;
    }

    public Object top() {
        Object obj = null;
        int size = elementi.size();

        if (size > 0) {
            obj = elementi.elementAt(size-1);
        }
        return obj;
    }

    public boolean vuota() {
        if (elementi.size() > 0)
            return false;
        else
            return true;
    }

    public int size() {
        return elementi.size();
    }
}
