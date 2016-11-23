from rest_framework import generics
from rest_framework import permissions
from django.contrib.auth.models import User
from items.serializers import UserSerializer, GroupSerializer, ItemOfGroupSerializer
from items.models import Item, Group, ItemOfGroup
from items.serializers import ItemSerializer
from items.permissions import IsOwnerOrReadOnly, IsOwner, IsUser, IsOwnerOrIsMemberReadOnly
from rest_framework.decorators import api_view
from rest_framework.response import Response
from rest_framework.reverse import reverse
from rest_framework import renderers

class ItemList(generics.ListCreateAPIView):
    serializer_class = ItemSerializer
    permission_classes = (permissions.IsAuthenticated, IsOwner)
    def get_queryset(self):
        """
        This view should return a list of all the items
        for the currently authenticated user.
        """
        owner = self.request.user
        return Item.objects.filter(owner=owner)

    def perform_create(self, serializer):
        serializer.save(owner=self.request.user)

class ItemDetail(generics.RetrieveUpdateDestroyAPIView):
    permission_classes = (permissions.IsAuthenticated, IsOwner)
    queryset = Item.objects.all()
    serializer_class = ItemSerializer
    
#class UserRegister(generics.CreateAPIView):
#    serializer_class = UserSerializer

class UserList(generics.ListCreateAPIView):
    #permission_classes = (permissions.IsAuthenticated, IsUser)
    serializer_class = UserSerializer

    def get_queryset(self):
        user = self.request.user
        return User.objects.filter(username=user.username)

    def perform_create(self, serializer):
        serializer.save(owner=self.request.user)

class UserDetail(generics.RetrieveAPIView):
    permission_classes = (permissions.IsAuthenticated, IsUser)
    serializer_class = UserSerializer
    queryset = User.objects.all()
    '''def get_queryset(self):
        username = self.request.user
        return User.objects.filter(username=username)'''
    

class GroupList(generics.ListCreateAPIView):
    permission_classes = (permissions.IsAuthenticated, )
    serializer_class = GroupSerializer

    def get_queryset(self):
        user = self.request.user
        return Group.objects.filter(owner=user)
    
    def perform_create(self, serializer):
        serializer.save(owner=self.request.user)

class GroupDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Group.objects.all()
    serializer_class = GroupSerializer
    permission_classes = (permissions.IsAuthenticated, IsOwnerOrIsMemberReadOnly)

class ItemOfGroupList(generics.ListCreateAPIView):
    queryset = ItemOfGroup.objects.all()
    serializer_class = ItemOfGroupSerializer
    permission_classes = (permissions.IsAuthenticatedOrReadOnly,)

    def perform_create(self, serializer):
        serializer.save(owner=self.request.user)

class ItemOfGroupDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = ItemOfGroup.objects.all()
    serializer_class = ItemOfGroupSerializer
    permission_classes = (permissions.IsAuthenticatedOrReadOnly, IsOwnerOrReadOnly,)

@api_view(['GET'])
def api_root(request, format=None):
    return Response({
        'users': reverse('user-list', request=request, format=format),
        'items': reverse('item-list', request=request, format=format),
	'groups':  reverse('group-list', request=request, format=format),
	'items of groups': reverse('itemofgroup-list', request=request, format=format),
    })

