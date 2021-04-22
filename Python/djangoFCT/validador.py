import re
from datetime import datetime
import os
import pdfkit


def generarPDF():
    pdfkit.from_file('reporte.html', 'reporteLaboral.pdf')
    os.startfile('reporteLaboral.pdf')


def valida(patron, cadena):
    validador = re.compile(patron)
    return bool(validador.match(cadena))


def revisaTelefono(cadena):
    if cadena != None and valida("^6[0-9]{8}$", cadena):
        return True
    else:
        return False


def revisaCp(cadena):
    if cadena != None and valida("^[0-9]{5}$", cadena):
        return True
    else:
        return False


def revisaFecha(cadena):
    try:
        datetime.strptime(cadena, '%Y-%m-%d')
        return True
    except ValueError:
        return False


def revisaCorreo(cadena):
    if cadena != None and valida("^[a-z0-9]+[\._]?[a-z0-9]+[@]\w+[.]\w{2,3}$", cadena):
        return True
    else:
        return False


def revisaDNI(cadena):
    if cadena != None and valida("^\d{8}[A-Z]{1}$", cadena):
        return True
    else:
        return False


def revisaSoloLetras(cadena):
    if cadena != None:
        for caracter in cadena:
            if caracter.isdigit():
                return False
        return True
    else:
        return False

if __name__ == "__main__":
    generarPDF()