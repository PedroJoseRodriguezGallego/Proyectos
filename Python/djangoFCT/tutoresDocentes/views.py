from django.shortcuts import render, get_object_or_404
from .models import TutorDocente
from .forms import TutorDocenteForm
import validador as validador

# Create your views here.
def index(request):
    return render(request, 'index.html')


def tutoresDocentes_list(request):
    tutoresDocentes = TutorDocente.objects.all()
    return render(request, 'tutoresDocentes/tutorDocente_list.html', {'tutoresDocentes': tutoresDocentes})


def tutorDocente_detail(request, pk):
    tutorDocente = get_object_or_404(TutorDocente, pk=pk)
    return render(request, 'tutoresDocentes/tutorDocente_detail.html', {'tutorDocente': tutorDocente})


def tutorDocente_new(request):
    if request.method == "POST":
        form = TutorDocenteForm(request.POST)
        if form.is_valid():
            tutorDocente = form.save(commit=False)
            if validador.revisaSoloLetras(tutorDocente.nombreApellido) and validador.revisaCorreo(tutorDocente.email) and validador.revisaTelefono(tutorDocente.telefono):
                tutorDocente.save()
                tutoresDocentes = TutorDocente.objects.all()
                return render(request, 'tutoresDocentes/tutorDocente_list.html', {'tutoresDocentes': tutoresDocentes})
            else:
                return render(request, 'tutoresDocentes/tutorDocente_edit.html', {'form': form})
    else:
        form = TutorDocenteForm()

    return render(request, 'tutoresDocentes/tutorDocente_edit.html', {'form': form})


def tutorDocente_edit(request, pk):
    tutorDocente = get_object_or_404(TutorDocente, pk=pk)
    if request.method == "POST":
        form = TutorDocenteForm(request.POST, instance=tutorDocente)
        if form.is_valid() and validador.revisaSoloLetras(tutorDocente.nombreApellido) and validador.revisaCorreo(tutorDocente.email) and validador.revisaTelefono(tutorDocente.telefono):
            tutorDocente = form.save(commit=False)
            tutorDocente.save()
            tutoresDocentes = TutorDocente.objects.all()
            return render(request, 'tutoresDocentes/tutorDocente_list.html', {'tutoresDocentes': tutoresDocentes})
        else:
            form = TutorDocenteForm(instance=tutorDocente)
    else:
        form = TutorDocenteForm(instance=tutorDocente)

    return render(request, 'tutoresDocentes/tutorDocente_edit.html', {'form': form})


def tutorDocente_delete(request, pk):
    TutorDocente.objects.filter(id=pk).delete()
    tutoresDocentes = TutorDocente.objects.all()
    return render(request, 'tutoresDocentes/tutorDocente_list.html', {'tutoresDocentes': tutoresDocentes})
