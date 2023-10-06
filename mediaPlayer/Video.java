package mediaPlayer;

public class Video extends ElementoMultimediale implements RegolazioneVolume, RegolazioneLuminosità, Riproducibili {

    //Attributes
    int volume = 5;
    int durata;
    int luminosità = 3;

    //Constructors
    public Video(String titolo, int durata) {
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
    public void alzaLuminosità() {
        if (this.luminosità < 10) {
            this.luminosità++;
        } else {
            System.out.println("La luminosità è già al massimo.");
        }
    }

    @Override
    public void abbassaLuminosità() {
        if (this.luminosità > 0) {
            this.luminosità--;
        } else {
            System.out.println("La luminosità è già al minimo.");
        }
    }


    @Override
    public void play() {
        String str = "";
        for (int i = 0; i < this.volume; i++) {
            str += "!";
        }
        for (int i = 0; i < this.luminosità; i++) {
            str += "*";
        }
        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.titolo + str);
        }
    }

    @Override
    public String toString() {
        return "Video{" +
                "titolo=" + titolo +
                ", volume=" + volume +
                ", durata=" + durata +
                ", luminosità=" + luminosità + '\'' +
                '}';
    }

    //Getters
    public int getVolume() {
        return volume;
    }

    public int getDurata() {
        return durata;
    }

    public int getLuminosità() {
        return luminosità;
    }
}
