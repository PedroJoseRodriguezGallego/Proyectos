from bs4 import BeautifulSoup
import requests
import instaloader


def ordenarDatos(s):  # Ordena los datos en un diccionario
    data = {}  # Diccionario para guardar los datos

    s = s.split("-")[0] #Separamos el contenido segun '-' para diferenciar los datos de la cadena
    s = s.split(" ")

    data['Followers'] = s[0] #Asignamos a la clave Followers (seguidores) el valor de la posicion 0
    data['Following'] = s[2] #Asignamos a la clave Following (seguidos) el valor de la posicion 2
    data['Posts'] = s[4] #Asignamos a la clave Posts (publicaciones) el valor de la posicion 4

    return data #Devolvemos el diccionario con los datos


def obtenerDatos(username):  # Obtenemos los datos del usuario indicado
    request = requests.get(f"https://www.instagram.com/{username}/") #Direccion a la que le solicitaremos los datos
    informacion = BeautifulSoup(request.text, "html.parser") #Convertimos a texto lo solicitado para obtener su informacion
    print(informacion.text) #Permite ver si estamos bloqueados durante un tiempo (debe salir que no encuentra la pagina de instagram en ese caso)
    meta = informacion.find("meta", property="og:description") #Obtenemos la informacion de la etiqueta meta con que tenga la propiedad og:description

    return ordenarDatos(meta.attrs["content"]) #Introducimos los datos del atributo content que esten en la etoqueta meta con la property indicada anteriormente en un diccionario para acceder a ellos mas facilmente


def obtenerFoto(usuario): #Obtenemos la foto de perfil del usuario indicado
    buscadorFotos = instaloader.Instaloader() #Instanciamos un buscador de instagram
    buscadorFotos.download_profile(usuario, profile_pic_only=True) #Descargamos solo la foto de perfil


username = "prodriguezgallego"
data = obtenerDatos(username)
obtenerFoto(username)
print(data)