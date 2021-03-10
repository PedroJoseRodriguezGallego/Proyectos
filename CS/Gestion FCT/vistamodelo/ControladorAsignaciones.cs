using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using System.Windows;
using Gestion_FCT.modelo;
using MySqlConnector;

namespace Gestion_FCT.vistamodelo
{
    class ControladorAsignaciones
    {
        private Conexion conexion;

        public ControladorAsignaciones()
        {
            this.conexion = new Conexion();
        }

        public int insertarAsignacion(Asignacion nueva)
        {
            int insertadas = 0;
            try
            {
                conexion.setCmd("INSERT INTO asignados VALUES (@IdAlumno, @IdEmpresa, @IdTutor);");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("IdAlumno", nueva.IdAlumno);
                cmd.Parameters.AddWithValue("IdEmpresa", nueva.IdEmpresa);
                cmd.Parameters.AddWithValue("IdTutor", nueva.IdTutor);
                insertadas = cmd.ExecuteNonQuery();
                conexion.desconectarBD();
            } catch (Exception)
            {
                conexion.desconectarBD();
                insertadas = 0;
            }
            return insertadas;
        }

        public int eliminarAsignacion(Asignacion eliminada)
        {
            int eliminadas = 0;
            try
            {
                conexion.setCmd("DELETE FROM asignados WHERE CodigoAlumno = @IdAlumno AND CodEmpresa = @IdEmpresa AND CodigoTutor = @IdTutor;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("IdAlumno", eliminada.IdAlumno);
                cmd.Parameters.AddWithValue("IdEmpresa", eliminada.IdEmpresa);
                cmd.Parameters.AddWithValue("IdTutor", eliminada.IdTutor);
                eliminadas = cmd.ExecuteNonQuery();
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                eliminadas = 0;
            }
            return eliminadas;
        }

        public List<string> rellenarDesplegables(string sql)
        {
            List<string> datos = new List<string>();
            try
            {
                conexion.setCmd(sql);
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                MySqlDataReader lector = cmd.ExecuteReader();
                datos.Add("--");
                while (lector.Read())
                {
                    datos.Add(lector.GetString(0));
                }
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                datos = new List<string>();
            }
            return datos;
        }

        public DataTable listarAsignaciones()
        {
            DataTable datos = new DataTable();
            conexion.setCmd("SELECT CONCAT(a.CodigoAlumno, ' - ', al.Nombre, ' ', al.Apellidos) 'Alumno', CONCAT(a.CodEmpresa, ' - ', e.Nombre) 'Empresa', CONCAT(a.CodigoTutor, ' - ', t.NomAp) 'Tutor docente' FROM asignados a JOIN alumnos al ON a.CodigoAlumno = al.CodigoAlumno JOIN empresas e ON a.CodEmpresa = e.CodEmpresa JOIN tutoresdocentes t ON a.CodigoTutor = t.CodigoTutor");
            conexion.conectarBD();
            MySqlCommand cmd = conexion.getCmd();
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            da.Fill(datos);
            conexion.desconectarBD();
            return datos;
        }

        public Boolean comprobarAsignado(int id)
        {
            Boolean asignado = false;
            try
            {
                conexion.setCmd("SELECT CodigoAlumno FROM asignados");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    if (lector.GetInt32(0) == id)
                    {
                        asignado = true;
                        break;
                    }
                }
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                asignado = false;
            }
            return asignado;
        }
    }
}
