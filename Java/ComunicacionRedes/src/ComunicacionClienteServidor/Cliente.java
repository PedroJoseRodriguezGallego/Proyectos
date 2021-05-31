package ComunicacionClienteServidor;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args)
    {
        int puerto = 12345;
        Scanner teclado = new Scanner(System.in);

        while (true)
        {
            byte[] buffer;
            DatagramSocket cliente;
            DatagramPacket paqueteDatos;
            String mensaje;
            InetAddress servidor;

            try
            {
                cliente = new DatagramSocket();
                servidor = InetAddress.getByName("localhost");
                System.out.print("Mensaje a enviar : ");
                mensaje = teclado.nextLine().trim();
                buffer = mensaje.getBytes();
                paqueteDatos = new DatagramPacket(buffer, buffer.length, servidor, puerto);
                cliente.send(paqueteDatos);

                if(mensaje.equals("*"))
                {
                    break;
                }

                buffer = new byte[1024];
                paqueteDatos = new DatagramPacket(buffer, buffer.length);
                cliente.setSoTimeout(500);
                cliente.receive(paqueteDatos);
                mensaje = new String(paqueteDatos.getData());
                System.out.println("Mensaje recibido del servidor : " + mensaje);
            }
                catch (InterruptedIOException iioe)
                {
                    System.out.println("Se ha perdido el paquete");
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
        }
    }
}