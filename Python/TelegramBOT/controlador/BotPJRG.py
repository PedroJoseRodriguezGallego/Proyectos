import traceback
import telebot
import validators
import os
import glob
import InformationPJRG as calculadora
import MediaDownloaderPJRG as downloader
import InstagramPJRG as scraper

# region variables
tokenPJRG = "1628039898:AAFFXxp60JWmXGegx1rCamTREK4lLx_29ZM"
bot = telebot.TeleBot(tokenPJRG)

commands = {"/help": "Comandos disponibles",
            "/info": "Datos del desarrollador",
            "/stats": "Información sobre el bot",
            "/scrapInstagram": "Descarga todos los datos de cualquier usuario de instagram",
            "/comment": "Deja un comentario para que podamos leerte",
            "/autoFollow": "Aumenta tus seguidores indicando el nombre de usuario",
            "/transcript": "Pasa de audio a texto",
            "/downloadSong": "Descarga cualquier cancion",
            "/downloadVideo": "Descarga cualquier video"}

esperandoEnlaceAudio = False
esperandoEnlaceVideo = False
esperandoPerfilInstagram = False
esperandoComentario = False
esperandoFollow = False
# endregion

try:
    # region comandosBOT
    @bot.message_handler(commands=['help'])
    def ayuda(message):
        calculadora.aumentarComandos()
        mensaje = "<b><u>Comandos disponibles</u></b>\n"

        for command in commands:
            mensaje = mensaje + (f"\n<i>{command}</i>  :  {commands[command]}")

        bot.reply_to(message, mensaje, parse_mode="HTML")


    @bot.message_handler(commands=['info'])
    def infoDesarrollador(message):
        calculadora.aumentarComandos()
        bot.reply_to(message, "<b>Pedro José Rodríguez Gallego</b>\n\n" +
                     "IG : <a href='https://www.instagram.com/prodriguezgallego/'>@prodriguezgallego</a>\n" +
                     "TW : <a href='https://twitter.com/pedrito626'>@pedrito626</a>\n" +
                     "FB : <a href='https://www.facebook.com/pedro.rodriguezgallego.1'>@pedrorodriguezgallego</a>\n" +
                     "GH : <a href='https://github.com/PedroJoseRodriguezGallego'>@pedrojoserodriguezgallego</a>\n" +
                     "MAIL : pedrojoserodriguezgallego@gmail.com\n", parse_mode="HTML")


    @bot.message_handler(commands=['downloadSong'])
    def descargarAudio(message):
        calculadora.aumentarComandos()
        bot.send_message(message.chat.id, "Introduce un enlace de <b>YouTube</b>", parse_mode="HTML")
        global esperandoEnlaceAudio
        esperandoEnlaceAudio = True


    @bot.message_handler(commands=['comment'])
    def contactarDesarrollador(message):
        calculadora.aumentarComandos()
        bot.send_message(message.chat.id, "Introduce el nombre del solicitante y el comentario separado por una coma (nombre,comentario)", parse_mode="HTML")
        global esperandoComentario
        esperandoComentario = True


    @bot.message_handler(commands=['scrapInstagram'])
    def transcribir(message):
        calculadora.aumentarComandos()
        bot.reply_to(message, "Funcion aun en desarrollo")


    @bot.message_handler(commands=['downloadVideo'])
    def descargarVideo(message):
        calculadora.aumentarComandos()
        bot.send_message(message.chat.id, "Introduce un enlace de <b>YouTube</b>", parse_mode="HTML")
        global esperandoEnlaceVideo
        esperandoEnlaceVideo = True


    @bot.message_handler(commands=['scrapInstagram'])
    def scrapInstagram(message):
        calculadora.aumentarComandos()
        bot.send_message(message.chat.id, "Introduce un perfil de <b>Instagram</b>", parse_mode="HTML")
        global esperandoPerfilInstagram
        esperandoPerfilInstagram = True


    @bot.message_handler(commands=['autoFollow'])
    def aumentarSeguidores(message):
        calculadora.aumentarComandos()
        bot.send_message(message.chat.id, "Introduce un usuario de <b>Instagram</b>", parse_mode="HTML")
        global esperandoFollow
        esperandoFollow = True


    @bot.message_handler(commands=['start'])
    def mensajeBienvenida(message):
        calculadora.aumentarConexiones()
        calculadora.aumentarComandos()
        bot.reply_to(message,"BOT desarrollado por Pedro José Rodríguez Gallego\n\n Introduce o pulsa /help para ver los comandos disponibles")


    @bot.message_handler(commands=['stats'])
    def mostrarEstadisticas(message):
        calculadora.aumentarComandos()
        bot.reply_to(message, f"Conexiones globales : {calculadora.consultarConexiones()}\nComandos usados : {calculadora.consultarComandos()}")

    @bot.message_handler(func=lambda message: True)
    def echo_all(message):
        global esperandoEnlaceAudio
        global esperandoEnlaceVideo
        global esperandoPerfilInstagram
        global esperandoFollow

        if esperandoEnlaceAudio or esperandoEnlaceVideo or esperandoPerfilInstagram or esperandoComentario or esperandoFollow:
            gestionRespuestas(message)
        else:
            bot.send_message(message.chat.id, "Por favor, introduce un comando valido")
