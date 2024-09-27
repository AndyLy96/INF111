public class Cours2 {
    public static void main(String[] args) {
        String message = "allo";
        afficherHeure(3, 0);
        modifierString(message);
        double surface = surfaceCercle(21.0);
        System.out.printf("%.2f\n",surface);
        StringBuffer chaineModif = new StringBuffer("Chaine modifiable");
        modifierStringBuff(chaineModif);

        for(int i = 0; i < message.length(); i++){
            char lettre = message.charAt(i);
            System.out.println(lettre);
        }

        System.out.println(inverse(message));
        System.out.println(message.indexOf("o"));
        System.out.println(message.substring(3));

        String text = "Ecole de technologie superieure de Montréal";
        System.out.println(text.contains("Montréal"));

    }


    public static String inverse(String s){
        String r = "";
        for(int i = s.length() -1; i >= 0; i--){
            r += s.charAt(i);
        }
        return r;
    }

    public static void afficherHeure(int heure, int minute){
        //side effect de la fonction : afficher l'heure où ce que l'on veut
        System.out.println(heure + ":" + minute);
    }

    public static void modifierString(String message){
        message = message + " mots supplémentaires";
        System.out.println(message);
    }

    public static double surfaceCercle(double rayon){
        double resultat = Math.PI * rayon * rayon;
        return resultat;
    }

    public static void modifierStringBuff(StringBuffer message){
        System.out.println(message);
        message.append(" mots supplémentaires");
        System.out.println(message);

    }
}

/*

Passage de paramètres
-par valeur(par copie)
    -types primitifs
    int heure = 13;
    int minute = 0;
    afficherHeure(heure, minute);

-par référence
    reçue en paramètre : modifierString(message)
        -type d'objets
            -Éviter la copie de grands blocs de données

La concaténation
    -Créé un nouveau objet String et message pointe en suite sur cet objet
message -> [String] longueur = 36, pointeur -> "Message court, Mot supplémentaire"


La condition du if est une expression
    -valeur litterale
    -appel de fonction
    -variable
    -combinaison de sous-expressions
qui s'évalue à une valeur de type boolean


Loi de DeMorgan
---------------
!(A&&B) = !A || !B
!(A||B) = !A && !B
 */