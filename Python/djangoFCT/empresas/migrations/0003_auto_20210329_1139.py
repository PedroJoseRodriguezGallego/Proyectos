# Generated by Django 3.1.7 on 2021-03-29 09:39

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('empresas', '0002_empresa_nombretutorlaboral'),
    ]

    operations = [
        migrations.AlterField(
            model_name='empresa',
            name='nombreTutorLaboral',
            field=models.CharField(max_length=50),
        ),
    ]
