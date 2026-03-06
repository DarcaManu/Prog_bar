package iisvolta.strutture_array_list;

import java.util.*;

public class Coda
{
  private ArrayList<Object> elementi;

    /**
     * documentazione 
     */
  public Coda()
  {
     elementi = new ArrayList<>();
  }

  public void aggiungi(Object obj)
  {
    elementi.add(obj);
  }

   public Object togli()
  {
    Object obj = null;
    int size = elementi.size();

    if (size > 0)
    {
      obj = elementi.get(0);
      elementi.remove(0);
    }
    return obj;
  }

  public boolean vuota()
  {
     return elementi.isEmpty();
  }

  public int size()
  {
    return elementi.size();
  }
}
