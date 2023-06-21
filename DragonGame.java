import java.util.Scanner;
import java.util.Random;

public class DragonGame {
    public static int poz() {
        return new Random().nextInt(75) + 20; // Randomly poz, se pozdravis med 20 do 75
    }

    public static int lightdmg() {
        return new Random().nextInt(20) + 1; // Light attack mapade za med 1 do 20
    }

    public static int strdmg() {
        return new Random().nextInt(90) + 30; // Strong attack napade za med 30 to 90
    }

    public static int dragonAttack() {
        return new Random().nextInt(50) + 1; // Dragon napade za med 1 to 50
    }

    public static int LightAtk(int lightDamage, int dragonHealth) {
        lightDamage = lightdmg(); // Priklic LightDmg
        dragonHealth -= lightDamage; // Odsteje health zmaju
        System.out.println("\nTvoj napad:");
        System.out.println("- " + lightDamage); // Prikaze damage ki si ga naredil
        return dragonHealth;
    }

    public static int StrongAtk(int strongDamage, int dragonHealth, int playerHealth) {
        String playerHealthMsg = "Tvoj trenutni health: ";
        strongDamage = strdmg(); // Priklic StrongDmg
        dragonHealth -= strongDamage;
        playerHealth -= strongDamage / 7;
        System.out.println("\nZaradi močnega napada si izgubil " + strongDamage / 7 + " health");
        System.out.println("\n" + playerHealthMsg + playerHealth);
        System.out.println("\nTvoj napad:");
        System.out.println("- " + strongDamage);
        return dragonHealth;
    }

    public static int Heal(int playerHealth, int pozHealth) {
        String playerHealthMsg = "Tvoj trenutni health: ";
        String CannotPozMsg = "Nemores se pozdraviti trenutno.";
        if (playerHealth < 100 && playerHealth > 0) {
            pozHealth = poz(); // Priklic zdravljenja
            playerHealth += pozHealth; // Pristeje k tvojemu healthu
            System.out.println("\nPozdravil si se in pridobil " + pozHealth + " health");
            System.out.println("\n" + playerHealthMsg + playerHealth);
        } else {
            System.out.println(CannotPozMsg);
        }
        return playerHealth;
    }

    public static void main(String[] args) {
        int dragonHealth = 100;
        int playerHealth = 100;
        int lightDamage = 0;
        int strongDamage = 0;
        int pozHealth = 0;

        String playerName;
        char option;
        String dragonHealthMsg = "Zmajev trenutni health: ";

        Scanner Scanner = new Scanner(System.in);

        // Izpise info
        System.out.println("Luka Zivkovic\n");
        System.out.println("Vpisi svoje ime:");
        playerName = Scanner.next();
        System.out.println(playerName + "\n");
        System.out.println("Vpisi svoj stil napada:");
        System.out.println("a - Attack");
        System.out.println("m - Mocan attack");
        System.out.println("h - se pozdravis/heal");
        System.out.println("p - Pomoč");

        // Uporabnik vpise stil napada
        for (int i = 1;; i++) {
            System.out.println("\n------------------------------------ " + playerName
                    + " ----------------------------------------------");
            System.out.println("Tvoj " + i + ". action"); // Count your attacks
            option = Scanner.next().charAt(0);
            System.out.println(
                    "-----------------------------------------------------------------------------------------------");

            // Light Attack
            if (option == 'a') {
                dragonHealth = LightAtk(lightDamage, dragonHealth);
                System.out.println("\n" + dragonHealthMsg + dragonHealth); // Zmajev trenutni health
            }
            // Strong Attack
            else if (option == 'm') {
                dragonHealth = StrongAtk(strongDamage, dragonHealth, playerHealth);
                System.out.println("\n" + dragonHealthMsg + dragonHealth); // Zmajev trenutni health

            } // Heal
            else if (option == 'h') {
                playerHealth = Heal(playerHealth, pozHealth);
            } // Pomoč
            else if (option == 'p') {
                System.out.println("\nCilj igre je, da premagaš zmaja brez da ti umres.");
            } // Če vnesena črka ni nič od navedenih
            else {
                System.out.println("\nVnesena crka ni pravilna.");
            }
            // Napad Zmaja če ne ni vnesena črka za pomoč
            if (option != 'p') {
                System.out.println("\n Zmajev napad:");
                playerHealth -= dragonAttack();
                System.out.println("\n- " + dragonAttack());
                System.out.println("\nTvoj trenutni health: " + playerHealth);
            }
        }
    }
}