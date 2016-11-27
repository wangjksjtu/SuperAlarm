package basic_class;

class Group {
	private String url;
	private String id;
	private String owner;
	private String groupname;
	private String limit;
	private String member[];
	private String item[];
	public Group(String u,String  i,String o,String gN,String li,   String m[],String it[]){
		       url=u;
		       id=i;
		       owner=o;
		       groupname=gN;
		       limit=li;
		       member=m;
		       item=it;
         	}
	public Group(){}
    public void setUrl(String u)
            {url=u;}
    public void setId(String i)
     {id=i; }
    public void setOwner(String o){owner=o;}
    public void setGroupName(String gN){groupname=gN;}
    public void setLimit(String li){limit=li;}
    public void setMember(String m[]){member=m;}
    public void setItem (String it[]){item=it;}
    public String getUrl(){return url;}
    public String  getId(){return id;}
    public String getOwner(){return owner;}
    public String getGroupName(){return groupname;}
    public String  getLimit(){return limit;}
    public String[] getMember(){return member;}
    public String[]  getItem(){return item;}
    
    
}
