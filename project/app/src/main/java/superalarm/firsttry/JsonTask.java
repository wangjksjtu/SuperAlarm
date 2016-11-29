package superalarm.firsttry;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Pair;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import basic_class.Item;
import basic_class.RepeatedAddtionException;
import basic_class.User;
import basic_class.UserManager;

/**
 * Created by wangjksjtu on 2016/11/19.
 */

public class JsonTask extends AsyncTask<String, String, String>{
    private int LastestItemId;

    public int getLastestItemId() {
        return LastestItemId;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestProperty("encoding","UTF-8");
            if (params[1] == "GET") {
                final String basicAuth= "Basic " + Base64.encodeToString(
                        (params[3]+":"+params[4]).getBytes(), Base64.NO_WRAP);
                connection.setRequestProperty ("Authorization", basicAuth);
                connection.connect();
                if (params[2] == "Item") {
                    InputStream stream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(stream));
                    StringBuffer buffer = new StringBuffer();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }
                    JsonParser jsp = new JsonParser(buffer.toString());
                    jsp.JsonParserItem();
                    int id = jsp.getLastestItemId();
                    LastestItemId = id;
                }
                if (params[2] == "User") {
                    if (connection.getResponseCode() / 100 == 2) {
                        UserManager userManager = new UserManager();
                        User user = new User();
                        user.setUsername(params[3]);
                        user.setPassword(params[4]);
                        userManager.addUser(user);
                        userManager.write(MainActivity.instance);
                        return "success";
                    }
                    else return "failure";
                }
            }

            if (params[1] == "POST") {
                connection.setConnectTimeout(2000);
                connection.setReadTimeout(5000);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("contentType","application/x-www-form-urlencoded");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                if (params[2] == "User") {
                    String username_origin = "testAccount";
                    String password_origin = "testPassword";
                    final String basicAuth= "Basic " + Base64.encodeToString(
                            (username_origin+":"+password_origin).getBytes(), Base64.NO_WRAP);
                    connection.setRequestProperty ("Authorization", basicAuth);
                    String username = params[3];
                    String password = params[4];
                    String email = params[5];
                    User user = new User(username, password, email);
                    List<Pair<String, String>> arrlist = new ArrayList<>();
                    arrlist.add(new Pair<>("username", username));
                    arrlist.add(new Pair<>("password", password));
                    arrlist.add(new Pair<>("email", email));
                    OutputStream os = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(getQuery(arrlist));
                    writer.flush();
                    writer.close();
                    os.close();
                    connection.connect();
                    basic_class.UserManager userManager = new basic_class.UserManager();
                    userManager.read(MainActivity.instance);
                    userManager.addUser(user);
                    userManager.write(MainActivity.instance);
                }
                if (params[2] == "Item") {
                    final String basicAuth= "Basic " + Base64.encodeToString(
                            (params[3]+":"+params[4]).getBytes(), Base64.NO_WRAP);
                    connection.setRequestProperty ("Authorization", basicAuth);
                    String title = params[5];
                    String deadline = params[6];
                    String module = params[7];
                    String importance = params[8];
                    String content = params[9];
                    List<Pair<String, String>> arrlist = new ArrayList<>();
                    arrlist.add(new Pair<>("title", title));
                    arrlist.add(new Pair<>("deadline",deadline));
                    arrlist.add(new Pair<>("module",module));
                    arrlist.add(new Pair<>("importance",importance));
                    arrlist.add(new Pair<>("content",content));
                    OutputStream os = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(getQuery(arrlist));
                    writer.flush();
                    writer.close();
                    os.close();
                    connection.connect();
                }
            }

            if (params[1] == "DELETE") {
                connection.setRequestMethod("DELETE");
                connection.setRequestProperty("contentType","application/x-www-form-urlencoded");
                final String basicAuth= "Basic " + Base64.encodeToString(
                        (params[2]+":"+params[3]).getBytes(), Base64.NO_WRAP);
                connection.setRequestProperty ("Authorization", basicAuth);
                connection.connect();

            }

            if (params[1] == "PUT") {
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestMethod("PUT");
                connection.setDoOutput(true);
                final String basicAuth= "Basic " + Base64.encodeToString((params[3]+":"+params[4]).getBytes(),
                        Base64.NO_WRAP);
                connection.setRequestProperty ("Authorization", basicAuth);
                OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());

                if (params[2] == "Item") {
                    int id = Integer.parseInt(params[5]);
                    String title = params[6];
                    String deadline = params[7];
                    String module = params[8];
                    int importance = Integer.parseInt(params[9]);
                    String content = params[10];
                    Item item = new Item(id, module, title, deadline, importance, content);
                    Gson gson = new Gson();
                    String data = gson.toJson(item);
                    osw.write(data);
                    osw.flush();
                    osw.close();
                    connection.connect();
                }
            }

            if (connection.getResponseCode() / 100 == 2) {
                return "success";
//            } else if (connection.getResponseCode() / 100 == 4){
//                return "failure";
            } else {
                return "failure";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (RepeatedAddtionException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    private String getQuery(List<Pair<String, String>> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Pair<String, String> pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.first, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.second, "UTF-8"));
        }

        return result.toString();
    }

}
