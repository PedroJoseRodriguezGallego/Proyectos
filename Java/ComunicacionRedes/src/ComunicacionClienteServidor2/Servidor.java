package ComunicacionClienteServidor2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor
{
    Alumno[] alumnos = new Alumno[5];

    public static void main(String[] args) throws IOException
    {
        Servidor servidor = new Servidor();
        String cadena;

        DatagramSocket socket = new DatagramSocket(12345);
        DatagramPacket paqueteDatos;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;

        Curso cursoDDI = new Curso("DDI", "Asignatura de Desarrollo de interfaces");
        Curso cursoPMDM = new Curso("PMDM", "Asignatura de Programacion Multimedia y de Dispositivos Moviles");
        servidor.alumnos[0] = new Alumno("PJRG","Pedro", cursoDDI, 8);
        servidor.alumnos[1] = new Alumno("JMGB","Jose",cursoDDI, 10);
        servidor.alumnos[2] = new Alumno("SRG","Sara",cursoPMDM, 7);
        servidor.alumnos[3] = new Alumno("EMM","Eva",cursoPMDM, 2);
        servidor.alumnos[4] = new Alumno("AMRG","Andrea",cursoDDI, 4);

        do
        {
            byte[] recibidos = new byte[1024];
            paqueteDatos = new DatagramPacket( recibidos , recibidos.length );
            socket.receive(paqueteDatos);
            cadena = new String(paqueteDatos.getData()).trim();

            InetAddress IPOrigen = paqueteDatos.getAddress();
            int puerto = paqueteDatos.getPort();

            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            Alumno alumno = servidor.buscarAlumno(cadena);
            objectOutputStream.writeObject(alumno);

            byte[] enviados = byteArrayOutputStream.toByteArray();
            DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
            socket.send(envio);

        } while(!cadena.equals("*"));

        byteArrayOutputStream.close();
        objectOutputStream.close();
        socket.close();
    }



    public Alumno buscarAlumno(String id)
    {
        for(int i = 0; i < alumnos.length; i++)
        {
            if (alumnos[i].idAlumno.equals(id))
            {
                return alumnos[i];
            }
        }

        return null;
    }
}