package basic_class;

/**
 * Created by dell on 2016/11/29.
 */

public class userTest {
    protected String mail;
    protected String password;
    protected String sex;
    protected String name;
    protected int age;
    protected int vertifictionCode;
    private boolean isActivated = false;
    ItemManagerTestSrc itemManager;
    static int count = 0;
    public userTest(String m, String p, String n, int a, String s) {
        mail = m; password = p;
        name = n; age = a; sex = s;
    }
    public userTest(String m, String p) {
        mail = m; password = p;
        sex = ""; name = ""; age = 0;
        ++count;
    }
    public userTest() {this("","");}
    public void setAll(String m, String p, String n, int a, String s) {
        mail = m; password = p;
        name = n; age = a; sex = s;        // May be I will delete this method
    }
    public void setSex(String s) {sex = s;}
    public void setName(String n) {name = n;}
    public void setMail(String n) {mail = n;}
    public void setPassword(String p) {password = p;}
    public void setAge(int a) {age = a;}
    public void setVertifictionCode(int v) {vertifictionCode = v;}
    public void activate() {isActivated = true;}
    public void inactivate() { isActivated = false;}
    public String getMail() {return mail;}
    public String getSex() {return sex;}
    public int getAge() {return age;}
    public String getName() {return name;}
    public String getPassword() {return password;}
    public int getVertifictionCode() {return vertifictionCode;}
    public int getCount() {return count;}

    public boolean equals(userTest user) {
        return this.mail.equals(user.mail) && this.password.equals(user.password) && this.name.equals(user.name)
                && this.age == user.age && this.sex.equals(user.sex);
    }

    public String getEquals(){
        userTest m = new userTest("123456789@sjtu.edu.cn","abcdefg","xyz",99,"man");
        return this.equals(m)? "yes":"no";
    }
}
