import mediaPlayer.RegistrazioneAudio;
import mediaPlayer.Video;

public class Player {
    public static void main(String[] args) {
        RegistrazioneAudio registrazione = new RegistrazioneAudio("prova", 3);
        Video video = new Video("video prova", 4);
        registrazione.play();
        video.play();
    }
}
