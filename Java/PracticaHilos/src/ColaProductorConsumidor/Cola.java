package ColaProductorConsumidor;

public class Cola
{
    private String cadena;
    private boolean disponible = false;



    public synchronized String get()
    {
        while(!disponible)
        {
            try
            {
                wait();
            }
                catch (InterruptedException e)
                {
                    System.out.println("Error en el get");
                }
        }

        disponible = false;
        notifyAll();
        return cadena;
    }



    public synchronized void put(String cadena)
    {
        while(disponible)
        {
            try
            {
                wait();
            }
                catch (InterruptedException e)
                {
                    System.out.println("Error en el put");
                }
        }

        this.cadena = cadena;
        disponible = true;
        notifyAll();
    }
}