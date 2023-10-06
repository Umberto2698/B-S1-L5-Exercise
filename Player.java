import mediaPlayer.RegistrazioneAudio;

public class Player {
    public static void main(String[] args) {
        RegistrazioneAudio registrazione = new RegistrazioneAudio("prova", 3);

        registrazione.play();
    }
}
