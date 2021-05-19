package CarreraCaballos;

import java.util.Observable;

public class Hilo extends Observable implements Runnable
{
    String nombre;

    public Hilo(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public void run()
    {
        int porcentaje = 0;
        int numAleatorio;

        try
        {
            while (porcentaje < 100)
            {
                numAleatorio = aumentarProgreso();
                porcentaje += numAleatorio;

                this.setChanged();
                this.notifyObservers(porcentaje);
                this.clearChanged();

                Thread.sleep(120);
            }
        }
            catch (InterruptedException ex) { }
    }

    public int aumentarProgreso()
    {
        int num = (int) Math.floor(Math.random() * 5 + 1);
        return num;
    }

}