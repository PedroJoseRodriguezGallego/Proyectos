package ColaProductorConsumidor;

public class Productor extends Thread
{
    private Cola cola;
    private int numero;



    public Productor(Cola fcola, int fnumero)
    {
        this.cola = fcola;
        this.numero = fnumero;
    }



    @Override
    public void run()
    {
        String cadena = "PING";

        for (int i = 0; i < 10; i++)
        {
            cola.put(cadena);

            if(cadena.equals("PING"))
            {
                cadena = "PONG";
            }
                else if(cadena.equals("PONG"))
                {
                    cadena = "PING";
                }
        }

        System.exit(0);
    }
}