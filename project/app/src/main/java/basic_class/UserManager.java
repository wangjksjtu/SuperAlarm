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
/**date 2016-10-25
 * @yanglinbo
 */
/**
 * date:2016-10-02
 * @author wangjksjtu
 */

public class UserManager {

    private final ArrayList<User> userArr = new ArrayList();

    public  void addUser(User user)  {
        userArr.add(user);
    }

    public User searchUser(User user) {
        for (int i = 0; i < userArr.size(); ++i) {
            if (userArr.get(i).equals(user)) {
                return userArr.get(i);
            }
        }
        return null;
    }

    public boolean deleteUser(User user)  {
        if (searchUser(user) != null) {
            userArr.remove(searchUser(user));
            return true;
        }
        return false;
    }

    public int ifUserexist(String username){
        for (int i = 0; i < userArr.size(); ++i){
            if (username.equals(userArr.get(i).getUsername())) return i;
        }
        return -1;
    }

    public ArrayList<User> getUserArr() {
        return userArr;
    }

    public void write(Context context) {
        try {
            String data = "";
            for (int i = 0; i < userArr.size(); ++i) {
                data += userArr.get(i).getUsername() + "\r\n";
                data += userArr.get(i).getPassword() + "\r\n";
                data += userArr.get(i).getMail() + "\r\n";
                data += "\r\n";
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    context.openFileOutput("users.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public void read(Context context) {
        try {
            InputStream inputStream = context.openFileInput("users.txt");
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String data = bufferedReader.readLine();
                while  (data!=null) {
                    User user = new User();
                    for (int i = 0; i < 3; ++i) {
                        switch(i % 3) {
                            case 0:
                                user.setUsername(data);
                                data = bufferedReader.readLine();
                                break;
                            case 1:
                                user.setPassword(data);
                                data = bufferedReader.readLine();
                                break;
                            default:
                                user.setMail(data);
                                bufferedReader.readLine();
                                data = bufferedReader.readLine();
                                addUser(user);
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
