# Generated by Django 3.0.5 on 2021-04-19 15:14

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('asignados', '0003_remove_asignado_tutorlaboral'),
    ]

    operations = [
        migrations.CreateModel(
            name='InformeAsignados',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('nombreCurso', models.CharField(max_length=70)),
                ('alumnosTitulados', models.IntegerField()),
                ('alumnosOtrosEstudios', models.IntegerField()),
                ('alumnosParo', models.IntegerField()),
                ('alumnosTrabajaFCT', models.IntegerField()),
                ('alumnosTrabajaOtra', models.IntegerField()),
                ('alumnosContratoFijo', models.IntegerField()),
                ('alumnosContratoOtro', models.IntegerField()),
                ('alumnosSinSeguimiento', models.IntegerField()),
                ('alumnasTituladas', models.IntegerField()),
                ('alumnasOtrosEstudios', models.IntegerField()),
                ('alumnasParo', models.IntegerField()),
                ('alumnasTrabajaFCT', models.IntegerField()),
                ('alumnasTrabajaOtra', models.IntegerField()),
                ('alumnasContratoFijo', models.IntegerField()),
                ('alumnasContratoOtro', models.IntegerField()),
                ('alumnasSinSeguimiento', models.IntegerField()),
            ],
        ),
    ]
