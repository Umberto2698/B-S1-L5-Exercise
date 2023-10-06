import mediaPlayer.Immagine;
import mediaPlayer.RegistrazioneAudio;
import mediaPlayer.Video;

public class Player {
    public static void main(String[] args) {
        RegistrazioneAudio registrazione = new RegistrazioneAudio("prova", 3);
        Video video = new Video("video prova", 4);
        Immagine immagine = new Immagine("pippo");
        registrazione.play();
        video.esegui();
        immagine.esegui();
    }
}
