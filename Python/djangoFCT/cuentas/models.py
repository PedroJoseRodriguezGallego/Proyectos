from django.db import models


# Create your models here.
class Cuenta(models.Model):
    usuario = models.CharField(max_length=50, unique=True)
    contrasena = models.CharField(max_length=50)
    tipo = models.CharField(max_length=50)

    def __str__(self):
        return self.usuario + " - " + self.tipo


class Tipo(models.Model):
    tipo = models.CharField(max_length=50)

    def __str__(self):
        return self.tipo
