from django.db import models

# Create your models here.
class Empresa(models.Model):
    nombre = models.CharField(max_length=50)
    cif = models.CharField(max_length=9, unique=True)
    direccion = models.CharField(max_length=100)
    cp = models.CharField(max_length=5)
    localidad = models.CharField(max_length=50)
    tipoJornada = models.CharField(max_length=15)
    dniResponsable = models.CharField(max_length=9, unique=True)
    nombreResponsable = models.CharField(max_length=50)
    apellidosResponsable = models.CharField(max_length=100)
    dniTutorLaboral = models.CharField(max_length=9, unique=True)
    nombreTutorLaboral = models.CharField(max_length=50)
    apellidosTutorLaboral = models.CharField(max_length=100)
    emailTutorLaboral = models.CharField(max_length=100)
    telefonoTutorLaboral = models.CharField(max_length=9)

    def __str__(self):
        return self.nombre
