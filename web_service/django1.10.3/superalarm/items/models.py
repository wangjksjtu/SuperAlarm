from __future__ import unicode_literals
from django.db import models

GENDER_CHOICES = (('M', 'Male'), ('F', 'Female'), ('S', 'Secret'))

class Item(models.Model):
	created = models.DateTimeField(auto_now_add=True)
	title = models.CharField(max_length=100, blank=True, default='')
	deadline = models.CharField(max_length=20)
	module = models.CharField(max_length=50)
	importance = models.PositiveSmallIntegerField(default=3,blank=False)
	content = models.TextField(blank=True, default='')
	owner = models.ForeignKey('auth.User', related_name='items', on_delete=models.CASCADE)

	def __unicode__(self):
		return self.title + '(id:' + str(self.id) + ')'

class Group(models.Model):
	groupname = models.CharField(max_length=50)
	member = models.ManyToManyField('auth.User',related_name='groupmember')
	limit = models.PositiveSmallIntegerField(default=100, blank=False)
	owner = models.ForeignKey('auth.User', related_name='group', on_delete=models.CASCADE)
	item = models.ManyToManyField('ItemOfGroup', related_name='groupitem', blank=True)

	def __unicode__(self):
		return self.groupname + '(id:' + str(self.id) + ')'

class ItemOfGroup(models.Model):
	created = models.DateTimeField(auto_now_add=True)
	title = models.CharField(max_length=100, blank=True, default='')
	deadline = models.CharField(max_length=20)
	module = models.CharField(max_length=50)
	content = models.TextField(blank=True, default='')
	owner = models.ForeignKey('auth.User', related_name='itemofgroupowner', on_delete=models.CASCADE)
	group = models.ForeignKey('Group', related_name='itemofgroupgroupname', on_delete=models.CASCADE)

	def __unicode__(self): 
		return self.title + '(id:' + str(self.id) + ')'
