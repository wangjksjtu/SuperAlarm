package basic_class;

/**
 * date 2016-10-24
 * @yanglinbo
 */

/**
 * date:2016-10-02
 * @author wangjksjtu
 */
public class User {
    private String username;
    private String password;
    private String mail;

    public User(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public User() {
        this("","","");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
