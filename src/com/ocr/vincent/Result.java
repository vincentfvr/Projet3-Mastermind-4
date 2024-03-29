package com.ocr.vincent;

public class Result {

    /**
     * Résultat fin de partie : Partie gagnée, nouvel essai ou partie perdue (nombre d'essais dépassé)
     * @param player : nom du joueur
     * @param secret : la combinaison secrète
     * @param theReply : Contient le résultat de la comparaison comb1/comb2 (+, -, =)
     * @param winReply : Contient le résultat attendu ( "=" x longueur de la combinaison)
     * @param gameIsOver : true si partie terminée (qu'elle soit gagnée ou perdue)
     * @param nbTry : compteur d'essai
     * @return gameIsOver
     */
    public boolean run(String player, String secret, String theReply, String winReply, boolean gameIsOver, int nbTry) {

        String newLine = System.getProperty("line.separator");

        /** Affichage des indications en fonction de la suggestion */
            System.out.println("Indication --> " + theReply);

        /** Affichage des indications en mode Développeur uniquement */
        if (Settings.devMode) {
            System.out.println("maxValues : " + Settings.maxValues);
            System.out.println("minValues : " + Settings.minValues);
            System.out.println("theValues : " + Settings.theValues);
        }

        /** Affichage fin de partie : Partie gagnée, nouvel essai ou partie perdue (nombre d'essais dépassé) */

        if (theReply.contains(winReply)) {
            gameIsOver = true;
            System.out.println(newLine + "**********************************************************");
            System.out.println("   Joueur " + player + " A GAGNÉ! Combinaison trouvée en " + nbTry + " coups.");
            System.out.println("**********************************************************");
        } else {
            //System.out.println("MAUVAISE COMBINAISON");
            if (nbTry == Settings.nbTryLimit) {
                gameIsOver = true;
                System.out.println(newLine + "[PARTIE PERDUE] Nombre d'essais dépassé (" + Settings.nbTryLimit + ")");
                System.out.println("La bonne combinaison était : " + secret);
            } else {
                if (player=="USER")System.out.println(newLine + "[NOUVEL ESSAI] (" + (nbTry + 1) + "/" + Settings.nbTryLimit + ")");
            }
        }
        return gameIsOver;
    }
}
