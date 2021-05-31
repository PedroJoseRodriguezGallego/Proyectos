package DatosClientesConectados;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente extends Socket //Extiende de socket
{
    public Cliente(String ip, int puerto) throws IOException //Constructor heredado donde indicamos la IP o Host del servidor y el puerto
    {
        super(InetAddress.getByName(ip), puerto);
    }

    public void leer() throws IOException //Obtiene el mensaje del servidor
    {
        DataInputStream flujoEntrada = new DataInputStream(this.getInputStream());
        System.out.println("Mensaje recibido del servidor : " + flujoEntrada.readUTF());
        flujoEntrada.close();
    }
}