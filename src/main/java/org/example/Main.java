package org.example;

import java.util.ArrayList;
import java.util.List;
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
                    aufgaben.add(new Aufgabe(titel, beschreibung));
                }
                case 2 -> {
                    for (Aufgabe aufgabe : aufgaben){
                        System.out.println(aufgabe.toString());
                    }
                    System.out.println();
                }
                case 3 -> System.out.println();
                case 4 -> {
                    return;
                }
                default -> { System.err.println("Fehlerhafte Eingabe. Bitte erneut versuchen.\n"); }
            }
        }

    }
}

class Aufgabe{
    private String titel;
    private String beschreibung;
    private boolean erledigt;

    public Aufgabe(String titel, String beschreibung) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.erledigt = false;
    }

    public void alsErledigtMarkieren(){
        this.erledigt = true;
    }

    @Override
    public String toString(){
        if(erledigt==true){
            return  "[x] " + this.titel + ": " + this.beschreibung;
        } else {
            return "[ ] " + this.titel + ": " + this.beschreibung;
        }

    }
}