package TicTac;

public class UsoHilos
{
    public static void main(String[] args)
    {
        Actividad2Hilo1 h1 = new Actividad2Hilo1();
        Actividad2Hilo2 h2 = new Actividad2Hilo2();

        h1.start();
        h2.start();
    }
}