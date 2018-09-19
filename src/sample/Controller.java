//made by Lachlan Slater-Launt, intended for personal use ONLY.
package sample;
import javafx.fxml.FXML;
import javafx.scene.effect.BlendMode;
import javafx.scene.web.WebView;


public class Controller {
    boolean hasLyrics = false;
    public static String currentTrack = new String();
    public static void start() throws Exception {
        currentTrack = processReader.getSpotifyTrack();

    }

    @FXML private WebView htmlLyrics = new WebView();
    @FXML private WebView image = new WebView();

    @FXML
    private void playButton() throws  Exception {

        if((currentTrack.equals(processReader.getSpotifyTrack())) && hasLyrics){
            return;
        }
        start();
        try {
            htmlLyrics.getEngine().loadContent(songObject.getter(currentTrack));
        }catch(IndexOutOfBoundsException e)
        {
            System.out.println("Song not found on Genius!");
        }
        image.setBlendMode(BlendMode.DARKEN);
                image.getEngine().loadContent("<img src='" + songObject.getImage() + "'>");
                    hasLyrics = true;
    }









}
