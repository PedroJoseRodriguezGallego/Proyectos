using Gestion_FCT.vistamodelo;
using Gestion_FCT.modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Data;
using System.Collections;
using System.Text.RegularExpressions;

namespace Gestion_FCT
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private ControladorAlumnos controlAlumnos;
        private ControladorTutores controlTutores;
        private ControladorEmpresas controlEmpresas;
        private ControladorAsignaciones controlAsignaciones;
        

        public MainWindow()
        {
            InitializeComponent();
            controlAlumnos = new ControladorAlumnos();
            controlTutores = new ControladorTutores();
            controlEmpresas = new ControladorEmpresas();
            controlAsignaciones = new ControladorAsignaciones();
        }

        private string sacaId(string seleccion)
        {
            string[] componentes = seleccion.Split(" - ");
            return componentes[0];
        }

        private Boolean revisaVacio(TextBox campo)
        {
            if (campo.Text.Length > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private void TabControl_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (pestanas.SelectedIndex == 0)
            {
                actualizaAlumnos();
                Application.Current.MainWindow.Height = 600;
            }
            else if (pestanas.SelectedIndex == 1)
            {
                actualizaTutores();
                Application.Current.MainWindow.Height = 600;
            }
            else if (pestanas.SelectedIndex == 2)
            {
                actualizaEmpresas();
                Application.Current.MainWindow.Height = 700;
            }
            else if (pestanas.SelectedIndex == 3)
            {
                Application.Current.MainWindow.Height = 600;
            }
        }

        private void tabAsignaciones_MouseEnter(object sender, MouseEventArgs e)
        {
            actualizaAsignaciones();
            txtAlumnoAsig.SelectedIndex = 0;
            txtEmpresaAsig.SelectedIndex = 0;
            txtTutorAsig.SelectedIndex = 0;
        }

        private void actualizaAlumnos()
        {
            tablaAlum.ItemsSource = controlAlumnos.listarAlumnos().DefaultView;
            txtCodAlum.Text = (controlAlumnos.sacaUltimoId() + 1).ToString();
            txtDniAlum.Text = "";
            txtNomAlum.Text = "";
            txtApeAlum.Text = "";
            txtFecAlum.SelectedDate = null;
    }

        private void actualizaTutores()
        {
            tablaTutorD.ItemsSource = controlTutores.listarTutores().DefaultView;
            txtCodTutorD.Text = (controlTutores.sacaUltimoId() + 1).ToString();
            txtNomTutorD.Text = "";
            txtEmailTutorD.Text = "";
            txtTelfTutorD.Text = "";
        }

        private void actualizaEmpresas()
        {
            tablaEmpresa.ItemsSource = controlEmpresas.listarEmpresas().DefaultView;
            txtCodEmpresa.Text = (controlEmpresas.sacaUltimoId() + 1).ToString();
            rbPartida.IsChecked = true;
            rbCompleta.IsChecked = false;
            txtNombreEmpresa.Text = "";
            txtCIFEmpresa.Text = "";
            txtDireccionEmpresa.Text = "";
            txtCPEmpresa.Text = "";
            txtLocalidadEmpresa.Text = "";
            txtDNIResponsableEmpresa.Text = "";
            txtNombreResponsableEmpresa.Text = "";
            txtApellidosResponsableEmpresa.Text = "";
            txtDNITutorLaboralEmpresa.Text = "";
            txtNombreTutorLaboralEmpresa.Text = "";
            txtApellidosTutorLaboralEmpresa.Text = "";
            txtEmailTutorLaboralEmpresa.Text = "";
            txtTelefonoTutorLaboralEmpresa.Text = "";
        }

        private void actualizaAsignaciones()
        {
            tablaAsig.ItemsSource = controlAsignaciones.listarAsignaciones().DefaultView;
            txtAlumnoAsig.ItemsSource = controlAsignaciones.rellenarDesplegables("SELECT CONCAT(CodigoAlumno, ' - ', Nombre, ' ', Apellidos) FROM alumnos;");
            txtEmpresaAsig.ItemsSource = controlAsignaciones.rellenarDesplegables("SELECT CONCAT(CodEmpresa, ' - ', Nombre) FROM empresas;");
            txtTutorAsig.ItemsSource = controlAsignaciones.rellenarDesplegables("SELECT CONCAT(CodigoTutor, ' - ', NomAp) FROM tutoresdocentes;");
        }

        private void colocaAlumno(Alumno a)
        {
            try
            {
                txtCodAlum.Text = a.IdAlumno.ToString();
                txtDniAlum.Text = a.Dni;
                txtNomAlum.Text = a.Nombre;
                txtApeAlum.Text = a.Apellidos;
                txtFecAlum.SelectedDate = a.FechaNac;
            } catch (NullReferenceException) {
                actualizaAlumnos();
            }
        }

        private void colocaTutor(Tutor t)
        {
            try
            {
                txtCodTutorD.Text = t.IdTutor.ToString();
                txtNomTutorD.Text = t.NombreApellidos;
                txtEmailTutorD.Text = t.Email;
                txtTelfTutorD.Text = t.Telefono;
            } catch (NullReferenceException) {
                actualizaTutores();
            }
        }

        private void colocaEmpresa(Empresa e)
        {
            try
            {
                txtCodEmpresa.Text = e.IdEmpresa.ToString();
                if (e.TipoJornada.Equals("Completa"))
                {
                    rbPartida.IsChecked = false;
                    rbCompleta.IsChecked = true;
                }
                else
                {
                    rbPartida.IsChecked = true;
                    rbCompleta.IsChecked = false;
                }
                txtNombreEmpresa.Text = e.Nombre;
                txtCIFEmpresa.Text = e.Cif;
                txtDireccionEmpresa.Text = e.Direccion;
                txtCPEmpresa.Text = e.Cp;
                txtLocalidadEmpresa.Text = e.Localidad;
                txtDNIResponsableEmpresa.Text = e.DniResponsable;
                txtNombreResponsableEmpresa.Text = e.NombreResponsable;
                txtApellidosResponsableEmpresa.Text = e.ApellidosResponsable;
                txtDNITutorLaboralEmpresa.Text = e.DniTutorLaboral;
                txtNombreTutorLaboralEmpresa.Text = e.NombreTutorLaboral;
                txtApellidosTutorLaboralEmpresa.Text = e.ApellidosTutorLaboral;
                txtEmailTutorLaboralEmpresa.Text = e.EmailTutorLaboral;
                txtTelefonoTutorLaboralEmpresa.Text = e.TelefonoTutorLaboral;
            } catch (NullReferenceException) {
                actualizaEmpresas();
            }
        }

        private void btnInsAlum_Click(object sender, RoutedEventArgs e)
        {
            if (!revisaValidoAlumno())
            {
                MessageBox.Show("Revisa los datos introducidos");
            }
            else
            {
                int insertadas = 0;
                try
                {
                    Alumno nuevo = new Alumno(Int32.Parse(txtCodAlum.Text), txtDniAlum.Text, txtNomAlum.Text, txtApeAlum.Text, (DateTime)txtFecAlum.SelectedDate);
                    if (!controlAlumnos.comprobarAlumno(nuevo.IdAlumno))
                    {
                        insertadas = controlAlumnos.insertarAlumno(nuevo);
                    }
                    else
                    {
                        MessageBox.Show("ID ya utilizado.");
                        insertadas = 0;
                    }
                }
                catch (InvalidOperationException)
                {
                    MessageBox.Show("Debes rellenar todos los campos");
                }
                actualizaAlumnos();
                if (insertadas > 0)
                {
                    MessageBox.Show("Alumno insertado correctamente.");
                }
            }
        }

        private void btnModAlum_Click(object sender, RoutedEventArgs e)
        {
            if (!revisaValidoAlumno())
            {
                MessageBox.Show("Revisa los datos introducidos");
            }
            else
            {
                int modificadas = 0;
                Alumno modificado = new Alumno();
                try
                {
                    modificado = new Alumno(Int32.Parse(txtCodAlum.Text), txtDniAlum.Text, txtNomAlum.Text, txtApeAlum.Text, (DateTime)txtFecAlum.SelectedDate);
                    if (controlAlumnos.comprobarAlumno(modificado.IdAlumno))
                    {
                        modificadas = controlAlumnos.modificarAlumno(modificado);
                    }
                    else
                    {
                        MessageBox.Show("ID no existente.");
                        modificadas = 0;
                    }
                }
                catch (InvalidOperationException)
                {
                    MessageBox.Show("Debes rellenar todos los campos");
                }
                actualizaAlumnos();
                if (modificadas > 0)
                {
                    colocaAlumno(modificado);
                    MessageBox.Show("Alumno modificado correctamente.");
                }
            }
        }

        private void btnElimAlum_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int id = Int32.Parse(txtCodAlum.Text);
                if (controlAlumnos.comprobarAlumno(id))
                {
                    controlAlumnos.eliminarAlumno(id);
                }
                else
                {
                    MessageBox.Show("ID no existente.");
                }
            } catch (FormatException)
            {
                MessageBox.Show("Debes introducir un ID válido.");
            }
            actualizaAlumnos();
        }

        private void btnInsTutorD_Click(object sender, RoutedEventArgs e)
        {
            if (!revisaValidoTutor())
            {
                MessageBox.Show("Revisa los datos introducidos");
            }
            else
            {
                int insertadas = 0;
                try
                {
                    Tutor nuevo = new Tutor(Int32.Parse(txtCodTutorD.Text), txtNomTutorD.Text, txtEmailTutorD.Text, txtTelfTutorD.Text);
                    if (!controlTutores.comprobarTutor(nuevo.IdTutor))
                    {
                        insertadas = controlTutores.insertarTutor(nuevo);
                    }
                    else
                    {
                        MessageBox.Show("ID ya utilizado.");
                        insertadas = 0;
                    }
                }
                catch (InvalidOperationException)
                {
                    MessageBox.Show("Debes rellenar todos los campos");
                }
                actualizaTutores();
                if (insertadas > 0)
                {
                    MessageBox.Show("Tutor insertado correctamente.");
                }
            }
        }

        private void btnModTutorD_Click(object sender, RoutedEventArgs e)
        {
            if (!revisaValidoTutor())
            {
                MessageBox.Show("Revisa los datos introducidos");
            }
            else
            {
                int modificadas = 0;
                Tutor modificado = new Tutor();
                try
                {
                    modificado = new Tutor(Int32.Parse(txtCodTutorD.Text), txtNomTutorD.Text, txtEmailTutorD.Text, txtTelfTutorD.Text);
                    if (controlTutores.comprobarTutor(modificado.IdTutor))
                    {
                        modificadas = controlTutores.modificarTutor(modificado);
                    }
                    else
                    {
                        MessageBox.Show("ID no existente.");
                        modificadas = 0;
                    }
                }
                catch (InvalidOperationException)
                {
                    MessageBox.Show("Debes rellenar todos los campos");
                }
                actualizaTutores();
                if (modificadas > 0)
                {
                    colocaTutor(modificado);
                    MessageBox.Show("Tutor modificado correctamente.");
                }
            }
        }

        private void btnElimTutorD_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int id = Int32.Parse(txtCodTutorD.Text);
                if (controlTutores.comprobarTutor(id))
                {
                    controlTutores.eliminarTutor(id);
                }
                else
                {
                    MessageBox.Show("ID no existente.");
                }
            } catch (FormatException)
            {
                MessageBox.Show("Debes introducir un ID válido.");
            }
            actualizaTutores();
        }

        private void btnInsertarEmpresa_Click(object sender, RoutedEventArgs e)
        {
            if (!revisaValidoEmpresa())
            {
                MessageBox.Show("Revisa los datos introducidos");
            }
            else
            {
                int insertadas = 0;
                try
                {
                    string jornada = "";
                    if (rbPartida.IsChecked == true)
                    {
                        jornada = rbPartida.Content.ToString();
                    }
                    else if (rbCompleta.IsChecked == true)
                    {
                        jornada = rbCompleta.Content.ToString();
                    }
                    Empresa nueva = new Empresa(Int32.Parse(txtCodEmpresa.Text), txtNombreEmpresa.Text, txtCIFEmpresa.Text, txtDireccionEmpresa.Text, txtCPEmpresa.Text,
                        txtLocalidadEmpresa.Text, jornada, txtDNIResponsableEmpresa.Text, txtNombreResponsableEmpresa.Text,
                        txtApellidosResponsableEmpresa.Text, txtDNITutorLaboralEmpresa.Text, txtNombreTutorLaboralEmpresa.Text, txtApellidosTutorLaboralEmpresa.Text,
                        txtEmailTutorLaboralEmpresa.Text, txtTelefonoTutorLaboralEmpresa.Text);
                    if (!controlEmpresas.comprobarEmpresa(nueva.IdEmpresa))
                    {
                        insertadas = controlEmpresas.insertarEmpresa(nueva);
                    }
                    else
                    {
                        MessageBox.Show("ID ya utilizado.");
                        insertadas = 0;
                    }
                }
                catch (InvalidOperationException)
                {
                    MessageBox.Show("Debes rellenar todos los campos");
                }
                actualizaEmpresas();
                if (insertadas > 0)
                {
                    MessageBox.Show("Tutor insertado correctamente.");
                }
            } 
        }

        private void btnModificarEmpresa_Click(object sender, RoutedEventArgs e)
        {
            if (!revisaValidoEmpresa())
            {
                MessageBox.Show("Revisa los datos introducidos");
            }
            else
            {
                int modificadas = 0;
                Empresa modificada = new Empresa();
                try
                {
                    string jornada = "";
                    if (rbPartida.IsChecked == true)
                    {
                        jornada = rbPartida.Content.ToString();
                    }
                    else if (rbCompleta.IsChecked == true)
                    {
                        jornada = rbCompleta.Content.ToString();
                    }
                    modificada = new Empresa(Int32.Parse(txtCodEmpresa.Text), txtNombreEmpresa.Text, txtCIFEmpresa.Text, txtDireccionEmpresa.Text, txtCPEmpresa.Text,
                        txtLocalidadEmpresa.Text, jornada, txtDNIResponsableEmpresa.Text, txtNombreResponsableEmpresa.Text,
                        txtApellidosResponsableEmpresa.Text, txtDNITutorLaboralEmpresa.Text, txtNombreTutorLaboralEmpresa.Text, txtApellidosTutorLaboralEmpresa.Text,
                        txtEmailTutorLaboralEmpresa.Text, txtTelefonoTutorLaboralEmpresa.Text);
                    if (controlEmpresas.comprobarEmpresa(modificada.IdEmpresa))
                    {
                        modificadas = controlEmpresas.modificarEmpresa(modificada);
                    }
                    else
                    {
                        MessageBox.Show("ID no existente.");
                        modificadas = 0;
                    }
                }
                catch (InvalidOperationException)
                {
                    MessageBox.Show("Debes rellenar todos los campos");
                }
                actualizaEmpresas();
                if (modificadas > 0)
                {
                    colocaEmpresa(modificada);
                    MessageBox.Show("Empresa modificada correctamente.");
                }
            }
        }

        private void btnBorrarEmpresa_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int id = Int32.Parse(txtCodEmpresa.Text);
                if (controlEmpresas.comprobarEmpresa(id))
                {
                    controlEmpresas.eliminarEmpresa(id);
                }
                else
                {
                    MessageBox.Show("ID no existente.");
                }
            } catch (FormatException)
            {
                MessageBox.Show("Debes introducir un ID válido.");
            }
            actualizaEmpresas();
        }

        private void btnAsignar_Click(object sender, RoutedEventArgs e)
        {
            string idAlumno = txtAlumnoAsig.Text;
            string idEmpresa = txtEmpresaAsig.Text;
            string idTutor = txtTutorAsig.Text;
            if (!idAlumno.Equals("--") && !idEmpresa.Equals("--") && !idTutor.Equals("--"))
            {
                idAlumno = sacaId(txtAlumnoAsig.Text);
                idEmpresa = sacaId(txtEmpresaAsig.Text);
                idTutor = sacaId(txtTutorAsig.Text);
                if (!controlAsignaciones.comprobarAsignado(Int32.Parse(idAlumno)))
                {
                    Asignacion nueva = new Asignacion(Int32.Parse(idAlumno), Int32.Parse(idEmpresa), Int32.Parse(idTutor));
                    controlAsignaciones.insertarAsignacion(nueva);
                }
                else
                {
                    MessageBox.Show("Este alumno ya ha sido asignado.");
                }
            }
            else
            {
                MessageBox.Show("Debes elegir las 3 opciones.");
            }
            actualizaAsignaciones();
        }

        private void btnBorrarAsig_Click(object sender, RoutedEventArgs e)
        {
            string idAlumno = txtAlumnoAsig.Text;
            string idEmpresa = txtEmpresaAsig.Text;
            string idTutor = txtTutorAsig.Text;
            if (!idAlumno.Equals("--") && !idEmpresa.Equals("--") && !idTutor.Equals("--"))
            {
                idAlumno = sacaId(idAlumno);
                idEmpresa = sacaId(idEmpresa);
                idTutor = sacaId(idTutor);
                if (controlAsignaciones.comprobarAsignado(Int32.Parse(idAlumno)))
                {
                    Asignacion eliminada = new Asignacion(Int32.Parse(idAlumno), Int32.Parse(idEmpresa), Int32.Parse(idTutor));
                    controlAsignaciones.eliminarAsignacion(eliminada);
                }
                else
                {
                    MessageBox.Show("Este alumno aún no ha recibido su asignación.");
                }
            }
            else
            {
                MessageBox.Show("Debes elegir las 3 opciones.");
            }
            actualizaAsignaciones();
        }

        private void tablaAlum_SelectedCellsChanged(object sender, SelectedCellsChangedEventArgs e)
        {
            try
            {
                TextBlock campo = (TextBlock)tablaAlum.SelectedCells[0].Column.GetCellContent(tablaAlum.SelectedCells[0].Item);
                colocaAlumno(controlAlumnos.consultarAlumno(Int32.Parse(campo.Text)));
            } catch (FormatException)
            {
                MessageBox.Show("Para colocar los datos en los campos, haz click en el código o ID.");
            } catch (Exception)
            {
                return;
            }
        }

        private void tablaTutorD_SelectedCellsChanged(object sender, SelectedCellsChangedEventArgs e)
        {
            try
            {
                TextBlock campo = (TextBlock)tablaTutorD.SelectedCells[0].Column.GetCellContent(tablaTutorD.SelectedCells[0].Item);
                if (Int32.Parse(campo.Text) > 1000)
                {
                    throw new FormatException();
                }
                colocaTutor(controlTutores.consultarTutor(Int32.Parse(campo.Text)));
            }
            catch (FormatException)
            {
                MessageBox.Show("Para colocar los datos en los campos, haz click en el código o ID.");
            }
            catch (Exception)
            {
                return;
            }
        }

        private void tablaEmpresa_SelectedCellsChanged(object sender, SelectedCellsChangedEventArgs e)
        {
            try
            {
                TextBlock campo = (TextBlock)tablaEmpresa.SelectedCells[0].Column.GetCellContent(tablaEmpresa.SelectedCells[0].Item);
                if (Int32.Parse(campo.Text) > 1000)
                {
                    throw new FormatException();
                }
                colocaEmpresa(controlEmpresas.consultarEmpresa(Int32.Parse(campo.Text)));
            }
            catch (FormatException)
            {
                MessageBox.Show("Para colocar los datos en los campos, haz click en el código o ID.");
            }
            catch (Exception)
            {
                return;
            }
        }

        private bool validarConRegex(string pattern, string contenido)
        {
            Regex r = new Regex(pattern);

            if ((r.IsMatch(contenido)))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private bool revisaFecAlumn()
        {
            try
            {
                DateTime hoy = DateTime.Today;
                DateTime elegida = (DateTime)txtFecAlum.SelectedDate;
                if (elegida < hoy)
                {
                    return true;
                }
                else
                {
                    throw new Exception();
                }
            }
            catch (Exception)
            {
                return false;
            }
        }

        private bool revisaValidoAlumno()
        {
            if (revisaVacio(txtDniAlum) && revisaVacio(txtNomAlum) && revisaVacio(txtApeAlum) && revisaFecAlumn() && validarConRegex(@"^((([A-Za-z])\d{8})|(\d{8}([A-Za-z])))$", txtDniAlum.Text))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private bool revisaValidoTutor()
        {
            if (revisaVacio(txtNomTutorD) && revisaVacio(txtEmailTutorD) && revisaVacio(txtTelfTutorD) &&
                validarConRegex(@"^(([^<>()\[\]\.,;:\s@\”]+(\.[^<>()\[\]\.,;:\s@\”]+)*)|(\”.+\”))@(([^<>()[\]\.,;:\s@\”]+\.)+[^<>()[\]\.,;:\s@\”]{2,})$", txtEmailTutorD.Text) &&
                validarConRegex(@"^6[0-9]{8}$", txtTelfTutorD.Text))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private bool revisaValidoEmpresa()
        {
            if (revisaVacio(txtNombreEmpresa) && revisaVacio(txtCIFEmpresa) && revisaVacio(txtCPEmpresa) && revisaVacio(txtDireccionEmpresa) && 
                revisaVacio(txtLocalidadEmpresa) && revisaVacio(txtNombreResponsableEmpresa) && revisaVacio(txtApellidosResponsableEmpresa) && 
                revisaVacio(txtDNIResponsableEmpresa) && revisaVacio(txtNombreTutorLaboralEmpresa) && revisaVacio(txtApellidosTutorLaboralEmpresa) && revisaVacio(txtDNITutorLaboralEmpresa) &&
                revisaVacio(txtTelefonoTutorLaboralEmpresa) && revisaVacio(txtEmailTutorLaboralEmpresa) && validarConRegex(@"^((([A-Za-z])\d{8})|(\d{8}([A-Za-z])))$", txtCIFEmpresa.Text) &&
                validarConRegex(@"^((([A-Za-z])\d{8})|(\d{8}([A-Za-z])))$", txtDNITutorLaboralEmpresa.Text) && validarConRegex(@"^((([A-Za-z])\d{8})|(\d{8}([A-Za-z])))$", txtDNIResponsableEmpresa.Text) &&
                validarConRegex(@"^(([^<>()\[\]\.,;:\s@\”]+(\.[^<>()\[\]\.,;:\s@\”]+)*)|(\”.+\”))@(([^<>()[\]\.,;:\s@\”]+\.)+[^<>()[\]\.,;:\s@\”]{2,})$", txtEmailTutorLaboralEmpresa.Text) &&
                validarConRegex(@"^6[0-9]{8}$", txtTelefonoTutorLaboralEmpresa.Text))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
