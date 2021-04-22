from django.shortcuts import render, get_object_or_404
from .models import Empresa
from .forms import EmpresaForm
import validador as validador

# Create your views here.
def index(request):
    return render(request, 'index.html')


def empresas_list(request):
    empresas = Empresa.objects.all()
    return render(request, 'empresas/empresa_list.html', {'empresas': empresas})


def empresa_detail(request, pk):
    empresa = get_object_or_404(Empresa, pk=pk)
    return render(request, 'empresas/empresa_detail.html', {'empresa': empresa})


def empresa_new(request):
    if request.method == "POST":
        form = EmpresaForm(request.POST)
        if form.is_valid():
            empresa = form.save(commit=False)
            if validador.revisaDNI(empresa.cif) and validador.revisaCp(empresa.cp) and validador.revisaSoloLetras(empresa.localidad) and validador.revisaSoloLetras(empresa.tipoJornada) and validador.revisaDNI(empresa.dniResponsable) and validador.revisaSoloLetras(empresa.nombreResponsable) and validador.revisaSoloLetras(empresa.apellidosResponsable) and validador.revisaDNI(empresa.dniTutorLaboral) and validador.revisaSoloLetras(empresa.nombreTutorLaboral) and validador.revisaSoloLetras(empresa.apellidosTutorLaboral) and validador.revisaCorreo(empresa.emailTutorLaboral) and validador.revisaTelefono(empresa.telefonoTutorLaboral):
                empresa.save()
                empresas = Empresa.objects.all()
                return render(request, 'empresas/empresa_list.html', {'empresas': empresas})
            else:
                return render(request, 'empresas/empresa_edit.html', {'form': form})
    else:
        form = EmpresaForm()

    return render(request, 'empresas/empresa_edit.html', {'form': form})


def empresa_edit(request, pk):
    empresa = get_object_or_404(Empresa, pk=pk)
    if request.method == "POST":
        form = EmpresaForm(request.POST, instance=empresa)
        if form.is_valid() and validador.revisaDNI(empresa.cif) and validador.revisaCp(empresa.cp) and validador.revisaSoloLetras(empresa.localidad) and validador.revisaSoloLetras(empresa.tipoJornada) and validador.revisaDNI(empresa.dniResponsable) and validador.revisaSoloLetras(empresa.nombreResponsable) and validador.revisaSoloLetras(empresa.apellidosResponsable) and validador.revisaDNI(empresa.dniTutorLaboral) and validador.revisaSoloLetras(empresa.nombreTutorLaboral) and validador.revisaSoloLetras(empresa.apellidosTutorLaboral) and validador.revisaCorreo(empresa.emailTutorLaboral) and validador.revisaTelefono(empresa.telefonoTutorLaboral):
            empresa = form.save(commit=False)
            empresa.save()
            empresas = Empresa.objects.all()
            return render(request, 'empresas/empresa_list.html', {'empresas': empresas})
        else:
            form = EmpresaForm(instance=empresa)
    else:
        form = EmpresaForm(instance=empresa)

    return render(request, 'empresas/empresa_edit.html', {'form': form})


def empresa_delete(request, pk):
    Empresa.objects.filter(id=pk).delete()
    empresas = Empresa.objects.all()
    return render(request, 'empresas/empresa_list.html', {'empresas': empresas})
