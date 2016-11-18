# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.db import models
from django.core.urlresolvers import reverse
from DjangoUeditor.models import UEditorField

class User(models.Model):
	GENDER_CHOICES = (('M', 'Male'), ('F', 'Female'), ('S', 'Secret'))

	username = models.CharField(max_length=50)
	password = models.CharField(max_length=50)
	email = models.EmailField()
	gender = models.CharField(max_length=1, choices=GENDER_CHOICES)	
	age = models.IntegerField()

	def __unicode__(self):
		return self.username

class Item(models.Model):
	username = models.CharField('username', max_length=50)
	deadline = models.CharField('deadline', max_length=20)
	module = models.CharField('module', max_length=50)
	title = models.CharField('title', max_length=50)
	content = UEditorField('content', height=300, width=1000,
		default=u'', blank=True, imagePath='uploads/images/', 
		toolbars='besttome', filePath='uploads/files/')
	update_time = models.DateTimeField('update_time', auto_now=True, null=True)

	def get_absolute_url(self):
		return reverse('item', args=(self.id, self.module,))
	def __unicode__(self):
		return self.title
	
	class Meta:
		verbose_name = 'Items'
		verbose_name_plural = 'Items'

class Group(models.Model):
	groupname = models.CharField('groupname', max_length=50)
	groupowner = models.ForeignKey(User, related_name='Owner', blank=False, null=False)
	member = models.ManyToManyField(User, related_name='member')
	limit = models.PositiveSmallIntegerField(default=100)

	def get_absolute_url(self):
		return reverse('group', args=(self.id, self.groupname))
	def __unicode__(self):
		return self.groupname
