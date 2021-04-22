from django.shortcuts import render, get_object_or_404
from .models import Alumno
from .forms import AlumnoForm
import validador as validador


# Create your views here.

def index(request):
    return render(request, 'index.html')


def alumnos_list(request):
    alumnos = Alumno.objects.all()
    return render(request, 'alumnos/alumno_list.html', {'alumnos': alumnos})


def alumno_detail(request, pk):
    alumno = get_object_or_404(Alumno, pk=pk)
    return render(request, 'alumnos/alumno_detail.html', {'alumno': alumno})


def alumno_new(request):
    if request.method == "POST":
        form = AlumnoForm(request.POST)
        if form.is_valid():
            alumno = form.save(commit=False)
            if validador.revisaDNI(alumno.dni):
                alumno.save()
                alumnos = Alumno.objects.all()
                return render(request, 'alumnos/alumno_list.html', {'alumnos': alumnos})
            else:
                return render(request, 'alumnos/alumno_edit.html', {'form': form})
    else:
        form = AlumnoForm()

    return render(request, 'alumnos/alumno_edit.html', {'form': form})


def alumno_edit(request, pk):
    alumno = get_object_or_404(Alumno, pk=pk)
    if request.method == "POST":
        form = AlumnoForm(request.POST, instance=alumno)
        if form.is_valid() and validador.revisaDNI(alumno.dni) and validador.revisaSoloLetras(alumno.nombre) and validador.revisaSoloLetras(alumno.apellidos):
            alumno = form.save(commit=False)
            alumno.save()
            alumnos = Alumno.objects.all()
            return render(request, 'alumnos/alumno_list.html', {'alumnos': alumnos})
        else:
            form = AlumnoForm(instance=alumno)
    else:
        form = AlumnoForm(instance=alumno)

    return render(request, 'alumnos/alumno_edit.html', {'form': form})


def alumno_delete(request, pk):
    Alumno.objects.filter(id=pk).delete()
    alumnos = Alumno.objects.all()
    return render(request, 'alumnos/alumno_list.html', {'alumnos': alumnos})
