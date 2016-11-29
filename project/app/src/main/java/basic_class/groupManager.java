
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
// class groupManager {
//       public ArrayList<Group> groupArr;
//       public int length;
//       public groupManager() {
//           groupArr = new ArrayList();
//           length = 0;
//      }
//       private boolean isExist(Group group) {
//           for (int i = 0; i < length; ++i) {
//               if (groupArr.get(i).equals(group))
//                   return true;
//           }
//           return false;
//       }
//       private Group search(Group group) {
//           for (int i = 0; i < length; ++i) {
//               if (groupArr.get(i).equals(group))
//                   return (Group) groupArr.get(i);
//           }
//           return null;
//       }
//       public int getLength() {
//           return length;
//       }
//
//       public ArrayList<Group> getGroupArr() {
//           return groupArr;
//       }
//       public void add(Group group) throws RepeatedAddtionException {
//           if (isExist(group)) throw new RepeatedAddtionException();
//           groupArr.add(group);
//           ++length;
//       }
//       public void delete(Group group) throws NotExistException {
//           if (!isExist(group)) throw new NotExistException();
//           groupArr.remove(group);
//           --length;
//       }
//       void modify(Group group, String u, String gN,String limi,String []mem,String []ite) throws NotExistException {
//           if (!isExist(group)) throw new NotExistException();
//           group.setUrl(u);
//           group.setGroupName(gN);
//           group.setLimit(limi);
//           group.setMember(mem);
//           group.setItem (ite);
//
//       }
//       public void write(Context context) {
//           try {
//               String data = "";
//               for (int i = 0; i < length; ++i) {
//                   data += groupArr.get(i).getUrl() + "\r\n";
//                   data += groupArr.get(i).getId() + "\r\n";
//                   data += groupArr.get(i).getOwner() + "\r\n";
//                   data += groupArr.get(i).getGroupName() + "\r\n";
//                   data += groupArr.get(i).getLimit() + "\r\n";
//                   data += groupArr.get(i).getMember() + "\r\n";
//                   data += groupArr.get(i).getItem() + "\r\n";
//                   data += "\r\n";
//               }
//               OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("groups.txt", Context.MODE_PRIVATE));
//               outputStreamWriter.write(data);
//               outputStreamWriter.close();
//           }
//           catch (IOException e) {
//               Log.e("Exception", "File write failed: " + e.toString());
//           }
//       }
//       public void read(Context context) {
//           try {
//               InputStream inputStream = context.openFileInput("groups.txt");
//               if ( inputStream != null ) {
//                   InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                   BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                   String data = bufferedReader.readLine();
//                   while  (data!=null) {
//                       Group group = new Group();
//                       for (int i = 0; i < 7; ++i) {
//                           switch(i % 7) {
//                               case 0:
//                                   group.setUrl(data);
//                                   data = bufferedReader.readLine();
//                                   break;
//                               case 1:
//                                   group.setId(data); data = bufferedReader.readLine();
//                                   break;
//                               case 2:
//                                   group.setOwner(data); data = bufferedReader.readLine();
//                                   break;
//                               case 3:
//
//                                   group.setGroupName(data);
//                                   data = bufferedReader.readLine();
//                                   break;
//                               case 4:
//                            	   group.setLimit(data);
//                                   data = bufferedReader.readLine();
//                                   break;
//                               case 5:
//                                   group.setMember(data);
//                                   data = bufferedReader.readLine();
//                                   break;
//                               case 6:
//                            	   group.setItem(data);
//                                   data = bufferedReader.readLine();
//                                   break;
//
//                           }
//                       }
//                   }
//                   bufferedReader.close();
//                   inputStream.close();
//
//               }
//          }
//        catch (FileNotFoundException e) {
//            Log.e("login activity", "File not found: " + e.toString());
//        } catch (IOException e) {
//            Log.e("login activity", "Can not read file: " + e.toString());
//        } catch (RepeatedAddtionException e) {
//            e.printStackTrace();
//        }
//}
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

class groupManager {
      public ArrayList<Group> groupArr;
      public int length;
      public groupManager() {
          groupArr = new ArrayList();
          length = 0;
     }
      private boolean isExist(Group group) {
          for (int i = 0; i < length; ++i) {
              if (groupArr.get(i).equals(group))
                  return true;
          }
          return false;
      }
      private Group search(Group group) {
          for (int i = 0; i < length; ++i) {
              if (groupArr.get(i).equals(group))
                  return (Group) groupArr.get(i);
          }
          return null;
      }
      public int getLength() {
          return length;
      }

      public ArrayList<Group> getGroupArr() {
          return groupArr;
      }
      public void add(Group group) throws RepeatedAddtionException {
          if (isExist(group)) throw new RepeatedAddtionException();
          groupArr.add(group);
          ++length;
      }
      public void delete(Group group) throws NotExistException {
          if (!isExist(group)) throw new NotExistException();
          groupArr.remove(group);
          --length;
      }
      void modify(Group group, String u, String gN,String limi,String []mem,String []ite) throws NotExistException {
          if (!isExist(group)) throw new NotExistException();
          group.setUrl(u);
          group.setGroupName(gN);
          group.setLimit(limi);
          group.setMember(mem);
          group.setItem (ite);

      }
      public void write(Context context) {
          try {
              String data = "";
              for (int i = 0; i < length; ++i) {
                  data += groupArr.get(i).getUrl() + "\r\n";
                  data += groupArr.get(i).getId() + "\r\n";
                  data += groupArr.get(i).getOwner() + "\r\n";
                  data += groupArr.get(i).getGroupName() + "\r\n";
                  data += groupArr.get(i).getLimit() + "\r\n";
                  data += groupArr.get(i).getMember() + "\r\n";
                  data += groupArr.get(i).getItem() + "\r\n";
                  data += "\r\n";
              }
              OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("groups.txt", Context.MODE_PRIVATE));
              outputStreamWriter.write(data);
              outputStreamWriter.close();
          }
          catch (IOException e) {
              Log.e("Exception", "File write failed: " + e.toString());
          }
      }
      public void read(Context context) {
          try {
              InputStream inputStream = context.openFileInput("groups.txt");
              if ( inputStream != null ) {
                  InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                  BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                  String data = bufferedReader.readLine();
                  while  (data!=null) {
                      Group group = new Group();
                      for (int i = 0; i < 7; ++i) {
                          switch(i % 7) {
                              case 0:
                                  group.setUrl(data);
                                  data = bufferedReader.readLine();
                                  break;
                              case 1:
                                  group.setId(data); data = bufferedReader.readLine();
                                  break;
                              case 2:
                                  group.setOwner(data); data = bufferedReader.readLine();
                                  break;
                              case 3:

                                  group.setGroupName(data);
                                  data = bufferedReader.readLine();
                                  break;
                              case 4:
                           	   group.setLimit(data);
                                  data = bufferedReader.readLine();
                                  break;
                              case 5:
                                  data = bufferedReader.readLine();
                                  break;
                              case 6:
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
}}
