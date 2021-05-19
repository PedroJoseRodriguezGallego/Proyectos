package Prioridad;


public class EjemploPrioridad1 // Clase para ejecutar los hilos
{
    public static void main(String[] args)
    {
        // Inicializamos los hilos
        HiloPrioridad1 h1 = new HiloPrioridad1("Hilo1");
        HiloPrioridad1 h2 = new HiloPrioridad1("Hilo2");
        HiloPrioridad1 h3 = new HiloPrioridad1("Hilo3");

        // Establecemos las prioridades de los hilos
        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);

        // Comenzamos los hilos
        h1.start();
        h2.start();
        h3.start();

        try
        {
            Thread.sleep(10000); // Esperamos 10 segundos
        }
            catch (Exception e)
            {
                System.out.println("Error por excepcion");
            }

        // Paramos todos los hilos
        h1.pararHilo();
        h2.pararHilo();
        h3.pararHilo();

        // Vemos el resultado de contador para comprobar si realmente los de mayor prioridad se ejecutan antes
        System.out.println("h2 (Prioridad Maxima) : " + h2.getContador());
        System.out.println("h1 (Prioridad Normal) : " + h1.getContador());
        System.out.println("h3 (Prioridad Minima) : " + h3.getContador());
    }
}