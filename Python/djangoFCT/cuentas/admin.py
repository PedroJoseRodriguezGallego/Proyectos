from django.contrib import admin

# Register your models here.
from cuentas.models import Cuenta, Tipo

admin.site.register(Cuenta)
