package DatosClientesConectados;

import java.io.IOException;

public class Piloto
{
    public static void main(String[] args) throws IOException
    {
        Servidor servidor = new Servidor(6000,3); //Creamos el servidor
        Cliente[] clientes = new Cliente[servidor.cantidad]; //Creamos la lista de clientes

        for(int i = 0; i < servidor.cantidad; i++) //Inicializamos a los clientes
        {
            clientes[i] = new Cliente("localhost", 6000);
        }

        System.out.println("SERVIDOR INICIADO");
        servidor.aceptar(); //Acepta a todos los clientes que esten esperando a ser aceptados

        for(int i = 0; i < servidor.cantidad; i++) //Enviamos los datos a los clientes y hacemos que lean los mensajes
        {
            servidor.enviar();
            clientes[i].leer();
        }

        servidor.close();
    }
}