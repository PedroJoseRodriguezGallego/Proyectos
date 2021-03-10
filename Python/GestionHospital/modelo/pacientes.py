import modelo.conexion as c

con = c.Conexion()

def sacaUltimoId():
    con.conectar()
    ultimoId = 0
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT * FROM pacientes")
            resultados = cursor.fetchall()
            ultimoId = resultados[len(resultados) - 1][0]
    finally:
        con.desconectar()
        return ultimoId

def existePaciente(id):
    result = consultarPaciente(id)
    if result != None and len(result) > 0:
        return True
    else:
        return False

def insertarPaciente(numSS, nombre, apellidos, direccion, poblacion, provincia, cp, telefono, numHistorial, observaciones):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            consulta = "INSERT INTO pacientes(numSeguridadSocial, nombre, apellidos, direccion, poblacion, provincia, cp, telefono, numHistorial, observaciones) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s);"
            cursor.execute(consulta, (numSS, nombre, apellidos, direccion, poblacion, provincia, cp, telefono, numHistorial, observaciones))
    finally:
        con.desconectar()

def consultarPaciente(id):
    con.conectar()
    resultados = None
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT * FROM pacientes WHERE idPaciente = " + str(id) + ";")
            resultados = cursor.fetchall()
    finally:
        con.desconectar()
        return resultados

def modificarPaciente(idPaciente, numSeguridadSocial, nombre, apellidos, direccion, poblacion, provincia, cp, telefono, numHistorial, observaciones):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            consulta = "UPDATE pacientes SET numSeguridadSocial = %s, nombre = %s, apellidos = %s, direccion = %s, poblacion = %s, provincia = %s, cp = %s, telefono = %s, numHistorial = %s, observaciones = %s WHERE idPaciente = %s;"
            cursor.execute(consulta, (numSeguridadSocial,nombre, apellidos, direccion, poblacion, provincia, cp, telefono, numHistorial, observaciones, idPaciente))
    finally:
        con.desconectar()

def eliminarPaciente(id):
    con.conectar()
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("DELETE FROM pacientes WHERE idPaciente = " + str(id) + ";")
    finally:
        con.desconectar()