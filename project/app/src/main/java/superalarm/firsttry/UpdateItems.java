package superalarm.firsttry;

import basic_class.Item;

/**
 * Created by wangjksjtu on 2016/11/23.
 */

public class UpdateItems {
    private String username;
    private String password;

    public UpdateItems() {
        username = "wangjk";
        password = "wjk19711025wyq";
    }

    private void getItems() {
        new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/","GET");
    }

    private void postItems(Item item) {
        String s = String.valueOf(item.getImportance());
        new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/","POST","Item", username,
                password, item.getTitle(), item.getDeadline(), item.getClassTitle(),
                String.valueOf(item.getImportance()), item.getContent());
    }

    private void deleteItems(int id) {
        new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/" + String.valueOf(id) + "/"
                ,"DELETE",username, password);
    }

    private void putItems(Item item) {
        new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/" + String.valueOf(item.getId()) + "/"
                ,"PUT", "Item", username, password, item.getTitle(), item.getDeadline(),
                item.getClassTitle(), String.valueOf(item.getImportance()), item.getContent());
    }
}
