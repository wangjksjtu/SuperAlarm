# -*- coding: utf-8 -*-
# Generated by Django 1.10.3 on 2016-11-18 11:45
from __future__ import unicode_literals

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('items', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Group',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('groupname', models.CharField(max_length=50)),
                ('limit', models.PositiveSmallIntegerField(default=100)),
            ],
        ),
        migrations.CreateModel(
            name='ItemOfGroup',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('created', models.DateTimeField(auto_now_add=True)),
                ('title', models.CharField(blank=True, default='', max_length=100)),
                ('deadline', models.CharField(max_length=20)),
                ('module', models.CharField(max_length=50)),
                ('content', models.TextField(blank=True, default='')),
                ('groupname', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='itemofgroupgroupname', to='items.Group')),
                ('owner', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='itemofgroupowner', to=settings.AUTH_USER_MODEL)),
            ],
        ),
        migrations.AlterField(
            model_name='item',
            name='owner',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='itemowner', to=settings.AUTH_USER_MODEL),
        ),
        migrations.AddField(
            model_name='group',
            name='item',
            field=models.ManyToManyField(related_name='groupitem', to='items.ItemOfGroup'),
        ),
        migrations.AddField(
            model_name='group',
            name='member',
            field=models.ManyToManyField(related_name='groupmember', to=settings.AUTH_USER_MODEL),
        ),
        migrations.AddField(
            model_name='group',
            name='owner',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='groupowner', to=settings.AUTH_USER_MODEL),
        ),
    ]
