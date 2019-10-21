package com.ocr.vincent;
public class Dual {

    /**
     * LANCEMENT DU MODE DUEL --> MODE 3
     * @param len : longueur de la combinaison (nbr de charactères défini dans le .properties)
     */
    public void run(int len) {

        Combination combination = new Combination();
        Result result = new Result();
        int nbTry = 0;
        boolean gameIsOver = false;

        System.out.println("Création de ma combinaison :");
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");

        String userSecret = combination.ask(len);  // Combinaison secrète saisie par l'utilisateur
        String cpuSecret = combination.generate(len); // combinaison secrète générée aléatoirement par CPU
        String userReply=""; // Résultat après comparaison (+ - =)
        String cpuReply=""; // Résultat après comparaison (+ - =)

        System.out.println("Joueur CPU a créé sa combinaison :");
        System.out.println("----------------------------------");
        // System.out.println(userSecret); // A SUPPRIMER
        // System.out.println(cpuSecret); // A SUPPRIMER

        do {
            nbTry += 1;
            System.out.println("Saisir votre suggestion :");
            String userInput = combination.ask(len);
            String cpuInput = combination.find(len);
            String player;

            if (!gameIsOver) {
                /** TOUR ORDINATEUR*/
                System.out.println("----------------------------------");
                player = "CPU";
                combination.display(userSecret, cpuInput, player, nbTry);
                cpuReply = combination.compare(userSecret, cpuInput, player, len);
                gameIsOver = result.run(player, userSecret, cpuReply , Settings.winReply, gameIsOver, nbTry);
            }

            if (!gameIsOver){
                /** TOUR UTILISATEUR*/
                System.out.println("----------------------------------");
                player ="USER";
                combination.display(cpuSecret, userInput, player, nbTry);
                userReply = combination.compare(cpuSecret, userInput, player, len);
                gameIsOver = result.run(player, cpuSecret, userReply , Settings.winReply, gameIsOver, nbTry);
                System.out.println("----------------------------------");
            }
        } while (!gameIsOver);
    }
}