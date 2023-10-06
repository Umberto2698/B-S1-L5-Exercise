package mediaPlayer;

abstract class ElementoMultimediale {
    String titolo;

    public void esegui() {
        if (this instanceof Immagine) {
            ((NonRiproducibile) this).show();
        } else if (this instanceof Video || this instanceof RegistrazioneAudio) {
            ((Riproducibili) this).play();
        }
    }
}
