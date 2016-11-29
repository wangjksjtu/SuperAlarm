//package basic_class;
//
//import android.content.Context;
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//
// class ItemOfGroupManager {
//
//    public ArrayList<ItemOfGroup> itemOGArr;
//    public int length;
//
//    public ItemOfGroupManager() {
//         itemOGArr = new ArrayList();
//         length = 0;
//    }
//    private boolean isExist(ItemOfGroupManager itemOG) {
//        for (int i = 0; i < length; ++i) {
//            if (itemOGArr.get(i).equals(itemOG))
//                return true;
//        }
//        return false;
//    }
//    private ItemOfGroup search(ItemOfGroup itemOG) {
//        for (int i = 0; i < length; ++i) {
//            if (itemOGArr.get(i).equals(itemOG))
//                return (ItemOfGroup) itemOGArr.get(i);
//        }
//        return null;
//    }
//
//    public int getLength() {
//        return length;
//    }
//
//    public ArrayList<ItemOfGroup> getItemOfGroupArr() {
//        return itemOGArr;
//    }
//
//    public void add(ItemOfGroup itemOG) throws RepeatedAddtionException {
//        if (isExist(itemOG)) throw new RepeatedAddtionException();
//        itemOGArr.add(itemOG);
//        ++length;
//    }
//    public void delete(ItemOfGroup itemOG) throws NotExistException {
//        if (!isExist(itemOG)) throw new NotExistException();
//        itemOGArr.remove(itemOG);
//        --length;
//    }
//    void modify(ItemOfGroup itemOG, String u, String Id,String o, String t,String d,String mod,String impo,String con,String cre) throws NotExistException {
//        if (!isExist(item)) throw new NotExistException();
//        itemOG.setUrl(u);
//        itemOG.setId(Id);
//        itemOG.setOwner(o);
//        itemOG.setTitle(t);
//        itemOG.setDeadline(d);
//        itemOG.setModule(mod);
//        itemOG.setImportance(impo);
//        itemOG.setContent(con);
//        itemOG.setCreated(cre);
//
//    }
//
//
//
//
//    public void write(Context context) {
//        try {
//            String data = "";
//            for (int i = 0; i < length; ++i) {
//                data += itemOGArr.get(i).getUrl() + "\r\n";
//                data += itemOGArr.get(i).getId() + "\r\n";
//                data += itemOGArr.get(i).getOwner() + "\r\n";
//                data += itemOGArr.get(i).getTitle() + "\r\n";
//                data += itemOGArr.get(i).getDeadline() + "\r\n";
//                data += itemOGArr.get(i).getModule() + "\r\n";
//                data += itemOGArr.get(i).getImportance() + "\r\n";
//                data += itemOGArr.get(i).getContent() + "\r\n";
//                data += itemOGArr.get(i).getCreated() + "\r\n";
//                data += "\r\n";
//            }
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("itemOfGroup.txt", Context.MODE_PRIVATE));
//            outputStreamWriter.write(data);
//            outputStreamWriter.close();
//        }
//        catch (IOException e) {
//            Log.e("Exception", "File write failed: " + e.toString());
//        }
//    }
//    public void read(Context context) {
//        try {
//            InputStream inputStream = context.openFileInput("itemOfGroup.txt");
//            if ( inputStream != null ) {
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                String data = bufferedReader.readLine();
//                while  (data!=null) {
//                    ItemOfGroup itemOG = new ItemOfGroup();
//                    for (int i = 0; i < 9; ++i) {
//                        switch(i % 9) {
//                            case 0:
//                                itemOG.setUrl(data);
//                                data = bufferedReader.readLine();
//                                break;
//                            case 1:
//                                itemOG.setId(data); data = bufferedReader.readLine();
//                                break;
//                            case 2:
//                                itemOG.setOwner(data); data = bufferedReader.readLine();
//                                break;
//                            case 3:
//                                itemOG.setTitle(data);
//                                data = bufferedReader.readLine();
//                                break;
//                            case 4:
//                                itemOG.setDeadline(data);
//                                data = bufferedReader.readLine();
//                                break;
//                            case 5:
//                                itemOG.setModule(data);
//                                data = bufferedReader.readLine();
//                                break;
//                            case 6:
//                                itemOG.setImportance(data);
//                                data = bufferedReader.readLine();
//                                break;
//                            case 7:
//                                itemOG.setContent(data);
//                                data = bufferedReader.readLine();
//                                break;
//                            case 8:
//                                itemOG.setCreated(data);
//                                data = bufferedReader.readLine();
//                                break;
//                        }
//                    }
//                }
//                bufferedReader.close();
//                inputStream.close();
//
//            }
//        }
//        catch (FileNotFoundException e) {
//            Log.e("login activity", "File not found: " + e.toString());
//        } catch (IOException e) {
//            Log.e("login activity", "Can not read file: " + e.toString());
//        } catch (RepeatedAddtionException e) {
//            e.printStackTrace();
//        }
//    }
//}
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

