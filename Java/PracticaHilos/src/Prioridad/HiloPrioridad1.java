package Prioridad;

public class HiloPrioridad1 extends Thread //Clase que extiende de Thread para crear el hilo
{
    private int contador = 0;
    private boolean stopHilo = false;

    public HiloPrioridad1(String nombre) //Costructor del hilo
    {
        super(nombre);
    }

    public int getContador() // Funcion que devuelve el atributo de contador
    {
        return contador;
    }

    public void pararHilo() // Funcion que cambia el atributo stopHilo para parar el hilo sin dar errores de bloqueo
    {
        stopHilo = true;
    }

    public void run() // Funcion que indica que hara el hilo al comenzar
    {
        while (!stopHilo) // Mientras no paremos el hilo
        {
            try
            {
                Thread.sleep(2); // Esperamos 2 milisegundos
                contador++; // Aumentamos el contador
            }
                catch (Exception e)
                {
                    System.out.println("Error capturado por excepcion");
                }
        }

        System.out.println("Fin del hilo : " + this.getName()); // Cuando acabe el hilo mostramos el mensaje
    }
}