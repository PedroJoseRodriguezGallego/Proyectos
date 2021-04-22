from django import forms
from .models import Cuenta, Tipo


class CuentaRegisterForm(forms.ModelForm):

    class Meta:
        model = Cuenta
        fields = '__all__'

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['tipo'] = forms.ModelChoiceField(queryset=Tipo.objects.all())
        self.fields['contrasena'] = forms.CharField(widget=forms.PasswordInput())
        self.fields['contrasena'].label = "Contraseña"


class CuentaLoginForm(forms.ModelForm):

    class Meta:
        model = Cuenta
        fields = ('usuario', 'contrasena')

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['contrasena'] = forms.CharField(widget=forms.PasswordInput())
        self.fields['contrasena'].label = "Contraseña"
