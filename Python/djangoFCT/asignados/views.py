from django.shortcuts import render, get_object_or_404
from .models import Asignado, InformeAsignados
from .forms import AsignadoForm, InformeAsignadosForm
from django.template.loader import render_to_string
from validador import generarPDF
import os
import pdfkit




# Create your views here.

def index(request):
    return render(request, 'index.html')


def asignados_list(request):
    asignados = Asignado.objects.all()
    return render(request, 'asignados/asignado_list.html', {'asignados': asignados})


def asignado_detail(request, pk):
    asignado = get_object_or_404(Asignado, pk=pk)
    return render(request, 'asignados/asignado_detail.html', {'asignado': asignado})


def asignado_new(request):
    if request.method == "POST":
        form = AsignadoForm(request.POST)
        if form.is_valid():
            asignado = form.save(commit=False)
            asignado.save()
            asignados = Asignado.objects.all()
            return render(request, 'asignados/asignado_list.html', {'asignados': asignados})
    else:
        form = AsignadoForm()

    return render(request, 'asignados/asignado_edit.html', {'form': form})


def asignado_edit(request, pk):
    asignado = get_object_or_404(Asignado, pk=pk)
    if request.method == "POST":
        form = AsignadoForm(request.POST, instance=asignado)
        if form.is_valid():
            asignado = form.save(commit=False)
            asignado.save()
            asignados = Asignado.objects.all()
            return render(request, 'asignados/asignado_list.html', {'asignados': asignados})
        else:
            form = AsignadoForm(instance=asignado)
    else:
        form = AsignadoForm(instance=asignado)

    return render(request, 'asignados/asignado_edit.html', {'form': form})


def asignado_delete(request, pk):
    Asignado.objects.filter(id=pk).delete()
    asignados = Asignado.objects.all()
    return render(request, 'asignados/asignado_list.html', {'asignados': asignados})


def informeAsignado_new(request):
    if request.method == "POST":
        form = InformeAsignadosForm(request.POST)
        if form.is_valid():
            informe = InformeAsignados()
            informe.nombreCurso = form['nombreCurso'].value()

            informe.alumnosTitulados = form['alumnosTitulados'].value()
            informe.alumnosOtrosEstudios = form['alumnosOtrosEstudios'].value()
            informe.alumnosParo = form['alumnosParo'].value()
            informe.alumnosTrabajaFCT = form['alumnosTrabajaFCT'].value()
            informe.alumnosTrabajaOtra = form['alumnosTrabajaOtra'].value()
            informe.alumnosContratoFijo = form['alumnosContratoFijo'].value()
            informe.alumnosContratoOtro = form['alumnosContratoOtro'].value()
            informe.alumnosSinSeguimiento = form['alumnosSinSeguimiento'].value()

            informe.alumnasTituladas = form['alumnasTituladas'].value()
            informe.alumnasOtrosEstudios = form['alumnasOtrosEstudios'].value()
            informe.alumnasParo = form['alumnasParo'].value()
            informe.alumnasTrabajaFCT = form['alumnasTrabajaFCT'].value()
            informe.alumnasTrabajaOtra = form['alumnasTrabajaOtra'].value()
            informe.alumnasContratoFijo = form['alumnasContratoFijo'].value()
            informe.alumnasContratoOtro = form['alumnasContratoOtro'].value()
            informe.alumnasSinSeguimiento = form['alumnasSinSeguimiento'].value()

            informe.familiaTitulada = int(informe.alumnosTitulados) + int(informe.alumnasOtrosEstudios)
            informe.familiaOtrosEstudios = int(informe.alumnosOtrosEstudios) + int(informe.alumnasOtrosEstudios)
            informe.familiaParo = int(informe.alumnosParo) + int(informe.alumnasParo)
            informe.familiaTrabajaFCT = int(informe.alumnosTrabajaFCT) + int(informe.alumnasTrabajaFCT)
            informe.familiaTrabajaOtra = int(informe.alumnosTrabajaOtra) + int(informe.alumnasTrabajaFCT)
            informe.familiaContratoFijo = int(informe.alumnosContratoFijo) + int(informe.alumnasContratoFijo)
            informe.familiaContratoOtro = int(informe.alumnosContratoOtro) + int(informe.alumnasContratoOtro)
            informe.familiaSinSeguimiento = int(informe.alumnosSinSeguimiento) + int(informe.alumnasSinSeguimiento)

            rendered = render_to_string('asignados/informeAsignado_detail.html', {'informe': informe})

            with open("reporte.html", "w") as fp:
                fp.write(rendered)
                fp.close()

            generarPDF()

            asignados = Asignado.objects.all()
            return render(request, 'asignados/asignado_list.html', {'asignados': asignados})
    else:
        form = InformeAsignadosForm()

    return render(request, 'asignados/informeAsignado_edit.html', {'form': form})
