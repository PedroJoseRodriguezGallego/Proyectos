# Generated by Django 3.1.7 on 2021-03-22 17:16

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='TutorDocente',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombreApellido', models.CharField(max_length=150)),
                ('email', models.CharField(max_length=60)),
                ('telefono', models.CharField(max_length=9)),
            ],
        ),
    ]
