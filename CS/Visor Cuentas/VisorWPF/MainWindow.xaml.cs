using System.Windows;
using System.Windows.Media;

namespace VisorWPF
{
    public partial class MainWindow : Window
    {
        GestionCuenta gestionCuenta = new GestionCuenta();



        public MainWindow()
        {
            InitializeComponent();
            gestionCuenta.rellenarDatos();
            gestionCuenta.tam = gestionCuenta.actualizarTamano();
            gestionCuenta.mostrarDatos(numeroText, titularText, fechaText, saldoText, nacionalidadText, gestionCuenta.index);
        }



        private void rightButton_Click(object sender, RoutedEventArgs e)
        {
            gestionCuenta.index++;
            hideButton();
            gestionCuenta.mostrarDatos(numeroText, titularText, fechaText, saldoText, nacionalidadText, gestionCuenta.index);
        }



        private void leftButton_Click(object sender, RoutedEventArgs e)
        {
            gestionCuenta.index--;
            hideButton();
            gestionCuenta.mostrarDatos(numeroText, titularText, fechaText, saldoText, nacionalidadText, gestionCuenta.index);
        }



        private void cancelButton_Click(object sender, RoutedEventArgs e)
        {
            hideButton();
            tituloLabel.Content = "VISOR DE LAS CUENTAS BANCARIAS";
            gestionCuenta.mostrarDatos(numeroText, titularText, fechaText, saldoText, nacionalidadText, gestionCuenta.index);

            numeroText.IsReadOnly = true;
            titularText.IsReadOnly = true;
            saldoText.IsReadOnly = true;
            fechaText.IsReadOnly = true;
            nacionalidadText.IsReadOnly = true;

            numeroText.Background = Brushes.White;
            titularText.Background = Brushes.White;
            fechaText.Background = Brushes.White;
            saldoText.Background = Brushes.White;
            nacionalidadText.Background = Brushes.White;
        }



        private void aceptButton_Click(object sender, RoutedEventArgs e)
        {
            if (gestionCuenta.verificarNumero(numeroText) && gestionCuenta.verificarCadena(titularText) && gestionCuenta.verificarFecha(fechaText) && gestionCuenta.verificarSaldo(saldoText) && gestionCuenta.verificarCadena(nacionalidadText))
            {
                hideButton();
                gestionCuenta.insertarDatos(numeroText.Text, titularText.Text, fechaText.Text, saldoText.Text, nacionalidadText.Text);
                gestionCuenta.tam = gestionCuenta.actualizarTamano();

                numeroText.Background = Brushes.White;
                titularText.Background = Brushes.White;
                fechaText.Background = Brushes.White;
                saldoText.Background = Brushes.White;
                nacionalidadText.Background = Brushes.White;

            }
                else
                {
                    if (!gestionCuenta.verificarNumero(numeroText))
                    {
                        numeroText.Background = Brushes.Red;
                    }
                        else
                        {
                            numeroText.Background = Brushes.White;
                        }

                    if (!gestionCuenta.verificarCadena(titularText))
                    {
                        titularText.Background = Brushes.Red;
                    }
                        else
                        {
                            titularText.Background = Brushes.White;
                        }

                    if (!gestionCuenta.verificarFecha(fechaText))
                    {
                        fechaText.Background = Brushes.Red;
                    }
                        else
                        {
                            fechaText.Background = Brushes.White;
                        }

                    if (!gestionCuenta.verificarSaldo(saldoText))
                    {
                        saldoText.Background = Brushes.Red;
                    }
                        else
                        {
                            saldoText.Background = Brushes.White;
                        }

                    if (!gestionCuenta.verificarCadena(nacionalidadText))
                    {
                        nacionalidadText.Background = Brushes.Red;
                    }
                        else
                        {
                            nacionalidadText.Background = Brushes.White;
                        }
                }
        }

        private void newButton_Click(object sender, RoutedEventArgs e)
        {
            tituloLabel.Content = "VISOR DE LAS CUENTAS NUEVAS";

            numeroText.Text = null;
            fechaText.Text = null;
            saldoText.Text = null;
            titularText.Text = null;
            nacionalidadText.Text = null;

            numeroText.IsReadOnly = false;
            fechaText.IsReadOnly = false;
            saldoText.IsReadOnly = false;
            titularText.IsReadOnly = false;
            nacionalidadText.IsReadOnly = false;


            rightButton.Opacity = 0;
            rightButton.IsEnabled = false;
            leftButton.Opacity = 0;
            leftButton.IsEnabled = false;
            newButton.Opacity = 0;
            newButton.IsEnabled = false;
            aceptButton.Opacity = 100;
            aceptButton.IsEnabled = true;
            cancelButton.Opacity = 100;
            cancelButton.IsEnabled = true;
        }

        public void hideButton()
        {
            if (gestionCuenta.index == 0)
            {
                rightButton.Opacity = 100;
                rightButton.IsEnabled = true;
                leftButton.Opacity = 0;
                leftButton.IsEnabled = false;
                aceptButton.Opacity = 0;
                aceptButton.IsEnabled = false;
                cancelButton.Opacity = 0;
                cancelButton.IsEnabled = false;
                newButton.Opacity = 0;
                newButton.IsEnabled = false;
            }
                else if (gestionCuenta.index == gestionCuenta.tam - 1)
                {
                    newButton.Opacity = 100;
                    newButton.IsEnabled = true;
                    leftButton.Opacity = 100;
                    leftButton.IsEnabled = true;
                    rightButton.Opacity = 0;
                    rightButton.IsEnabled = false;
                    aceptButton.Opacity = 0;
                    aceptButton.IsEnabled = false;
                    cancelButton.Opacity = 0;
                    cancelButton.IsEnabled = false;
                }
                    else
                    {
                        newButton.Opacity = 0;
                        newButton.IsEnabled = false;
                        leftButton.Opacity = 100;
                        leftButton.IsEnabled = true;
                        rightButton.Opacity = 100;
                        rightButton.IsEnabled = true;
                        aceptButton.Opacity = 0;
                        aceptButton.IsEnabled = false;
                        cancelButton.Opacity = 0;
                        cancelButton.IsEnabled = false;
                    }
        }
    }
}