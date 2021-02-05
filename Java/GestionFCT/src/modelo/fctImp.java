/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import help.Help;

public class fctImp {
////////////// Conexion BBDD
    private static final String ADD_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mariadb://localhost:3306/Proy3TEx";
    final String usuario = "root";
    final String contrasenia = "dam2020";
    Connection conexBd = null;
    PreparedStatement encapsulaCons = null;
    FileInputStream fileInpStr = null;
    ObjectInputStream entrada = null;
    
        ArrayList<Serializable> alumnos = new ArrayList<>();


    public String inserta( String COD_EMPRESA,String NOM_EMPRESA,String CIF,String DIREC,String LOCALI,String CP,String TIP_JORNADA,String DNI_RESP,String NOM_RESP,String APELLIDO_RESP,String DNI_TUTOR,
                           String NOM_TUTOR,String APE_TUTOR,String MAIL_TUTOR,String TLF_TUTOR) throws SQLException {

        String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String inser = "INSERT INTO empresa VALUES(" + COD_EMPRESA + ",'" + NOM_EMPRESA + "','" + CIF + "','" + DIREC + "','"+ LOCALI +"','"+CP+"','"+TIP_JORNADA+"','" + DNI_RESP + "','" + NOM_RESP + "','" + APELLIDO_RESP + "','"+DNI_TUTOR+"','"+NOM_TUTOR+"'" +
                    ",'"+APE_TUTOR+"','"+MAIL_TUTOR+"','"+TLF_TUTOR+"');";
            encapsulaCons = conexBd.prepareStatement(inser);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro insertado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "Error, no has insertado los datos correctamente";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
            mensaje = "error";
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();

            }
        }
        if (conexBd != null) {
            conexBd.close();
        }

        return mensaje;
    }

    //////////////////////////////////////////////////////////////

        public String modfica( String COD_EMPRESA,String NOM_EMPRESA,String CIF,String DIREC,String LOCALI,String CP,String TIP_JORNADA,String DNI_RESP,String NOM_RESP,String APELLIDO_RESP,String DNI_TUTOR,
                           String NOM_TUTOR,String APE_TUTOR,String MAIL_TUTOR,String TLF_TUTOR) throws SQLException{

        String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);

            String mod1 = "update empresa set NOM_EMPRESA='" + NOM_EMPRESA + "',CIF='" + CIF + "',DIREC='" + DIREC + "',LOCALI='" + LOCALI + "',CP='" + CP + "',TIP_JORNADA='" + TIP_JORNADA + "',DNI_RESP='" + DNI_RESP + "',NOM_RESP='" + NOM_RESP + "',APELLIDO_RESP='" + APELLIDO_RESP + "',DNI_TUTOR='" + DNI_TUTOR + "'" +
                    ",NOM_TUTOR='" + NOM_TUTOR + "',APE_TUTOR='" + APE_TUTOR + "',MAIL_TUTOR='" + MAIL_TUTOR + "',TLF_TUTOR='" + TLF_TUTOR + "' where COD_EMPRESA=" + COD_EMPRESA;

            encapsulaCons = conexBd.prepareStatement(mod1);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro Modificado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "Error, no has insertado los datos correctamente";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
    }
    //////////////////////////////////////////////////////////
    public String borra(String COD_EMPRESA) throws SQLException {

        String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);

            String mod1 = "delete from empresa where COD_EMPRESA=" + COD_EMPRESA;

            encapsulaCons = conexBd.prepareStatement(mod1);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro borrado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "Error, no has insertado los datos correctamente";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
    }

    /////////////////////////////////////////////////
    public ObservableList<emp> consulta() throws SQLException {
        ObservableList<emp> lista = FXCollections.observableArrayList();
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String mod1 = "SELECT * FROM empresa";
            encapsulaCons = conexBd.prepareStatement(mod1);
            ResultSet consul = encapsulaCons.executeQuery();

            emp empresa;

            while (consul.next()) {
                empresa = new emp(consul.getString("COD_EMPRESA"), consul.getString("NOM_EMPRESA"), consul.getString("CIF"),
                        consul.getString("LOCALI"),consul.getString("DIREC"), consul.getString("CP"), consul.getString("TIP_JORNADA"), consul.getString("DNI_RESP"),
                        consul.getString("NOM_RESP"),consul.getString("APELLIDO_RESP"),consul.getString("DNI_TUTOR"),
                        consul.getString("NOM_TUTOR"), consul.getString("APE_TUTOR"), consul.getString("MAIL_TUTOR"), consul.getString("TLF_TUTOR"));

                lista.add(empresa);
            }

        } catch (SQLException se) {
            System.out.println(se.getMessage());

        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return lista;
    }
    
   public String FicherosATabla() throws SQLException {
       String mensaje="";
        mensaje=ExtraerXML();
        mensaje=ExtraerBinario();
        return mensaje;
    }

    //Función para pasar a tabla los datos del fichero binario .dat
    public String ExtraerBinario() throws SQLException {
        String mensaje = null;
        try {
            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String insertData = "";
            /*Creamos al objeto alumno que recibirá cada objeto y lo añadirá a la lista, y que se
            empleará para pasar los s nuevo a una tabla de la base de datos.*/
            Alumno alumno = new Alumno();

            // Preparando el fichero que almacena los datos serializados
            fileInpStr = new FileInputStream("src/modelo/alumnos2CFS.dat");

            // Nos aseguramos de que la lista vuelve a estar vacía antes de volver a recuperar los objetos
            if (alumnos != null)
                alumnos.removeAll(alumnos);

            // Recorremos el fichero completo hasta que no quedan más Objetos que devolver.
            while (fileInpStr.available() > 0) {
                // Creación del flujo para la deserialización y poder recuperar todos los objetos.
                entrada = new ObjectInputStream(fileInpStr);
                //Casting imprescindible porque readObject() devuelve obviamente Object
                alumnos.add((Alumno) entrada.readObject()); // Guardamos cada Object en el ArrayList alumnos.
            }
            // Cerramos flujo abierto y fichero.
            entrada.close();
            fileInpStr.close();

            // Obtener datos de alumno y mostrar por pantalla.
            int i;
            int codigoAlumno = 0;
            String dniAlumno = null;
            String nombreAlumno = null;
            String apellidosAlumno = null;
            String fechaNacimiento = null;

            for (i = 0; i < alumnos.size(); i++) {
                Alumno currentalumno = (Alumno) alumnos.get(i);
                codigoAlumno = currentalumno.codigoAlumno;
                dniAlumno = currentalumno.DNI;
                nombreAlumno = currentalumno.nombre;
                apellidosAlumno = currentalumno.apellidos;
                fechaNacimiento = currentalumno.fechaNacimiento;

                insertData = "INSERT INTO alumnos VALUES('" + codigoAlumno + "','" + dniAlumno + "','" + nombreAlumno + "','" + apellidosAlumno + "','" + fechaNacimiento + "');";
                encapsulaCons = conexBd.prepareStatement(insertData);
                conexBd.setAutoCommit(false);
                encapsulaCons.executeQuery();
                conexBd.commit();

            }
            mensaje="Insertado correctamente";

        } catch (IOException ioe) {
        } catch (SQLException se) {
            mensaje="Archivos ya insertados...";

        } catch (ClassNotFoundException cnfe) {
            mensaje="Clase alumno no encontrada...";

        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();

            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
    }

    // Función para pasar los datos de tutoresDocentes desde un XML a una tabla de la BBDD.
    public String ExtraerXML() throws SQLException {
        // Creamos una referencia de tipo File para cargar el fichero XML existente
        File moviesFile = new File("src/modelo/tutoresSAFA.xml");
       String mensaje="";
        try {
            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String insertData = "";

            // Parsea el fichero y lo convierte de fichero a documento XML recorrible
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(moviesFile);
            // Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            doc.getDocumentElement().normalize();

            // Primero imprimimos y localizamos el elemento raíz.
            //System.out.println("\n========================");
            Element root = doc.getDocumentElement();
            //  System.out.println("Elemento raíz: " + root.getNodeName());

            // Creamos una lista donde insertamos el número de elementos con tag "pelicula" que cuelgan del raíz.
            NodeList list = doc.getElementsByTagName("tutordoc");
            // System.out.println("Número de nodos: " + list.getLength());
            //System.out.println("========================");

            // Mientras no se acabe de recorrer la longitud de la lista, va mostrando por pantalla los contenidos de cada elemento pelicula.
            for (int i = 0; i < list.getLength(); i++) {
                Node currentNode = list.item(i);

                //System.out.println("Película Nodo número " + (i+1));

                if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element currentElement = (Element) currentNode;

                    int codigo = Integer.parseInt(currentElement.getElementsByTagName("codtut").item(0).getTextContent());
                    String nombreApellidos = currentElement.getElementsByTagName("nomap").item(0).getTextContent();
                    String correo = currentElement.getElementsByTagName("correo").item(0).getTextContent();
                    String phone = currentElement.getElementsByTagName("telefono").item(0).getTextContent();

                    insertData = "INSERT INTO tutoresdocentes VALUES('" + codigo + "','" + nombreApellidos + "','" + correo + "','" + phone + "');";
                    encapsulaCons = conexBd.prepareStatement(insertData);
                    conexBd.setAutoCommit(false);
                    encapsulaCons.executeQuery();
                    conexBd.commit();
                    mensaje="insertado Correctamente";
                }
                
            }

        } catch (SQLException e) {/// poner mensaje
            System.out.println(e.getMessage());
            mensaje="Archivo ya insertados";
            

        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();

            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
    }
    
    public String borraAlum() throws SQLException{
         String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);

            String mod1 = "delete from alumnos";

            encapsulaCons = conexBd.prepareStatement(mod1);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro borrado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "Error";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
        
    }
    public String borraTut() throws SQLException{
         String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);

            String mod1 = "delete from tutoresdocentes";

            encapsulaCons = conexBd.prepareStatement(mod1);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro borrado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "Error";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
        
    }
      public String borraAsig() throws SQLException{
         String mensaje = "";
        try {

            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);

            String mod1 = "delete from asignados";

            encapsulaCons = conexBd.prepareStatement(mod1);
            conexBd.setAutoCommit(false);
            encapsulaCons.executeQuery();
            conexBd.commit();
            mensaje = "Registro borrado";
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            mensaje = "Error";
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } finally {
            if (encapsulaCons != null) {
                encapsulaCons.close();
            }
        }
        if (conexBd != null) {
            conexBd.close();
        }
        return mensaje;
        
    }
    
    //////////////////////////////////////////////////////combos

    public ObservableList<String> rellenaCombalum() throws SQLException {
        ObservableList<String> comb = FXCollections.observableArrayList();
        try {
            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String Empresa_Alumno_Tutor = " SELECT * FROM alumnos;";
            encapsulaCons = conexBd.prepareStatement(Empresa_Alumno_Tutor);
            ResultSet resulCons = encapsulaCons.executeQuery();
            while (resulCons.next()) {
                //ComboAlumno.addItem(resulCons.getString("Apellidos") + ", " + resulCons.getString("Nombre"));
                comb.add(resulCons.getString("Apellidos") + ", " + resulCons.getString("Nombre"));
            }
        } catch (SQLException |
                ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
        return comb;
    }

    //Añadimos el nombre de la empresa al JcomboBox
    public ObservableList<String> rellenaCombempre() throws SQLException {
        ObservableList<String> comb = FXCollections.observableArrayList();
        try {
            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String Empresa_Alumno_Tutor = " SELECT * FROM empresa;";
            encapsulaCons = conexBd.prepareStatement(Empresa_Alumno_Tutor);
            encapsulaCons.executeQuery();
            ResultSet resulCons = encapsulaCons.executeQuery();
            while (resulCons.next()) {
                //ComboEmpresa.addItem(resulCons.getString("NOM_EMPRESA"));
                comb.add(resulCons.getString("NOM_EMPRESA"));
            }
        } catch (SQLException |
                ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
        return comb;
    }


    //Añadimos el nombre y el apellido del Tutor al JcomboBox


    public ObservableList<String> rellenaCombtut() throws SQLException {
        ObservableList<String> comb = FXCollections.observableArrayList();
        try {
            Class.forName(ADD_DRIVER);
            conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
            String Empresa_Alumno_Tutor = " SELECT * FROM tutoresdocentes;";
            encapsulaCons = conexBd.prepareStatement(Empresa_Alumno_Tutor);
            ResultSet resulCons = encapsulaCons.executeQuery();
            while (resulCons.next()) {
                //ComboTutor.addItem(resulCons.getString("NombreApellido"));
                comb.add(resulCons.getString("NombreApellido"));
            }
        } catch (SQLException |
                ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
        return comb;
    }

    public String texto( String Nombrealum, String Nombreempre, String Nombretutor) throws SQLException {
        String varitext = null;
     try

    {
        //Para recoger solo el nombre del alumno del JcomboBox seleccionado. Sirve para coger su codigo de alumno.
        int inicio = Nombrealum.indexOf(", ");
        String NombreCompl = Nombrealum.substring(inicio + 2);


        Class.forName(ADD_DRIVER);
        conexBd = DriverManager.getConnection(URL_CONEXION, usuario, contrasenia);
        //Seleccionamos los datos que queremos de la tabla que queremos y el nombre del alumno tiene que ser el mismo al seleccionado en el JcomboBox.
        String COMPTutor = " SELECT NOM_TUTOR, APE_TUTOR,codigo FROM empresa, alumnos WHERE NOM_EMPRESA = '" + Nombreempre + "' AND Nombre = '" + NombreCompl + "';";
        encapsulaCons = conexBd.prepareStatement(COMPTutor);
        ResultSet resulCons = encapsulaCons.executeQuery();
        String Num = "";
        while (resulCons.next()) {
            //Recoge los datos del select y creamos el texto resultado final
            String Nmb = resulCons.getString("NOM_TUTOR");
            String ape = resulCons.getString("APE_TUTOR");
            Num = resulCons.getString("Codigo");
            //Resultado.setText("El alumno " + Nombrealum + " queda asignado a la empresa " + Nombreempre + " supervisados por los tutores " + Nombretutor + " (docente) y " + Nmb + " " + ape + " (laboral).");
             varitext="El alumno " + Nombrealum + "\n queda asignado a la empresa " + Nombreempre + " " +
                     " supervisados por los tutores\n " + Nombretutor + " (docente) y\n " + Nmb + " " + ape + " (laboral).";

        }
        //Recogemos el Texto del resultado final y lo transformamos en un String
      //  String FinalResult = varitext.getText();

        //Insertamos el codigo del alumno y el resultado final a la tabla de Alumnos Asignados
        String insert = "INSERT INTO asignados VALUES (" + Num + ", '" + varitext + "');";
        conexBd.setAutoCommit(false);
        encapsulaCons = conexBd.prepareStatement(insert);
        encapsulaCons.executeQuery();
        //encapsulaCons.executeUpdate(insert);
        conexBd.commit();
        conexBd.close();
    } catch(SQLException |
    ClassNotFoundException se)
    {
        System.out.println(se.getMessage());
        varitext="\tEl alumno ya está asginado";
    }finally{
         conexBd.close();
     }
     
    return varitext;
}

    public void ayuda(){
        Help help =new Help();
        help.setVisible(true);
    }
}