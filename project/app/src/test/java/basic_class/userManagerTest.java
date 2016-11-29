package basic_class;

/**
 * Created by dell on 2016/11/29.
 */

import java.util.ArrayList;
import static java.lang.Math.random;

public class userManagerTest {
    private UserManagerTestSrc UManager1 = new UserManagerTestSrc();
    private userTest user1 = new userTest();
    private String pw;
    private String mail;

    public userManagerTest(){};
    public void setPw(String pw){
        this.pw=pw;
    }
    public boolean checkPw(){
        if (pw.length() >=6 && pw.length() <= 20) return true;
        return false;
    }

    public void setmail(String mail){
        this.mail=mail;
    }
    public boolean validMail() {
        return this.UManager1.validMail(this.mail);
    }


    public void setuser(String mail,String password,String sex,String name,String age,String vertifictionCode){
        this.user1.mail=mail;
        this.user1.password=password;
        this.user1.sex=sex;
        this.user1.name=name;
        this.user1.age=Integer.parseInt(age);
        this.user1.vertifictionCode=Integer.parseInt(vertifictionCode);
    }
    public boolean add(){
        try{
            return this.UManager1.addUser(this.user1);
        }
        catch(Exception e)
        {return false;}
    }
    public boolean delete(){
        try
        {return this.UManager1.deleteUser(this.user1);}
        catch(Exception e){return false;}

    }

    public boolean search(){
        if(this.UManager1.searchUser(this.user1)!=null)return true;
        return false;
    }

}
