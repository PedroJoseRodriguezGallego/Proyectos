using System;
using System.Collections.Generic;
using System.Text;

namespace Gestion_FCT.modelo
{
    class Alumno
    {
        private int idAlumno;
        private string dni;
        private string nombre;
        private string apellidos;
        private DateTime fechaNac;

        public int IdAlumno { get; set; }
        public string Dni { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public DateTime FechaNac { get; set; }

        public Alumno() {}

        public Alumno(int idAlumno, string dni, string nombre, string apellidos, DateTime fechaNac)
        {
            this.IdAlumno = idAlumno;
            this.Dni = dni;
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.FechaNac = fechaNac;
        }
    }
}
