using Gestion_FCT.modelo;
using MySqlConnector;
using System;
using System.Collections.Generic;
using System.Data;
using System.Text;

namespace Gestion_FCT.vistamodelo
{
    class ControladorEmpresas
    {
        private Conexion conexion;

        public ControladorEmpresas()
        {
            this.conexion = new Conexion();
        }

        public int insertarEmpresa(Empresa nueva)
        {
            int insertadas = 0;
            try
            {
                conexion.setCmd("INSERT INTO empresas VALUES(@CodEmpresa, @Nombre, @CIF, @Direccion, @CP, @Localidad, " +
                                "@TipoJornada, @DNIResp, @NombreResp, @ApellidosResp, @DNITL, @NombreTL, @ApellidosTL, " +
                                "@EmailTL, @TelefonoTL);");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("CodEmpresa", nueva.IdEmpresa);
                cmd.Parameters.AddWithValue("Nombre", nueva.Nombre);
                cmd.Parameters.AddWithValue("CIF", nueva.Cif);
                cmd.Parameters.AddWithValue("Direccion", nueva.Direccion);
                cmd.Parameters.AddWithValue("CP", nueva.Cp);
                cmd.Parameters.AddWithValue("Localidad", nueva.Localidad);
                cmd.Parameters.AddWithValue("TipoJornada", nueva.TipoJornada);
                cmd.Parameters.AddWithValue("DNIResp", nueva.DniResponsable);
                cmd.Parameters.AddWithValue("NombreResp", nueva.NombreResponsable);
                cmd.Parameters.AddWithValue("ApellidosResp", nueva.ApellidosResponsable);
                cmd.Parameters.AddWithValue("DNITL", nueva.DniTutorLaboral);
                cmd.Parameters.AddWithValue("NombreTL", nueva.NombreTutorLaboral);
                cmd.Parameters.AddWithValue("ApellidosTL", nueva.ApellidosTutorLaboral);
                cmd.Parameters.AddWithValue("EmailTL", nueva.EmailTutorLaboral);
                cmd.Parameters.AddWithValue("TelefonoTL", nueva.TelefonoTutorLaboral);
                insertadas = cmd.ExecuteNonQuery();
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                insertadas = 0;
            }
            return insertadas;
        }

