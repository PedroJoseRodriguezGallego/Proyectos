package Codigo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Calculador_movilidad
{

    public static void main(String[] args)
    {
        Metodos operacion = new Metodos();

        JFrame ventana = new JFrame("Aplicación Movilidad");

        JPanel panelPrincipal = new JPanel();
        JPanel panelEstancia = new JPanel();
        JPanel panelPropuesta = new JPanel();
        JPanel panelColectivo = new JPanel();
        JPanel panelBillete = new JPanel();

        SpinnerNumberModel modelo = new SpinnerNumberModel(0, 0, 999, 1);
        JSpinner spinner_dias = new JSpinner(modelo);

        JLabel etiqueta_dias = new JLabel("Días ");
        JLabel etiqueta_viajes = new JLabel();
        JLabel zona_billete = new JLabel();

        JSlider slider_viajes = new JSlider(0, 100, 0);

        JTextArea texto_propuesta = new JTextArea();

        Icon icono_aceptar = new ImageIcon("src/Imagenes/Botones/icono_aceptar.png");
        Icon icono_cancelar = new ImageIcon("src/Imagenes/Botones/icono_cancelar.png");

        JButton boton_aceptar = new JButton(icono_aceptar);
        JButton boton_cancelar = new JButton(icono_cancelar);

        JRadioButton sin = new JRadioButton("Sin Descuento");
        JRadioButton jubilado = new JRadioButton("Jubilado");
        JRadioButton discapacitado = new JRadioButton("Discapacitado");
        JRadioButton parado = new JRadioButton("Parado");
        JRadioButton estudiante = new JRadioButton("Estudiante");

        ButtonGroup grupo_colectivo = new ButtonGroup();

        /* ****************************************************************************************************** */

        panelPrincipal.setLayout(new GridLayout(2, 2, 1, 1));
        panelEstancia.setLayout(new FlowLayout(1, 1, 25));
        panelPropuesta.setLayout(new FlowLayout(1, 10, 20));
        panelColectivo.setLayout(new GridLayout(5, 1, 1, 1));

        panelEstancia.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Estancia"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));

        panelColectivo.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Colectivo"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));

        panelPropuesta.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Propuesta"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));

        panelBillete.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Su billete"), BorderFactory
                .createEmptyBorder(5, 5, 5, 5)));

        // ---------------------

        Dimension spinner = new Dimension(50, 20);
        spinner_dias.setPreferredSize(spinner);
        spinner_dias.setSize(100, 20);

        // ---------------------

        slider_viajes.setPaintTrack(true);
        slider_viajes.setPaintTicks(true);
        slider_viajes.setPaintLabels(true);
        slider_viajes.setMajorTickSpacing(20);
        slider_viajes.setMinorTickSpacing(5);
        etiqueta_viajes.setText("Viajes : " + slider_viajes.getValue());

        // ---------------------

        sin.setSelected(true);

        // ---------------------

        Dimension texto = new Dimension(200, 60);
        texto_propuesta.setPreferredSize(texto);
        texto_propuesta.setEditable(false);
        texto_propuesta.setLineWrap(true);
        texto_propuesta.setWrapStyleWord(true);

        /* ****************************************************************************************************** */

        boton_aceptar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int lectura_colectivo = 0;

                if (sin.isSelected())
                {
                    lectura_colectivo = 1;
                }

                    else if (jubilado.isSelected())
                    {
                        lectura_colectivo = 2;
                    }

                        else if (discapacitado.isSelected())
                        {
                            lectura_colectivo = 3;
                        }

                            else if (parado.isSelected())
                            {
                                lectura_colectivo = 4;
                            }

                                else if (estudiante.isSelected())
                                {
                                    lectura_colectivo = 5;
                                }

                int lectura_viajes = (int) slider_viajes.getValue();
                int lectura_dias = (int) spinner_dias.getValue();

                operacion.calculaPreciosViaje(lectura_dias, lectura_viajes);
                operacion.mejorOpcion(lectura_colectivo, lectura_dias, lectura_viajes);

                texto_propuesta.setText(operacion.propuesta);
                zona_billete.setIcon(new ImageIcon(operacion.ruta_billete));
            }
        });



        boton_cancelar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                slider_viajes.setValue(0);
                spinner_dias.setValue(0);
                texto_propuesta.setText(null);
                sin.setSelected(true);
                zona_billete.setIcon(new ImageIcon("src/Imagenes/Billete/reset.jpg"));
            }
        });



        slider_viajes.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                etiqueta_viajes.setText("Viajes : " + slider_viajes.getValue());
            }
        });

        /* ****************************************************************************************************** */

        panelPrincipal.add(panelEstancia);
        panelPrincipal.add(panelColectivo);
        panelPrincipal.add(panelPropuesta);
        panelPrincipal.add(panelBillete);

        panelEstancia.add(etiqueta_dias);
        panelEstancia.add(spinner_dias);
        panelEstancia.add(slider_viajes);
        panelEstancia.add(etiqueta_viajes);

        panelPropuesta.add(texto_propuesta);
        panelPropuesta.add(boton_aceptar);
        panelPropuesta.add(boton_cancelar);

        panelBillete.add(zona_billete);

        panelColectivo.add(sin);
        panelColectivo.add(jubilado);
        panelColectivo.add(discapacitado);
        panelColectivo.add(parado);
        panelColectivo.add(estudiante);

        grupo_colectivo.add(sin);
        grupo_colectivo.add(jubilado);
        grupo_colectivo.add(discapacitado);
        grupo_colectivo.add(parado);
        grupo_colectivo.add(estudiante);

        /* ****************************************************************************************************** */

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(450, 450);
        ventana.add(panelPrincipal);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}