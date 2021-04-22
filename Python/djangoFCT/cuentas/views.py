from django.shortcuts import render, redirect
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User, Group
from .forms import CuentaLoginForm, CuentaRegisterForm


# Create your views here.
def index(request):
    return render(request, 'index.html')


def register(request):
    if request.method == "POST":
        form = CuentaRegisterForm(request.POST)
        if form.is_valid():
            cuenta = form.save(commit=False)
            if cuenta.tipo == 'Alumno':
                user = User.objects.create_user(cuenta.usuario, cuenta.usuario + '@safareyes.es', cuenta.contrasena)
                user.save()
                group = Group.objects.get(name='alumnos')
                user.groups.add(group)
                user.save()
                cuenta.save()
                return redirect('loggin')
            elif cuenta.tipo == 'Tutor':
                user = User.objects.create_user(cuenta.usuario, cuenta.usuario + '@fundacionsafa.es', cuenta.contrasena)
                user.save()
                group = Group.objects.get(name='tutores')
                user.groups.add(group)
                user.save()
                cuenta.save()
                return redirect('loggin')
    else:
        form = CuentaRegisterForm()

    return render(request, 'cuentas/register.html', {'form': form})


def loggin(request):
    logout(request)
    if request.method == "POST":
        form = CuentaLoginForm(request.POST)
        usuario = form['usuario'].value()
        contrasena = form['contrasena'].value()
        user = authenticate(request, username=usuario, password=contrasena)
        if user is not None:
            login(request, user)
        else:
            newForm = CuentaLoginForm()
            return render(request, 'cuentas/loggin.html', {'form': newForm})
        return redirect('index')
    else:
        form = CuentaLoginForm()

    return render(request, 'cuentas/loggin.html', {'form': form})
