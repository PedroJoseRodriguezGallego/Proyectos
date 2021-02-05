package Codigo;

public class Metodos
{
    String propuesta;
    String ruta_billete;

    public double[] precioIlimitado7d(int dias,int viajes)
    {
        double[] tabla_colectivo = {0,1,2,3,4};
        double precio = 33;
        double bonos;
        double valor;


        if(dias % 7 == 0)
        {
            bonos = dias / 7;
        }

            else
            {
                bonos = Math.floor(dias / 7) + 1;
            }


        valor = precio * bonos;

        tabla_colectivo[0] = valor / viajes;                    //Sin descuento
        tabla_colectivo[1] = (valor - (valor * 0.5)) / viajes;  //Jubilado
        tabla_colectivo[2] = (valor - (valor * 0.6)) / viajes;  //Parado
        tabla_colectivo[3] = (valor - (valor * 0.75)) / viajes; //Discapacitado
        tabla_colectivo[4] = (valor - (valor * 0.8)) / viajes;  //Estudiante

        return tabla_colectivo;
    }

    /* ******************************************************************************************** */

    public double[] precioIlimitado30d(int dias,int viajes)
    {
        double[] tabla_colectivo = {0,1,2,3,4};
        double precio = 127;
        double bonos;
        double valor;


        if(dias % 30 == 0)
        {
            bonos = dias / 30;
        }

            else
            {
                bonos = Math.floor(dias / 30) + 1;
            }


        valor = precio * bonos;

        tabla_colectivo[0] = valor / viajes;                     //Sin descuento
        tabla_colectivo[1] = (valor - (valor * 0.5)) / viajes;  //Jubilado
        tabla_colectivo[2] = (valor - (valor * 0.6)) / viajes;  //Parado
        tabla_colectivo[3] = (valor - (valor * 0.75)) / viajes; //Discapacitado
        tabla_colectivo[4] = (valor - (valor * 0.8)) / viajes;  //Estudiante

        return tabla_colectivo;
    }

    /* ******************************************************************************************** */

    public double[] precioUnitario(int viajes)
    {
        double[] tabla_colectivo = {0,1,2,3,4};
        double precio = 2.75;
        double valor;


        valor = precio * viajes;

        tabla_colectivo[0] = valor / viajes;                    //Sin descuento
        tabla_colectivo[1] = (valor - (valor * 0.5)) / viajes;  //Jubilado
        tabla_colectivo[2] = (valor - (valor * 0.6)) / viajes;  //Parado
        tabla_colectivo[3] = (valor - (valor * 0.75)) / viajes; //Discapacitado
        tabla_colectivo[4] = (valor - (valor * 0.8)) / viajes;  //Estudiante

        return tabla_colectivo;
    }

    /* ******************************************************************************************** */

    public double[] calculaPreciosViaje(int dias, int viajes) //Devuelve tabla/array con los 15 resultados(3 tipos de ticket x 5 colectivos)
    {
        double[] billetera = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,14};
        double[] bono_unitario;
        double[] bono_7dias;
        double[] bono_30dias;

        int i;
        int j;

        Metodos op = new Metodos();

        bono_unitario = op.precioUnitario(viajes);
        bono_7dias = op.precioIlimitado7d(dias,viajes);
        bono_30dias = op.precioIlimitado30d(dias,viajes);

        for(i = 0; i < billetera.length; i++)
        {
            for(j = 0; j < bono_unitario.length; j++)
            {
                billetera[i] = bono_unitario[j];
                i++;
            }

            for(j = 0; j < bono_7dias.length; j++)
            {
                billetera[i] = bono_7dias[j];
                i++;
            }

            for(j = 0; j < bono_30dias.length; j++)
            {
                billetera[i] = bono_30dias[j];
                i++;
            }
        }

