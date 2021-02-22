using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
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

namespace Financiero
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnGenerar_Click(object sender, RoutedEventArgs e)
        {
            if (comboBanco.SelectedIndex != -1)
            {
                if (validarCampos())
                {
                    // Entidad
                    comprobarComboBox();

                    Cuenta cuenta = new Cuenta(ccEntidad.Text, ccSucursal.Text, ccCuenta.Text);
                    ObtenerDatosCuenta odc = new ObtenerDatosCuenta();
                    ObtenerDatosTarjeta odt = new ObtenerDatosTarjeta();

                    // Dígito de control
                    odc.generarDigitoControl(cuenta);
                    ccDc.Text = cuenta.Dc;

                    // IBAN
                    odc.generarIban(cuenta);
                    ciIban.Text = "ES" + cuenta.Iban;
                    ciCuenta.Text = cuenta.Entidad + cuenta.Sucursal + cuenta.Dc + cuenta.NumCuenta;

                    // Número de tarjeta
                    numTarjeta.Text = odt.generarNumTarjeta(comprobarRadioButtons());
                }
            }
            else
            {
                MessageBox.Show("Debe seleccionar su banco");
            }
        }

        public String comprobarRadioButtons()
        {
            Random rnd = new Random();
            if (rbVisa.IsChecked == true)
            {
                return "4";
            }
            if (rbMaster.IsChecked == true)
            {
                return rnd.Next(51, 56).ToString();
            }
            if (rbAmerican.IsChecked == true)
            {
                String[] numAmerican = new[] { "34", "37" };
                return numAmerican[rnd.Next(numAmerican.Length)];
            }
            return "";
        }

        public void comprobarComboBox()
        {
            if (comboBanco.SelectedIndex == 0)
                ccEntidad.Text = "0049"; // Santander
            if (comboBanco.SelectedIndex == 1)
                ccEntidad.Text = "0182"; // BBVA
            if (comboBanco.SelectedIndex == 2)
                ccEntidad.Text = "2100"; // La Caixa
            if (comboBanco.SelectedIndex == 3)
                ccEntidad.Text = "2038"; // Bankia
            if (comboBanco.SelectedIndex == 4)
                ccEntidad.Text = "0081"; // Sabadell
        }

        public Boolean validarCampos()
        {
            // Validar sucursal
            if (string.IsNullOrEmpty(ccSucursal.Text))
            {
                MessageBox.Show("Debe rellenar la sucursal");
                return false;
            }
            Regex regexSucursal = new Regex("^[0-9]{4}$");
            if (!regexSucursal.IsMatch(ccSucursal.Text))
            {
                MessageBox.Show("Sucursal incorrecta");
                return false;
            }

            // Validar cuenta
            if (string.IsNullOrEmpty(ccCuenta.Text))
            {
                MessageBox.Show("Debe rellenar el número de cuenta");
                return false;
            }
            Regex regexCuenta = new Regex("^[0-9]{10}$");
            if (!regexCuenta.IsMatch(ccCuenta.Text))
            {
                MessageBox.Show("Cuenta incorrecta");
                return false;
            }

            return true;
        }

    }
}