class ItemOfGroupManager {

   public ArrayList<ItemOfGroup> itemOGArr;
   public int length;

   public ItemOfGroupManager() {
        itemOGArr = new ArrayList();
        length = 0;
   }
   private boolean isExist(ItemOfGroup itemOG) {
       for (int i = 0; i < length; ++i) {
           if (itemOGArr.get(i).equals(itemOG))
               return true;
       }
       return false;
   }
   private ItemOfGroup search(ItemOfGroup itemOG) {
       for (int i = 0; i < length; ++i) {
           if (itemOGArr.get(i).equals(itemOG))
               return (ItemOfGroup) itemOGArr.get(i);
       }
       return null;
   }

   public int getLength() {
       return length;
   }

   public ArrayList<ItemOfGroup> getItemOfGroupArr() {
       return itemOGArr;
   }

   public void add(ItemOfGroup itemOG) throws RepeatedAddtionException {
       if (isExist(itemOG)) throw new RepeatedAddtionException();
       itemOGArr.add(itemOG);
       ++length;
   }
   public void delete(ItemOfGroup itemOG) throws NotExistException {
       if (!isExist(itemOG)) throw new NotExistException();
       itemOGArr.remove(itemOG);
       --length;
   }
   void modify(ItemOfGroup itemOG, String u, String Id,String o, String t,String d,String mod,String impo,String con,String cre) throws NotExistException {
       if (!isExist(itemOG)) throw new NotExistException();
       itemOG.setUrl(u);
       itemOG.setId(Id);
       itemOG.setOwner(o);
       itemOG.setTitle(t);
       itemOG.setDeadline(d);
       itemOG.setModule(mod);
       itemOG.setImportance(impo);
       itemOG.setContent(con);
       itemOG.setCreated(cre);

   }




   public void write(Context context) {
       try {
           String data = "";
           for (int i = 0; i < length; ++i) {
               data += itemOGArr.get(i).getUrl() + "\r\n";
               data += itemOGArr.get(i).getId() + "\r\n";
               data += itemOGArr.get(i).getOwner() + "\r\n";
               data += itemOGArr.get(i).getTitle() + "\r\n";
               data += itemOGArr.get(i).getDeadline() + "\r\n";
               data += itemOGArr.get(i).getModule() + "\r\n";
               data += itemOGArr.get(i).getImportance() + "\r\n";
               data += itemOGArr.get(i).getContent() + "\r\n";
               data += itemOGArr.get(i).getCreated() + "\r\n";
               data += "\r\n";
           }
           OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("itemOfGroup.txt", Context.MODE_PRIVATE));
           outputStreamWriter.write(data);
           outputStreamWriter.close();
       }
       catch (IOException e) {
           Log.e("Exception", "File write failed: " + e.toString());
       }
   }
   public void read(Context context) {
       try {
           InputStream inputStream = context.openFileInput("itemOfGroup.txt");
           if ( inputStream != null ) {
               InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
               BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
               String data = bufferedReader.readLine();
               while  (data!=null) {
                   ItemOfGroup itemOG = new ItemOfGroup();
                   for (int i = 0; i < 9; ++i) {
                       switch(i % 9) {
                           case 0:
                               itemOG.setUrl(data);
                               data = bufferedReader.readLine();
                               break;
                           case 1:
                               itemOG.setId(data); data = bufferedReader.readLine();
                               break;
                           case 2:
                               itemOG.setOwner(data); data = bufferedReader.readLine();
                               break;
                           case 3:
                               itemOG.setTitle(data);
                               data = bufferedReader.readLine();
                               break;
                           case 4:
                               itemOG.setDeadline(data);
                               data = bufferedReader.readLine();
                               break;
                           case 5:
                               itemOG.setModule(data);
                               data = bufferedReader.readLine();
                               break;
                           case 6:
                               itemOG.setImportance(data);
                               data = bufferedReader.readLine();
                               break;
                           case 7:
                               itemOG.setContent(data);
                               data = bufferedReader.readLine();
                               break;
                           case 8:
                               itemOG.setCreated(data);
                               data = bufferedReader.readLine();
                               break;
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
       }
   }
}
