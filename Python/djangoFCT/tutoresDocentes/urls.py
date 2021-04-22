from django.urls import path
from . import views
import cuentas.views as viewsCuentas

urlpatterns = [
    path('', viewsCuentas.loggin, name='loggin'),
    path('index.html', views.index, name='index'),
    path('tutoresDocentes/tutorDocente_list.html', views.tutoresDocentes_list, name='tutoresDocentes_list'),
    path('tutoresDocentes/<int:pk>/', views.tutorDocente_detail, name='tutorDocente_detail'),
    path('tutoresDocentes/new', views.tutorDocente_new, name='tutorDocente_new'),
    path('tutoresDocentes/<int:pk>/edit/', views.tutorDocente_edit, name='tutorDocente_edit'),
    path('tutoresDocentes/<int:pk>/delete/', views.tutorDocente_delete, name='tutorDocente_delete'),
]