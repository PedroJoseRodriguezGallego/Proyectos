/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import vo.Trabajo;

/**
 *
 * @author Pedro
 */
public class TrabajoDAO 
{
        public ArrayList<Trabajo> buscarTrabajos()
    {
	Conexion conexion = new Conexion();
	ArrayList<Trabajo> lista = new ArrayList<Trabajo>();
	Trabajo trabajo;
        
	try 
        {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM trabajos");

            while(rs.next())
            {
		trabajo = new Trabajo();
                
		trabajo.setId_trabajo(rs.getInt("IDTrabajo"));
                trabajo.setDescripcion(rs.getString("Descripcion"));
                trabajo.setHoras(rs.getInt("Horas"));
                trabajo.setPrecio(rs.getDouble("Precio"));
                trabajo.setCoste(rs.getDouble("Coste"));
                trabajo.setReparacionesMecanicas(rs.getInt("ReparacionesMecanicas"));
                trabajo.setReparacionesChapistas(rs.getInt("ReparacionesChapistas"));
                trabajo.setReparacionesRevisiones(rs.getInt("ReparacionesRevisiones"));
                trabajo.setFechaInicio(rs.getString("FechaInicio"));
                trabajo.setFechaFin(rs.getString("FechaFin"));
                trabajo.setId_operario(rs.getInt("IDOperario"));

		lista.add(trabajo);
            }
            
            rs.close();
            st.close();
            conexion.desconectar();
	} 
            catch (SQLException e) 
            {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al consultar", "Error",JOptionPane.ERROR_MESSAGE);
            }
        
	return lista;
    }
    
    
    
    public ArrayList<Trabajo> buscarTrabajoConcreto(int id)
    {
	Conexion conexion = new Conexion();
	ArrayList<Trabajo> lista = new ArrayList<Trabajo>();
	Trabajo trabajo;
        
	try 
        {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM trabajos WHERE IDTrabajo = " + id);

            while (rs.next()) 
            {
		trabajo = new Trabajo();
                
		trabajo.setId_trabajo(rs.getInt("IDTrabajo"));
                trabajo.setDescripcion(rs.getString("Descripcion"));
                trabajo.setHoras(rs.getInt("Horas"));
                trabajo.setPrecio(rs.getDouble("Precio"));
                trabajo.setCoste(rs.getDouble("Coste"));
                trabajo.setReparacionesMecanicas(rs.getInt("ReparacionesMecanicas"));
                trabajo.setReparacionesChapistas(rs.getInt("ReparacionesChapistas"));
                trabajo.setReparacionesRevisiones(rs.getInt("ReparacionesRevisiones"));
                trabajo.setFechaInicio(rs.getString("FechaInicio"));
                trabajo.setFechaFin(rs.getString("FechaFin"));
                trabajo.setId_operario(rs.getInt("IDOperario"));

		lista.add(trabajo);
            }
            
            rs.close();
            st.close();
            conexion.desconectar();
	} 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        
	return lista;
    }
    
    
    
