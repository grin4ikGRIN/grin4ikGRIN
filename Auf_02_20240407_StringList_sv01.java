package aufgaben;

import java.io.IOException;
import java.util.*;

/*
Schreiben Sie bitte zunächst die 3 folgenden Methoden:
a) Funktionsname: schreibeListe
   Übergabewert:  1 String-Liste 'l'
   Funktion:      l wird sortiert, anschließend werden alle Strings in l auf der Konsole ausgegeben
   Rückgabewert:  Keiner
b) Funktionsname: hatLeerzeichen
   Übergabewert:  1 String 's'
   Funktion:      Füllt die boolesche Variable 'b' mit 'true', FALLS s (mindestens) ein Leerzeichen besitzt, SONST 'false'
   Rückgabewert:  b
c) Funktionsname: schonVorhanden
   Übergabewert:  1 String-Liste 'l' und ein String 's'
   Funktion:      Füllt die boolesche Variable 'b' mit 'true', FALLS s in l vorkommt, SONST 'false'
   Rückgabewert:  b

Testen Sie die obigen Methoden bitte mithilfe des folgenden Programms:
- Zunächst wird eine Liste vom Typ String eingeführt
- Das Programm startet eine Endlos-Schleife, in der pro Durchlauf ...
  + vom User ein Wort abgefragt wird
    - falls in der Eingabe ein Leerzeichen vorkommt: entsprechende Fehlermeldung:
    - falls in der Eingabe KEIN Leerzeichen vorkommt, ABER die Eingabe bereits in der Liste vorkommt: entsprechende Fehlermeldung
    - falls WEDER ein Leerzeichen vorkommt, NOCH die Eingabe bereits vorkommt, so wird die Eingabe in die Liste mit aufgenommen
  + alle Elemente der Liste werden auf der Konsole ausgegeben
*/
public class Auf_02_20240407_StringList_sv01 {
    //Schreiben Sie bitte zunächst die 3 folgenden Methoden:
    //a) Funktionsname: schreibeListe
    //   Übergabewert:  1 String-Liste 'l'
    //   Funktion:      l wird sortiert, anschließend werden alle Strings in l auf der Konsole ausgegeben
    //   Rückgabewert:  Keiner

    public static void schreibeListe(ArrayList<String> l) {
        Collections.sort(l);
        for(String s : l) {
            System.out.println(s);
        }
    }

    //b) Funktionsname: hatLeerzeichen
    //   Übergabewert:  1 String 's'
    //   Funktion:      Füllt die boolesche Variable 'b' mit 'true', FALLS s (mindestens) ein Leerzeichen besitzt, SONST 'false'
    //   Rückgabewert:  b

    public static boolean hatLeerzeichen(String s) {
        boolean b = false;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i] == ' '){
                b = true;
                break;
            }
        }
        return b;
    }

    //c) Funktionsname: schonVorhanden
    //   Übergabewert:  1 String-Liste 'l' und ein String 's'
    //   Funktion:      Füllt die boolesche Variable 'b' mit 'true', FALLS s in l vorkommt, SONST 'false'
    //   Rückgabewert:  b

    public static boolean schonVorhanden(ArrayList<String> l, String s){
        boolean b = false;
        if (l.contains(s)){
            b = true;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        // Testen Sie die obigen Methoden bitte mithilfe des folgenden Programms:
        //- Zunächst wird eine Liste vom Typ String eingeführt

        ArrayList<String> strListe = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String eingabe = null;

        //- Das Programm startet eine Endlos-Schleife, in der pro Durchlauf ...
        //  + vom User ein Wort abgefragt wird
        while (true) {
            System.out.print("Geben Sie ein Wort ein: ");
            eingabe = scan.nextLine();

            try {
                //    - falls in der Eingabe ein Leerzeichen vorkommt: entsprechende Fehlermeldung:
                if(hatLeerzeichen(eingabe)) {
                    throw new IOException("Das sind mehrere Wörter! Versuchen Sie noch einmal");
                } else if (schonVorhanden(strListe, eingabe)) {
                    //    - falls in der Eingabe KEIN Leerzeichen vorkommt, ABER die Eingabe bereits in der Liste vorkommt: entsprechende Fehlermeldung
                    throw new InputMismatchException("Das Wort ist schon vorhanden");
                }
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                continue;
            }

            //    - falls WEDER ein Leerzeichen vorkommt, NOCH die Eingabe bereits vorkommt, so wird die Eingabe in die Liste mit aufgenommen
            strListe.add(eingabe);

            //  + alle Elemente der Liste werden auf der Konsole ausgegeben
            System.out.println(strListe);
        }

    }

}
