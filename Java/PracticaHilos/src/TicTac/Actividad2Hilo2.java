package TicTac;

public class Actividad2Hilo2 extends Thread
{
    public void  run()
    {
        while (true)
        {
            System.out.println("TAC");

            try
            {
                sleep(1000);
            }
                catch (InterruptedException e)
                {
                    System.out.println("Catch del Hilo2");
                }
        }
    }
}