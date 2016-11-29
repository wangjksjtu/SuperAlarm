package basic_class;

/**
 * Created by dell on 2016/11/29.
 */


import java.util.ArrayList;
import static java.lang.Math.random;

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Sorry, you have input the wrong password!");
    }
}

class TooShortPasswordException extends Exception {
    public TooShortPasswordException() {
        super("Sorry, the length of password can't be less than six!");
    }
}

class TooLongPasswordException extends Exception {
    public TooLongPasswordException() {
        super("Sorry, the length of password can't be more than 20!");
    }
}
class UsedMailException extends Exception {
    public UsedMailException() {
        super("Sorry, this e-mail address has been rigistered");
    }
}


class NotExistException2 extends Exception {
    public NotExistException2() {
        super("The user is not exist!");
    }
}

public class UserManagerTestSrc {
    // Now I don't destory those user objects which is not activated
    // I am ready to destory them if it has been long time not to bw activated.
    private final ArrayList<String> mailArr = new ArrayList();
    private final ArrayList<userTest> userArr = new ArrayList();
    private boolean validPassword(String pw) {
        if (pw.length() >=6 && pw.length() <= 20) return true;
        return false;
    }
    protected boolean validMail(String mail) {
        for (int i = 0; i < mailArr.size(); ++i) {
            if (mail.equals(mailArr.get(i))) return false;
        }
        return true;
    }
    boolean sendVerfictionCode(userTest user, String mail) {
        int num = (int)(random() * 1000000);
        user.setVertifictionCode(num);
        return true;
    }
    boolean addUser(userTest user) throws UsedMailException, TooShortPasswordException, TooLongPasswordException {
        if (validMail(user.getMail()) && validPassword(user.getPassword())) {
            user.activate();
            mailArr.add(user.getMail());
            userArr.add(user);
            return true;
        }
        else if (!validMail(user.getMail())) throw new UsedMailException();
        else if (user.getPassword().length() < 6) throw new TooShortPasswordException();
        else throw new TooLongPasswordException();
    }
    userTest searchUser(userTest user) {
        for (int i = 0; i < userArr.size(); ++i) {
            if (userArr.get(i).equals(user)) {
                return userArr.get(i);
            }
        }
        return null;
    }
    boolean deleteUser(userTest user) throws NotExistException2 {
        if (searchUser(user) != null) {
            searchUser(user).inactivate();
            mailArr.remove(searchUser(user).getMail());
            userArr.remove(searchUser(user));
            return true;
        }
        throw new NotExistException2();
    }
    public userTest register(String mail, String pw, String name, int age, String sex)
            throws UsedMailException, TooShortPasswordException, TooLongPasswordException {
        if (validMail(mail) && validPassword(pw)) {
            userTest user = new userTest(mail,pw);
            user.setAge(age);
            user.setPassword(pw);
            user.setName(name);
            user.setSex(sex);
            sendVerfictionCode(user, mail);
            return user;
        }
        else if (!validMail(mail)) throw new UsedMailException();
        else if (pw.length() < 6) throw new TooShortPasswordException();
        else throw new TooLongPasswordException();
    }
    public boolean verifyLog(userTest user, int vCode) {
        if (user.getVertifictionCode() == vCode) {
            user.activate();
            mailArr.add(user.getMail());
            userArr.add(user);
            return true;
        }
        else return false;
    }
    public boolean modifyPassword(userTest user, String oldPW, String newPW) throws WrongPasswordException,
            TooShortPasswordException, TooLongPasswordException {
        if (!oldPW.equals(user.getPassword()))
            throw new WrongPasswordException();
        else {
            if (validPassword(newPW)) {
                user.setPassword(newPW);
                return true;
            }
            else if (newPW.length() < 6) throw new TooShortPasswordException();
            else throw new TooLongPasswordException();
        }
    }
    public boolean setUserName(userTest user, String name) {
        if (name.equals("") || name.length() > 20) return false;
        user.setName(name);
        return true;
    }
    public boolean setUserAge(userTest user, int age) {
        user.setAge(age);
        return true;
    }
    String display() {
        String s = "";
        for (int i = 0; i < userArr.size(); ++i) {
            s = s + userArr.get(i).getMail() + "\t" + userArr.get(i).getPassword() + "\t"
                    + userArr.get(i).getName() + "\t" + userArr.get(i).getAge() +
                    "\t" + userArr.get(i).getSex() + "\n";
        }
        for (int i = 0; i < mailArr.size(); ++i) {
            System.out.printf(mailArr.get(i) + "\t");
        }
        System.out.printf("\n");
        return s;
    }

}
