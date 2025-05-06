package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Aufgabe> aufgaben = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int eingabe;

        while (true){
            System.out.println("Geben Sie eine Nummer ein. Um zu starten: \n");
            System.out.println("1. Neue Aufgabe hinzufügen\n2. Aufgaben anzeigen\n3. Aufgabe als erledigt markieren\n4. Programm beenden");
            switch(scanner.nextInt()){
                case 1 -> {
                    scanner.nextLine();
                    System.out.println("Titel der Aufgabe: ");
                    String titel = scanner.nextLine();
                    System.out.println("Beschreibung der Aufgabe: ");
                    String beschreibung = scanner.nextLine();
                    System.out.println("Prio der Aufgabe: Hoch, Mittel oder Niedrig? ");
                    String prio = scanner.nextLine();
                    Prio priority = null;
                    switch (prio.toLowerCase()){
                        case "hoch" -> priority = Prio.HIGH;
                        case "mittel" -> priority = Prio.MEDIUM;
                        case "niedrig" -> priority = Prio.LOW;
                        default -> System.err.println("Ungültige Priorität eingabe");
                    }
                    if(priority != null){
                        aufgaben.add(new Aufgabe(titel, beschreibung, priority));
                        System.out.println("Aufgabe wurde hinzugefügt!");
                    } else {
                        System.err.println("Objekt wurde nicht erstellt wegen fehlender Priorität");
                    }

                }
                case 2 -> {
                    for (Aufgabe aufgabe : aufgaben){
                        System.out.println(aufgabe.toString());
                    }
                    System.out.println();
                }
                case 3 -> {
                    scanner.nextLine();
                    System.out.println("Titel der Aufgabe die als erledigt markiert werden soll: ");
                    String titel = scanner.nextLine();

                    for (Aufgabe aufgabe : aufgaben){

                        if(aufgabe.getTitel().equalsIgnoreCase(titel)){
                            aufgabe.alsErledigtMarkieren();
                            System.out.println(aufgabe.getTitel() + " Wurde erledigt!\n");
                            break;
                        }
                    }

                    //System.err.println("Es wurde keine aufgabe mit den Titel gefunden!");


                }
                case 4 -> {
                    return;
                }
                default -> { System.err.println("Fehlerhafte Eingabe. Bitte erneut versuchen.\n"); }
            }
        }

    }
}

enum Prio{
    LOW,
    MEDIUM,
    HIGH
}

class Aufgabe{
    private String titel;
    private String beschreibung;
    private boolean erledigt;
    private Prio prio;

    public Aufgabe(String titel, String beschreibung, Prio prio) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.erledigt = false;
        this.prio = prio;
    }

    public void alsErledigtMarkieren(){
        this.erledigt = true;
    }

    @Override
    public String toString(){
        if(erledigt==true){
            return  "[x] " + this.titel + ": " + this.beschreibung + " [" + this.prio + "] ";
        } else {
            return "[ ] " + this.titel + ": " + this.beschreibung  + " [" + this.prio + "] ";
        }

    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }
}