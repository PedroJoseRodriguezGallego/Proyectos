package JuegoAdivinar;

public class Piloto
{
    public static void main(String[] args)
    {
        Piloto p = new Piloto();
        int resultado = p.generarNumero();

        Arbitro arbitro = new Arbitro(3,resultado); //Cola
        Jugador jugador1 = new Jugador(1,arbitro); //Productor
        Jugador jugador2 = new Jugador(2,arbitro); //Productor
        Jugador jugador3 = new Jugador(3,arbitro); //Productor

        System.out.println("NUMERO A ADIVINAR : " + resultado);
        System.out.println("-------------------------");

        jugador1.start();
        jugador2.start();
        jugador3.start();
    }


    public int generarNumero()
    {
        int numero = 1 + (int)(10 * Math.random() );
        return numero;
    }
}