    public void insertarTrabajo(JTextField IDTrabajo, JTextArea descripcion, JSpinner horas, JTextField precio, JSpinner reparacionesMecanicas, JSpinner reparacionesChapistas, JSpinner reparacionesRevisiones, JTextField fechaInicio, JTextField IDOperario)
    {
        Conexion conexion = new Conexion();
        
        try
        {
            PreparedStatement pst = conexion.getConnection().prepareStatement("INSERT INTO trabajos (IDTrabajo, Descripcion, Horas, Precio, Coste, ReparacionesMecanicas, ReparacionesChapistas, ReparacionesRevisiones, FechaInicio, FechaFin, IDOperario) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setInt(1,Integer.parseInt(IDTrabajo.getText()));
            pst.setString(2,descripcion.getText());
            pst.setInt(3,(Integer) horas.getValue());
            pst.setDouble(4,Integer.parseInt(precio.getText()));
            pst.setDouble(5, obtenerCoste((Integer) horas.getValue(), Integer.parseInt(precio.getText()),(Integer) reparacionesRevisiones.getValue(),(Integer) reparacionesMecanicas.getValue(),(Integer) reparacionesChapistas.getValue())); //Coste
            pst.setInt(6,(Integer) reparacionesMecanicas.getValue());
            pst.setInt(7,(Integer) reparacionesChapistas.getValue());
            pst.setInt(8,(Integer) reparacionesRevisiones.getValue());
            pst.setString(9,fechaInicio.getText());
            pst.setString(10, obtenerFechaFin()); //FechaFin
            pst.setInt(11,Integer.parseInt(IDOperario.getText()));
            
            int resultado = pst.executeUpdate();
            if(resultado != 1)
            {
                System.out.println("Registro no insertado");
            }
            conexion.desconectar();
        }
            catch (Exception e) 
            {
                System.out.println("Error al insertar");
            }
    }
    
    
    
    public void eliminarTrabajo(JTextField IDTrabajo, JTextArea descripcion, JSpinner horas, JTextField precio, JSpinner reparacionesMecanicas, JSpinner reparacionesChapistas, JSpinner reparacionesRevisiones, JTextField fechaInicio, JTextField IDOperario, JTextField DNIOperario, JTextField fechaFin)
    {
        Conexion conexion = new Conexion();
        
        try
        {
            PreparedStatement pst = conexion.getConnection().prepareStatement("DELETE FROM trabajos WHERE IDTrabajo = ?");
            
            pst.setInt(1,Integer.parseInt(IDTrabajo.getText()));

            IDTrabajo.setText(null);
            descripcion.setText(null);
            horas.setValue(0);
            precio.setText(null);
            reparacionesMecanicas.setValue(0);
            reparacionesChapistas.setValue(0);
            reparacionesRevisiones.setValue(0);
            fechaInicio.setText(null);
            IDOperario.setText(null);
            DNIOperario.setText(null);
            fechaFin.setText(null);
            
            int resultado = pst.executeUpdate();
            if(resultado != 1)
            {
                System.out.println("Registro no eliminado");
            }
            conexion.desconectar();
        }
            catch (Exception e) 
            {
                System.out.println("Error al eliminar");
            }
    }
    
    
    
    public void modificarTrabajo(JTextField IDTrabajo, JTextArea descripcion, JSpinner horas, JTextField precio, JSpinner reparacionesMecanicas, JSpinner reparacionesChapistas, JSpinner reparacionesRevisiones, JTextField fechaInicio, JTextField IDOperario)
    {
        Conexion conexion = new Conexion();
        
        try
        {
            PreparedStatement pst = conexion.getConnection().prepareStatement("UPDATE trabajos SET Descripcion = ?, Horas = ?, Precio = ?, Coste = ?, ReparacionesMecanicas = ?, ReparacionesChapistas = ?, ReparacionesRevisiones = ?, FechaInicio = ?, FechaFin = ?, IDOperario = ? WHERE IDTrabajo = ?");
            
            pst.setString(1,descripcion.getText());
            pst.setInt(2,(Integer) horas.getValue());
            pst.setDouble(3,Integer.parseInt(precio.getText()));
            pst.setDouble(4, obtenerCoste((Integer) horas.getValue(), Integer.parseInt(precio.getText()),(Integer) reparacionesRevisiones.getValue(),(Integer) reparacionesMecanicas.getValue(),(Integer) reparacionesChapistas.getValue())); //Coste
            pst.setInt(5,(Integer) reparacionesMecanicas.getValue());
            pst.setInt(6,(Integer) reparacionesChapistas.getValue());
            pst.setInt(7,(Integer) reparacionesRevisiones.getValue());
            pst.setString(8,fechaInicio.getText());
            pst.setString(9, obtenerFechaFin()); //FechaFin
            pst.setInt(10,Integer.parseInt(IDOperario.getText()));
            pst.setInt(11,Integer.parseInt(IDTrabajo.getText()));
            
            int resultado = pst.executeUpdate();
            if(resultado != 1)
            {
                System.out.println("Registro no modificado");
            }
            
            conexion.desconectar();
        }
            catch (Exception e) 
            {
                System.out.println("Error al modificar");
            }
    }
    
    
    
    public double obtenerCoste(int horas, int material, int revisiones, int mecanicos, int chapas)
    {
        double fijo = horas*30;
        double precioMecanico = 0;
        double precioChapa = 0;
        double precioRevision = 0;
        
        if(revisiones != 0 )
        {
            precioRevision = 20;
        }
        
        if(mecanicos != 0 )
        {
            precioMecanico = material * 1.5;
        }
        
        if(chapas != 0 )
        {
            precioChapa = material * 2;
        }
        
        double resultado = fijo + precioMecanico + precioChapa + precioRevision;
        return resultado;
    }
    
    
    
    public String obtenerFechaFin() //Fecha actual del ordenador aaaa-mm-dd
    {
        Calendar calendario = new GregorianCalendar();
        
        String dia = Integer.toString(calendario.get(Calendar.DATE));
        String mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
        String anio = Integer.toString(calendario.get(Calendar.YEAR));
        
        return anio+"-"+mes+"-"+dia;
    }
}