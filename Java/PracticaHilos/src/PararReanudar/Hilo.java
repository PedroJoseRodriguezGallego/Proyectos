package PararReanudar;

import javax.swing.JTextField;


public class Hilo extends Thread
{
    private SolicitaSuspender suspender = new SolicitaSuspender();
    public JTextField texto;
    private int contador = 0;
    private boolean parado = false;
    
    public Hilo(JTextField ftexto,String nombre)
    {
        super(nombre);
        this.texto = ftexto;
    }

    public void Suspende()
    {
        suspender.set(true);
    }

    public void Reanuda()
    {
        suspender.set(false);
    }

    public int getContador()
    {
        return contador;
    }
    
    public void pararHilo()
    {
        parado = true;
    }

    public void run()
    {
        try
        {
            while(!parado)
            {
                contador++;
                this.texto.setText(Integer.toString(this.contador));
                sleep(500);

                suspender.esperandoParaReanudar();
            }
        }
            catch (InterruptedException e)
            {
                System.out.println("Error de interrupcion de hilos");
            }
    }
}