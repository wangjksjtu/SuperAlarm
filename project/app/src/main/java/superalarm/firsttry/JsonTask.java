package superalarm.firsttry;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Pair;

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

import basic_class.RepeatedAddtionException;

/**
 * Created by wangjksjtu on 2016/11/19.
 */

public class JsonTask extends AsyncTask<String, String, String>{
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
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                JsonParser jsp = new JsonParser(buffer.toString());
                jsp.JsonParserItem();
            }
            if (params[1] == "POST") {
                connection.setConnectTimeout(2000);
                connection.setReadTimeout(5000);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("contentType","application/x-www-form-urlencoded");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                String username = "hello10";
                String password = "password";
                List<Pair<String, String>> arrlist = new ArrayList<>();
                arrlist.add(new Pair<>("username", username));
                arrlist.add(new Pair<>("password", password));

                OutputStream os = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getQuery(arrlist));
                writer.flush();
                writer.close();
                os.close();

                connection.connect();
                //connection.getOutputStream().write(para.getBytes());

            }
            if (params[1] == "DELETE") {
                connection.setRequestMethod("DELETE");
                connection.setRequestProperty("contentType","application/x-www-form-urlencoded");
                final String basicAuth= "Basic " + Base64.encodeToString("wangjk:wjk19711025wyq".getBytes(), Base64.NO_WRAP);
                connection.setRequestProperty ("Authorization", basicAuth);
                connection.connect();

            }
            if (params[1] == "PUT") {
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestMethod("PUT");
                connection.setDoOutput(true);
                final String basicAuth= "Basic " + Base64.encodeToString("wangjk:wjk19711025wyq".getBytes(), Base64.NO_WRAP);
                connection.setRequestProperty ("Authorization", basicAuth);
                String data = "{\"title\":\"2000meters\",\"deadline\":\"2016-11-23-22-52-27\", \"module\":\"Sports\", " +
                        "\"content\":\"I want to do exercise again\"}";

                OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
                osw.write(data);
                osw.flush();
                osw.close();
                connection.connect();
            }

            if (connection.getResponseCode() / 100 == 2) {
                return "success";
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
