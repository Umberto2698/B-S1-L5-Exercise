package mediaPlayer;

public abstract class ElementoMultimediale {
    //Attributes
    String titolo;

    //Methods
    public void esegui() {
        if (this instanceof Immagine) {
            ((NonRiproducibile) this).show();
        } else if (this instanceof Video || this instanceof RegistrazioneAudio) {
            ((Riproducibili) this).play();
        }
    }
}
