package superalarm.firsttry;
//Dulou on 11-3

public class itemManagerTest{
	private ItemManager IManager;
	private Item item;
	
	public itemManagerTest(){
		IManager = new ItemManager();
		item = new Item();		
	}

	public void setItem(String title,String deadline,char importance,String content){
		this.item.title=title;
		this.item.deadline=deadline;
		this.item.importance=importance-'0';
		this.item.content=content;
	}
	public int add(){
		try{
			this.IManager.add(this.item);
		}
		finally{
		return this.IManager.length;
		}
	}
	public int delete(){
		try{
			this.IManager.delete(this.item);
		}finally{
		return this.IManager.length;}
	}
	public boolean isExist(){
		return this.IManager.isExist(this.item);
	}
	public boolean search(){
		if(this.IManager.search(this.item)!=null)return true;
		return false;
	}
	public String sortByDeadline(){
		this.IManager.sortByDeadline();
		return this.IManager.itemArr.get(0).deadline;
	}
	public int sortByImportance(){
		this.IManager.sortByImportance();
		return this.IManager.itemArr.get(0).importance;
	}
}