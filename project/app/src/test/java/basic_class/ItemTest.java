package basic_class;

/**
 * Created by Dulou on 2016/11/27 0027.
 */

public class ItemTest {
    protected String title;
    protected String deadline;
    protected int importance;
    protected String content;
    public ItemTest(String t, String d, int i, String c) {
        title = t; deadline = d; importance = i; content = c;
    }
    public ItemTest(String t, String d, int i) {this(t,d,i,"");}
    public ItemTest(){this("","",1,"");}
    public void setTitle(String t) {title = t;}
    public void setDeadline(String d) {deadline = d;}
    public void setImportance(int i) {importance = i;}
    public void setContent(String c) {content = c;}
    public String getTitle() {return title;}
    public String getDeadline() {return deadline;}
    public int getImportance() {return importance;}
    public String getContent() {return content;}
    public boolean equals(ItemTest it) {
        if (this == it) return true;
        if (it == null) return false;
        return title.equals(it.title) && deadline.equals(it.deadline) && (importance == it.importance)
                && content.equals(it.content);
    }
    void copy(ItemTest it) { //After test, I will delete the public
        this.content = it.content;
        this.deadline = it.deadline;
        this.importance = it.importance;
        this.title = it.title;
    }
    public String getEquals(){
        ItemTest m = new ItemTest("abc","2.15",5,"ttt");
        return (this.equals(m)?"yes":"no");
    }

}
