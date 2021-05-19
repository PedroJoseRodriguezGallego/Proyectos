package Sincronizado;

public class Hilo extends Thread
{
    private Saldo saldo;


    public Hilo (String fNombreHilo, Saldo fSaldo)
    {
        setName(fNombreHilo);
        this.saldo = fSaldo;
    }


    public void run()
    {
        saldo.incrementarSaldo(200,"Gorgue");
        saldo.incrementarSaldo(500,"Pepe");
        saldo.incrementarSaldo(1000,"Alejandra");
        saldo.incrementarSaldo(85,"Pedro");
    }

}