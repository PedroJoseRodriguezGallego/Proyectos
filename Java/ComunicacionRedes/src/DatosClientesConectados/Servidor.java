package DatosClientesConectados;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends ServerSocket //Extiende de servidor
{
    Socket[] clientes; //Lista para guardar a los clientes
    int cantidad; //Cantidad de clientes que tendremos
    int indice; //Indice para saber con que cliente tratamos


    protected Servidor(int fport, int fcantidad) throws IOException //Constructor heredado donde indicamos el puerto
    {
        super(fport);
        clientes = new Socket[fcantidad]; //Inicializamos la lista de clientes con la cantidad
        cantidad = fcantidad;
    }


    public void aceptar() throws IOException //Recorre a los clientes y los acepta
    {
        for(int i = 0; i < cantidad; i++)
        {
            clientes[i] = accept();
        }
    }


    public void enviar() throws IOException //Envia mensaje a los clientes dependiendo de cual sea (indice)
    {
        OutputStream salida = clientes[indice].getOutputStream(); //Crea el hueco para el bufer de salida
        DataOutputStream flujoSalida = new DataOutputStream(salida); //Crea el bufer de salida

        flujoSalida.writeUTF("Soy el servidor y tu eres el cliente : " + (indice + 1) ); //Escribe mensaje en el flujo

        salida.close();
        flujoSalida.close();

        indice++;
    }

}