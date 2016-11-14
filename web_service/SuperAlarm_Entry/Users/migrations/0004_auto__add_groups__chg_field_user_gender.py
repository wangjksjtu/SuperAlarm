# -*- coding: utf-8 -*-
from south.utils import datetime_utils as datetime
from south.db import db
from south.v2 import SchemaMigration
from django.db import models


class Migration(SchemaMigration):

    def forwards(self, orm):
        # Adding model 'Groups'
        db.create_table(u'Users_groups', (
            (u'id', self.gf('django.db.models.fields.AutoField')(primary_key=True)),
            ('groupname', self.gf('django.db.models.fields.CharField')(max_length=50)),
            ('groupowner', self.gf('django.db.models.fields.related.ForeignKey')(related_name=u'Owner', to=orm['Users.User'])),
            ('limit', self.gf('django.db.models.fields.PositiveSmallIntegerField')(default=100)),
        ))
        db.send_create_signal(u'Users', ['Groups'])

        # Adding M2M table for field member on 'Groups'
        m2m_table_name = db.shorten_name(u'Users_groups_member')
        db.create_table(m2m_table_name, (
            ('id', models.AutoField(verbose_name='ID', primary_key=True, auto_created=True)),
            ('groups', models.ForeignKey(orm[u'Users.groups'], null=False)),
            ('user', models.ForeignKey(orm[u'Users.user'], null=False))
        ))
        db.create_unique(m2m_table_name, ['groups_id', 'user_id'])


        # Changing field 'User.gender'
        db.alter_column(u'Users_user', 'gender', self.gf('django.db.models.fields.CharField')(max_length=1))

    def backwards(self, orm):
        # Deleting model 'Groups'
        db.delete_table(u'Users_groups')

        # Removing M2M table for field member on 'Groups'
        db.delete_table(db.shorten_name(u'Users_groups_member'))


        # Changing field 'User.gender'
        db.alter_column(u'Users_user', 'gender', self.gf('django.db.models.fields.CharField')(max_length=10))

    models = {
        u'Users.groups': {
            'Meta': {'object_name': 'Groups'},
            'groupname': ('django.db.models.fields.CharField', [], {'max_length': '50'}),
            'groupowner': ('django.db.models.fields.related.ForeignKey', [], {'related_name': "u'Owner'", 'to': u"orm['Users.User']"}),
            u'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'limit': ('django.db.models.fields.PositiveSmallIntegerField', [], {'default': '100'}),
            'member': ('django.db.models.fields.related.ManyToManyField', [], {'related_name': "u'member'", 'symmetrical': 'False', 'to': u"orm['Users.User']"})
        },
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
            'gender': ('django.db.models.fields.CharField', [], {'max_length': '1'}),
            u'id': ('django.db.models.fields.AutoField', [], {'primary_key': 'True'}),
            'password': ('django.db.models.fields.CharField', [], {'max_length': '50'}),
            'username': ('django.db.models.fields.CharField', [], {'max_length': '50'})
        }
    }

    complete_apps = ['Users']