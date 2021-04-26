function validar_campo_vacio_provincia()
{
    var valor = document.getElementById("provincia").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Provincia' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_tlf()
{
    var valor = document.getElementById("telefono").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Telefono' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_correo()
{
    var valor = document.getElementById("correo").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Correo' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_cp()
{
    var valor = document.getElementById("codigo_postal").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Codigo Postal' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_domicilio()
{
    var valor = document.getElementById("domicilio").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Domicilio' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_nombre()
{
    var valor = document.getElementById("nombre").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Nombre' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_apellidos()
{
    var valor = document.getElementById("apellidos").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Apellidos' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_comentario()
{
    var valor = document.getElementById("comentario").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'Comentario personal' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_vacio_dni()
{
    var valor = document.getElementById("dni").value;

    if( valor == null || valor.length == 0 || /^\s+$/.test(valor) )
    {
        alert("Debes rellenar el campo 'DNI' ");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_letra_dni()
{
    var dni = document.getElementById("dni").value;

    if(/^\d{8}[A-Z]$/.test(dni) == false)
    {
        alert("Debes poner un correcto formato de DNI");
        return false;
    }
        else
        {
            numero = dni.substr(0,dni.length-1);
            letr = dni.substr(dni.length-1,1);
            numero = numero % 23;
            letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
            letra = letra.substring(numero,numero+1);

            if(letra!=letr.toUpperCase())
            {
                alert('Debes introducir la letra correspondiente a ese numero de DNI');
            }
        }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_hora()
{
    var hora = document.getElementById("hora_envio").value;

    if (hora.length!=8) 
    {
        alert("Debes poner un correcto formato de fecha");
		return false;
    }

    var a = hora.charAt(0); //<=2
	var b = hora.charAt(1); //<4
	var c = hora.charAt(2); //:
	var d = hora.charAt(3); //<=5
	var e = hora.charAt(5); //:
    var f = hora.charAt(6); //<=5
    
    if ((a==2 && b>3) || (a>2)) 
    {
        alert("Horas incorrectas");
		return false;
    }
    
    if (d>5) 
    {
        alert("Minutos incorrectos");
		return false;
    }
    
    if (f>5) 
    {
        alert("Segundos incorrectos");
		return false;
    }
    
    if (c!=':' || e!=':')
    {
        alert("Mal formato de separadores");
		return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_correo()
{
    var correo = document.getElementById("correo").value;

    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(correo) == false)
    {
        alert("Debes introducir un formato de correo correcto");
        return false;
    } 
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_numerico_longitud_fija_cp()
{
    var codigo_postal = document.getElementById("codigo_postal").value;

    if((/^\d{5}$/.test(codigo_postal)) == false) 
    {
        alert("Debes introducir un formato de codigo postal correcto");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_numerico_longitud_fija_tlf()
{
    var telefono = document.getElementById("telefono").value;

    if((/^\d{9}$/.test(telefono)) == false) 
    {
        alert("Debes introducir un formato de numero de telefono correcto");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_fecha()
{
    var fecha = document.getElementById("fecha_nacimiento").value;

    if (/^\d{1,2}\/\d{1,2}\/\d{2,4}$/.test(fecha) == false) 
    {
        alert("Debes introducir un formato de fecha correcto");
        return false;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function validar_campo_cuenta_bancaria()
{
    var banco = document.getElementById("codigo_banco").value;
    var sucursal = document.getElementById("codigo_sucursal").value;
    var dc = document.getElementById("digitos_control").value;
    var cuenta = document.getElementById("numero_cuenta").value;
    var CCC = banco + sucursal + dc + cuenta;

    if(banco.length != 4)
    {
        alert("Debes introducir un numero de banco correcto");
        return false;
    }

    if(sucursal.length != 4)
    {
        alert("Debes introducir un numero de sucursal correcto");
        return false;
    }

    if(dc.length != 2)
    {
        alert("Debes introducir una pareja de digitos de control");
        return false;
    }

    if(cuenta.length != 10)
    {
        alert("Debes introducir un numero de cuenta correcto");
        return false;
    }

    if (!/^[0-9]{20}$/.test(CCC))
    {
        alert("Debes introducir un formato de cuenta corriente correcto");
        return false;
    }
        else
        {
            valores = new Array(1, 2, 4, 8, 5, 10, 9, 7, 3, 6);
            var control = 0;

            for (i=0; i<=9; i++)
            control += parseInt(cuenta.charAt(i)) * valores[i];
            control = 11 - (control % 11);
            
            if (control == 11)
            {
                control = 0;
            }
                else if (control == 10)
                {
                    control = 1;
                }

            if(control != parseInt(dc.charAt(1))) 
            {
                alert("El segundo digito de control es incorrecto");
                return false;
            }

            control = 0;
            var zbs = "00" + banco + sucursal;

            for (i=0; i<=9; i++)
            control += parseInt(zbs.charAt(i)) * valores[i];
            control = 11 - (control % 11);
            
            if (control == 11)
            {
                control = 0;
            }
                else if (control == 10)
                {
                    control = 1;
                }

            if(control != parseInt(dc.charAt(0))) 
            {
                alert("El primer digito de control es incorrecto");
                return false;
            }
        }

    calcular_iban();
}

// ---------------------------------------------------------------------------------------------------------------------------

function calcular_iban() 
{
    var banco = document.getElementById("codigo_banco").value;
    var sucursal = document.getElementById("codigo_sucursal").value;
    var dc = document.getElementById("digitos_control").value;
    var cuenta = document.getElementById("numero_cuenta").value;
    var ncuenta = banco + sucursal + dc + cuenta;
    var cpais = "ES";
    
    var aux;
    var csiguientes;
    var tmp;
    var csiguientes;
    
    ncuenta = ncuenta + (cpais.charCodeAt(0) - 55).toString() + (cpais.charCodeAt(1) - 55).toString() + "00";
    tmp = parseInt(ncuenta.substring(0, 9), 10) % 97;
    

    if (tmp < 10)
    {
        aux = "0";
    }    
        else
        {
            aux = "";
            aux = aux + tmp.toString();
            ncuenta = ncuenta.substring(9);
        }
            
    while(ncuenta != "") 
    {
        if (parseInt(aux, 10) < 10)
        {
            csiguientes = 8;
        }
            else
            {
                csiguientes = 7;
            }
                
        if (ncuenta.length < csiguientes) 
        {
            aux = aux + ncuenta;ncuenta="";
        }
            else 
            {
                aux = aux + ncuenta.substring(0, csiguientes);
                ncuenta = ncuenta.substring(csiguientes);
            }

        tmp = parseInt(aux, 10) % 97;

        if (tmp < 10)
        {
            aux = "0";
        }
            else
            {
                aux = "";
            }
                
        aux = aux + tmp.toString();
    }

    tmp = 98 - parseInt(aux, 10);

    if (tmp < 10)
    {
        alert("El numero de IBAN de la cuenta es : " + cpais + "0" + tmp.toString() );
    }
        else
        {
            alert("El numero de IBAN de la cuenta es : " + cpais + tmp.toString() );
        }
}
    
// ---------------------------------------------------------------------------------------------------------------------------

function mostrar_sexo()
{
    opciones = document.getElementsByName("sexo");

    for(var i=0; i<opciones.length; i++) 
    {
        if(opciones[i].checked) 
        {
            alert(opciones[i].value + " seleccionado");
        }
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function mostrar_idiomas()
{
    opciones = document.getElementsByName("idiomas");

    for(var i=0; i<opciones.length; i++) 
    {
        if(opciones[i].checked) 
        {
            alert(opciones[i].value + " seleccionado");
        }
    }
}

// ---------------------------------------------------------------------------------------------------------------------------

function mostrar_hora()
{
    var horario = new Date();
    var hora_actual="";
    var horas = horario.getHours();
    var minutos = horario.getMinutes();
    var segundos = horario.getSeconds();
 
    hora_actual = (horas<10?"0"+horas:horas) + ":" + (minutos<10?"0"+minutos:minutos) + ":" + (segundos<10?"0"+segundos:segundos);
 
    document.getElementById("hora_envio").value = hora_actual;
}

// ---------------------------------------------------------------------------------------------------------------------------

function resetear()
{
    document.getElementById("formulario").reset();
    alert("reseteado");
}

// ---------------------------------------------------------------------------------------------------------------------------

function enviar()
{
    document.getElementById("formulario").submit();
    alert("enviado");
}