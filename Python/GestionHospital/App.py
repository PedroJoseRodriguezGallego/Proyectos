import tkinter as tk
from tkinter import ttk
from tkinter import messagebox

import matplotlib.pyplot as plt
import numpy as np
import re

import modelo.pacientes as p
import modelo.medicos as m
import modelo.ingresos as i
import modelo.graficos as g

def generarGrafico1():
    datos = g.consultarDatosGrafico1()
    valores = []
    etiquetas = []

    for i in range(len(datos)):
        valores.append(datos[i][0])
        etiquetas.append(datos[i][1])

    valores = np.array(valores)

    plt.pie(valores, labels=etiquetas, autopct="%0.1f %%")
    plt.show()

def generarGrafico2():
    datos = g.consultarDatosGrafico2()
    valores = []
    etiquetas = []

    for i in range(len(datos)):
        valores.append(datos[i][0])
        etiquetas.append(datos[i][1])

    valores = np.array(valores)
    plt.bar(etiquetas, valores)
    plt.show()

def valida(patron, cadena):
    validador = re.compile(patron)
    return bool(validador.match(cadena))

def revisaId(cadena):
    cad = revisaVacio(cadena)
    if cad != None and valida("^[0-9]{1,11}$", cad):
        return cad
    else:
        tk.messagebox.showerror(title="Error", message="ID no válido")

def revisaUnicos(cadena):
    cad = revisaVacio(cadena)
    if cad != None and valida("^[0-9]{9}[A-Z]$", cad):
        return cad
    else:
        tk.messagebox.showerror(title="Error", message="Número identificador no válido")

def revisaCp(cadena):
    cad = revisaVacio(cadena)
    if cad != None and valida("^[0-9]{5}$", cad):
        return cad
    else:
        tk.messagebox.showerror(title="Error", message="Código postal no válido")

def revisaTelefono(cadena):
    cad = revisaVacio(cadena)
    if cad != None and valida("^6[0-9]{8}$", cad):
        return cad
    else:
        tk.messagebox.showerror(title="Error", message="Número de teléfono no válido")

def revisaCamaPlanta(cadena):
    cad = revisaVacio(cadena)
    if cad != None and valida("^[0-9]{1,2}$", cad):
        return cad
    else:
        tk.messagebox.showerror(title="Error", message="Planta o cama no válida")

def revisaVacio(cadena):
    if len(cadena) <= 0:
        return None
    else:
        return cadena

def recogePacientes():
    id = idPacienteTextp.get()
    numss = revisaUnicos(numSeguridadSocialTextp.get())
    nombre = revisaVacio(nombreTextp.get())
    apellidos = revisaVacio(apellidosTextp.get())
    direccion = revisaVacio(direccionTextp.get())
    poblacion = revisaVacio(poblacionTextp.get())
    provincia = revisaVacio(provinciaTextp.get())
    cp = revisaCp(cpTextp.get())
    telefono = revisaTelefono(telefonoTextp.get())
    numHistorial = revisaUnicos(numHistorialTextp.get())
    observaciones = revisaVacio(observacionesTextp.get())
    return id, numss, nombre, apellidos, direccion, poblacion, provincia, cp, telefono, numHistorial, observaciones

def recogeMedicos():
    id = idMedicoTextm.get()
    nombre = revisaVacio(nombreTextm.get())
    apellidos = revisaVacio(apellidosTextm.get())
    especialidad = revisaVacio(especialidadTextm.get())
    numColegiado = revisaUnicos(numColegiadoTextm.get())
    cargo = revisaVacio(cargoTextm.get())
    observaciones = revisaVacio(observacionesTextm.get())
    return id, nombre, apellidos, especialidad, numColegiado, cargo, observaciones

