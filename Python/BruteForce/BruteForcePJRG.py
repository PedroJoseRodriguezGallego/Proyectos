import datetime
import random
import time


def adivinadorContrasenas(contrasena): # 32.186 intentos por segundo (i5 7400 3Ghz)
    listaCaracteres = list("0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-_.,") # Caracteres disponibles elevado a longitud de la contraseña
    combinacionesPosibles = pow(len(listaCaracteres),len(contrasena))
    contrasenaIntentada = ""
    tiempoInicial = time.time()
    intentos = 1
    contrasenasIntentadas = []


    while contrasenaIntentada != contrasena:

        coincidencia = False
        contrasenaIntentada = random.choices(listaCaracteres, k=len(contrasena)) #Le pasamos los caracteres disponibles y la longitud

        for contra in contrasenasIntentadas:
            if contrasenaIntentada == contra:
                coincidencia = True

        if not coincidencia:
            contrasenasIntentadas.append(contrasenaIntentada)

            if contrasenaIntentada == list(contrasena):
                print("\n\n\n\tCONTRASEÑA ENCONTRADA\n")
                print(f"Tiempo empleado --> {str(datetime.timedelta(seconds=(time.time() - tiempoInicial)))[0:10]}")
                print("Contraseña --> ", "".join(contrasenaIntentada))
                print(f"Intentos --> {intentos:,}")
                print(f"Combinaciones posibles --> {combinacionesPosibles:,}")
                break
            else:
                print(f"Intento {intentos:,} :", "".join(contrasenaIntentada))
                intentos += 1

        if intentos > combinacionesPosibles:
            print("\n\nNo se ha podido averiguar la contraseña porque has usado un caracter no registrado")
            break




if __name__ == "__main__":
    contrasena = input("Introduce tu contraseña : ")
    adivinadorContrasenas(contrasena)