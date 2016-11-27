package superalarm.firsttry;

import basic_class.Item;

/**
 * Created by wangjksjtu on 2016/11/23.
 */

public class UpdateItems {
    private String username;
    private String password;

    public UpdateItems() {
        username = "testAccount";
        password = "testPassword";
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
