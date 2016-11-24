from django.contrib import admin
from .models import Item, Group

class ItemAdmin(admin.ModelAdmin):
	list_display = ('id','owner', 'title', 'deadline', 'module', 'content')

class GroupAdmin(admin.ModelAdmin):
	list_display = ('id', 'owner', 'groupname', 'limit')

admin.site.register(Item, ItemAdmin)
admin.site.register(Group, GroupAdmin)
