package basic_class;

 class ItemOfGroup {
	 private String url;
		private String id;
		private String owner;
		private String title;
		private String deadline;
		private String module;
		private String importance;
		private String content;
		private String created;
	
	
	
		public ItemOfGroup(String u,String Id,String o,String t,String d , String m,String i,String con,String crea ){
			       url=u;
			       id=Id;
			       owner=o;
			       title=t;
			       deadline=d;
			       module=m;
			       importance=i;
			       content=con;
			       created=crea;
	         	}

     public ItemOfGroup() {
         this("", "", "", "", "", "", "", "", "");
     }

     public void ItemOfGroup(){

		}

	    public void setUrl(String u){url=u;}
	    
	    public void setId(String i){id=i; }
	    
	    public void setOwner(String o){owner=o;}
	    
	    public void setTitle(String t){title=t;}
	    
	    public void setDeadline(String d){deadline=d;}
	    
	    public void setModule(String m){module=m;}
	    
	    public void setImportance(String i){importance=i;}
	    
	    public void setContent(String con){content=con;}
	    
	    public void setCreated(String c){created=c;}
	    
	    public String getUrl(){return url;}
	    
	    public String  getId(){return id;}
	    
	    public String getOwner(){return owner;}
	    
	    public String getTitle(){return title;}
	    
	    public String   getDeadline(){return deadline;}
	    
	    public String getModule (){return module ;}
	    
	    public String   getImportance(){return importance;}
	    
	    public String getContent (){return content ;}
	    
	    public String getCreated (){return created ;}
	  
	    
	    
}
