package com.ocr.vincent;

import java.util.Scanner;

public class Game {

    /**
     * LANCEMENT DU JEU : Choix du mode
     */
    public void play() {
        int mode; // Choix du mode de jeu  1 ou 2 ou 3
        Scanner sc = new Scanner(System.in);
        System.out.println("[NOUVELLE PARTIE]");
            do {
                System.out.println("CHOISIR UN MODE DE JEU : 1 - CHALLENGER, 2 - DÉFENSEUR, 3 - DUEL");
                if (Settings.devMode) System.out.println("[MODE DÉVELOPPEUR ACTIF]");
                mode = sc.nextInt();
                /** Lancement du mode de jeu choisi */
                switch (mode) {
                    case 1: /** MODE CHALLENGER */
                        System.out.println("[MODE CHALLENGER] : Trouver la bonne combinaison ");
                        Challenger challenger = new Challenger();
                        challenger.run("USER", Settings.combLen);
                        break;
                    case 2: /** MODE DEFENSEUR */
                        System.out.println("[MODE DÉFENSEUR] : Définir une combinaison secrète");
                        Defender defender = new Defender();
                        defender.run("CPU", Settings.combLen);
                        break;
                    case 3: /** MODE DUEL */
                        System.out.println("[MODE DUEL]");
                        Dual dual = new Dual();
                        dual.run(Settings.combLen);
                        break;
                    case 123: /** "123" active le mode Développeur false par defaut dans le .properties */
                        //System.out.println("[MODE DÉVELOPPEUR ACTIF]");
                        Settings.devMode = true;
                        break;
                    default:
                        System.out.println("Taper 1,2 ou 3");
                        break;
                }
            } while (mode < 1 || mode > 4);
        }

    /**
     * Méthode permettant de relancer une partie ou quitter
     * @return b1 True -> Rejouer, False = Quitter le jeu
     */
    public boolean replay () {

        Scanner sc = new Scanner(System.in);
        Controls controls = new Controls();
        boolean b1 = true; // rue -> Rejouer, False = Quitter le jeu
        boolean b2 = false; // Controle de saisie True -> erreur, false -> pas d'erreur
        int myChoise; // Choix 1 ou 2 pour rejouer ou quitter
        String myChoiseStr = ""; // Choix au format string pour le control de saisie

        do {
            System.out.println("Rejouer une partie ? : Taper : 1 -> oui ou 2 -> non");
            myChoiseStr = sc.nextLine();
            b2 = controls.run(myChoiseStr); // Controle de saisie : true -> erreur trouvée (char et non int)
            if (!b2) {
                myChoise = Integer.parseInt(myChoiseStr);
                switch (myChoise) {
                    case 1:
                        b1 = true;
                        break;
                    case 2:
                        System.out.println("[FIN DE PARTIE]");
                        b1 = false;
                        break;
                }
            }
            /**if (myChoiseStr.equals("1") || myChoiseStr.equals("2")) {
                System.out.println("ok");
            } */
            if (myChoiseStr.equals("1") == true || myChoiseStr.equals("2") == true) {
                b2 = true;
            }
        } while (!b2); // b2 !myChoiseStr.equals(1) || !myChoiseStr.equals(2)
        return b1;
    }
}
