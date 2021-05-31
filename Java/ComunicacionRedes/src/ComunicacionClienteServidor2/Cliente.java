package ComunicacionClienteServidor2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Scanner;

public class Cliente
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        InetAddress destino = InetAddress.getLocalHost();
        Scanner teclado = new Scanner(System.in);
        String consulta;

        DatagramSocket socket = new DatagramSocket(34567);
        DatagramPacket paqueteDatos;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;

        int port = 12345;
        byte[] mensaje;

        do
        {
            System.out.print("Introduce el ID del alumno : ");
            consulta = teclado.nextLine();
            mensaje = consulta.getBytes();

            paqueteDatos = new DatagramPacket(mensaje , mensaje.length , destino , port);
            socket.send(paqueteDatos);

            byte[] recibidos = new byte[1024];
            paqueteDatos = new DatagramPacket(recibidos , recibidos.length);
            socket.receive(paqueteDatos);
            byteArrayInputStream = new ByteArrayInputStream(recibidos);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            Alumno alumno = (Alumno) objectInputStream.readObject();

            if(alumno != null)
            {
                System.out.println("ID : " + alumno.idAlumno);
                System.out.println("Nombre : " + alumno.nombre);
                System.out.println("Curso : " + alumno.curso.id + " --> " + alumno.curso.descripcion);
                System.out.println("Nota : " + alumno.nota + "\n\n");
            }
                else
                {
                    System.out.println("No se ha podido encontrar el alumno especifico");
                }

        } while (!consulta.equals("*"));

        byteArrayInputStream.close();
        objectInputStream.close();
        socket.close();
    }
}