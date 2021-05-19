package JuegoAdivinar;

public class Arbitro //Cola
{
    private int jugadores;
    private int numero;
    private boolean terminado = false;


    public Arbitro(int jugadores, int numero)
    {
        this.jugadores = jugadores;
        this.numero = numero;
    }

    public boolean getTerminado()
    {
        return terminado;
    }


    public synchronized void comprobarJugada(int idJugador, int numeroIntentado)
    {
        System.out.println("\nJugador " + idJugador + " dice : " + numeroIntentado);

        if(numeroIntentado == numero)
        {
            System.out.println("\tJugador " + idJugador + " gana, ha acertado el numero !!!");
            terminado = true;
        }
            else //Indicar cual es el siguiente jugador turno
            {
                System.out.println("\t Le toca al siguiente jugador");
            }

    }
}