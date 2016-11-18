# Register my models here
from django.contrib import admin
from .models import User, Item, Group

class UserAdmin(admin.ModelAdmin):
	list_display = ('username', 'password', 'email', 'gender', 'age')

class ItemAdmin(admin.ModelAdmin):
	list_display = ('username', 'title', 'deadline', 'module','content', 'update_time')

class GroupAdmin(admin.ModelAdmin):
	lis_display = ('groupname', 'Owner', 'member', 'limit')

admin.site.register(User, UserAdmin)
admin.site.register(Item, ItemAdmin)
admin.site.register(Group, GroupAdmin)
