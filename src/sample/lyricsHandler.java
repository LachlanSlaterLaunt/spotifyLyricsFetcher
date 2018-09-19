//made by Lachlan Slater-Launt, intended for personal use ONLY.
package sample;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class lyricsHandler {

    public static String getLyrics(String URL) throws Exception{
        Document doc = Jsoup.connect(URL).get();
        Elements lyrics = doc.getElementsByClass("lyrics");
        return lyrics.toString().replaceAll("href=", "");
    }



}