except:
    traceback.print_exc()
# endregion

# region funciones
def gestionRespuestas(message):
    global esperandoEnlaceAudio
    global esperandoEnlaceVideo
    global esperandoPerfilInstagram
    global esperandoComentario
    global esperandoFollow

    try:
        if esperandoEnlaceAudio or esperandoEnlaceVideo:
            validador = validators.url(message.text)

            if validador:
                bot.send_message(message.chat.id, "Descarga en proceso...")
                if esperandoEnlaceAudio:
                    song = downloader.descargarAudio(message.text, 'm4a')
                    bot.send_message(message.chat.id, "Enviando audio...")
                    bot.send_audio(message.chat.id, audio=open(song, 'rb'))
                    os.remove(song)
                elif esperandoEnlaceVideo:
                    video = downloader.descargarVideo(message.text)
                    fichero = open(video, 'rb')
                    bot.send_message(message.chat.id, "Enviando video...")
                    bot.send_video(message.chat.id,fichero)
                    fichero.close()
                    os.remove(video)
            else:
                bot.reply_to(message, "Debes introducir un enlace valido")
        elif esperandoPerfilInstagram:
            bot.send_message(message.chat.id, "Buscando perfil...")
            datos = scraper.scrapearImagenes(message.text)
            comprimido = open(datos, 'rb')
            bot.send_message(message.chat.id, "Enviando datos...")
            bot.send_document(message.chat.id, comprimido)
        elif esperandoComentario:
            bot.send_message(message.chat.id, "Gracias por su colaboracion")
            calculadora.guardarComentario(message.text)
        elif esperandoFollow:
            bot.send_message(message.chat.id, f"Aumentaremos sus seguidores en : +{scraper.getBots()}")
            scraper.lanzarBots(message.text)
    except:
        traceback.print_exc()

        if esperandoEnlaceAudio:
            bot.send_message(message.chat.id, "Ha ocurrido un error al enviar el audio")
            for fichero in glob.iglob(f"*.m4a", recursive=True):
                os.remove(fichero)
        elif esperandoEnlaceVideo:
            bot.send_message(message.chat.id, "Ha ocurrido un error al enviar el video")
            for fichero in glob.iglob(f"*.mp4", recursive=True):
                os.remove(fichero)
        elif esperandoPerfilInstagram:
            bot.send_message(message.chat.id, "El perfil indicado no existe, no es accesible o tiene demasiados archivos")
        elif esperandoFollow:
            bot.send_message(message.chat.id,"El perfil indicado no existe")

    esperandoEnlaceAudio = False
    esperandoEnlaceVideo = False
    esperandoPerfilInstagram = False
    esperandoComentario = False
# endregion


if __name__ == "__main__":
    print("BOT iniciado correctamente")
    try:
        bot.polling()
    except:
        traceback.print_exc()
