using System;
using System.Collections.Generic;
using System.Text;

namespace Gestion_FCT.modelo
{
    class Asignacion
    {
        private int idAlumno;
        private int idEmpresa;
        private int idTutor;

        public int IdAlumno { get; set; }
        public int IdEmpresa { get; set; }
        public int IdTutor { get; set; }

        public Asignacion() {}

        public Asignacion(int idAlumno, int idEmpresa, int idTutor)
        {
            this.IdAlumno = idAlumno;
            this.IdEmpresa = idEmpresa;
            this.IdTutor = idTutor;
        }
    }
}
