package modelo;

import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class Gestion
{
    ArrayList<Cuenta> listaDatos = new ArrayList<>();
    public int index = 0;
    public int tamano = 0;



    public void cargaInicial()
    {
        listaDatos.add(new Cuenta("001","Pedro","15/08/2001","1000"));
        listaDatos.add(new Cuenta("002","Alejandra","08/01/2004","500"));
        listaDatos.add(new Cuenta("003","Alvaro","22/09/1997","20000"));
        listaDatos.add(new Cuenta("004","Alba","12/03/2004","3000"));
        listaDatos.add(new Cuenta("005","Carlos","02/10/2000","100"));

        tamano = listaDatos.size();
    }



    public void anadirRegistro(TextField fnumeroCuenta, TextField ftitular, TextField ffechaApertura, TextField fsaldo)
    {
        listaDatos.add(new Cuenta(fnumeroCuenta.getText(),ftitular.getText(),ffechaApertura.getText(),fsaldo.getText()));
        tamano = listaDatos.size();
    }



    public void mostrarRegistro(TextField fnumeroCuenta, TextField ftitular, TextField ffechaApertura, TextField fsaldo)
    {
        fnumeroCuenta.setText(listaDatos.get(index).numeroCuenta);
        ftitular.setText(listaDatos.get(index).titular);
        ffechaApertura.setText(listaDatos.get(index).fechaApertura);
        fsaldo.setText(listaDatos.get(index).saldo + "€");
    }



    public boolean checkTitular(TextField ftitular)
    {
        boolean result = true;

        if(ftitular.getText() != null)
        {
            char[] chars = ftitular.getText().toCharArray();

            for(char c : chars)
            {
                if(Character.isDigit(c))
                {
                    result = false;
                }
            }
        }
            else
            {
                result = false;
            }


        return result;
    }


    public boolean checkFecha(TextField ffecha)
    {
        boolean result = true;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if(ffecha.getText() != null)
        {
            try
            {
                dateFormat.parse(ffecha.getText().trim());
            }
            catch (ParseException pe)
            {
                result = false;
            }
        }
            else
            {
                result = false;
            }


        return result;
    }


    public boolean checkNumero(TextField fnumero)
    {
        boolean result = true;
        boolean anyLetter = false;

        if(fnumero.getText() != null)
        {
            char[] chars = fnumero.getText().toCharArray();

            for(char c : chars)
            {
                if(!Character.isDigit(c))
                {
                    anyLetter = true;
                }
            }

            for (Cuenta listaDato : listaDatos)
            {
                if (fnumero.getText().equals(listaDato.numeroCuenta))
                {
                    result = false;
                }
            }

            if(anyLetter)
            {
                result = false;
            }
        }
            else
            {
                result = false;
            }


        return result;
    }


    public boolean checkSaldo(TextField fsaldo)
    {
        boolean result = true;
        boolean anyNumber = false;

        if(fsaldo.getText() != null)
        {
            char[] chars = fsaldo.getText().toCharArray();

            for(char c : chars)
            {
                if(Character.isDigit(c))
                {
                    anyNumber = true;
                }
            }

            if(!anyNumber)
            {
                result = false;
            }
        }
            else
            {
                result = false;
            }


        return result;
    }

}