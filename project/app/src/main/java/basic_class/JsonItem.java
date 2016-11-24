package basic_class;

/**
 * Created by wangjksjtu on 2016/11/23.
 */

public class JsonItem {
    private int Id;
    private String title;
    private String deadline;
    private String module;
    private int importance;
    private String content;

    public JsonItem(int id, String title, String deadline, String module, int importance, String content) {
        Id = id;
        this.title = title;
        this.deadline = deadline;
        this.module = module;
        this.importance = importance;
        this.content = content;
    }

    public JsonItem(Item item) {
        Id = item.getId();
        title = item.getTitle();
        deadline = item.getDeadline();
        module = item.getClassTitle();
        importance = item.getImportance();
        content = item.getContent();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
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
}