def recogeIngresos():
    id = idIngresoTexti.get()
    procedencia = revisaVacio(procedenciaTexti.get())
    fechaIngreso = i.strFecha(revisaVacio(fechaIngresoTexti.get()))
    planta = revisaCamaPlanta(numPlantaTexti.get())
    cama = revisaCamaPlanta(numCamaTexti.get())
    observaciones = revisaVacio(observacionesTexti.get())
    paciente = revisaId(idPacienteTexti.get())
    medico = revisaId(idMedicoTexti.get())
    return id, procedencia, fechaIngreso, planta, cama, observaciones, paciente, medico

#region Funciones
def insertarPaciente():
    datos = recogePacientes()
    try:
        p.insertarPaciente(datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], datos[8], datos[9], datos[10])
        tk.messagebox.showinfo(title="Información", message="Registro insertado")
        idPacienteTextp.set(p.sacaUltimoId())
        consultarPaciente()
    except:
        tk.messagebox.showerror(title="Error", message="Inserción fallida")

def eliminarPaciente():
    datos = recogePacientes()
    if p.existePaciente(datos[0]):
        try:
            p.eliminarPaciente(datos[0])
            tk.messagebox.showinfo(title="Información", message="Registro eliminado")
        except:
            tk.messagebox.showerror(title="Error", message="Borrado fallido")
    else:
        tk.messagebox.showerror(title="Error", message="Registro no encontrado")

    resetearPaciente()

def modificarPaciente():
    datos = recogePacientes()
    if p.existePaciente(datos[0]):
        try:
            p.modificarPaciente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], datos[8], datos[9], datos[10])
            tk.messagebox.showinfo(title="Información", message="Registro modificado")
        except:
            tk.messagebox.showerror(title="Error", message="Modificación fallida")

        consultarPaciente()
    else:
        tk.messagebox.showerror(title="Error", message="Registro no encontrado")

def consultarPaciente():
    try:
        consulta = p.consultarPaciente(idPacienteTextp.get())
        idPacienteTextp.set(consulta[0][0])
        numSeguridadSocialTextp.set(consulta[0][1])
        nombreTextp.set(consulta[0][2])
        apellidosTextp.set(consulta[0][3])
        direccionTextp.set(consulta[0][4])
        poblacionTextp.set(consulta[0][5])
        provinciaTextp.set(consulta[0][6])
        cpTextp.set(consulta[0][7])
        telefonoTextp.set(consulta[0][8])
        numHistorialTextp.set(consulta[0][9])
        observacionesTextp.set(consulta[0][10])
    except:
        tk.messagebox.showerror(title="Error", message="Consulta fallida")
        resetearPaciente()

def resetearPaciente():
    idPacienteTextp.set("")
    numSeguridadSocialTextp.set("")
    nombreTextp.set("")
    apellidosTextp.set("")
    direccionTextp.set("")
    poblacionTextp.set("")
    provinciaTextp.set("")
    cpTextp.set("")
    telefonoTextp.set("")
    numHistorialTextp.set("")
    observacionesTextp.set("")

def insertarMedico():
    datos = recogeMedicos()
    try:
        m.insertarMedico(datos[1], datos[2], datos[3], datos[4], datos[5], datos[6])
        tk.messagebox.showinfo(title="Información", message="Registro insertado")
        idMedicoTextm.set(m.sacaUltimoId())
        consultarMedico()
    except:
        tk.messagebox.showerror(title="Error", message="Inserción fallida")

def eliminarMedico():
    datos = recogeMedicos()
    if m.existeMedico(datos[0]):
        try:
            m.eliminarMedico(datos[0])
            tk.messagebox.showinfo(title="Información", message="Registro eliminado")
        except:
            tk.messagebox.showerror(title="Error", message="Borrado fallido")
    else:
        tk.messagebox.showerror(title="Error", message="Registro no encontrado")

    resetearMedico()

