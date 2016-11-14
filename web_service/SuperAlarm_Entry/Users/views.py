from django.http import HttpResponse,HttpResponseRedirect
from django.shortcuts import render, render_to_response
from django.template import RequestContext
from django import forms
from .models import User, Item

#Userform
class UserForm(forms.Form):
	username = forms.CharField(label='username', max_length = 100)
	password = forms.CharField(label='password', widget=forms.PasswordInput())
	email = forms.EmailField(label='email')
	gender = forms.CharField(label='sex')
	age = forms.IntegerField(label='age')

#User Registration
def register(request):
	if request.method == 'POST':
		userform = UserForm(request.POST)
		if userform.is_valid():
			#get data from Userform
			username = userform.cleaned_data['username']
			password = userform.cleaned_data['password']
			email = userform.cleaned_data['email']
			gender = userform.cleaned_data['gender']
			age = userform.cleaned_data['age']
			#add user to SQlite Database
			'''user = User()
			user.username = username
			user.password = password
			user.email = email
			user.gender = gender
			user.age = age
			user.save()'''
			User.objects.create(username=username, password=password, email=email, gender=gender, age=age)
			return HttpResponse('Successgully sign in!')
		else: pass #This part is unfinished
	else:
		userform = UserForm()
	return render_to_response('register.html', {'userform':userform}, context_instance = RequestContext(request))

#User login
def login(request):
	if request.method == 'POST':
		userform = UserForm(request.POST)
		if userform.is_valid():
			#get username and password from Userform
			username = userform.cleaned_data['username']
			password = userform.cleaned_data['password']
			#compare the form data with those in Database
			flag = User.objects.filter(username__exact = username,password__exact = password)
			if flag:  
				#if the data are same, jump to index page.
				response = HttpResponseRedirect('/Users/index/')
                #put username in browser's cookie
				response.set_cookie('username', username, 3600)
				return response
			else:
				#if the data are different, stay this page
				return HttpResponseRedirect('/Users/login/')
	else:
		userform = UserForm()
	return render_to_response('login.html',{'userform':userform},context_instance=RequestContext(request))

#Sucessfully log in
def index(request):
	username = request.COOKIES.get('username','')
	return render_to_response('index.html' ,{'username':username})

#Log out
def logout(request):
	response = HttpResponse('logout')
	#clear cookies
	response.delete_cookie('username')
	return response


