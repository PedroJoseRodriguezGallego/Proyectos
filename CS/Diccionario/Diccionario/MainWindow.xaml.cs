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

namespace Diccionario
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        
        int estado;
        int[] indices;
        Juego game;
        Dictionary<string, string> listaPalabras;
        KeyValuePair<string, string> pareja;
        public MainWindow()
        {
            InitializeComponent();
            listaPalabras = new Dictionary<string, string>();
            listaPalabras.Add("black", "negro");
            listaPalabras.Add("cat", "gato");
            listaPalabras.Add("dog", "perro");
            listaPalabras.Add("house", "casa");
            listaPalabras.Add("white", "blanco");
            listaPalabras.Add("orange", "naranja");
            listaPalabras.Add("next", "siguiente");
            listaPalabras.Add("school", "colegio");
            listaPalabras.Add("sound", "sonido");
            listaPalabras.Add("car", "coche");
            listaPalabras.Add("computer", "ordenador");
            listaPalabras.Add("keyboard", "teclado");
            listaPalabras.Add("face mask", "mascarilla");
            listaPalabras.Add("controller", "mando");
            listaPalabras.Add("fan", "ventilador");
            listaPalabras.Add("bag", "mochila");
            listaPalabras.Add("shirt", "camisa");
        }

        private void TabControl_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (ingEsp.IsSelected)
            {
                txtBuscaIngles.Text = "";
                txtResulEspanol.Text = "";
            } else if (espIng.IsSelected)
            {
                txtBuscaEspanol.Text = "";
                txtResulIngles.Text = "";
            } else if (juego.IsSelected)
            {
                txtParaAdivinar.Text = "";
                txtRespuesta.Text = "";
                iniciarJuego();
            } else if (lista.IsSelected)
            {
                refrescaListado();
                txtIngles.Text = "";
                txtEspanol.Text = "";
            }
        }

        private void iniciarJuego()
        {
            btnEmpezar.Visibility = Visibility.Visible;
            btnSiguiente.Visibility = Visibility.Hidden;
            estado = 0;
            indices = new int[10];
            game = new Juego();
            pareja = new KeyValuePair<string, string>();
            escribeEtiquetasJuego();
        }

        private void escribeEtiquetasJuego()
        {
            lblRecuento.Content = "Palabra " + game.numPalabra + "/" + indices.Length;
            lblAciertos.Content = "Aciertos: " + game.aciertos;
            lblFallos.Content = "Fallos: " + game.fallos;
        }

        private void refrescaListado()
        {
            txtTraducciones.Text = "";
            foreach (var item in listaPalabras)
            {
                txtTraducciones.Text = txtTraducciones.Text + item.Key + " = " + item.Value + "\n";
            }
        }

        private void generaPalabra()
        {
            int indice = 0;
            bool generada = false;
            Random aleatorio = new Random();
            while (!generada)
            {
                try
                {
                    indice = aleatorio.Next(listaPalabras.Count);
                    if (!indices.Contains(indice))
                    {
                        pareja = listaPalabras.ElementAt(indice);
                        txtParaAdivinar.Text = pareja.Key;
                        txtRespuesta.Text = "";
                        generada = true;
                        indices[estado] = indice;
                        estado++;
                        return;
                    } else
                    {
                        generada = false;
                    }
                }
                catch (ArgumentException)
                {
                    generada = false;
                }
                catch (IndexOutOfRangeException)
                {
                    txtParaAdivinar.Text = "";
                    txtRespuesta.Text = "";
                    MessageBox.Show("¡Finalizado! Has respondido " + indices.Length + " preguntas. Has acertado " + game.aciertos + " y has fallado " + game.fallos + ".");
                    iniciarJuego();
                    generada = false;
                    return;
                }
            }
        }

        private void btnTraduceIngles_Click(object sender, RoutedEventArgs e)
        {
            string ingles = txtBuscaIngles.Text;
            try
            {
                if (!ingles.Equals(""))
                {
                    txtResulEspanol.Text = listaPalabras[ingles];
                }
                else
                {
                    MessageBox.Show("Debes rellenar el campo de inglés");
                    txtBuscaIngles.Text = "";
                    txtResulEspanol.Text = "";
                }
            }
            catch (KeyNotFoundException)
            {
                MessageBox.Show("No se ha encontrado traducción para esa palabra");
                txtBuscaIngles.Text = "";
                txtResulEspanol.Text = "";
            }
        }

        private void btnTraduceEspanol_Click(object sender, RoutedEventArgs e)
        {
            string espanol = txtBuscaEspanol.Text;
            try
            {
                if (!espanol.Equals(""))
                {
                    txtResulIngles.Text = listaPalabras.First(x => x.Value == espanol).Key;
                }
                else
                {
                    MessageBox.Show("Debes rellenar el campo de inglés");
                    txtBuscaEspanol.Text = "";
                    txtResulIngles.Text = "";
                }
            }
            catch (InvalidOperationException)
            {
                MessageBox.Show("No se ha encontrado traducción para esa palabra");
                txtBuscaEspanol.Text = "";
                txtResulIngles.Text = "";
            }
        }

        private void btnEmpezar_Click(object sender, RoutedEventArgs e)
        {
            iniciarJuego();
            btnEmpezar.Visibility = Visibility.Hidden;
            btnSiguiente.Visibility = Visibility.Visible;
            generaPalabra();
        }

        private void btnSiguiente_Click(object sender, RoutedEventArgs e)
        {
            string espanol = txtRespuesta.Text;
            if (!espanol.Equals(""))
            {
                game.numPalabra++;
                if (espanol.Equals(pareja.Value))
                {
                    game.aciertos++;
                } else
                {
                    game.fallos++;
                }
            } else
            {
                MessageBox.Show("Debes rellenar el campo de respuesta");
            }
            escribeEtiquetasJuego();
            generaPalabra();
        }

        private void btnAnadir_Click(object sender, RoutedEventArgs e)
        {
            string ingles = txtIngles.Text;
            string espanol = txtEspanol.Text;
            try
            {
                if (!ingles.Equals("") && !espanol.Equals(""))
                {
                    listaPalabras.Add(ingles, espanol);
                    MessageBox.Show("Palabra y traducción añadida correctamente");
                }
                else
                {
                    MessageBox.Show("Debes rellenar los campos de inglés y español");
                }
            } catch (ArgumentException)
            {
                MessageBox.Show("Esta palabra ya está incluida en el diccionario");
            }
            refrescaListado();
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            string ingles = txtIngles.Text;
            if (!ingles.Equals(""))
            {
                txtEspanol.Text = listaPalabras[ingles];
                if (listaPalabras.Remove(ingles))
                {
                    MessageBox.Show("\"" + ingles + "\" eliminada correctamente");
                } else
                {
                    MessageBox.Show("Esta palabra no aparece en el diccionario");
                }
            }
            else
            {
                MessageBox.Show("Debes rellenar el campo de inglés");
            }
            refrescaListado();
        }
    }

    class Juego
    {
        public int numPalabra
        {
            get; set;
        }
        public int aciertos
        {
            get; set;
        }
        public int fallos
        {
            get; set;
        }

        public KeyValuePair<string, string> pareja
        {
            get; set;
        }

        public Juego()
        {
            numPalabra = 0;
            aciertos = 0;
            fallos = 0;
            pareja = new KeyValuePair<string, string>();
        }
    }
}
