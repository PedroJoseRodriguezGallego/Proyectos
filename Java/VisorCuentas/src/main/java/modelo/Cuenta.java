package modelo;



public class Cuenta
{
    String numeroCuenta;
    String titular;
    String fechaApertura;
    String saldo;

    public Cuenta(String fnumeroCuenta, String ftitutlar, String ffechaApertura, String fsaldo)
    {
        this.numeroCuenta = fnumeroCuenta;
        this.titular = ftitutlar;
        this.fechaApertura = ffechaApertura;
        this.saldo = fsaldo;
    }

}