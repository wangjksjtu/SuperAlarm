from django.conf.urls import url, include
from items import views
from django.contrib.auth.forms import UserCreationForm
from rest_framework.urlpatterns import format_suffix_patterns

urlpatterns = format_suffix_patterns([
    url(r'^$', views.api_root),
    url(r'^items/$', views.ItemList.as_view(), name='item-list'),
    url(r'^items/(?P<pk>[0-9]+)/$', views.ItemDetail.as_view(), name='item-detail'),
    #url(r'^users/$', views.UserList.as_view(), name='user-list'),
	url(r'^users/$', views.CreateUserView.as_view(), name = 'user-register'),
    #url(r'^users/register$', views.UserRegister.as_view(), name='user-register'),
    url(r'^users/(?P<pk>[0-9]+)/$', views.UserDetail.as_view(), name='user-detail'),
    url(r'^groups/$', views.GroupList.as_view(), name='group-list'),
    url(r'^groups/(?P<pk>[0-9]+)/$', views.GroupDetail.as_view(), name='group-detail'),
    url(r'^items_of_groups/$', views.ItemOfGroupList.as_view(), name='itemofgroup-list'),
    url(r'^items_of_groups/(?P<pk>[0-9]+)/$', views.ItemOfGroupList.as_view(), name='itemofgroup-detail'),
])

# Login and logout views for the browsable API
urlpatterns += [
    url(r'^api-auth/', include('rest_framework.urls',
                               namespace='rest_framework')),
]
