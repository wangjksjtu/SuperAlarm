# -*- coding: utf-8 -*-
from south.utils import datetime_utils as datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models


class Migration(SchemaMigration):

    def forwards(self, orm):
        # Adding model 'Item'
        db.create_table(u'Users_item', (
            (u'id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('username', self.gf('django.db.models.fields.CharField')(max_length=50)),
            ('deadline', self.gf('django.db.models.fields.CharField')(max_length=20)),
            ('module', self.gf('django.db.models.fields.CharField')(max_length=50)),
            ('title', self.gf('django.db.models.fields.CharField')(max_length=50)),
            ('content', self.gf('DjangoUeditor.models.UEditorField')(default=u'', blank=True)),
            ('update_time', self.gf('django.db.models.fields.DateTimeField')(auto_now=True, null=True, blank=True)),
        ))
        db.send_create_signal(u'Users', ['Item'])

        # Deleting field 'User.sex'
        db.delete_column(u'Users_user', 'sex')

        # Adding field 'User.gender'
        db.add_column(u'Users_user', 'gender',
                      self.gf('django.db.models.fields.CharField')(default=u'Not Sure', max_length=10),
                      keep_default=False)


    def backwards(self, orm):
        # Deleting model 'Item'
        db.delete_table(u'Users_item')

        # Adding field 'User.sex'
        db.add_column(u'Users_user', 'sex',
                      self.gf('django.db.models.fields.CharField')(default='Error', max_length=10),
                      keep_default=False)

        # Deleting field 'User.gender'
        db.delete_column(u'Users_user', 'gender')


    models = {
        u'Users.item': {
            'Meta': {'object_name': 'Item'},
            'content': ('DjangoUeditor.models.UEditorField', [], {'default': "u''", 'blank': 'True'}),
            'deadline': ('django.db.models.fields.CharField', [], {'max_length': '20'}),
            u'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'module': ('django.db.models.fields.CharField', [], {'max_length': '50'}),
            'title': ('django.db.models.fields.CharField', [], {'max_length': '50'}),
            'update_time': ('django.db.models.fields.DateTimeField', [], {'auto_now': 'True', 'null': 'True', 'blank': 'True'}),
            'username': ('django.db.models.fields.CharField', [], {'max_length': '50'})
        },
        u'Users.user': {
            'Meta': {'object_name': 'User'},
            'age': ('django.db.models.fields.IntegerField', [], {}),
            'email': ('django.db.models.fields.EmailField', [], {'max_length': '75'}),
            'gender': ('django.db.models.fields.CharField', [], {'default': "u'Not Sure'", 'max_length': '10'}),
            u'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'password': ('django.db.models.fields.CharField', [], {'max_length': '50'}),
            'username': ('django.db.models.fields.CharField', [], {'max_length': '50'})
        }
    }

    complete_apps = ['Users']