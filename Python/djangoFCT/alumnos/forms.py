from django import forms
from .models import Alumno

class AlumnoForm(forms.ModelForm):

    class Meta:
        model = Alumno
        fields = ('dni', 'nombre', 'apellidos', 'fechaNacimiento')

    def __init__(self, *args, **kwargs):
        super(AlumnoForm, self).__init__(*args, **kwargs)
        self.fields['fechaNacimiento'].label = "Fecha de nacimiento"
        self.fields['dni'].label = "DNI"
