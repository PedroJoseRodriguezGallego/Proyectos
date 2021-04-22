import datetime
import random
import time


def adivinadorContrasenasLibre(contrasena):
    listaCaracteres = list("0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-_.,")
    combinacionesTotales = pow(len(listaCaracteres), len(contrasena))
    contrasenaIntentada = ""
    tiempoInicial = time.time()
    intentos = 1

    while contrasenaIntentada != contrasena:

        contrasenaIntentada = random.choices(listaCaracteres, k=len(contrasena))

        if contrasenaIntentada == list(contrasena):
            print("\n\n\n\tCONTRASEÑA ENCONTRADA\n")
            print(f"Tiempo empleado --> {str(datetime.timedelta(seconds=(time.time() - tiempoInicial)))[0:10]}")
            print("Contraseña --> ", "".join(contrasenaIntentada))
            print(f"Intentos --> {intentos:,}")
            print(f"Combinaciones totales --> {combinacionesTotales:,} ")
            break
        else:
            print(f"Intento {intentos:,} :", "".join(contrasenaIntentada))
            intentos += 1


def generarPalabra(caracteres, longitud):
    listaCaracteres = list(caracteres)
    generacion = random.choices(listaCaracteres, k=longitud)
    return "".join(generacion)


def adivinadorContrasenasControlado(contrasena): # Se ve reducida la velocidad mediante pasa el tiempo por tener que comprobar cada vez mas contrasenas
    listaCaracteres = list("0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-_.,")
    combinacionesTotales = pow(len(listaCaracteres), len(contrasena))
    contrasenaIntentada = ""
    combinacionesIntentadas = []
    coincidencia = False
    tiempoInicial = time.time()
    intentos = 1

    while contrasenaIntentada != contrasena:

        contrasenaIntentada = random.choices(listaCaracteres, k=len(contrasena))

        for contra in combinacionesIntentadas:
            if contra == contrasenaIntentada:
                coincidencia = True

        if not coincidencia:
            combinacionesIntentadas.append(contrasenaIntentada)
            if contrasenaIntentada == list(contrasena):
                print("\n\n\n\tCONTRASEÑA ENCONTRADA\n")
                print(f"Tiempo empleado --> {str(datetime.timedelta(seconds=(time.time() - tiempoInicial)))[0:10]}")
                print("Contraseña --> ", "".join(contrasenaIntentada))
                print(f"Intentos --> {intentos:,}")
                print(f"Combinaciones totales --> {combinacionesTotales:,} ")
                break
            else:
                print(f"Intento {intentos:,} :", "".join(contrasenaIntentada))
                intentos += 1

        coincidencia = False

        if len(combinacionesIntentadas) >= combinacionesTotales:
            print("No se ha podido averiguar la contrasena porque se ha usado un caracter no registrado")
