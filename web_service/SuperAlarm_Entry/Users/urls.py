from django.conf.urls import patterns, url
from Users import views

urlpatterns = patterns('',
	url(r'^$', views.login, name = 'login'),
	url(r'^login/$',views.login,name = 'login'),
	url(r'^register/$',views.register,name = 'register'),
	url(r'^index/$',views.index,name = 'index'),
	url(r'^logout/$',views.logout,name = 'logout'),
)
