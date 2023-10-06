package mediaPlayer;

public class Immagine extends ElementoMultimediale implements RegolazioneLuminosità, NonRiproducibile {

    //Attributes
    int luminosità = 4;

    //Constructors
    public Immagine(String title) {
        this.titolo = title;
    }

    //Methods
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
    public void show() {
        String str = "";
        for (int i = 0; i < this.luminosità; i++) {
            str += "*";
        }
        System.out.println(this.titolo + str);

    }

    @Override
    public String toString() {
        return "Immagine{" +
                "titolo=" + titolo +
                ", luminosità=" + luminosità + '\'' +
                '}';
    }
    
    // Getters
    public int getLuminosità() {
        return luminosità;
    }
}
