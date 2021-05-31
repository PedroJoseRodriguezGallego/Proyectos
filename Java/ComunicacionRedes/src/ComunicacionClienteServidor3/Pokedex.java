package ComunicacionClienteServidor3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Pokedex //Servidor
{
    private static int id;

    public static void main(String[] args) throws IOException
    {
        TipoElemental fuego = new TipoElemental("Fuego","Agua");
        TipoElemental agua = new TipoElemental("Agua","Planta");
        TipoElemental planta = new TipoElemental("Planta","Fuego");

        Ataque ascuas = new Ataque("Ascuas",15);
        Ataque latigoCepa = new Ataque("Latigo cepa",20);
        Ataque pistolaAgua = new Ataque("Pistola agua",30);

        Pokemon Charmander = new Pokemon(4,"Charmander",fuego,ascuas);
        Pokemon Bulbasur = new Pokemon(1,"Bulbasur",planta,latigoCepa);
        Pokemon Squirtle = new Pokemon(7,"Squirtle",agua,pistolaAgua);

        Pokemon[] pokemones = {Bulbasur, Charmander, Squirtle};
        Pokemon pokemonVacio = new Pokemon(0,"PokemonVacio",fuego,ascuas);



        int numeroPuerto = 6000;
        String mensajefin = "";
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado;
        InputStream entrada;
        DataInputStream flujoEntrada;
        DataOutputStream flujoSalida;
        OutputStream salida;
        boolean encontrado;


        while(true)
        {
            encontrado = false;
            clienteConectado = servidor.accept();
            id++;

            salida = clienteConectado.getOutputStream();
            flujoSalida = new DataOutputStream(salida);
            System.out.println("Entrenador pokemon : " + id);
            flujoSalida.writeInt(id);

            entrada = clienteConectado.getInputStream();
            flujoEntrada = new DataInputStream(entrada);

            try
            {
                mensajefin = flujoEntrada.readUTF();
                int consulta =Integer.parseInt(mensajefin);

                for(int i = 0; i <pokemones.length ; i++)
                {
                    if(pokemones[i].getNumeroPokedex() == consulta)
                    {
                        Pokemon pokemonEnviar = pokemones[i];
                        encontrado = true;

                        ObjectOutputStream outObjeto = new ObjectOutputStream(clienteConectado.getOutputStream());
                        outObjeto.writeObject(pokemonEnviar);

                        System.out.println("Cliente consulta el numero de pokedex : " + consulta);
                    }
                }

                if(!encontrado)
                {
                    ObjectOutputStream outObjeto = new ObjectOutputStream(clienteConectado.getOutputStream());
                    outObjeto.writeObject(pokemonVacio);
                    System.out.println("Pokemon no encontrado");
                }

                System.out.println("Entrenador pokemon : " + id + " desconectado");
            }
                catch (Exception e)
                {
                    System.out.println("Entrenador pokemon : " + id + " desconectado");
                }
        }
    }
}