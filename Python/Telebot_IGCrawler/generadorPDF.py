from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4
import glob


def obtenerRutaImagen(usuario): #Funcion que devolvera la ruta de la imagen de perfil del usuario indicado
    for fichero in glob.iglob(f"{usuario}/*.jpg", recursive=True): #Buscamos un fichero cuyo nombre concuerde con la informacion indicada
        return fichero #Devolvemos el nombre del fichero


def generarInforme(usuario,datos):
    # region generarBase
    ancho, alto = A4  # Pasamos el valor del ancho y alto del tamano A4 a las variables para calcular mejor las posiciones de los elementos
    canvasPDF = canvas.Canvas("informeInstagramPJRG.pdf", pagesize=A4)  # Creamos el PDF
    # endregion

    # region plantilla
    canvasPDF.drawString(250, alto - 70,"Instagram crawler by Pedro Jose Rodriguez Gallego")  # Posicion X e Y (la esquina inferior izquierda es 0,0) #Posicion X e Y (la esquina inferior izquierda es 0,0)

    text = canvasPDF.beginText(250, alto - 90)  # Para crear un texto largo con saltos de linea creamos un objeto
    text.setFont("Times-Roman", 12)  # Indicamos la fuente para el objeto
    text.textLine(f"Usuario : {usuario}")  # Introducimos las lineas que queramos
    text.textLine(f"Seguidores : {datos.get('Followers')}")
    text.textLine(f"Seguidos : {datos.get('Following')}")
    text.textLine(f"Publicaciones : {datos.get('Posts')}")

    canvasPDF.drawText(text) #Dibujamos el texto creado
    canvasPDF.drawImage(obtenerRutaImagen(usuario), 50, alto - 200, width=150, height=150) #Dibujamos la imagen indicada con las medidas indicadas
    # endregion

    # region generarPDF
    canvasPDF.showPage()  # Indica que hemos acabado de trabajar con la pagina actual y pasaremos a la siguiente
    canvasPDF.save()  # Guarda o sobreescribe el PDF
    # endregion
