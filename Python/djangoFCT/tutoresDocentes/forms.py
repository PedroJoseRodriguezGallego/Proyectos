from django import forms
from .models import TutorDocente

class TutorDocenteForm(forms.ModelForm):

    class Meta:
        model = TutorDocente
        fields = ('nombreApellido', 'email', 'telefono')

    def __init__(self, *args, **kwargs):
        super(TutorDocenteForm, self).__init__(*args, **kwargs)
        self.fields['nombreApellido'].label = "Nombre y apellidos"
        self.fields['telefono'].label = "Teléfono"
