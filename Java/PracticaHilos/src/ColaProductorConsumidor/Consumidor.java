package ColaProductorConsumidor;

public class Consumidor extends Thread
{
    private Cola cola;
    private int numero;



    public Consumidor(Cola fcola, int fnumero)
    {
        this.cola = fcola;
        this.numero = fnumero;
    }



    @Override
    public void run()
    {
        String cadena;

        while (true)
        {
            cadena = cola.get();
            System.out.print(cadena + " ");
        }
    }
}