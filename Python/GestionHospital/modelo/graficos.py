import modelo.conexion as c

con = c.Conexion()

def consultarDatosGrafico1():
    con.conectar()
    resultados = None
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT (COUNT(i.idIngreso)/(SELECT COUNT(*) FROM ingresos)) * 100 'Porcentaje de pacientes', m.nombre 'Nombre del médico' FROM ingresos i JOIN medicos m ON i.idMedico = m.idMedico GROUP BY m.idMedico")
            resultados = cursor.fetchall()
    finally:
        con.desconectar()
        return resultados

def consultarDatosGrafico2():
    con.conectar()
    resultados = None
    try:
        with con.bdd.cursor() as cursor:
            cursor.execute("SELECT COUNT(numCama) 'Número de camas ocupadas', CONCAT('Planta ',numPlanta) 'Planta' FROM ingresos GROUP BY numPlanta")
            resultados = cursor.fetchall()
    finally:
        con.desconectar()
        return resultados