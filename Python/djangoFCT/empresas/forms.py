from django import forms
from .models import Empresa

class EmpresaForm(forms.ModelForm):

    class Meta:
        model = Empresa
        fields = ('nombre', 'cif', 'direccion', 'cp', 'localidad', 'tipoJornada', 'dniResponsable', 'nombreResponsable', 'apellidosResponsable', 'dniTutorLaboral', 'nombreTutorLaboral', 'apellidosTutorLaboral', 'emailTutorLaboral', 'telefonoTutorLaboral')

    def __init__(self, *args, **kwargs):
        super(EmpresaForm, self).__init__(*args, **kwargs)
        self.fields['cif'].label = "CIF"
        self.fields['direccion'].label = "Dirección"
        self.fields['cp'].label = "Código postal"
        self.fields['tipoJornada'].label = "Tipo de jornada"
        self.fields['dniResponsable'].label = "DNI del responsable"
        self.fields['nombreResponsable'].label = "Nombre del responsable"
        self.fields['apellidosResponsable'].label = "Apellidos del responsable"
        self.fields['dniTutorLaboral'].label = "DNI del tutor laboral"
        self.fields['nombreTutorLaboral'].label = "Nombre del tutor laboral"
        self.fields['apellidosTutorLaboral'].label = "Apellidos del tutor laboral"
        self.fields['emailTutorLaboral'].label = "Email del tutor laboral"
        self.fields['telefonoTutorLaboral'].label = "Teléfono del tutor laboral"
