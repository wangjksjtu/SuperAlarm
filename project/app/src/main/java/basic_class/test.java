package basic_class;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * date:2016-10-02
 * @author wangjksjtu
 */
public class test {
   public static void main(String []args) throws UsedMailException, IOException {
       //Test the Item.java
       Item it1 = new Item("Study","study1","201610022345",1);
       Item it2 = new Item("Study","study2","201610023345",2);
       Item it3 = new Item();
       it3.copy(it2);
       System.out.println(it3.equals(it2));
       System.out.println(it3.equals(it1));
       // Test the ItemManager.java
       ItemManager itmanager = new ItemManager();
       ItemManager itmanager2 = new ItemManager();
       try {
           itmanager.add(it1);
           itmanager.add(it2);
           //itmanager.add(it3);
           itmanager.delete(it1);
           //itmanager.delete(it1);
           itmanager.modify(it2, "Study","201510023345",3,"have a try!");
           Item it4 = new Item("Exercise","exercise1","201510023475",4,"I am happy!");
           Item it5 = new Item("Play","play1","201610023345",2,"Have a good time!");
           Item it6 = new Item("Food","food1","201611023345",1,"banana!");
           itmanager.add(it4); itmanager.add(it5); itmanager.add(it6);
           itmanager.sortByDeadline();
           itmanager.write();
           System.out.printf("___________________\n");
           itmanager2.read();
           System.out.printf(itmanager2.display());
           System.out.printf("___________________\n");
           System.out.printf("\n");
           System.out.printf(itmanager.display());
           System.out.printf("\n");
           itmanager.sortByImportance();
           itmanager.write();
           System.out.printf(itmanager.display());
       } catch (RepeatedAddtionException ex) {
           Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NotExistException ex) {
           Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
       }
       System.out.printf("\n");
       // Test the UserManager.java
       User user1 = new User();
       User user2 = new User("555555@qq.com", "password");
       user1.setAll("123456@qq.com", "password","wang",10,"male");
       user2.setName("shi"); user2.setAge(9); user2.setGender("female");
       User user3 = new User("123456@qq.com","password","jing",10,"male");
       User user4 = new User();
       User user5 = new User();
       UserManager usermanager = new UserManager();
       try {
           user4 = usermanager.register("234567@qq.com", "password", "xiao", 9, "female");
           usermanager.verifyLog(user4, user4.getVertifictionCode());
           user5 = usermanager.register("135790@qq.com", "password", "chuan", 10, "female");
           usermanager.verifyLog(user5, user5.getVertifictionCode());
           //user5 = usermanager.register("234567@qq.com", "password", "kang", 9, "female");
           usermanager.addUser(user1);
           usermanager.addUser(user2);
           //usermanager.addUser(user3);
           System.out.printf(usermanager.display());
           System.out.printf("\n");
           usermanager.deleteUser(user2);
           //usermanager.deleteUser(user2);
           System.out.printf(usermanager.display());
           System.out.printf("\n");
           usermanager.modifyPassword(user4, "password", "newPWord");
           //usermanager.modifyPassword(user4, "password", "newPWord");
           //usermanager.modifyPassword(user4, "newPWord", "newP");
           //usermanager.modifyPassword(user4, "newPWord", "newPassssssssssssswordddddddd");
           usermanager.setUserAge(user1, 11);
           System.out.printf(usermanager.display());
       } catch (TooShortPasswordException ex) {
           Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
       } catch (TooLongPasswordException ex) {
           Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
       } catch (WrongPasswordException ex) {
           Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
       } catch (NotExistException2 ex) {
           Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
       }
     
   }
}
