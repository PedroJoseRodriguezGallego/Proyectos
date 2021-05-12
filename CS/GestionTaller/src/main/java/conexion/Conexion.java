/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pedro
 */
public class Conexion 
{
    static String bd = "proyectoreportespjrg";
    static String login = "pjrg";
    static String password = "pjrg";
    static String url = "jdbc:mysql://localhost:3306/" + bd + "?serverTimezone=UTC";

    Connection connection = null;
   
   
    public Conexion()
    {
         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(url,login,password);
         }
             catch(Exception e)
             {
                System.out.println(e);
             }
    }
   
   
    public Connection getConnection() //Crea la conexion con la BBDD
    {
        return connection;
    }

    public void desconectar() // Cierra la conexion con la BBDD
    {
        connection = null;
    }
}