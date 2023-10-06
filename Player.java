import mediaPlayer.Immagine;
import mediaPlayer.RegistrazioneAudio;
import mediaPlayer.Video;

import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        Object[] arrayElementiMultimediali = new Object[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arrayElementiMultimediali.length; i++) {
            System.out.println("Inserisci il titolo della tuo Elemento");
            String title = input.nextLine();
            String type;
            do {
                System.out.println("Adesso inserisci il tipo del tuo Elemento seguendo la legenda:" + "\n a=Immagine, b=Registrazione audio, c=Video.");
                type = (input.nextLine().toLowerCase());
            } while (!(type.equals("a") || type.equals("b") || type.equals("c")));
            int durata = 0;
            if (type.equals("b") || type.equals("c")) {
                do {
                    System.out.println("Inserisci un numero intero maggiore di 0 per indicare la durata del tuo elemento.");
                    durata = Integer.parseInt(input.nextLine());
                }
                while (durata <= 0);
            }
            switch (type) {
                case "a" -> arrayElementiMultimediali[i] = new Immagine(title);
                case "b" -> arrayElementiMultimediali[i] = new RegistrazioneAudio(title, durata);
                case "c" -> arrayElementiMultimediali[i] = new Video(title, durata);
            }
        }
        short n;
        System.out.println(arrayElementiMultimediali[1]);
        do {
            System.out.println("Quale elemento vuoi eseguire?");
            do {
                System.out.println("Inserisci unb numero intero tra 1 e 5 (compresi), 0 per terminare la riproduzione.");
                n = Short.parseShort(input.nextLine());
            } while (n < 0);
            if (n == 0) System.out.println("Player spento.");
            if (arrayElementiMultimediali[n - 1] instanceof Immagine) {
                ((Immagine) arrayElementiMultimediali[n - 1]).esegui();
            } else if (arrayElementiMultimediali[n - 1] instanceof RegistrazioneAudio) {
                ((RegistrazioneAudio) arrayElementiMultimediali[n - 1]).esegui();
            } else {
                ((Video) arrayElementiMultimediali[n - 1]).esegui();
            }
        } while (n > 0);
    }
}
