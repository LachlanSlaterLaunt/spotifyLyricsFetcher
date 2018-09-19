//made by Lachlan Slater-Launt, intended for personal use ONLY.
package sample;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class processReader {
    public static String getSpotifyTrack() throws Exception{
        String command = "powershell.exe Get-Process 'Spotify' |where {$_.mainWindowTItle} |format-table name, mainwindowtitle –AutoSize";
        Process powerShellProcess = Runtime.getRuntime().exec(command);
        powerShellProcess.getOutputStream().close();
        String line;
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()));
        while((line = stdout.readLine()) != null){
            if(line.contains("Spotify")){
                return line.substring(line.indexOf(" ") + 1);
            }
        }
        stdout.close();


        return "Error: Spotify Track Not Detected";
    }
}
