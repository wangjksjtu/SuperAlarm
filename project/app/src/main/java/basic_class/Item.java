package basic_class;

import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**date 10.23 
 * @author yanglinbo
 */
/**
 * date:2016-10-02
 * @author wangjksjtu
 */

public class Item {
    private int Id;
    private String classTitle;
    private String title;
    private String deadline;
    private int importance; 
    private String content;
    private Item(int id, String cl,String t, String d, int i, String c) {
       Id = id; classTitle=cl; title = t; deadline = d; importance = i; content = c;
    }
    public Item(String cl, String t, String d, int i) {this(0, cl,t,d,i,"");}
    public Item(String cl, String t, String d, int i, String c) {this(0, cl,t,d,i,c);;}
    public Item(){this(0, "","","",1,"");}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    public String getClassTitle(){return classTitle;}
    public String getTitle() {return title;}
    public String getDeadline() {return deadline;}
    public int getImportance() {return importance;}
    public String getContent() {return content;}
    public void setClassTitle(String cl){classTitle =cl; }
    public void setTitle(String t) {title = t;}
    public void setDeadline(String d) {deadline = d;}
    public void setImportance(int i) {importance = i;}
    public void setContent(String c) {content = c;}
    boolean equals(Item it) {
        if (this == it) return true;
        if (it == null) return false;
        return classTitle.equals(it.classTitle)&&title.equals(it.title) && deadline.equals(it.deadline) && (importance == it.importance) 
                && content.equals(it.content);
    }
    void copy(Item it) { //After test, I will delete the public
    	this.classTitle=it.classTitle;
        this.content = it.content;
        this.deadline = it.deadline;
        this.importance = it.importance;
        this.title = it.title;
    }
    
    //xieRu
    public void write ()throws IOException {
        //String path;
        //String fileName;
        //path="data";
        //fileName=path+"/" + "items.txt";
        //File filePath=new File(path);
        //if (!filePath.exists()){filePath.mkdir();}
        File filePath = Environment.getExternalStorageDirectory();
        //fileName = "/data/data/packagename/items.txt";
        FileWriter fw =new FileWriter(filePath,true);
        fw.write(classTitle+"\r\n");
        fw.write(title+"\r\n");
        fw.write(deadline+"\r\n");
        char simportance;
        simportance=(char)(importance+48);   
        fw.write(simportance+"\r\n");
        fw.write(content+"\r\n\r\n");
        fw.close();
    }
}
