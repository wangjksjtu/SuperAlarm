# -*- coding: utf-8 -*-
from south.utils import datetime_utils as datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models


class Migration(SchemaMigration):

    def forwards(self, orm):
        # Adding field 'User.sex'
        db.add_column(u'Users_user', 'sex',
                      self.gf('django.db.models.fields.CharField')(default='NotSure', max_length=10),
                      keep_default=False)

        # Adding field 'User.age'
        db.add_column(u'Users_user', 'age',
                      self.gf('django.db.models.fields.IntegerField')(default=0),
                      keep_default=False)


    def backwards(self, orm):
        # Deleting field 'User.sex'
        db.delete_column(u'Users_user', 'sex')

        # Deleting field 'User.age'
        db.delete_column(u'Users_user', 'age')


    models = {
        u'Users.user': {
            'Meta': {'object_name': 'User'},
            'age': ('django.db.models.fields.IntegerField', [], {}),
            'email': ('django.db.models.fields.EmailField', [], {'max_length': '75'}),
            u'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'password': ('django.db.models.fields.CharField', [], {'max_length': '50'}),
            'sex': ('django.db.models.fields.CharField', [], {'max_length': '10'}),
            'username': ('django.db.models.fields.CharField', [], {'max_length': '50'})
        }
    }

    complete_apps = ['Users']
