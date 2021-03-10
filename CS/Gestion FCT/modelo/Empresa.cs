using System;
using System.Collections.Generic;
using System.Text;

namespace Gestion_FCT.modelo
{

    class Empresa
    {

        private int idEmpresa;
        private string nombre;
        private string cif;
        private string direccion;
        private string cp;
        private string localidad;
        private string tipoJornada;
        private string dniResponsable;
        private string nombreResponsable;
        private string apellidosResponsable;
        private string dniTutorLaboral;
        private string nombreTutorLaboral;
        private string apellidosTutorLaboral;
        private string emailTutorLaboral;
        private string telefonoTutorLaboral;

        public int IdEmpresa { get; set; }
        public string Nombre { get; set; }
        public string Cif { get; set; }
        public string Direccion { get; set; }
        public string Cp { get; set; }
        public string Localidad { get; set; }
        public string TipoJornada { get; set; }
        public string DniResponsable { get; set; }
        public string NombreResponsable { get; set; }
        public string ApellidosResponsable { get; set; }
        public string DniTutorLaboral { get; set; }
        public string NombreTutorLaboral { get; set; }
        public string ApellidosTutorLaboral { get; set; }
        public string EmailTutorLaboral { get; set; }
        public string TelefonoTutorLaboral { get; set; }

        public Empresa() {}

        public Empresa(int idEmpresa, string nombre, string cif, string direccion, string cp,
            string localidad, string tipoJornada, string dniResponsable, string nombreResponsable, string apellidosResponsable,
            string dniTutorLaboral, string nombreTutorLaboral, string apellidosTutorLaboral, string emailTutorLaboral, string telefonoTutorLaboral)
        {
            this.IdEmpresa = idEmpresa;
            this.Nombre = nombre;
            this.Cif = cif;
            this.Direccion = direccion;
            this.Cp = cp;
            this.Localidad = localidad;
            this.TipoJornada = tipoJornada;
            this.DniResponsable = dniResponsable;
            this.NombreResponsable = nombreResponsable;
            this.ApellidosResponsable = apellidosResponsable;
            this.DniTutorLaboral = dniTutorLaboral;
            this.NombreTutorLaboral = nombreTutorLaboral;
            this.ApellidosTutorLaboral = apellidosTutorLaboral;
            this.EmailTutorLaboral = emailTutorLaboral;
            this.TelefonoTutorLaboral = telefonoTutorLaboral;
        }
    }
}
