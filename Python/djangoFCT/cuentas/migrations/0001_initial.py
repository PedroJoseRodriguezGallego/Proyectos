# Generated by Django 3.0.5 on 2021-04-12 15:13

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Asignado',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('usuario', models.CharField(max_length=50, unique=True)),
                ('contrasena', models.CharField(max_length=50)),
                ('tipo', models.CharField(max_length=50)),
            ],
        ),
    ]
