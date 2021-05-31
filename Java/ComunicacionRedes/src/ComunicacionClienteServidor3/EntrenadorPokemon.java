package ComunicacionClienteServidor3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EntrenadorPokemon //Cliente
{
    public static int id;

    public static void main(String[] args) throws IOException
    {
        String Host = "localhost";
        int Puerto = 6000;
        String fin = "";
        Socket Cliente = new Socket(Host, Puerto);
        InputStream entrada;
        OutputStream salida = null;
        DataOutputStream flujoSalida = null;
        DataInputStream flujoEntrada;
        ObjectInputStream inObjeto;
        Scanner sc = new Scanner(System.in);

        entrada = Cliente.getInputStream();
        flujoEntrada = new DataInputStream(entrada);
        id = flujoEntrada.readInt();
        System.out.println("El entrenador pokemon tiene el id " + id);

        do
        {
            System.out.print("Introduce un numero de la pokedex : ");
            fin = sc.nextLine();

            try
            {
                salida = Cliente.getOutputStream();
                flujoSalida = new DataOutputStream(salida);
                flujoSalida.writeUTF(fin);

                inObjeto = new ObjectInputStream(Cliente.getInputStream());

                Pokemon pokemonRecibido = (Pokemon) inObjeto.readObject();

                if(pokemonRecibido.getNumeroPokedex() != 0)
                {
                    System.out.println("\nPokemon : " + pokemonRecibido.getNombre());
                    System.out.println("\tTipo : " + pokemonRecibido.getElemento().getElemento());
                    System.out.println("\tDebilidad : " + pokemonRecibido.getElemento().getDebilidad());
                    System.out.println("\tAtaque : " + pokemonRecibido.getAtq().getAtaque() + " - " + pokemonRecibido.getAtq().getDamage() + "DMG");
                }
                    else
                    {
                        System.out.println("Pokemon no encontrado");
                    }
            }
                catch (Exception e)
                {
                    System.out.println("Ha ocurrido un error");
                    e.printStackTrace();
                }
        } while (!fin.equals("*"));


        flujoEntrada.close();
        entrada.close();
        flujoSalida.close();
        salida.close();
        Cliente.close();
    }
}