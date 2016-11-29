package basic_class;

/**
 * Created by Dulou on 2016/11/27 0027.
 */

public class itemManagerTest {
    private ItemManagerTestSrc IManager;
    private ItemTest item;

    public itemManagerTest(){
        IManager = new ItemManagerTestSrc();
        item = new ItemTest();
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
