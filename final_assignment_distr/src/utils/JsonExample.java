package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.HttpURLConnection;
import java.util.*;
import java.util.Iterator;

import org.json.*;
import org.json.JSONObject;
import org.json.JSONArray;

public class JsonExample {

  private static String readAll(Reader rd) throws IOException {

    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String surl) throws IOException, JSONException {

    URL url = new URL(surl);
    HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");

    InputStream is = httpcon.getInputStream();
    //InputStream is = new URL(url).openStream();

    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);

      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

    //list pokemon species which starts with  'pid'
    public static void listSpecies(){
      List<String> species = new ArrayList<>();
      try {
        JSONObject json = readJsonFromUrl("https://pokeapi.co/api/v2/pokemon-species/");
        JSONArray arr = json.getJSONArray("results");
        for(int i=0; i<arr.length(); i++){
          species.add(arr.getJSONObject(i).get("name").toString());
        }
        for(String name : species){
          if(name.startsWith("pid")){
            System.out.println(name);
          }
        }
      }
      catch(Exception e){
        System.out.println(e);
      }
}






}