def modificarMedico():
    datos = recogeMedicos()
    if m.existeMedico(datos[0]):
        try:
            m.modificarMedico(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6])
            tk.messagebox.showinfo(title="Información", message="Registro modificado")
        except:
            tk.messagebox.showerror(title="Error", message="Modificación fallida")

        consultarMedico()
    else:
        tk.messagebox.showerror(title="Error", message="Registro no encontrado")

def consultarMedico():
    try:
        consulta = m.consultarMedico(idMedicoTextm.get())
        idMedicoTextm.set(consulta[0][0])
        nombreTextm.set(consulta[0][1])
        apellidosTextm.set(consulta[0][2])
        especialidadTextm.set(consulta[0][3])
        numColegiadoTextm.set(consulta[0][4])
        cargoTextm.set(consulta[0][5])
        observacionesTextm.set(consulta[0][6])
    except:
        tk.messagebox.showerror(title="Error", message="Consulta fallida")
        resetearMedico()

def resetearMedico():
    idMedicoTextm.set("")
    nombreTextm.set("")
    apellidosTextm.set("")
    especialidadTextm.set("")
    numColegiadoTextm.set("")
    cargoTextm.set("")
    observacionesTextm.set("")

def insertarIngreso():
    datos = recogeIngresos()
    try:
        i.insertarIngreso(datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7])
        tk.messagebox.showinfo(title="Información", message="Registro insertado")
        idIngresoTexti.set(i.sacaUltimoId())
        consultarIngreso()
    except:
        tk.messagebox.showerror(title="Error", message="Inserción fallida")

def eliminarIngreso():
    datos = recogeIngresos()
    if i.existeIngreso(datos[0]):
        try:
            i.eliminarIngreso(datos[0])
            tk.messagebox.showinfo(title="Información", message="Registro eliminado")
        except:
            tk.messagebox.showerror(title="Error", message="Borrado fallido")
    else:
        tk.messagebox.showerror(title="Error", message="Registro no encontrado")

    resetearIngreso()

def modificarIngreso():
    datos = recogeIngresos()
    if i.existeIngreso(datos[0]):
        try:
            i.modificarIngreso(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7])
            tk.messagebox.showinfo(title="Información", message="Registro modificado")
        except:
            tk.messagebox.showerror(title="Error", message="Modificación fallida")

        consultarIngreso()
    else:
        tk.messagebox.showerror(title="Error", message="Registro no encontrado")

def consultarIngreso():
    try:
        consulta = i.consultarIngreso(idIngresoTexti.get())
        idIngresoTexti.set(consulta[0][0])
        procedenciaTexti.set(consulta[0][1])
        fechaIngresoTexti.set(i.fechaStr(consulta[0][2]))
        numPlantaTexti.set(consulta[0][3])
        numCamaTexti.set(consulta[0][4])
        observacionesTexti.set(consulta[0][5])
        idPacienteTexti.set(consulta[0][6])
        idMedicoTexti.set(consulta[0][7])
    except:
        tk.messagebox.showerror(title="Error", message="Consulta fallida")
        resetearIngreso()

def resetearIngreso():
    idIngresoTexti.set("")
    procedenciaTexti.set("")
    fechaIngresoTexti.set("")
    numPlantaTexti.set("")
    numCamaTexti.set("")
    observacionesTexti.set("")
    idPacienteTexti.set("")
    idMedicoTexti.set("")
#endregion

#region Creamos la interfaz y el sistema de ventanas
interfaz = tk.Tk()

interfaz.geometry("590x450")
interfaz.resizable(False, False)
interfaz.title("CRUD Hospital")

tabControl = ttk.Notebook(interfaz)
#endregion

#region Creamos las pestanas
tabPacientes = ttk.Frame(tabControl)
tabMedicos = ttk.Frame(tabControl)
tabIngresos = ttk.Frame(tabControl)
tabGraficos = ttk.Frame(tabControl)
#endregion

