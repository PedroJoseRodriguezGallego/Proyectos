package controlador;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Gestion;

import java.net.URL;
import java.util.ResourceBundle;


public class Controlador implements Initializable
{
    Gestion operacion = new Gestion();
    boolean last;
    boolean save;

    public Label titulo;
    public Button leftButton;
    public Button rightButton;
    public TextField numeroTextfield;
    public TextField titularTextfield;
    public TextField fechaTextfield;
    public TextField saldoTextfield;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        operacion.cargaInicial();
        this.checkButtons();
        operacion.mostrarRegistro(numeroTextfield,titularTextfield,fechaTextfield,saldoTextfield);
        rightButton.setVisible(true);
    }


    public void leftButtonPressed()
    {
        if(last)
        {
            String greyBG = "-fx-background-color: #767676;";

            last = false;
            save = false;

            titularTextfield.setStyle(greyBG);
            fechaTextfield.setStyle(greyBG);
            numeroTextfield.setStyle(greyBG);
            saldoTextfield.setStyle(greyBG);
            
            this.viewMode();
        }

        operacion.index -= 1;
        this.checkButtons();
        operacion.mostrarRegistro(numeroTextfield,titularTextfield,fechaTextfield,saldoTextfield);
    }



    public void rightButtonPressed()
    {
        String greyBG = "-fx-background-color: #767676;";
        String redBG = "-fx-background-color: #D42525;";

        if(save)
        {
            if(operacion.checkTitular(titularTextfield) && operacion.checkFecha(fechaTextfield) && operacion.checkNumero(numeroTextfield) && operacion.checkSaldo(saldoTextfield))
            {
                operacion.anadirRegistro(numeroTextfield,titularTextfield,fechaTextfield,saldoTextfield);
                save = false;
                last = false;
                this.viewMode();

                titularTextfield.setStyle(greyBG);
                fechaTextfield.setStyle(greyBG);
                numeroTextfield.setStyle(greyBG);
                saldoTextfield.setStyle(greyBG);

                this.checkButtons();
                operacion.mostrarRegistro(numeroTextfield,titularTextfield,fechaTextfield,saldoTextfield);
            }
                else
                {
                    if(!operacion.checkTitular(titularTextfield))
                    {
                        titularTextfield.setStyle(redBG);
                    }
                        else
                        {
                            titularTextfield.setStyle(greyBG);
                        }

                    if(!operacion.checkFecha(fechaTextfield))
                    {
                        fechaTextfield.setStyle(redBG);
                    }
                        else
                        {
                            fechaTextfield.setStyle(greyBG);
                        }

                    if(!operacion.checkNumero(numeroTextfield))
                    {
                        numeroTextfield.setStyle(redBG);
                    }
                        else
                        {
                            numeroTextfield.setStyle(greyBG);
                        }

                    if(!operacion.checkSaldo(saldoTextfield))
                    {
                        saldoTextfield.setStyle(redBG);
                    }
                        else
                        {
                            saldoTextfield.setStyle(greyBG);
                        }
                }
        }

        if(last)
        {
            this.introductionMode();
            save = true;
        }
            else
            {
                operacion.index += 1;
                this.checkButtons();
                operacion.mostrarRegistro(numeroTextfield,titularTextfield,fechaTextfield,saldoTextfield);
            }
    }


    public void checkButtons()
    {
        leftButton.setVisible(operacion.index != 0);

        if(operacion.index == operacion.tamano - 1)
        {
            rightButton.setText("Nuevo");
            last = true;
        }
            else
            {
                rightButton.setText(">>");
            }
    }


    public void introductionMode()
    {
        titulo.setText("VISOR DE LAS CUENTAS NUEVAS");

        numeroTextfield.setText(null);
        titularTextfield.setText(null);
        fechaTextfield.setText(null);
        saldoTextfield.setText(null);

        numeroTextfield.setEditable(true);
        titularTextfield.setEditable(true);
        fechaTextfield.setEditable(true);
        saldoTextfield.setEditable(true);

        rightButton.setText("Aceptar");
        leftButton.setText("Cancelar");
    }


    public void viewMode()
    {
        titulo.setText("VISOR DE LAS CUENTAS EXISTENTES");

        numeroTextfield.setEditable(false);
        titularTextfield.setEditable(false);
        fechaTextfield.setEditable(false);
        saldoTextfield.setEditable(false);

        rightButton.setText(">>");
        leftButton.setText("<<");
    }
}