using System;
using System.Collections.Generic;
using System.Text;

namespace Gestion_FCT.modelo
{
    class Tutor
    {
        private int idTutor;
        private string nombreApellidos;
        private string email;
        private string telefono;

        public int IdTutor { get; set; }
        public string NombreApellidos { get; set; }
        public string Email { get; set; }
        public string Telefono { get; set; }

        public Tutor() {}

        public Tutor(int idTutor, string nombreApellidos, string email, string telefono)
        {
            this.IdTutor = idTutor;
            this.NombreApellidos = nombreApellidos;
            this.Email = email;
            this.Telefono = telefono;
        }
    }
}
