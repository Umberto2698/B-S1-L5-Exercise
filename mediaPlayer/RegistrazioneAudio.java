package mediaPlayer;

public class RegistrazioneAudio extends ElementoMultimediale implements RegolazioneVolume, Riproducibili {

    int volume = 5;
    int durata;


    public RegistrazioneAudio(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    @Override
    public void alzaVolume() {
        if (this.volume < 10) {
            this.volume++;
        } else {
            System.out.println("Il volume è già al massimo.");
        }
    }

    @Override
    public void abbassaVolume() {
        if (this.volume > 0) {
            this.volume--;
        } else {
            System.out.println("Il volume è già al minimo.");
        }
    }


    @Override
    public void play() {
        String str = "";
        for (int i = 0; i < this.volume; i++) {
            str += "!";
        }
        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.titolo + str);
        }
    }
}
