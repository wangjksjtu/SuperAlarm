package basic;
import java.util.ArrayList;

//Dulou on 10-29

public class itemManagerTest{
	private ItemManager IManager;
	private Item item;
	
	itemManager(){
		IManager=ItemManager();
		item=Item();
	}
	public void setItem(String title,String deadline,String importance,String content){
		this.item.title=title;
		this.item.deadline=deadline;
		this.item.importance=importance;
		this.item.content=content;
	}
	public int add(){
		this.IManager.add(this.item);
		return this.IManager.length;
	}
	public int delete(){
		this.IManager.delete(this.item);
		return this.IManager.length;
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