        return billetera;
    }

    /* ******************************************************************************************** */

    public void mejorOpcion(int colectivo, int dias, int viajes) //Identifique cuál de los precios de la tabla alimentada en el método anterior es el más bajo para el colectivo al que dice pertenecer.
    {
        //Sin descuento={0,,,,,5,,,,,10,,,,}
        //Jubilado={,1,,,,,6,,,,,11,,,}
        //Parado={,,2,,,,,7,,,,,12,,}
        //Discapacitado={,,,3,,,,,8,,,,,13,}
        //Estudiante={,,,,4,,,,,9,,,,,14}


        double[] billetera;
        Metodos op = new Metodos();
        billetera = op.calculaPreciosViaje(dias,viajes);


        switch(colectivo)
        {
            case 1 :
                if(billetera[0] < billetera[5] && billetera[0] < billetera[10])
                {
                    propuesta = "(Sin descuento) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[0] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/0.png";
                }

                    else if(billetera[5] < billetera[0] && billetera[5] < billetera[10])
                    {
                        propuesta = "(Sin descuento) Debería coger la opción de Bono 7 dias (" + (double)Math.round(billetera[5] * 100d) / 100d + "€/viaje)";
                        ruta_billete = "src/Imagenes/Billetes/5.png";
                    }

                        else if(billetera[10] < billetera[0] && billetera[10] < billetera[5])
                        {
                            propuesta = "(Sin descuento) Debería coger la opción de Bono 30 dias (" + (double)Math.round(billetera[10] * 100d) / 100d + "€/viaje)";
                            ruta_billete = "src/Imagenes/Billetes/10.png";
                        }

                            else if(billetera[0] == billetera[5] || billetera[0] == billetera[10] || billetera[5] == billetera[10])
                            {
                                propuesta = "(Sin descuento) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[0] * 100d) / 100d + "€/viaje)";
                                ruta_billete = "src/Imagenes/Billetes/0.png";
                            }
            break;


            case 2 :
                if(billetera[1] < billetera[6] && billetera[1] < billetera[11])
                {
                    propuesta = "(Jubilado) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[1] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/1.png";
                }

                    else if(billetera[6] < billetera[1] && billetera[6] < billetera[11])
                    {
                        propuesta = "(Jubilado) Debería coger la opción de Bono 7 dias (" + (double)Math.round(billetera[6] * 100d) / 100d + "€/viaje)";
                        ruta_billete = "src/Imagenes/Billetes/6.png";
                    }

                        else if(billetera[11] < billetera[1] && billetera[11] < billetera[6])
                        {
                            propuesta = "(Jubilado) Debería coger la opción de Bono 30 dias (" + (double)Math.round(billetera[11] * 100d) / 100d + "€/viaje)";
                            ruta_billete = "src/Imagenes/Billetes/11.png";
                        }

                            else if(billetera[1] == billetera[6] || billetera[1] == billetera[11] || billetera[6] == billetera[11])
                            {
                                propuesta = "(Jubilado) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[1] * 100d) / 100d + "€/viaje)";
                                ruta_billete = "src/Imagenes/Billetes/1.png";
                            }
            break;


            case 3:
                if(billetera[3] < billetera[8] && billetera[3] < billetera[13])
                {
                    propuesta = "(Discapacitado) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[3] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/3.png";
                }

                else if(billetera[8] < billetera[3] && billetera[8] < billetera[13])
                {
                    propuesta = "(Discapacitado) Debería coger la opción de Bono 7 dias (" + (double)Math.round(billetera[8] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/8.png";
                }

                else if(billetera[13] < billetera[3] && billetera[13] < billetera[8])
                {
                    propuesta = "(Discapacitado) Debería coger la opción de Bono 30 dias (" + (double)Math.round(billetera[13] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/13.png";
                }

                else if(billetera[3] == billetera[8] || billetera[3] == billetera[13] || billetera[8] == billetera[13])
                {
                    propuesta = "(Discapacitado) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[3] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/3.png";
                }
                break;

                            
            case 4 :
                if(billetera[2] < billetera[7] && billetera[2] < billetera[12])
                {
                    propuesta = "(Parado) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[2] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/2.png";
                }

                    else if(billetera[7] < billetera[2] && billetera[7] < billetera[12])
                    {
                        propuesta = "(Parado) Debería coger la opción de Bono 7 dias (" + (double)Math.round(billetera[7] * 100d) / 100d + "€/viaje)";
                        ruta_billete = "src/Imagenes/Billetes/7.png";
                    }

                        else if(billetera[12] < billetera[2] && billetera[12] < billetera[7])
                        {
                            propuesta = "(Parado) Debería coger la opción de Bono 30 dias (" + (double)Math.round(billetera[12] * 100d) / 100d + "€/viaje)";
                            ruta_billete = "src/Imagenes/Billetes/12.png";
                        }

                            else if(billetera[2] == billetera[7] || billetera[2] == billetera[12] || billetera[7] == billetera[12])
                            {
                                propuesta = "(Parado) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[2] * 100d) / 100d + "€/viaje)";
                                ruta_billete = "src/Imagenes/Billetes/2.png";
                            }
            break;


            case 5:
                if(billetera[4] < billetera[9] && billetera[4] < billetera[14])
                {
                    propuesta = "(Estudiante) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[4] * 100d) / 100d + "€/viaje)";
                    ruta_billete = "src/Imagenes/Billetes/4.png";
                }

                    else if(billetera[9] < billetera[4] && billetera[9] < billetera[14])
                    {
                        propuesta = "(Estudiante) Debería coger la opción de Bono 7 dias (" + (double)Math.round(billetera[9] * 100d) / 100d + "€/viaje)";
                        ruta_billete = "src/Imagenes/Billetes/9.png";
                    }

                        else if(billetera[14] < billetera[4] && billetera[14] < billetera[9])
                        {
                            propuesta = "(Estudiante) Debería coger la opción de Bono 30 dias (" + (double)Math.round(billetera[14] * 100d) / 100d + "€/viaje)";
                            ruta_billete = "src/Imagenes/Billetes/14.png";
                        }

                            else if(billetera[4] == billetera[9] || billetera[4] == billetera[14] || billetera[9] == billetera[14])
                            {
                                propuesta = "(Estudiante) Debería coger la opción de Bono Unitario (" + (double)Math.round(billetera[4] * 100d) / 100d + "€/viaje)";
                                ruta_billete = "src/Imagenes/Billetes/4.png";
                            }
            break;
        }
    }
}