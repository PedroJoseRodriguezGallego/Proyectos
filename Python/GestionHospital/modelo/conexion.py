import pymysql

class Conexion:
    def conectar(self):
        try:
            self.bdd = pymysql.connect(host='80.59.11.241', user='sge_crud_python', password='bhlh9THONjJkWmJQ', db='sge_crud_python')
        except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
            print("Ocurrió un error al conectar: ", e)

    def desconectar(self):
        self.bdd.commit()
        self.bdd.close()