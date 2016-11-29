from rest_framework import serializers
from items.models import Item, Group, ItemOfGroup
from django.contrib.auth.models import User
from django.contrib.auth import get_user_model # If used custom user model

UserModel = get_user_model()

class ItemSerializer(serializers.HyperlinkedModelSerializer):
	owner = serializers.ReadOnlyField(source='owner.username')

	class Meta:
		model = Item
		fields = ('url', 'id', 'owner', 'title', 'deadline', 'module', 'importance','content', 'created')

#class UserSerializer(serializers.HyperlinkedModelSerializer):
#    class Meta:
#        model = User
#        fields = ('url', 'id', 'username', 'password', 'email')

class UserSerializer(serializers.ModelSerializer):
    password = serializers.CharField(write_only=True)
    def create(self, validated_data):
        user = UserModel.objects.create(username = validated_data['username'])
        user.set_password(validated_data['password'])
        user.save()
        return user
    class Meta:
        model = UserModel
        fields = ('url','id','username','password','email')

class GroupSerializer(serializers.HyperlinkedModelSerializer):
	owner = serializers.ReadOnlyField(source='owner.username')
        
	class Meta:
		model = Group
		fields = ('url', 'id', 'owner', 'groupname', 'limit', 'member', 'item')

class ItemOfGroupSerializer(serializers.HyperlinkedModelSerializer):
	owner = serializers.ReadOnlyField(source='user.username')
        group = serializers.ReadOnlyField(source='group.groupname')
	class Meta:
		model = ItemOfGroup
		fields = ('url', 'id', 'group', 'owner', 'title', 'deadline', 'module', 'content', 'created')
	
