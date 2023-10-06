package mediaPlayer;

public class RegistrazioneAudio extends ElementoMultimediale implements RegolazioneVolume, Riproducibili {

    //Attributes
    int volume = 5;
    int durata;

    //Constructors
    public RegistrazioneAudio(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    //Methods
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

    @Override
    public String toString() {
        return "RegistrazioneAudio{" +
                "titolo=" + titolo +
                ", volume=" + volume +
                ", durata=" + durata + '\'' +
                '}';
    }

    //Getters
    public int getVolume() {
        return volume;
    }

    public int getDurata() {
        return durata;
    }
}
