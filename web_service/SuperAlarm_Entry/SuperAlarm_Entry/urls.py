from django.conf.urls import patterns, include, url
from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'SuperAlarm_Entry.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),
	url(r'^Users/', include('Users.urls')),
    url(r'^admin/', include(admin.site.urls)),
	url(r'^ueditor/', include('DjangoUeditor.urls')),
)

# use Django server /media/ files
from django.conf import settings
if settings.DEBUG:
	from django.conf.urls.static import static
	urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)

