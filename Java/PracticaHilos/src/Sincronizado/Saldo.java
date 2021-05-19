package Sincronizado;

public class Saldo
{
    private int cantidad;



    public Saldo(int fcantidad)
    {
        this.cantidad = fcantidad;
    }


    public synchronized void incrementarSaldo(int faumento, String fnombre)
    {
        System.out.println("Saldo actual : " + this.cantidad + "$");

        this.cantidad += faumento;

        System.out.println("\t" + fnombre + " anade " + faumento + "$ y ahora hay " + this.cantidad + "$");
    }



    public int getCantidad()
    {
        try
        {
            Thread.sleep(100);
        }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        return cantidad;
    }



    public void setCantidad(int cantidad)
    {
        try
        {
            Thread.sleep(100);
        }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        this.cantidad = cantidad;
    }
}