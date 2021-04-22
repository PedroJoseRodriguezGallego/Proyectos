from django.db import models

# Create your models here.

class Alumno(models.Model):
    dni = models.CharField(max_length=9, unique=True)
    nombre = models.CharField(max_length=50)
    apellidos = models.CharField(max_length=100)
    fechaNacimiento = models.DateField() #aaaa-mm-dd

    def fechaFormateada(self):
        return str(self.fechaNacimiento).split()[0]

    def __str__(self):
        return self.nombre + " " + self.apellidos
