import csv
from datetime import datetime

datos = []
momentoActual = datetime.now()
conexiones = 0
comandos = 0


def aumentarComandos():
    with open('../resources/information.csv', 'r') as file:
        datos = list(csv.reader(file))

    comandos = int(datos[1][1])
    comandos = comandos + 1
    datos[1][1] = str(comandos)
    momentoActual = datetime.now()
    datos[1][2] = str(momentoActual)

    with open("../resources/information.csv", "w", newline='') as file:
        writer = csv.writer(file)
        writer.writerows(datos)

    return comandos



def aumentarConexiones():
    with open('../resources/information.csv', 'r') as file:
        datos = list(csv.reader(file))

    conexiones = int(datos[1][0])
    comandos = int(datos[1][1])

    comandos = comandos + 1
    conexiones = conexiones + 1

    datos[1][0] = str(conexiones)
    datos[1][1] = str(comandos)
    momentoActual = datetime.now()
    datos[1][2] = str(momentoActual)

    with open("../resources/information.csv", "w", newline='') as file:
        writer = csv.writer(file)
        writer.writerows(datos)

    return conexiones



def consultarComandos():
    with open('../resources/information.csv', 'r') as file:
        datos = list(csv.reader(file))
    return int(datos[1][1])



def consultarConexiones():
    with open('../resources/information.csv', 'r') as file:
        datos = list(csv.reader(file))
    return int(datos[1][0])


if __name__ == "__main__":
    print('ok')
