//made by Lachlan Slater-Launt, intended for personal use ONLY.
package sample;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class songObject {
    public static String imageURL;
    public static String getter(String x) throws Exception {
        String data = new String();
        String key = "5fFhpZoE4N4C4-HSNVJJBjpIwbL_98USgdZqSIs5LCLKF7HbtKwxRlmBzL8xyLeK";
        String searchTerm;
        String songURL;
        String fullTitle;
        String songTitle;
        String artistName;

        fullTitle = x;
        int songBreak = fullTitle.indexOf(" - ");
        songTitle = fullTitle.substring(songBreak + 3);
        try {
            artistName = fullTitle.substring(0, songBreak);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("no track currently playing");
            return null;
        }
        searchTerm = (URLify(artistName) + "%20" + URLify(songTitle));

        URL lyricsAPI = new URL("https://api.genius.com/search?q=" + searchTerm + "&access_token=" + key);
        HttpURLConnection conn = (HttpURLConnection) lyricsAPI.openConnection();
        conn.setUseCaches(false);
        conn.setRequestMethod("GET");
        conn.connect();


            BufferedReader sc = new BufferedReader(new InputStreamReader(lyricsAPI.openStream()));
            data += sc.readLine();
            JSONParser parser = new JSONParser();
                JSONObject resultData = (JSONObject) parser.parse(data);
                    resultData = (JSONObject) resultData.get("response");
                        JSONArray resultData3 = (JSONArray) resultData.get("hits");
                            JSONObject firstHit = (JSONObject) resultData3.get(0);

            firstHit = (JSONObject) firstHit.get("result");
                songURL = (String) firstHit.get("url");
                    imageURL = (String) firstHit.get("song_art_image_thumbnail_url");
                        return lyricsHandler.getLyrics(songURL);




    }
    public static String getImage(){
        return imageURL;
    }

    public static String URLify (String s){

        String URLified = s.replaceAll(" ", "%20");
        return URLified;

    }


}
