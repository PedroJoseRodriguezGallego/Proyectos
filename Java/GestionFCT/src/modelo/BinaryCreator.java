package modelo;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryCreator {
    public static void main( String args[]){
        // Creamos una instancia de esta clase para poder acceder a los métodos no estáticos creados.
        BinaryCreator AppManager = new BinaryCreator();
        // Creamos una instancia de Scanner para introducir datos por teclado.
        Scanner textInput = new Scanner(System.in);

        // Creamos el flujo de salida (clase FileOutputStream) para poder guardar datos en un fichero.
        FileOutputStream fileOutStr = null;
        // Nos permite leer datos de tipo primitivo desde un InputStream.
        ObjectOutputStream output = null;
        // Creamos el flujo de entrada de datos desde el fichero al programa.
        FileInputStream fileInpStr = null;
        ObjectInputStream entrada = null;

        // Creamos una Lista de Objetos Serializables que emplearemos para leer Objetos Serializados del fichero.
        ArrayList<Serializable> alumnos = new ArrayList<>();
        /*Creamos al objeto alumno que recibirá cada objeto y lo añadirá a la lista, y que se
        empleará para pasar los s nuevo a una tabla de la base de datos.*/
        Alumno alumno = new Alumno();
        // Creamos una variable para elegir la opción.
        int option = 0;
        // Creamos variables para introducir por teclado los datos de alumno.
        int number = 0;
        String name = null;
        String DNI = null;
        String apellidos = null;
        String fechaNacimiento = null;

        // Creamos una variable del tipo DecimalFormat para que al mostrar valores por pantalla salgan solo con dos dígitos decimales.
        DecimalFormat numberFormat = new DecimalFormat("0.00");

        option = AppManager.AppMenu(textInput, option);

        while(option != 6){

            switch(option)
            {
                // Caso añadir nuevo registro.
                case 1:
                    AppManager.Addalumno(fileOutStr, output, number, DNI, name, apellidos, fechaNacimiento, textInput, alumno);
                    break;

                // Caso de modificar el valor de un registro del fichero.
                case 2:
                    AppManager.SearchValue(number, textInput, fileInpStr, entrada, alumnos, numberFormat);
                    break;

                // Caso de eliminar el fichero binario.
                case 3:
                    AppManager.DeleteFile();
                    break;

                default:
                    System.out.println("Opción no válida. Introduzca un valor de nuevo.");
                    break;
            }
            option = AppManager.AppMenu(textInput, option);
        }

    }

    // Método que llama al menú y pide opción por teclado.
    public int AppMenu(Scanner textInput, int option)
    {
        System.out.println("\n                               Menú de Opciones");
        System.out.println("                             =====================\n");
        System.out.println("1) Añadir nuevo alumno");
        System.out.println("2) Consulta de un alumno");
        System.out.println("3) Eliminar el fichero");
        System.out.println("4) Salir");

        System.out.print("Elige una opción: ");
        option = textInput.nextInt();
        return option;
    }
    // Método del case 1
    public void Addalumno(FileOutputStream fileOutStr, ObjectOutputStream output, int number, String DNI, String name, String apellidos, String fechaNacimiento, Scanner textInput, Alumno alumno)
    {
        try {
            //Abre el fichero existente o lo crea para escribir por el final
            fileOutStr = new FileOutputStream("src/modelo/alumnos2CFS.dat", true);
            // Abrimos flujo para la serialización de objetos.
            output = new ObjectOutputStream(fileOutStr);
            // Insertar código del alumno.
            System.out.print("Código del alumno: ");
            number = textInput.nextInt(); //Lee de teclado
            alumno.codigoAlumno = number;

            textInput.nextLine();

            // Insertar DNI del alumno.
            System.out.print("DNI: ");
            DNI = textInput.nextLine();
            alumno.DNI = DNI;

            // Insertar nombre del alumno.
            System.out.print("Nombre: ");
            name = textInput.nextLine();
            alumno.nombre = name;

            // Insertar apellidos del alumno.
            System.out.print("Apellidos: ");
            apellidos = textInput.nextLine();
            alumno.apellidos = apellidos;

            // Insertar nombre del alumno.
            System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
            fechaNacimiento = textInput.nextLine();
            alumno.fechaNacimiento = fechaNacimiento;

            output.writeObject(alumno);

        } catch (IOException fnfe) {
            System.out.println(fnfe.getMessage());
        } finally {
            try {
                if (fileOutStr != null) {
                    fileOutStr.close();
                }
                if (output != null) {
                    output.close();
                }
                //Mensaje al terminar la función correctamente.
                System.out.println("Datos incorporados al fichero.");
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

    // Método del case 2
    public void SearchValue(int number, Scanner textInput, FileInputStream fileInpStr, ObjectInputStream entrada, List<Serializable> alumnos, DecimalFormat numberFormat)
    {
        System.out.print("Número del alumno: ");
        number = textInput.nextInt(); //Lee de teclado
        try {
            // Preparando el fichero que almacena los datos serializados
            fileInpStr = new FileInputStream("src/modelo/alumnos2CFS.dat");

            // Nos aseguramos de que la lista vuelve a estar vacía antes de volver a recuperar los objetos
            if(alumnos != null)
                alumnos.removeAll(alumnos);

            // Recorremos el fichero completo hasta que no quedan más Objetos que devolver.
            while(fileInpStr.available() > 0){
                // Creación del flujo para la deserialización y poder recuperar todos los objetos.
                entrada = new ObjectInputStream(fileInpStr);
                //Casting imprescindible porque readObject() devuelve obviamente Object
                alumnos.add((Alumno)entrada.readObject()); // Guardamos cada Object en el ArrayList alumnos.
            }
            // Cerramos flujo abierto y fichero.
            entrada.close();
            fileInpStr.close();

            // Catch de excepciones.
        } catch (IOException ioe) {
            ioe.printStackTrace(); return;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Clase alumno no encontrada...");
            cnfe.printStackTrace(); return;
        }

        // Obtener datos de alumno y mostrar por pantalla.
        int i;
        int codigoAlumno = 0;
        String dniAlumno = null;
        String nombreAlumno = null;
        String apellidosAlumno = null;
        String fechaNacimiento = null;
        boolean isFound = false;

        for(i=0; i < alumnos.size(); i++ ){
            Alumno currentalumno = (Alumno)alumnos.get(i);
            if(currentalumno.codigoAlumno == number){
                codigoAlumno = currentalumno.codigoAlumno;
                dniAlumno = currentalumno.DNI;
                nombreAlumno = currentalumno.nombre;
                apellidosAlumno = currentalumno.apellidos;
                fechaNacimiento = currentalumno.fechaNacimiento;

                isFound = true;
            }
        }
        if(isFound == true){
            System.out.println("Código alumno: " + codigoAlumno);
            System.out.println("DNI alumno: " + dniAlumno);
            System.out.println("Nombre alumno: " + nombreAlumno);
            System.out.println("Apellidos alumno: " + apellidosAlumno);
            System.out.println("Fecha nacimiento alumno: " + fechaNacimiento);
        }else{
            System.out.println("Alumno no registrado");
        }
    }

    // Función caso 3
    public void DeleteFile()
    {
        // Creamos una variable de tipo File donde le pasamos la ruta del fichero a borrar.
        File myFile = new File("src/modelo/alumnos2CFS.dat");
        // Comprueba si el fichero existe, y de ser así lo borra. Ante cualquier imprevisto nos avisará por consola.
        if(myFile.exists()){
            boolean isDeleted = myFile.delete();
            if(isDeleted){
                System.out.println("Fichero eliminado.");
            }else{
                System.out.println("Ha surgido un error al eliminar el fichero. Inténtalo de nuevo.");
            }
        }else{
            System.out.println("No se puede borrar el fichero porque no existe.");
        }
    }
}