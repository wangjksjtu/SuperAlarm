package superalarm.firsttry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangjksjtu on 2016/11/19.
 */

public class JsonParser {
    private String finalJson;
    JsonParser(String string){
        finalJson = string;
    };
    String JsonParserItem () throws JSONException {
        JSONObject parentObject = new JSONObject(finalJson);
        JSONArray parentArray = parentObject.getJSONArray("results");

        StringBuffer finalBufferData = new StringBuffer();
        for (int i = 0; i < parentArray.length(); i++) {
            JSONObject finalObject = parentArray.getJSONObject(i);
            String title = finalObject.getString("title");
            String deadline = finalObject.getString("deadline");
            String module = finalObject.getString("module");
            String content = finalObject.getString("content");
            finalBufferData.append(title + "|||" + deadline + "|||" + module
            + "|||" + content +"\n");
        }
        return finalBufferData.toString();
    }

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
            finalBufferData.append(title + "|||" + deadline + "|||" + module
                    + "|||" + content +"\n");
        }
        return finalBufferData.toString();
    }

    /*
    String JsonParserGroup
    */
}
