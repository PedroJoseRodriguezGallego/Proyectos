using System;
using Xunit;
using Gestion_FCT.vistamodelo;
using Gestion_FCT.modelo;

namespace xUnit_FCT_E2
{
    public class Tests
    {
        ControladorAlumnos controladorAlumno = new ControladorAlumnos();
        ControladorEmpresas controladorEmpresa = new ControladorEmpresas();
        ControladorTutores controladorTutores = new ControladorTutores();

        [Fact]
        public void TestInsertarAlumno()
        {
            Alumno alumno = new Alumno(14, "20229530H", "Paco", "Sanz", new DateTime());
            Assert.Equal(1, controladorAlumno.insertarAlumno(alumno));
        }

        [Fact]
        public void TestModificarTutor()
        {
            Tutor tutor = new Tutor(1, "Prudencio Ruiz Gongora", "pruizgongora@gmail.com", "657787765");
            Assert.Equal(1, controladorTutores.modificarTutor(tutor));
        }

        [Fact]
        public void TestEliminarEmpresa()
        {
            Assert.Equal(1, controladorEmpresa.eliminarEmpresa(3));
        }

        [Fact]
        public void TestConsultarTutorDocente()
        {
            Assert.Equal("Prudencio Ruiz Gongora", controladorTutores.consultarTutor(1).NombreApellidos);
        }
    }
}
