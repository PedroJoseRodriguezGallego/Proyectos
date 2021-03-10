from datetime import datetime
import tkinter as tk
from tkinter import messagebox

import modelo.conexion as c

con = c.Conexion()

def fechaStr(fecha):
    try:
        cadena = fecha.strftime("%d-%m-%Y %H:%M:%S")
        return cadena
    except:
        tk.messagebox.showerror(title="Error", message="Fecha no válida")

def strFecha(cadena):
    try:
        fecha = datetime.strptime(cadena, "%d-%m-%Y %H:%M:%S")
        return fecha
    except:
        tk.messagebox.showerror(title="Error", message="Fecha no válida, se tomará la fecha actual")

def sacaUltimoId():
    con.conectar()
    ultimoId = 0
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT * FROM ingresos")
            resultados = cursor.fetchall()
            ultimoId = resultados[len(resultados) - 1][0]
    finally:
        con.desconectar()
        return ultimoId

def existeIngreso(id):
    result = consultarIngreso(id)
    if result != None and len(result) > 0:
        return True
    else:
        return False

def insertarIngreso(procedencia, fechaIngreso, numPlanta, numCama, observaciones, idPaciente, idMedico):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            consulta = "INSERT INTO ingresos(procedencia, fechaIngreso, numPlanta, numCama, observaciones, idPaciente, idMedico) VALUES (%s, %s, %s, %s, %s, %s, %s);"
            cursor.execute(consulta, (procedencia, fechaIngreso, numPlanta, numCama, observaciones, idPaciente, idMedico))
    finally:
        con.desconectar()

def consultarIngreso(id):
    con.conectar()
    resultados = None
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT * FROM ingresos WHERE idIngreso = " + str(id) + ";")
            resultados = cursor.fetchall()
    finally:
        con.desconectar()
        return resultados

def modificarIngreso(idIngreso, procedencia, fechaIngreso, numPlanta, numCama, observaciones, idPaciente, idMedico):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            consulta = "UPDATE ingresos SET procedencia = %s, fechaIngreso = %s, numPlanta = %s, numCama = %s, observaciones = %s, idPaciente = %s, idMedico = %s WHERE idIngreso = %s;"
            cursor.execute(consulta, (procedencia,fechaIngreso, numPlanta, numCama, observaciones, idPaciente, idMedico, idIngreso))
    finally:
        con.desconectar()

def eliminarIngreso(id):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("DELETE FROM ingresos WHERE idIngreso = " + str(id) + ";")
    finally:
        con.desconectar()