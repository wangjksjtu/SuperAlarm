package superalarm.firsttry;

import basic_class.Item;
import basic_class.UserManager;

/**
 * Created by wangjksjtu on 2016/11/23.
 */

public class UpdateItems {
    private String username;
    private String password;

    public UpdateItems() {
        UserManager userManager = new UserManager();
        userManager.read(MainActivity.instance);
        try {
            username = userManager.getUserArr().get(0).getUsername();
            password = userManager.getUserArr().get(0).getPassword();
        } catch(Exception e) {
            username = "";
            password = "";
        }
    }

    public void getItems() {
        new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/","GET", "Item", username,
                password);
    }

    public void postItems(Item item) {
        String s = String.valueOf(item.getImportance());
        JsonTask jsonTask = new JsonTask();
        jsonTask.execute("http://www.wangjksjtu.com.cn:2117/items/","POST","Item", username,
                password, item.getTitle(), item.getDeadline(), item.getModule(),
                String.valueOf(item.getImportance()), item.getContent());
        getItems();
        item.setId(jsonTask.getLastestItemId());
    }

    public void deleteItems(Item item) {
        new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/" + String.valueOf(item.getId()) + "/"
                ,"DELETE",username, password);
    }

    public void putItems(Item item) {
        new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/" + String.valueOf(item.getId()) + "/"
                ,"PUT", "Item", username, password, String.valueOf(item.getId()),
                item.getTitle(), item.getDeadline(), item.getModule(),
                String.valueOf(item.getImportance()), item.getContent()
                );
    }
}
