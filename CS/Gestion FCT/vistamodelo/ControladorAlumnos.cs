using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using System.Windows;
using Gestion_FCT.modelo;
using MySqlConnector;

namespace Gestion_FCT.vistamodelo
{
    class ControladorAlumnos
    {
        private Conexion conexion;

        public ControladorAlumnos()
        {
            this.conexion = new Conexion();
        }

        public int insertarAlumno(Alumno nuevo)
        {
            int insertadas = 0;
            try
            {
                conexion.setCmd("INSERT INTO alumnos VALUES (@Id, @Dni, @Nombre, @Apellidos, @FechaNac);");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("Id", nuevo.IdAlumno);
                cmd.Parameters.AddWithValue("Dni", nuevo.Dni);
                cmd.Parameters.AddWithValue("Nombre", nuevo.Nombre);
                cmd.Parameters.AddWithValue("Apellidos", nuevo.Apellidos);
                cmd.Parameters.AddWithValue("FechaNac", nuevo.FechaNac);
                insertadas = cmd.ExecuteNonQuery();
                conexion.desconectarBD();
            } catch (Exception)
            {
                conexion.desconectarBD();
                insertadas = 0;
            }
            return insertadas;
        }

        public int modificarAlumno(Alumno nuevo)
        {
            int modificadas = 0;
            try
            {
                conexion.setCmd("UPDATE alumnos SET DNI = @Dni, Nombre = @Nombre, Apellidos = @Apellidos, FechaNac = @FechaNac WHERE CodigoAlumno = @Id;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("Id", nuevo.IdAlumno);
                cmd.Parameters.AddWithValue("Dni", nuevo.Dni);
                cmd.Parameters.AddWithValue("Nombre", nuevo.Nombre);
                cmd.Parameters.AddWithValue("Apellidos", nuevo.Apellidos);
                cmd.Parameters.AddWithValue("FechaNac", nuevo.FechaNac);
                modificadas = cmd.ExecuteNonQuery();
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                modificadas = 0;
            }
            return modificadas;
        }

        public int eliminarAlumno(int idEliminado)
        {
            int eliminadas = 0;
            try
            {
                conexion.setCmd("DELETE FROM alumnos WHERE CodigoAlumno = @Id;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("Id", idEliminado);
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

        public Alumno consultarAlumno(int id)
        {
            Alumno consultado = new Alumno();
            try
            {
                conexion.setCmd("SELECT * FROM alumnos WHERE CodigoAlumno = @idAlumno;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("idAlumno", id.ToString());
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    consultado.IdAlumno = lector.GetInt32(0);
                    consultado.Dni = lector.GetString(1);
                    consultado.Nombre = lector.GetString(2);
                    consultado.Apellidos = lector.GetString(3);
                    consultado.FechaNac = (DateTime) lector.GetValue(4);
                }
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                consultado = new Alumno();
            }
            return consultado;
        }

        public int sacaUltimoId()
        {
            int id = 0;
            try
            {
                conexion.setCmd("SELECT * FROM alumnos;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    id = lector.GetInt32(0);
                    lector.GetString(1);
                    lector.GetString(2);
                    lector.GetString(3);
                    lector.GetValue(4);
                }
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                id = 0;
            }
            return id;
        }

        public DataTable listarAlumnos()
        {
            DataTable datos = new DataTable();
            conexion.setCmd("SELECT CodigoAlumno 'ID Alumno', DNI, Nombre, Apellidos, DATE_FORMAT(FechaNac, '%d-%m-%Y') 'Fecha de nacimiento' FROM alumnos;");
            conexion.conectarBD();
            MySqlCommand cmd = conexion.getCmd();
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            da.Fill(datos);
            conexion.desconectarBD();
            return datos;
        }

        public Boolean comprobarAlumno(int id)
        {
            Boolean existe = false;
            try
            {
                conexion.setCmd("SELECT CodigoAlumno FROM alumnos");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    if (lector.GetInt32(0) == id)
                    {
                        existe = true;
                        break;
                    }
                }
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                existe = false;
            }
            return existe;
        }
    }
}
