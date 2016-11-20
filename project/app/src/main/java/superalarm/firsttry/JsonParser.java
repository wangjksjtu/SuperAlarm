package superalarm.firsttry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangjksjtu on 2016/11/19.
 */

public class JsonParser {
    private String finalJson;
    JsonParser(String finalJsonJ){
        finalJsonJ = finalJsonJ;
    };
    String JsonParserItem () throws JSONException {
        JSONObject parentObject = new JSONObject(finalJson);
        JSONArray parentArray = parentObject.getJSONArray("results");

        StringBuffer finalBufferData = new StringBuffer();
        for (int i = 0; i<parentArray.length(); i++) {
            JSONObject finalObject = parentArray.getJSONObject(i);

            String title = finalObject.getString("title");
            String deadline = finalObject.getString("title");
            String module = finalObject.getString("module");
            String content = finalObject.getString("content");
            finalBufferData.append(title + "|" + deadline + "|" + module
            + "|" + content );
        }
        return finalBufferData.toString();
    }

    /*
    String JsonparserItemOfGroup
    } */

    /*
    String JsonParserGroup
    */
}
