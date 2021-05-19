package TicTac;

public class Actividad2Hilo1 extends Thread
{
    public void  run()
    {
        while (true)
        {
            System.out.println("TIC");

            try
            {
                sleep(1000);
            }
                catch (InterruptedException e)
                {
                    System.out.println("Catch del Hilo1");
                }
        }
    }
}
