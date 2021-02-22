import telebot
import validators
import generadorPDF as generador
import scraperPJRG as scraper


bot = telebot.TeleBot("token")


@bot.message_handler(commands=['start'])
def mensajeInicial(message):
    bot.reply_to(message, "BOT desarrollado por Pedro Jose Rodriguez Gallego\n\n" +
                 "Introduce un enlace de perfil de Instagram para analizarlo : ")


@bot.message_handler(func=lambda message: True)
def echo_all(message):
    validador = validators.url(message.text) #Comprobamos si el mensaje enviado es un enlace o no

    if not validador: #Si no es un enlace
        bot.reply_to(message, "Por favor, introduce un URL de perfil de Instagram valido") #Pedimos que introduzca uno valido
    else: #Si es un enlace
        bot.send_message(message.chat.id, "URL aceptada, espera unos segundos...")
        scraper.obtenerFoto(obtenerUsuario(message.text)) #Descargamos la foto del usuario
        datos = scraper.obtenerDatos(obtenerUsuario(message.text)) #Obtenemos los datos del usuario
        informePDF = generador.generarInforme(obtenerUsuario(message.text),datos) #Creamos el informe del usuario
        doc = open(informePDF,'rb') #Cargamos el documento PDF
        bot.send_document(message.chat.id, doc) #Enviamos el PDF al cliente que lo haya solicitado


def obtenerUsuario(link): #Funcion que extrae el nombre de usuario de cualquier enlace de perfil desde la app o busqueda en el navegador desde la pagina web
    elementos = 0
    nombreUsuario = ""
    for caracter in link: #El nombre se encuentra entre la tercera / de la URL y la cuarta / o ?
        if caracter == "/" or caracter == "?":
            elementos = elementos + 1
        if elementos == 3:
            nombreUsuario = nombreUsuario + caracter #No existe el += se supone
        if elementos == 4:
            break

    return nombreUsuario[1:] #Elimina la primera posicion del string porque es la / que coge cuando entra en el if de elementos == 3


bot.polling()
