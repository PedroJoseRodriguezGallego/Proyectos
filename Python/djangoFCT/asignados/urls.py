from django.urls import path
from . import views
import cuentas.views as viewsCuentas


urlpatterns = [
    path('', viewsCuentas.loggin, name='loggin'),
    path('index.html', views.index, name='index'),
    path('asignados/informeAsignado_edit', views.informeAsignado_new, name='informeAsignados_new'),
    path('asignados/asignado_list.html', views.asignados_list, name='asignados_list'),
    path('asignados/<int:pk>/', views.asignado_detail, name='asignado_detail'),
    path('asignados/new', views.asignado_new, name='asignado_new'),
    path('asignados/<int:pk>/edit/', views.asignado_edit, name='asignado_edit'),
    path('asignados/<int:pk>/delete/', views.asignado_delete, name='asignado_delete'),
]