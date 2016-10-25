package basic;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
        
/**
 * date:2016-10-02
 * @author wangjksjtu
 */

class RepeatedAddtionException extends Exception {
    public RepeatedAddtionException() {
        super("The items has existed!");
    }
} 

class NotExistException extends Exception {
    public NotExistException() {
        super("The items isn't existed!");
    }
}

public class ItemManager {
    private ArrayList<Item> itemArr;
    private int length;
    ItemManager() {
         itemArr = new ArrayList();
         length = 0;
    }
    private boolean isExist(Item item) {
        for (int i = 0; i < length; ++i) {
            if (itemArr.get(i).equals(item))
                return true;
        }
        return false;
    } 
    private Item search(Item item) {
        for (int i = 0; i < length; ++i) {
            if (itemArr.get(i).equals(item))
                return (Item) itemArr.get(i);
        }
        return null;
    }
    void add(Item item) throws RepeatedAddtionException {   //whether I should set this method private?
        if (isExist(item)) throw new RepeatedAddtionException();
        itemArr.add(item);
        ++length;
    }
    void delete(Item item) throws NotExistException {   //whether I should set this method private?
        if (!isExist(item)) throw new NotExistException();
        itemArr.remove(item);
        --length;
    }
    void modify(Item item, String t, String d, int i, String c) throws NotExistException {
        if (!isExist(item)) throw new NotExistException();
        item.setTitle(t);
        item.setDeadline(d);
        item.setImportance(i);
        item.setContent(c);
    }
    void modify(Item item, String t, String d, int i) throws NotExistException {
        this.modify(item, t, d, i, "");
    }
    void sortByDeadline() {                  //It can be improved in algorithm.
        for (int i = 0; i < length - 1; ++i) {       //** I will add private after test.
            boolean flag = true;
            for (int j = 1; j < length - i; ++j) {
                if ((itemArr.get(j)).getDeadline().compareTo(itemArr.get(j - 1).getDeadline()) > 0) {
                    Item temp = new Item();
                    temp.copy(itemArr.get(j));
                    itemArr.get(j).copy(itemArr.get(j - 1));
                    itemArr.get(j - 1).copy(temp);
                }
                flag = false;
            }
            if (flag) break;
        }
    }
    void sortByImportance() {             //** I will add private after test.
        for (int i = 0; i < length - 1; ++i) {
            boolean flag = true;
            for (int j = 1; j < length - i; ++j) {
                if (itemArr.get(j).getImportance() >(itemArr.get(j - 1).getImportance())) {
                    Item temp = new Item();
                    temp.copy(itemArr.get(j));
                    itemArr.get(j).copy(itemArr.get(j - 1));
                    itemArr.get(j - 1).copy(temp);
                }
                flag = false;
            }
            if (flag) break;
        }
    }
    void write() throws IOException {
        File newfile = new File("./ItemData/items.txt");
        newfile.delete();
        newfile.createNewFile();
        for (int i = 0; i < length; ++i) {
            itemArr.get(i).write();
        }
    }
    String display() {
        String s = "";
        for (int i = 0; i < length; ++i) {
            s = s + itemArr.get(i).getClassTitle() + "\t" + itemArr.get(i).getTitle() + "\t" + itemArr.get(i).getDeadline() + "\t\t" + 
            itemArr.get(i).getImportance() + "\t" + itemArr.get(i).getContent() + "\n";
        }
        return s;
    }
}
