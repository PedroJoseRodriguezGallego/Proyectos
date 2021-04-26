<?php // Aqui llamamos a todas las validaciones

header('Content-Type: text/html; charset=utf-8');
require_once 'confirm.php';


$dni = $_POST['dni'];
$nombre = $_POST['nombre'];
$apellidos = $_POST['apellidos'];
$fecha_nacimiento = $_POST['fecha_nacimiento'];
$domicilio = $_POST['domicilio'];
$codigo_postal = $_POST['codigo_postal'];
$provincia = $_POST['provincia'];
$telefono = $_POST['telefono'];
$correo = $_POST['correo'];
$comentario = $_POST['comentario'];
$codigo_banco = $_POST['codigo_banco'];
$codigo_sucursal = $_POST['codigo_sucursal'];
$digitos_control = $_POST['digitos_control'];
$numero_cuenta = $_POST['numero_cuenta'];
$ccc = $codigo_banco.$codigo_sucursal.$digitos_control.$numero_cuenta;
$hora_envio = $_POST['hora_envio'];

$errores = false;



if ($_SERVER['REQUEST_METHOD'] == 'POST') 
{

   if(!validar_campo_vacio($dni) || !validar_campo_vacio($nombre) || !validar_campo_vacio($apellidos) || !validar_campo_vacio($fecha_nacimiento) || !validar_campo_vacio($domicilio) || !validar_campo_vacio($codigo_postal) || !validar_campo_vacio($provincia) || !validar_campo_vacio($telefono) || !validar_campo_vacio($correo) || !validar_campo_vacio($comentario) || !validar_campo_vacio($codigo_banco) || !validar_campo_vacio($codigo_sucursal) || !validar_campo_vacio($digitos_control) || !validar_campo_vacio($numero_cuenta))
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }


   if(!validar_campo_correo($correo))
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }


   if(!validar_campo_numerico_tlf($telefono))
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }


   if(!validar_campo_numerico_cp($codigo_postal))
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }


   if(validar_dni($dni) == false)
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }


   if(validar_fecha($fecha_nacimiento) == false)
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }


   if(validar_cuenta($ccc) == false)
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }


   if(validateTime($hora_envio) == false)
   {
      header("Location: formul.html");
      exit;
      $errores = true;
   }



   if($errores == true)
   {
      header("Location: formul.html");
      exit;
   }
      else
      {
         echo "Datos enviados correctamente";
      }
}

?>







<?php //Funciones para las validaciones

function validar_campo_vacio($valor)
{
   if(trim($valor) == '')
   {
      return false;
   }
      else
      {
         return true;
      }
}


// --------------------------------------------------------------------------------------


function validar_campo_numerico_tlf($telefono)
{
   if (filter_var($telefono, FILTER_VALIDATE_INT))
   {
      if(strlen($telefono) != 9)
      {
         return false;
      }
         else
         {
            return true;
         }
   } 
      else 
      {
         return false;
      }
}

// --------------------------------------------------------------------------------------


function validar_campo_numerico_cp($codigo_postal)
{
   if (filter_var($codigo_postal, FILTER_VALIDATE_INT))
   {
      if(strlen($codigo_postal) != 5)
      {
         return false;
      }
         else
         {
            return true;
         }
   } 
      else 
      {
         return false;
      }
}


// --------------------------------------------------------------------------------------


function validar_campo_correo($correo)
{
   if(filter_var($correo, FILTER_VALIDATE_EMAIL) === FALSE)
   {
      return false;
   }
      else
      {
         return true;
      }
}

// --------------------------------------------------------------------------------------

function validar_dni($dni)
{
	$letra = substr($dni, -1);
   $numeros = substr($dni, 0, -1);
   
   if ( substr("TRWAGMYFPDXBNJZSQVHLCKE", $numeros%23, 1) == $letra && strlen($letra) == 1 && strlen ($numeros) == 8 )
   {
		return true;
   }
      else
      {
         return false;
      }
}

// --------------------------------------------------------------------------------------

function validar_fecha($fecha)
{
   $valores = explode('/', $fecha);
   
   if(count($valores) == 3 && checkdate($valores[1], $valores[0], $valores[2]))
   {
		return true;
   }
      else
      {
         return false;
      }
}

// --------------------------------------------------------------------------------------

function validar_cuenta($ccc)
{

$valido = true;
$suma = 0;

$suma += $ccc[0] * 4;
$suma += $ccc[1] * 8;
$suma += $ccc[2] * 5;
$suma += $ccc[3] * 10;
$suma += $ccc[4] * 9;
$suma += $ccc[5] * 7;
$suma += $ccc[6] * 3;
$suma += $ccc[7] * 6;




$division = floor($suma/11);
$resto = $suma - ($division  * 11);
$primer_digito_control = 11 - $resto;

if($primer_digito_control == 11)
{
   $primer_digito_control = 0;
}

if($primer_digito_control == 10)
{
   $primer_digito_control = 1;
}

if($primer_digito_control != $ccc[8])
{
   $valido = false;
}




   $suma = 0;
   $suma += $ccc[10] * 1;
   $suma += $ccc[11] * 2;
   $suma += $ccc[12] * 4;
   $suma += $ccc[13] * 8;
   $suma += $ccc[14] * 5;
   $suma += $ccc[15] * 10;
   $suma += $ccc[16] * 9;
   $suma += $ccc[17] * 7;
   $suma += $ccc[18] * 3;
   $suma += $ccc[19] * 6;

   $division = floor($suma/11);
   $resto = $suma-($division  * 11);
   $segundo_digito_control = 11 - $resto;

   if($segundo_digito_control == 11)
   {
      $segundo_digito_control = 0;
   }

   if($segundo_digito_control == 10)
   {
      $segundo_digito_control = 1;
   }

   if($segundo_digito_control != $ccc[9])
   {
      $valido = false;
   }


   return $valido;
}

// --------------------------------------------------------------------------------------

function validateTime($hora_envio)
{
   $pattern = "/^([0-1][0-9]|[2][0-3])[\:]([0-5][0-9])[\:]([0-5][0-9])$/";

   if(preg_match($pattern,$hora_envio))
   {
      return true;
   }
      else
      {
         return false;
      }
}

?>