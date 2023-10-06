import mediaPlayer.ElementoMultimediale;
import mediaPlayer.Immagine;
import mediaPlayer.RegistrazioneAudio;
import mediaPlayer.Video;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player {
    public static void main(String[] args) throws InterruptedException {
        ElementoMultimediale[] arrayElementiMultimediali = new ElementoMultimediale[5];
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
        String action;
        System.out.println("Accensione");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println(".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("..");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("...");
        do {
            System.out.println("Quale elemento vuoi eseguire?");
            do {
                System.out.println("Inserisci unb numero intero tra 1 e 5 (compresi), 0 per terminare la riproduzione.");
                n = Short.parseShort(input.nextLine());
            } while (n < 0 || n > 5);
            if (n == 0) {
                System.out.println("Player spento.");
                input.close();
            } else {
                ElementoMultimediale currentElement = arrayElementiMultimediali[n - 1];
                if (currentElement instanceof Immagine) {
                    System.out.println("La luminosità corrente è 4, vuoi cambiarla?");
                    do {
                        action = "";
                        System.out.println("Scegli +l per alzarla, -l per abbassarla, n per non cambiarla e visualizzare l'immagine.");
                        switch (input.nextLine().toLowerCase()) {
                            case "+l" -> {
                                ((Immagine) currentElement).alzaLuminosità();
                                System.out.println("Luminosità corrente " + ((Immagine) currentElement).getLuminosità() + " su 10.");
                                action = "+l";
                            }
                            case "-l" -> {
                                ((Immagine) currentElement).abbassaLuminosità();
                                System.out.println("Luminosità corrente " + ((Immagine) currentElement).getLuminosità() + " su 10.");
                                action = "-l";
                            }
                            case "n" -> {
                                currentElement.esegui();
                                action = "n";
                            }
                            default -> {
                                action = "";
                            }
                        }
                    } while (!action.equals("n"));
                } else if (currentElement instanceof RegistrazioneAudio) {
                    System.out.println("Il volume corrente è 5, vuoi cambiarlo?");
                    do {
                        action = "";
                        System.out.println("Scegli +v per alzarlo, -v per abbassarlo, n per non cambiarlo e ascoltare l'audio.");
                        switch (input.nextLine().toLowerCase()) {
                            case "+v" -> {
                                ((RegistrazioneAudio) currentElement).alzaVolume();
                                System.out.println("Luminosità corrente " + ((RegistrazioneAudio) currentElement).getVolume() + " su 10.");
                                action = "+v";
                            }
                            case "-v" -> {
                                ((RegistrazioneAudio) currentElement).abbassaVolume();
                                System.out.println("Luminosità corrente " + ((RegistrazioneAudio) currentElement).getVolume() + " su 10.");
                                action = "-v";
                            }
                            case "n" -> {
                                currentElement.esegui();
                                action = "n";
                            }
                            default -> {
                                action = "";
                            }
                        }
                    } while (!action.equals("n"));
                } else {
                    System.out.println("Le impostazioni di default sono: \n Volume=5, Luminosità=3");
                    System.out.println("Vuoi cambiarle?");
                    do {
                        action = "";
                        System.out.println("Scegli +v per alzare il volume, -v per abbassarlo, +l per alzare la luminosità, -l per abbssarla, n per non modificare e avviare il video.");
                        switch (input.nextLine().toLowerCase()) {
                            case "+v" -> {
                                ((Video) currentElement).alzaVolume();
                                System.out.println("Luminosità corrente " + ((Video) currentElement).getVolume() + " su 10.");
                                action = "+v";
                            }
                            case "-v" -> {
                                ((Video) currentElement).abbassaVolume();
                                System.out.println("Luminosità corrente " + ((Video) currentElement).getVolume() + " su 10.");
                                action = "-v";
                            }
                            case "+l" -> {
                                ((Video) currentElement).alzaLuminosità();
                                System.out.println("Luminosità corrente " + ((Video) currentElement).getLuminosità() + " su 10.");
                                action = "+l";
                            }
                            case "-l" -> {
                                ((Video) currentElement).abbassaLuminosità();
                                System.out.println("Luminosità corrente " + ((Video) currentElement).getLuminosità() + " su 10.");
                                action = "-l";
                            }
                            case "n" -> {
                                currentElement.esegui();
                                action = "n";
                            }
                            default -> {
                                action = "";
                            }
                        }
                    } while (!action.equals("n"));
                }
            }
        } while (n != 0);
    }
}
