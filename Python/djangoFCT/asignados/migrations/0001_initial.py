# Generated by Django 3.1.7 on 2021-03-22 17:39

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
                ('alumno', models.CharField(max_length=200)),
                ('empresa', models.CharField(max_length=200)),
                ('tutorDocente', models.CharField(max_length=200)),
                ('tutorLaboral', models.CharField(max_length=200)),
            ],
        ),
    ]