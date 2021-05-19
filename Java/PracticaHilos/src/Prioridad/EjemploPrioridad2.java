package Prioridad;


public class EjemploPrioridad2 extends Thread // Clase para crear el hilo que extiende de Thread
{
    EjemploPrioridad2(String nombre) // Constructor del hilo
    {
        this.setName(nombre);
    }

    public void run() // Funcion que realizara el hilo al comenzar su ejecucion
    {
        System.out.println("Ejecutando [" + getName() + "]"); // Mostramos el nombre del hilo

        for (int i = 1; i<= 5; i++)
        {
            System.out.println("\t(" + getName() + " : " + i + ")"); // Mostramos el valor del contador del hilo concreto
        }
    }

    public static void main(String[] args)
    {
        // Inicializamos los hilos
        EjemploPrioridad2 h1 = new EjemploPrioridad2("Uno");
        EjemploPrioridad2 h2 = new EjemploPrioridad2("Dos");
        EjemploPrioridad2 h3 = new EjemploPrioridad2("Tres");
        EjemploPrioridad2 h4 = new EjemploPrioridad2("Cuatro");
        EjemploPrioridad2 h5 = new EjemploPrioridad2("Cinco");

        // Establecemos las prioridades de los hilos
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(3);
        h3.setPriority(Thread.NORM_PRIORITY);
        h4.setPriority(7);
        h5.setPriority(Thread.MAX_PRIORITY);

        // Comenzamos los hilos
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
}