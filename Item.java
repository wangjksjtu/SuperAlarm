package item;
import java.io.*;
import java.io.IOException;
/**date 10.23 
 * @author yanglinbo
 */
/**
 * date:2016-10-02
 * @author wangjksjtu
 */

public class Item {
	private String classTitle;
    private String title;
    private String deadline;
    private int importance; 
    private String content;
    public Item(String cl,String t, String d, int i, String c) {
       classTitle=cl; title = t; deadline = d; importance = i; content = c;
    }
    public Item(String cl,String t, String d, int i) {this(cl,t,d,i,"");}
    public Item(){this("","","",1,"");}
    String getClasTitle(){return classTitle;}
    String getTitle() {return title;}
    String getDeadline() {return deadline;}
    int getImportance() {return importance;}
    String getContent() {return content;}
    void setClassTitle(String cl){classTitle =cl; }
    void setTitle(String t) {title = t;}
    void setDeadline(String d) {deadline = d;}
    void setImportance(int i) {importance = i;}
    void setContent(String c) {content = c;}
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
    String path;
    String fileName;
    path="D:/SuperAlarm"+classTitle;
    fileName=path+"/"+title+".txt";
    File filePath=new File(path);
    if (!filePath.exists()){filePath.mkdir();}
    FileWriter fw =new FileWriter(fileName,true);
    fw.write(classTitle+"\r\n");
    fw.write(title+"\r\n");
    fw.write(deadline+"\r\n");
    char simportance;
    simportance=(char)(importance+48);   
    fw.write(simportance+"\r\n");
    fw.write(content+"\r\n");
    fw.close();
    
    }
}
