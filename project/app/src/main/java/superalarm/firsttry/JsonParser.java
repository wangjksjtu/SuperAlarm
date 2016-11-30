package superalarm.firsttry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import basic_class.Item;
import basic_class.ItemManager;
import basic_class.RepeatedAddtionException;

/**
 * Created by wangjksjtu on 2016/11/19.
 */

public class JsonParser {
    private String finalJson;

    JsonParser(String string){
        finalJson = string;
    };

    void JsonParserItem () throws JSONException, RepeatedAddtionException, IOException {
        JSONObject parentObject = new JSONObject(finalJson);
        JSONArray parentArray = parentObject.getJSONArray("results");
        ItemManager itemManager = new ItemManager();
        //StringBuffer finalBufferData = new StringBuffer();
        for (int i = 0; i < parentArray.length(); i++) {
            JSONObject finalObject = parentArray.getJSONObject(i);
            Item item = new Item();
            item.setId(finalObject.getInt("id"));
            item.setTitle( finalObject.getString("title"));
            item.setDeadline( finalObject.getString("deadline"));
            item.setModule(finalObject.getString("module"));
            item.setImportance(finalObject.getInt("importance"));
            item.setContent( finalObject.getString("content"));
            itemManager.add(item);
        }
        itemManager.write(MainActivity.instance);
    }

    int getLastestItemId() throws JSONException {
        JSONObject parentObject = new JSONObject(finalJson);
        JSONArray parentArray = parentObject.getJSONArray("results");
        JSONObject finalObject = parentArray.getJSONObject(parentArray.length() - 1);
        return finalObject.getInt("id");
    }

//    void JsonParserUser () throws JSONException, RepeatedAddtionException, IOException {
//        JSONObject parentObject = new JSONObject(finalJson);
//        JSONArray parentArray = parentObject.getJSONArray("results");
//        UserManager userManager = new UserManager();
//        //StringBuffer finalBufferData = new StringBuffer();
//        for (int i = 0; i < parentArray.length(); i++) {
//            JSONObject finalObject = parentArray.getJSONObject(i);
//            User user = new User();
//            user.setUsername(finalObject.getString("username"));
//            user.setPassword( finalObject.getString("password"));
//            userManager.addUser(user);
//            userManager.write(MainActivity.instance);
//        }
//    }

    String JsonparserItemOfGroup() throws JSONException {
        JSONObject parentObject = new JSONObject(finalJson);
        JSONArray parentArray = parentObject.getJSONArray("results");
        StringBuffer finalBufferData = new StringBuffer();
        for (int i = 0; i < parentArray.length(); i++) {
            JSONObject finalObject = parentArray.getJSONObject(i);
            String groupId = finalObject.getString("id");
            String groupname = finalObject.getString("groupname");
            String title = finalObject.getString("title");
            String deadline = finalObject.getString("deadline");
            String module = finalObject.getString("module");
            String content = finalObject.getString("content");
            finalBufferData.append(title + "|" + deadline + "|" + module
                    + "|" + content +"\n");
        }
        return finalBufferData.toString();
    }

    /*
    String JsonParserGroup
    */
}