        public int modificarEmpresa(Empresa nueva)
        {
            int modificadas = 0;
            try
            {
                conexion.setCmd("UPDATE empresas SET Nombre = @Nombre, CIF = @CIF, Direccion = @Direccion, CP = @CP, Localidad = @Localidad, " +
                                "TipoJornada = @TipoJornada, DNIResp = @DNIResp, NombreResp = @NombreResp, ApellidosResp = @ApellidosResp, " +
                                "DNITL = @DNITL, " + "NombreTL = @NombreTL, ApellidosTL = @ApellidosTL, " + "EmailTL = @EmailTL, " +
                                "TelefonoTL = @TelefonoTL WHERE CodEmpresa = @CodEmpresa;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("Nombre", nueva.Nombre);
                cmd.Parameters.AddWithValue("CIF", nueva.Cif);
                cmd.Parameters.AddWithValue("Direccion", nueva.Direccion);
                cmd.Parameters.AddWithValue("CP", nueva.Cp);
                cmd.Parameters.AddWithValue("Localidad", nueva.Localidad);
                cmd.Parameters.AddWithValue("TipoJornada", nueva.TipoJornada);
                cmd.Parameters.AddWithValue("DNIResp", nueva.DniResponsable);
                cmd.Parameters.AddWithValue("NombreResp", nueva.NombreResponsable);
                cmd.Parameters.AddWithValue("ApellidosResp", nueva.ApellidosResponsable);
                cmd.Parameters.AddWithValue("DNITL", nueva.DniTutorLaboral);
                cmd.Parameters.AddWithValue("NombreTL", nueva.NombreTutorLaboral);
                cmd.Parameters.AddWithValue("ApellidosTL", nueva.ApellidosTutorLaboral);
                cmd.Parameters.AddWithValue("EmailTL", nueva.EmailTutorLaboral);
                cmd.Parameters.AddWithValue("TelefonoTL", nueva.TelefonoTutorLaboral);
                cmd.Parameters.AddWithValue("CodEmpresa", nueva.IdEmpresa);
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

        public int eliminarEmpresa(int idEliminado)
        {
            int eliminadas = 0;
            try
            {
                conexion.setCmd("DELETE FROM empresas WHERE CodEmpresa = @CodEmpresa;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("CodEmpresa", idEliminado);
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

        public Empresa consultarEmpresa(int id)
        {
            Empresa consultada = new Empresa();
            try
            {
                conexion.setCmd("SELECT * FROM empresas WHERE CodEmpresa = @idEmpresa;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                cmd.Parameters.AddWithValue("idEmpresa", id.ToString());
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    consultada.IdEmpresa = lector.GetInt32(0);
                    consultada.Nombre = lector.GetString(1);
                    consultada.Cif = lector.GetString(2);
                    consultada.Direccion = lector.GetString(3);
                    consultada.Cp = lector.GetString(4);
                    consultada.Localidad = lector.GetString(5);
                    consultada.TipoJornada = lector.GetString(6);
                    consultada.DniResponsable = lector.GetString(7);
                    consultada.NombreResponsable = lector.GetString(8);
                    consultada.ApellidosResponsable = lector.GetString(9);
                    consultada.DniTutorLaboral = lector.GetString(10);
                    consultada.NombreTutorLaboral = lector.GetString(11);
                    consultada.ApellidosTutorLaboral = lector.GetString(12);
                    consultada.EmailTutorLaboral = lector.GetString(13);
                    consultada.TelefonoTutorLaboral = lector.GetString(14);
                }
                conexion.desconectarBD();
            }
            catch (Exception)
            {
                conexion.desconectarBD();
                consultada = new Empresa();
            }
            return consultada;
        }

        public int sacaUltimoId()
        {
            int id = 0;
            try
            {
                conexion.setCmd("SELECT * FROM empresas;");
                conexion.conectarBD();
                MySqlCommand cmd = conexion.getCmd();
                MySqlDataReader lector = cmd.ExecuteReader();
                while (lector.Read())
                {
                    id = lector.GetInt32(0);
                    lector.GetString(1);
                    lector.GetString(2);
                    lector.GetString(3);
                    lector.GetString(4);
                    lector.GetString(5);
                    lector.GetString(6);
                    lector.GetString(7);
                    lector.GetString(8);
                    lector.GetString(9);
                    lector.GetString(10);
                    lector.GetString(11);
                    lector.GetString(12);
                    lector.GetString(13);
                    lector.GetString(14);
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

        public DataTable listarEmpresas()
        {
            DataTable datos = new DataTable();
            conexion.setCmd("SELECT CodEmpresa 'ID Empresa', Nombre, CIF, Direccion 'Dirección', CP, Localidad, TipoJornada 'Jornada', DNIResp 'DNI Responsable'," +
                "NombreResp 'Nombre Responsable', ApellidosResp 'Apellidos Responsable', DNITL 'DNI Tutor Laboral', NombreTL 'Nombre Tutor Laboral', ApellidosTL" +
                " 'Apellidos Tutor Laboral', EmailTL 'Email Tutor Laboral', TelefonoTL 'Teléfono Tutor Laboral' FROM empresas;");
            conexion.conectarBD();
            MySqlCommand cmd = conexion.getCmd();
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            da.Fill(datos);
            conexion.desconectarBD();
            return datos;
        }

        public Boolean comprobarEmpresa(int id)
        {
            Boolean existe = false;
            try
            {
                conexion.setCmd("SELECT CodEmpresa FROM empresas");
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
