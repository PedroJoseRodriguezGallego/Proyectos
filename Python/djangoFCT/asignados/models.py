from django.db import models

# Create your models here.
class Asignado(models.Model):
    alumno = models.CharField(max_length=200, unique=True)
    empresa = models.CharField(max_length=200)
    tutorDocente = models.CharField(max_length=200)


    def __str__(self):
        return self.alumno + " - " + self.empresa


class InformeAsignados(models.Model):
    nombreCurso = models.CharField(max_length=70)

    alumnosTitulados = models.IntegerField(default=0)
    alumnosOtrosEstudios = models.IntegerField(default=0)
    alumnosParo = models.IntegerField(default=0)
    alumnosTrabajaFCT = models.IntegerField(default=0)
    alumnosTrabajaOtra = models.IntegerField(default=0)
    alumnosContratoFijo = models.IntegerField(default=0)
    alumnosContratoOtro = models.IntegerField(default=0)
    alumnosSinSeguimiento = models.IntegerField(default=0)

    alumnasTituladas = models.IntegerField(default=0)
    alumnasOtrosEstudios = models.IntegerField(default=0)
    alumnasParo = models.IntegerField(default=0)
    alumnasTrabajaFCT = models.IntegerField(default=0)
    alumnasTrabajaOtra = models.IntegerField(default=0)
    alumnasContratoFijo = models.IntegerField(default=0)
    alumnasContratoOtro = models.IntegerField(default=0)
    alumnasSinSeguimiento = models.IntegerField(default=0)

    familiaTitulada = models.IntegerField(default=0)
    familiaOtrosEstudios = models.IntegerField(default=0)
    familiaParo = models.IntegerField(default=0)
    familiaTrabajaFCT = models.IntegerField(default=0)
    familiaTrabajaOtra = models.IntegerField(default=0)
    familiaContratoFijo = models.IntegerField(default=0)
    familiaContratoOtro = models.IntegerField(default=0)
    familiaSinSeguimiento = models.IntegerField(default=0)

    def __str__(self):
        return self.nombreCurso
