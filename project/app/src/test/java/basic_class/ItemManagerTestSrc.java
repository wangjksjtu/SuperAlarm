package basic_class;

import java.util.ArrayList;
/**
 * Created by Dulou on 2016/11/27 0027.
 */

public class ItemManagerTestSrc {
    protected ArrayList<ItemTest> itemArr;
    protected int length;
    protected ItemManagerTestSrc() {
        itemArr = new ArrayList();
        length = 0;
    }
    protected boolean isExist(ItemTest item) {
        for (int i = 0; i < length; ++i) {
            if (itemArr.get(i).equals(item))
                return true;
        }
        return false;
    }
    protected ItemTest search(ItemTest item) {
        for (int i = 0; i < length; ++i) {
            if (itemArr.get(i).equals(item))
                return (ItemTest) itemArr.get(i);
        }
        return null;
    }
    protected void add(ItemTest item) throws RepeatedAddtionException {   //whether I should set this method private?
        if (isExist(item)) throw new RepeatedAddtionException();
        itemArr.add(item);
        ++length;
    }
    protected void delete(ItemTest item) throws NotExistException {   //whether I should set this method private?
        if (!isExist(item)) throw new NotExistException();
        itemArr.remove(item);
        --length;
    }
    protected void modify(ItemTest item, String t, String d, int i, String c) throws NotExistException {
        if (!isExist(item)) throw new NotExistException();
        item.setTitle(t);
        item.setDeadline(d);
        item.setImportance(i);
        item.setContent(c);
    }
    protected void modify(ItemTest item, String t, String d, int i) throws NotExistException {
        this.modify(item, t, d, i, "");
    }
    protected void sortByDeadline() {                  //It can be improved in algorithm.
        for (int i = 0; i < length - 1; ++i) {       //** I will add private after test.
            boolean flag = true;
            for (int j = 1; j < length - i; ++j) {
                if ((itemArr.get(j)).getDeadline().compareTo(itemArr.get(j - 1).getDeadline()) > 0) {
                    ItemTest temp = new ItemTest();
                    temp.copy(itemArr.get(j));
                    itemArr.get(j).copy(itemArr.get(j - 1));
                    itemArr.get(j - 1).copy(temp);
                }
                flag = false;
            }
            if (flag) break;
        }
    }
    protected void sortByImportance() {             //** I will add private after test.
        for (int i = 0; i < length - 1; ++i) {
            boolean flag = true;
            for (int j = 1; j < length - i; ++j) {
                if (itemArr.get(j).getImportance() >(itemArr.get(j - 1).getImportance())) {
                    ItemTest temp = new ItemTest();
                    temp.copy(itemArr.get(j));
                    itemArr.get(j).copy(itemArr.get(j - 1));
                    itemArr.get(j - 1).copy(temp);
                }
                flag = false;
            }
            if (flag) break;
        }
    }
    protected String display() {
        String s = "";
        for (int i = 0; i < length; ++i) {
            s = s + itemArr.get(i).getTitle() + "\t" + itemArr.get(i).getDeadline() + "\t\t" +
                    itemArr.get(i).getImportance() + "\t" + itemArr.get(i).getContent() + "\n";
        }
        return s;
    }
}
