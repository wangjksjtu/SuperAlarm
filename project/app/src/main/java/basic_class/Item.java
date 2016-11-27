package basic_class;

/**date 10.23
 * @author yanglinbo
 */
/**
 * date:2016-10-02
 * @author wangjksjtu
 */

public class Item {
    private int Id;
    private String module;
    private String title;
    private String deadline;
    private int importance; 
    private String content;

    public Item(int id, String module, String title, String deadline, int importance, String content) {
        Id = id;
        this.module = module;
        this.title = title;
        this.deadline = deadline;
        this.importance = importance;
        this.content = content;
    }

    public Item(String cl, String t, String d, int i) {
        this(0, cl,t,d,i,"");
    }

    public Item(String cl, String t, String d, int i, String c) {
        this(0, cl,t,d,i,c);
    }

    public Item() {
        this(-1, "","","",1,"");
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    boolean equals(Item it) {
        if (this == it) return true;
        if (it == null) return false;
        return module.equals(it.module)&&title.equals(it.title) && deadline.equals(it.deadline) && (importance == it.importance) 
                && content.equals(it.content);
    }

    void copy(Item it) { //After test, I will delete the public
    	this.module=it.module;
        this.content = it.content;
        this.deadline = it.deadline;
        this.importance = it.importance;
        this.title = it.title;
    }
}
