import datetime
import random
import time


def adivinadorContrasenas(contrasena):
    listaCaracteres = list("0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ-_.,")
    combinacionesPosibles = pow(len(listaCaracteres),len(contrasena))
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
            print(f"Combinaciones posibles --> {combinacionesPosibles:,}")
            break
        else:
            print(f"Intento {intentos:,} :", "".join(contrasenaIntentada))
            intentos += 1


if __name__ == "__main__":
    contrasena = input("Introduce tu contraseña : ")
    adivinadorContrasenas(contrasena)