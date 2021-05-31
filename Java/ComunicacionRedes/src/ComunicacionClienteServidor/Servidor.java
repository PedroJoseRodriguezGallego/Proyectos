package ComunicacionClienteServidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor
{
    public static void main(String[] args)
    {
        while(true)
        {
            int puerto = 12345;
            byte[] buffer = new byte[1024];
            DatagramSocket servidor;
            DatagramPacket paqueteDatos;
            String mensaje;
            InetAddress direccionCliente;

            try
            {
                servidor = new DatagramSocket(puerto);
                paqueteDatos = new DatagramPacket(buffer, buffer.length);
                servidor.receive(paqueteDatos);
                mensaje = new String(paqueteDatos.getData()).trim();
                System.out.println("Mensaje desde el cliente : " + mensaje);

                if(mensaje.equals("*"))
                {
                    break;
                }

                mensaje = mensaje.toUpperCase();
                direccionCliente = paqueteDatos.getAddress();
                puerto = paqueteDatos.getPort();
                buffer = mensaje.getBytes();
                paqueteDatos = new DatagramPacket(buffer, buffer.length, direccionCliente, puerto);

                //Si hacemos un sleep de mas de 500 segundos no llega el paquete

                servidor.send(paqueteDatos);
                servidor.close();
            }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
        }
    }
}