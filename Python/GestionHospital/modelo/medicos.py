import modelo.conexion as c

con = c.Conexion()

def sacaUltimoId():
    con.conectar()
    ultimoId = 0
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT * FROM medicos")
            resultados = cursor.fetchall()
            ultimoId = resultados[len(resultados) - 1][0]
    finally:
        con.desconectar()
        return ultimoId

def existeMedico(id):
    result = consultarMedico(id)
    if result != None and len(result) > 0:
        return True
    else:
        return False

def insertarMedico(nombre, apellidos, especialidad, numColegiado, cargo, observaciones):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            consulta = "INSERT INTO medicos(nombre, apellidos, especialidad, numColegiado, cargo, observaciones) VALUES (%s, %s, %s, %s, %s, %s);"
            cursor.execute(consulta, (nombre, apellidos, especialidad, numColegiado, cargo, observaciones))
    finally:
        con.desconectar()

def consultarMedico(id):
    con.conectar()
    resultados = None
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT * FROM medicos WHERE idMedico = " + str(id) + ";")
            resultados = cursor.fetchall()
    finally:
        con.desconectar()
        return resultados

def modificarMedico(idMedico, nombre, apellidos, especialidad, numColegiado, cargo, observaciones):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            consulta = "UPDATE medicos SET nombre = %s, apellidos = %s, especialidad = %s, numColegiado = %s, cargo = %s, observaciones = %s WHERE idMedico = %s;"
            cursor.execute(consulta, (nombre,apellidos, especialidad, numColegiado, cargo, observaciones, idMedico))
    finally:
        con.desconectar()

def eliminarMedico(id):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("DELETE FROM medicos WHERE idMedico = " + str(id) + ";")
    finally:
        con.desconectar()