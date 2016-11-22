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

class NotExistException extends Exception {
    public NotExistException() {
        super("The items isn't existed!");
    }
}

public class ItemManager {
<<<<<<< HEAD
    public ArrayList<Item> itemArr;
    public int length;
=======
    private ArrayList<Item> itemArr;
    private int length;

>>>>>>> 73644653c23fbe4bbd8674d37e537e56858d54ca
    public ItemManager() {
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
<<<<<<< HEAD
=======
    public int getLength() {
        return length;
    }

    public ArrayList<Item> getItemArr() {
        return itemArr;
    }

>>>>>>> 73644653c23fbe4bbd8674d37e537e56858d54ca
    public void add(Item item) throws RepeatedAddtionException {   //whether I should set this method private?
        if (isExist(item)) throw new RepeatedAddtionException();
        itemArr.add(item);
        ++length;
    }
    public void delete(Item item) throws NotExistException {   //whether I should set this method private?
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
<<<<<<< HEAD
    public void write() throws IOException {
        File newfile = new File("./Data/items.txt");
        newfile.delete();
        newfile.createNewFile();
=======
    /* public void write() throws IOException {
        File deletefile = new File("items.txt");
        deletefile.delete();
>>>>>>> 73644653c23fbe4bbd8674d37e537e56858d54ca
        for (int i = 0; i < length; ++i) {
            itemArr.get(i).write();
        }
    } */

    public void write(Context context) {
        try {
            String data = "";
            for (int i = 0; i < length; ++i) {
                data += itemArr.get(i).getClassTitle() + "\r\n";
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
                    for (int i = 0; i < 5; ++i) {
                        switch(i % 5) {
                            case 0:
                                item.setClassTitle(data);
                                data = bufferedReader.readLine();
                                break;
                            case 1:
                                item.setTitle(data); data = bufferedReader.readLine();
                                break;
                            case 2:
                                item.setDeadline(data); data = bufferedReader.readLine();
                                break;
                            case 3:
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



    /*public void read() throws IOException, RepeatedAddtionException{
    	  BufferedReader fr=new BufferedReader (new FileReader("items.txt"));
          String data = fr.readLine();
          while  (data!=null) {
              Item item = new Item();
              for (int i = 0; i < 5; ++i) {
                switch(i % 5) {
                    case 0:
                        item.setClassTitle(data); 
                        data = fr.readLine(); 
                        break;
                    case 1: 
                        item.setTitle(data); data = fr.readLine(); 
                        break;
                    case 2: 
                        item.setDeadline(data); data = fr.readLine(); 
                        break;
                    case 3: 
                        int importance = Integer.parseInt(data); 
                        item.setImportance(importance); 
                        data = fr.readLine(); 
                        break;
                    default: 
                        item.setContent(data);
                        fr.readLine();
                        data = fr.readLine();
                        add(item);
                }
              }
          }
          fr.close();   
    } */
    
    String display() {
        String s = "";
        for (int i = 0; i < length; ++i) {
            s = s + itemArr.get(i).getClassTitle() + "\t" + itemArr.get(i).getTitle() + "\t" + itemArr.get(i).getDeadline() + "\t\t" + 
            itemArr.get(i).getImportance() + "\t" + itemArr.get(i).getContent() + "\n";
        }
        return s;
    }
}
