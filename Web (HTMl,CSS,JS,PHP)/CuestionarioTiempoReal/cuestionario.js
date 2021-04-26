//Declarar las variables contadores para ir sumando según la respuesta a cada pregunta.
var contadorA = 0;
var contadorB=0;
var contadorC=0;
var contadorD=0;

//Función que se ejecuta al finalizar y realiza recuento de todas las preguntas mediante un for para luego imprimir los resultados en la tabla del fondo de la página.

function count()
{
    //Resetea los contadores por si ya se ha ejecutado el botón de Finalizar y se vuelve a pulsar habiendo cambiado respuestas.
    contadorA = 0;
    contadorB = 0;
    contadorC = 0;
    contadorD = 0;
    for (var i = 1; i < 20; i++)
    {
        //Crea una variable tabla que iguala a la tabla del número de la pregunta actual que estemos revisando.
        var tabla = document.getElementsByName("tabla" + i);
        //Si la respuesta marcada es una A.
        if (tabla[0].checked)
        {
            contadorA++;
        }
        //Si la respuesta marcada es una B.
        if (tabla[1].checked)
        {
            contadorB++;
        }
        //Si la respuesta marcada es una C.
        if (tabla[2].checked)
        {
            contadorC++;
        }
        //Si la respuesta marcada es una D.
        if (tabla[3].checked)
        {
            contadorD++;
        }
    }
    //Sobreescribir en la tabla de resultados los números de respuestas obtenidos.
    document.getElementById("resultadoA").innerHTML=contadorA;
	document.getElementById("resultadoB").innerHTML=contadorB;
	document.getElementById("resultadoC").innerHTML=contadorC;
	document.getElementById("resultadoD").innerHTML=contadorD;
}