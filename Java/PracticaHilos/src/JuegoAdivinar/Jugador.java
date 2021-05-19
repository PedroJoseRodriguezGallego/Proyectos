package JuegoAdivinar;


public class Jugador extends Thread //Productor
{
    private int idJugador;
    private Arbitro arbitro;
    private boolean pararHilo = false;


    public Jugador(){}
    public Jugador(int fidJugador, Arbitro farbitro)
    {
        this.idJugador = fidJugador;
        this.arbitro = farbitro;
    }


    public void run()
    {
        Jugador j = new Jugador();

        while(!pararHilo)
        {
            if(!arbitro.getTerminado())
            {
                int numeroIntentado = j.generarNumero();
                arbitro.comprobarJugada(idJugador,numeroIntentado);

                try
                {
                    //wait();
                    sleep(100);
                }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
                else
                {
                    pararHilo = true;
                }
        }
    }


    public int generarNumero()
    {
        int numero = 1 + (int) (10*Math.random() );
        return numero;
    }
}