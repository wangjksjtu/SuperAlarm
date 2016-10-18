package basic;

/**
 * date:2016-10-02
 * @author wangjksjtu
 */

public class Item {
    private String title;
    private String deadline;
    private int importance; 
    private String content;
    public Item(String t, String d, int i, String c) {
        title = t; deadline = d; importance = i; content = c;
    }
    public Item(String t, String d, int i) {this(t,d,i,"");}
    public Item(){this("","",1,"");}
    String getTitle() {return title;}
    String getDeadline() {return deadline;}
    int getImportance() {return importance;}
    String getContent() {return content;}
    void setTitle(String t) {title = t;}
    void setDeadline(String d) {deadline = d;}
    void setImportance(int i) {importance = i;}
    void setContent(String c) {content = c;}
    boolean equals(Item it) {
        if (this == it) return true;
        if (it == null) return false;
        return title.equals(it.title) && deadline.equals(it.deadline) && (importance == it.importance) 
                && content.equals(it.content);
    }
    void copy(Item it) { //After test, I will delete the public
        this.content = it.content;
        this.deadline = it.deadline;
        this.importance = it.importance;
        this.title = it.title;
    }
}