#region Anadimos las ventanas a la interfaz
tabControl.add(tabPacientes, text="Pacientes")
tabControl.add(tabMedicos, text="Médicos")
tabControl.add(tabIngresos, text="Ingresos")
tabControl.add(tabGraficos, text="Gráficos")
tabControl.pack(expand=1, fill="both")
#endregion

#region Ventana pacientes
idPacienteTextp = tk.StringVar()
numSeguridadSocialTextp = tk.StringVar()
nombreTextp = tk.StringVar()
apellidosTextp = tk.StringVar()
direccionTextp = tk.StringVar()
poblacionTextp = tk.StringVar()
provinciaTextp = tk.StringVar()
cpTextp = tk.StringVar()
telefonoTextp = tk.StringVar()
numHistorialTextp = tk.StringVar()
observacionesTextp = tk.StringVar()

ttk.Label(tabPacientes, text="ID Paciente:").grid(column=0, row=0, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= idPacienteTextp).grid(column=1, row=0)

ttk.Label(tabPacientes, text="Número Seguridad Social:").grid(column=0, row=1, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= numSeguridadSocialTextp).grid(column=1, row=1)

ttk.Label(tabPacientes, text="Nombre:").grid(column=0, row=2, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= nombreTextp).grid(column=1, row=2)

ttk.Label(tabPacientes, text="Apellidos:").grid(column=0, row=3, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= apellidosTextp).grid(column=1, row=3)

ttk.Label(tabPacientes, text="Dirección:").grid(column=0, row=4, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= direccionTextp).grid(column=1, row=4)

ttk.Label(tabPacientes, text="Población:").grid(column=0, row=5, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= poblacionTextp).grid(column=1, row=5)

ttk.Label(tabPacientes, text="Provincia:").grid(column=0, row=6, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= provinciaTextp).grid(column=1, row=6)

ttk.Label(tabPacientes, text="Código postal:").grid(column=0, row=7, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= cpTextp).grid(column=1, row=7)

ttk.Label(tabPacientes, text="Teléfono:").grid(column=0, row=8, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= telefonoTextp).grid(column=1, row=8)

ttk.Label(tabPacientes, text="Número de historial:").grid(column=0, row=9, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= numHistorialTextp).grid(column=1, row=9)

ttk.Label(tabPacientes, text="Observaciones:").grid(column=0, row=10, padx=20, pady=7)
ttk.Entry(tabPacientes, width=20, textvariable= observacionesTextp).grid(column=1, row=10)

ttk.Button(tabPacientes, text="Insertar", command=insertarPaciente).grid(column=0, row=11, padx=30, pady=25)
ttk.Button(tabPacientes, text="Eliminar", command=eliminarPaciente).grid(column=1, row=11, padx=30)
ttk.Button(tabPacientes, text="Modificar", command=modificarPaciente).grid(column=2, row=11, padx=30)
ttk.Button(tabPacientes, text="Consultar", command=consultarPaciente).grid(column=3, row=11, padx=30)
#endregion

#region Ventana medicos
idMedicoTextm = tk.StringVar()
nombreTextm = tk.StringVar()
apellidosTextm = tk.StringVar()
especialidadTextm = tk.StringVar()
numColegiadoTextm = tk.StringVar()
cargoTextm = tk.StringVar()
observacionesTextm = tk.StringVar()

ttk.Label(tabMedicos, text="ID Médico:").grid(column=0, row=0, padx=20, pady=15)
ttk.Entry(tabMedicos, width=15, textvariable= idMedicoTextm).grid(column=1, row=0)

ttk.Label(tabMedicos, text="Nombre:").grid(column=0, row=1, padx=20, pady=15)
ttk.Entry(tabMedicos, width=15, textvariable= nombreTextm).grid(column=1, row=1)

ttk.Label(tabMedicos, text="Apellidos:").grid(column=0, row=2, padx=20, pady=15)
ttk.Entry(tabMedicos, width=15, textvariable= apellidosTextm).grid(column=1, row=2)

