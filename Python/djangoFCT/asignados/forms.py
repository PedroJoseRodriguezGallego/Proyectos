from django import forms
from .models import Asignado, InformeAsignados
from alumnos.models import Alumno
from empresas.models import Empresa
from tutoresDocentes.models import TutorDocente


class AsignadoForm(forms.ModelForm):

    class Meta:
        model = Asignado
        fields = '__all__'

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['alumno'] = forms.ModelChoiceField(queryset=Alumno.objects.all())
        self.fields['tutorDocente'] = forms.ModelChoiceField(queryset=TutorDocente.objects.all())
        self.fields['empresa'] = forms.ModelChoiceField(queryset=Empresa.objects.all())

        self.fields['tutorDocente'].label = "Tutor docente"


class InformeAsignadosForm(forms.ModelForm):

    class Meta:
        model = InformeAsignados
        fields = ('nombreCurso', 'alumnosTitulados', 'alumnosOtrosEstudios', 'alumnosParo', 'alumnosTrabajaFCT', 'alumnosTrabajaOtra', 'alumnosContratoFijo', 'alumnosContratoOtro', 'alumnosSinSeguimiento', 'alumnasTituladas', 'alumnasOtrosEstudios', 'alumnasParo', 'alumnasTrabajaFCT', 'alumnasTrabajaOtra', 'alumnasContratoFijo', 'alumnasContratoOtro', 'alumnasSinSeguimiento')

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['nombreCurso'].label = "Nombre del curso"
        self.fields['alumnosTitulados'].label = "Alumnos titulados"
        self.fields['alumnosOtrosEstudios'].label = "Alumnos cursando estudios"
        self.fields['alumnosParo'].label = "Alumnos en paro"
        self.fields['alumnosTrabajaFCT'].label = "Alumnos trabajando en empresa FCT"
        self.fields['alumnosTrabajaOtra'].label = "Alumnos trabajando en otra empresa"
        self.fields['alumnosContratoFijo'].label = "Alumnos con contrato fijo"
        self.fields['alumnosContratoOtro'].label = "Alumnos con otro contrato"
        self.fields['alumnosSinSeguimiento'].label = "Alumnos sin seguimiento"
        self.fields['alumnasTituladas'].label = "Alumnas tituladas"
        self.fields['alumnasOtrosEstudios'].label = "Alumnas cursando estudios"
        self.fields['alumnasParo'].label = "Alumnas en paro"
        self.fields['alumnasTrabajaFCT'].label = "Alumnas trabajando en empresa FCT"
        self.fields['alumnasTrabajaOtra'].label = "Alumnas trabajando en otra empresa"
        self.fields['alumnasContratoFijo'].label = "Alumnas con contrato fijo"
        self.fields['alumnasContratoOtro'].label = "Alumnas con otro contrato"
        self.fields['alumnasSinSeguimiento'].label = "Alumnas sin seguimiento"
