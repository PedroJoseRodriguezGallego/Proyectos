from django.urls import path
from . import views
import cuentas.views as viewsCuentas


urlpatterns = [
    path('', viewsCuentas.loggin, name='loggin'),
    path('index.html', views.index, name='index'),
    path('empresas/empresa_list.html', views.empresas_list, name='empresas_list'),
    path('empresas/<int:pk>/', views.empresa_detail, name='empresa_detail'),
    path('empresas/new', views.empresa_new, name='empresa_new'),
    path('empresas/<int:pk>/edit/', views.empresa_edit, name='empresa_edit'),
    path('empresas/<int:pk>/delete/', views.empresa_delete, name='empresa_delete'),
]