using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using Gestion_FCT.modelo;
using MySqlConnector;

namespace Gestion_FCT.vistamodelo
{
    class ControladorTutores
    {
        private Conexion conexion;

        public ControladorTutores()
        {
            this.conexion = new Conexion();
        }

        public int insertarTutor(Tutor nuevo)
        {
            int insertadas = 0;
            try
            {
                conexion.setCmd("INSERT INTO tutoresdocentes VALUES (@Id, @NombreApellidos, @Email, @Telefono);");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("Id", nuevo.IdTutor);
                cmd.Parameters.AddWithValue("NombreApellidos", nuevo.NombreApellidos);
                cmd.Parameters.AddWithValue("Email", nuevo.Email);
                cmd.Parameters.AddWithValue("Telefono", nuevo.Telefono);
                insertadas = cmd.ExecuteNonQuery();
                conexion.desconectarBD();
            } catch (Exception)
            {
                conexion.desconectarBD();
                insertadas = 0;
            }
            return insertadas;
        }

        public int modificarTutor(Tutor nuevo)
        {
            int modificadas = 0;
            try
            {
                conexion.setCmd("UPDATE tutoresdocentes SET NomAp = @NombreApellidos, EmailTD = @Email, TelefonoTD = @Telefono WHERE CodigoTutor = @Id;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("Id", nuevo.IdTutor);
                cmd.Parameters.AddWithValue("NombreApellidos", nuevo.NombreApellidos);
                cmd.Parameters.AddWithValue("Email", nuevo.Email);
                cmd.Parameters.AddWithValue("Telefono", nuevo.Telefono);
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

        public int eliminarTutor(int idEliminado)
        {
            int eliminadas = 0;
            try
            {
                conexion.setCmd("DELETE FROM tutoresdocentes WHERE CodigoTutor = @Id;");
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

        public Tutor consultarTutor(int id)
        {
            Tutor consultado = new Tutor();
            try
            {
                conexion.setCmd("SELECT * FROM tutoresdocentes WHERE CodigoTutor = @idTutor;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("idTutor", id.ToString());
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    consultado.IdTutor = lector.GetInt32(0);
                    consultado.NombreApellidos = lector.GetString(1);
                    consultado.Email = lector.GetString(2);
                    consultado.Telefono = lector.GetString(3);
                }
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                consultado = new Tutor();
            }
            return consultado;
        }

        public int sacaUltimoId()
        {
            int id = 0;
            try
            {
                conexion.setCmd("SELECT * FROM tutoresdocentes;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    id = lector.GetInt32(0);
                    lector.GetString(1);
                    lector.GetString(2);
                    lector.GetString(3);
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

        public DataTable listarTutores()
        {
            DataTable datos = new DataTable();
            conexion.setCmd("SELECT CodigoTutor 'ID Tutor', NomAp 'Nombre y apellidos', EmailTD 'Email', TelefonoTD 'Teléfono' FROM tutoresdocentes;");
            conexion.conectarBD();
            MySqlCommand cmd = conexion.getCmd();
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            da.Fill(datos);
            conexion.desconectarBD();
            return datos;
        }

        public Boolean comprobarTutor(int id)
        {
            Boolean existe = false;
            try
            {
                conexion.setCmd("SELECT CodigoTutor FROM tutoresdocentes");
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
