from django.db import models

# Create your models here.
class TutorDocente(models.Model):
    nombreApellido = models.CharField(max_length=150)
    email = models.CharField(max_length=60)
    telefono = models.CharField(max_length=9)

    def __str__(self):
        return self.nombreApellido
