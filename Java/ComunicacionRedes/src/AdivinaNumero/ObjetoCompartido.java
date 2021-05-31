package AdivinaNumero;

public class ObjetoCompartido
{
	private int numero; // numero a adivinar
	private boolean acabo; // true cuando se haya terminado el juego
	private int ganador; // jugador ganador

	public ObjetoCompartido(int numero)
	{
		this.numero = numero;
		this.acabo = false;
	}

	public boolean seAcabo() {
		return acabo;
	}

	public int getGanador() {
		return ganador;
	}

	public synchronized String nuevaJugada(int jugador, int suNumero)
	{
		String cad = "";

		if (!seAcabo()) //Mientras no adivinen el numero
		{
			if (suNumero > numero)
			{
				cad = "Numero demasiado grande";
			}
			if (suNumero < numero)
			{
				cad = "Numero demasiado bajo";
			}

			if (suNumero == numero)
			{
				cad = "Jugador " + jugador + " gana, adivino el numero: " + numero;
				acabo = true;
				ganador = jugador;
			}

		}
			else
			{
				cad = "Jugador " + ganador + " adivino el numero: " + numero;
			}

		return cad;
	}
}