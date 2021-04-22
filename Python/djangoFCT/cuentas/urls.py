from django.urls import path
from . import views

urlpatterns = [
    path('', views.loggin, name='loggin'),
    path('index.html', views.index, name='index'),
    path('cuentas/loggin', views.loggin, name='loggin'),
    path('cuentas/register', views.register, name='register'),
]
