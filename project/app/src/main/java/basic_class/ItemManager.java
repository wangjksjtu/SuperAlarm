package basic_class;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ItemManager {

    public ArrayList<Item> itemArr;
    public int length;

    public ItemManager() {
         itemArr = new ArrayList();
         length = 0;
    }
    protected boolean isExist(Item item) {
        for (int i = 0; i < length; ++i) {
            if (itemArr.get(i).equals(item))
                return true;
        }
        return false;
    } 
    protected Item search(Item item) {
        for (int i = 0; i < length; ++i) {
            if (itemArr.get(i).equals(item))
                return (Item) itemArr.get(i);
        }
        return null;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<Item> getItemArr() {
        return itemArr;
    }

    public void add(Item item) throws RepeatedAddtionException {
        itemArr.add(item);
        ++length;
    }
    public void delete(Item item) throws NotExistException {
        if (!isExist(item)) throw new NotExistException();
        itemArr.remove(item);
        --length;
    }
    public void modify(Item item, String t, String d, int i, String c) throws NotExistException {
        if (!isExist(item)) throw new NotExistException();
        item.setTitle(t);
        item.setDeadline(d);
        item.setImportance(i);
        item.setContent(c);
    }
    void modify(Item item, String t, String d, int i) throws NotExistException {
        this.modify(item, t, d, i, "");
    }
    public void sortByDeadline() {                  //It can be improved in algorithm.
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
    public void sortByImportance() {             //** I will add private after test.
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

    public void write(Context context) {
        try {
            String data = "";
            for (int i = 0; i < length; ++i) {
                data += itemArr.get(i).getId() + "\r\n";
                data += itemArr.get(i).getModule() + "\r\n";
                data += itemArr.get(i).getTitle() + "\r\n";
                data += itemArr.get(i).getDeadline() + "\r\n";
                data += itemArr.get(i).getImportance() + "\r\n";
                data += itemArr.get(i).getContent() + "\r\n";
                data += "\r\n";
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("items.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public void read(Context context) {
        try {
            InputStream inputStream = context.openFileInput("items.txt");
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String data = bufferedReader.readLine();
                while  (data!=null) {
                    Item item = new Item();
                    for (int i = 0; i < 6; ++i) {
                        switch(i % 6) {
                            case 0:
                                item.setId(Integer.valueOf(data));
                                data = bufferedReader.readLine();
                                break;
                            case 1:
                                item.setModule(data);
                                data = bufferedReader.readLine();
                                break;
                            case 2:
                                item.setTitle(data); data = bufferedReader.readLine();
                                break;
                            case 3:
                                item.setDeadline(data); data = bufferedReader.readLine();
                                break;
                            case 4:
                                int importance = Integer.parseInt(data);
                                item.setImportance(importance);
                                data = bufferedReader.readLine();
                                break;
                            default:
                                item.setContent(data);
                                bufferedReader.readLine();
                                data = bufferedReader.readLine();
                                add(item);
                        }
                    }
                }
                bufferedReader.close();
                inputStream.close();

            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (RepeatedAddtionException e) {
            e.printStackTrace();
        }
    }
}
