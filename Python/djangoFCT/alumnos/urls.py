from django.urls import path
from . import views
import cuentas.views as viewsCuentas

urlpatterns = [
    path('', viewsCuentas.loggin, name='loggin'),
    path('index.html', views.index, name='index'),
    path('alumnos/alumno_list.html', views.alumnos_list, name='alumnos_list'),
    path('alumnos/<int:pk>/', views.alumno_detail, name='alumno_detail'),
    path('alumnos/new', views.alumno_new, name='alumno_new'),
    path('alumnos/<int:pk>/edit/', views.alumno_edit, name='alumno_edit'),
    path('alumnos/<int:pk>/delete/', views.alumno_delete, name='alumno_delete'),
]