ttk.Label(tabMedicos, text="Especialidad:").grid(column=0, row=3, padx=20, pady=15)
ttk.Entry(tabMedicos, width=15, textvariable= especialidadTextm).grid(column=1, row=3)

ttk.Label(tabMedicos, text="Número de colegiado:").grid(column=0, row=4, padx=20, pady=15)
ttk.Entry(tabMedicos, width=15, textvariable= numColegiadoTextm).grid(column=1, row=4)

ttk.Label(tabMedicos, text="Cargo:").grid(column=0, row=5, padx=20, pady=15)
ttk.Entry(tabMedicos, width=15, textvariable= cargoTextm).grid(column=1, row=5)

ttk.Label(tabMedicos, text="Observaciones:").grid(column=0, row=6, padx=20, pady=15)
ttk.Entry(tabMedicos, width=15, textvariable= observacionesTextm).grid(column=1, row=6)

ttk.Button(tabMedicos, text="Insertar", command=insertarMedico).grid(column=0, row=7, padx=30, pady=20)
ttk.Button(tabMedicos, text="Eliminar", command=eliminarMedico).grid(column=1, row=7, padx=30)
ttk.Button(tabMedicos, text="Modificar", command=modificarMedico).grid(column=2, row=7, padx=30)
ttk.Button(tabMedicos, text="Consultar", command=consultarMedico).grid(column=3, row=7, padx=30)
#endregion

#region Ventana ingresos
idIngresoTexti = tk.StringVar()
procedenciaTexti = tk.StringVar()
fechaIngresoTexti = tk.StringVar()
numPlantaTexti = tk.StringVar()
numCamaTexti = tk.StringVar()
observacionesTexti = tk.StringVar()
idPacienteTexti = tk.StringVar()
idMedicoTexti = tk.StringVar()

ttk.Label(tabIngresos, text="ID Ingreso:").grid(column=0, row=0, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= idIngresoTexti).grid(column=1, row=0)

ttk.Label(tabIngresos, text="Procedencia:").grid(column=0, row=1, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= procedenciaTexti).grid(column=1, row=1)

ttk.Label(tabIngresos, text="Fecha ingreso:").grid(column=0, row=2, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= fechaIngresoTexti).grid(column=1, row=2)

ttk.Label(tabIngresos, text="Número de planta:").grid(column=0, row=3, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= numPlantaTexti).grid(column=1, row=3)

ttk.Label(tabIngresos, text="Número de cama:").grid(column=0, row=4, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= numCamaTexti).grid(column=1, row=4)

ttk.Label(tabIngresos, text="Observaciones:").grid(column=0, row=5, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= observacionesTexti).grid(column=1, row=5)

ttk.Label(tabIngresos, text="ID Paciente:").grid(column=0, row=6, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= idPacienteTexti).grid(column=1, row=6)

ttk.Label(tabIngresos, text="ID Médico:").grid(column=0, row=7, padx=20, pady=13)
ttk.Entry(tabIngresos, width=15, textvariable= idMedicoTexti).grid(column=1, row=7)

ttk.Button(tabIngresos, text="Insertar", command=insertarIngreso).grid(column=0, row=8, padx=30, pady=20)
ttk.Button(tabIngresos, text="Eliminar", command=eliminarIngreso).grid(column=1, row=8, padx=30)
ttk.Button(tabIngresos, text="Modificar", command=modificarIngreso).grid(column=2, row=8, padx=30)
ttk.Button(tabIngresos, text="Consultar", command=consultarIngreso).grid(column=3, row=8, padx=30)
#endregion

#region Ventana graficos
ttk.Button(tabGraficos, text="Porcentaje de pacientes por médico", command=generarGrafico1).grid(column=1, row=1, padx=30, pady=20)
ttk.Button(tabGraficos, text="Número de camas ocupadas por planta", command=generarGrafico2).grid(column=2, row=1, padx=30)
#endregion

interfaz.mainloop()