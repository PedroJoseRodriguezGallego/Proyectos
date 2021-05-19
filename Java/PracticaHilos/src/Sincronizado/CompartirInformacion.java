package Sincronizado;

public class CompartirInformacion
{
    public static void main(String[] args)
    {
        Saldo saldo = new Saldo(500);

        Hilo hilo1 = new Hilo("Hilo1",saldo);

        hilo1.start();
    }
}