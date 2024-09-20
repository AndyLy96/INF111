import java.util.Arrays;
import java.util.Scanner;

public class Cours3 {
    /*TABLEAUX
    * Les tableaux sont des collections d'éléments de même type
    * On accède à un élément par son indice
    * Les tableau sont des objets et son passés en référence
    *   -On peut modifier l'original dans les méthodes
    * */


    //Les étapes énumérés présentent une liste d'options.
    //Cest une alternative plus robuste à la définition de plusieurs constantes
    public enum PointCardinaux{NORD, SUD, EST, OUEST}

    public static void main(String[] args){
        System.out.println("Le mois d'aujourd'hui est :" + nomDuMOis(9));
        System.out.println("Le numéro de la couleur verte est :" + numeroCouleur("Vert") );

        //Utilisation correcte et robuste d'un enum
        System.out.println(nomDirectionAnglais(PointCardinaux.NORD));

        //Comment briser un enum
        System.out.println(nomDirectionAnglais(
                    PointCardinaux.valueOf("NORD")
                )
        );

        //Déclaration et réservation de la mémoire
        //tableau de 0 de 26 cases
        int[] valeurFixe = new int[26];

        for (int i = 0; i < valeurFixe.length;  i++){
            valeurFixe[i] = 3;
        }

        // Calculer la somme des éléments
        double[] depots = {221.47, 323.26, 417.01, 22.44, 912.31};
        double somme = 0;

        for (int i = 0; i < depots.length; i++){
            somme += depots[i];
        }

        //calculer la some avec foreach
        double total = 0;
        for (double d : depots){
            //Pour chacun des éléments "d" de depots
            total += d;
        }

        //calculer la mouemme
        double depotMoyen = somme / depots.length;

        //Trouver la valuer de maximum
        double valeurMax = depots[0];
        for (int i  = 1; i < depots.length; i++){
            if (depots[i] > valeurMax){
                valeurMax =  depots[i];
            }
        }

        //trouver la position (l'indice du maximum)
        int indiceMax = 0;
        for (int i = 1; i < depots.length; i++){
            indiceMax = i;
        }

        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez saisir le text");
        String texte = clavier.nextLine();

        int[] occurences = occurencesLettres(texte);
        double[] frequences = frequencesLettres(occurences);
        afficherResultats(occurences,frequences);

        int[] tableau1D = { 3, 7, 65, 876, 2345, 32, 12};
        int[][] donneesTest = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        // on a 5 evaluation pour 4 etudiants
        int[][] notesEtudiants = {
                {67, 86, 94, 53, 41},
                {100, 21, 43, 56, 78},
                {90, 98, 9, 87, 68},
                {12, 54, 36, 76, 21}
        };

        int[][] matriceVide = new int[5][8];

        // test d'access
        System.out.println(donneesTest[0][0]); //valeur attendue 1
        System.out.println(donneesTest[2][4]); //valeur attendue 15

        System.out.println(estPresent(donneesTest, 99)); //attendu faux
        System.out.println(estPresent(donneesTest, 8)); //attendu vrai

        //tester la moyenne d'une ligne
        System.out.println(moyenneLigne(notesEtudiants, 1));
        System.out.println(moyenneColonne(notesEtudiants, 1));

        //tester les indices de colonne
        System.out.println(getCOl(notesEtudiants, 21));
        System.out.println(getCOl(notesEtudiants, 99));


        //test des notes et moyennes
        System.out.println(max2d(notesEtudiants));
        double[] moy = moyenneEvaluations(notesEtudiants);
        System.out.println(Arrays.toString(moy));
    }


    /**
     * Valeur maximale trouvée dans un tableau 2d d'entier
     * @param data le tableau à considérer
     * @return la plus grande valeur trouvée
     */
    public static int max2d(int[][] data){
        int max = data[0][0];


        //data.length reoturne le nombre de sous-tableaux (les lignes)
        for (int i = 0; i < data.length; i++){
            //data[0].length retourne le nombre d'element par ligne
            for(int j = 0; j < data[0].length; j++){
                if (data[i][j] > max){
                    max = data[i][j];
                }
            }
        }

        return max;
    }

    /**
     * Produit un tableau des resultats moyen par évaluation à partir d,UN tableau 2d des notes
     * @param notes tableau a 2d des notes
     * @return un tableau des moyennes des évaluations
     */
    public static double[] moyenneEvaluations(int[][] notes){
        double[] moyennes = new double[notes[0].length];

        //on veut le total par colonne, donc on fait unparcours colonne - ligne
        for (int col = 0; col < notes[0].length; col++){
            for (int ligne = 0; ligne < notes.length; ligne++){
                moyennes[col] += notes[ligne][col];
            }
        }

        //on divise les totaux par le nmobre d'évaluations
        for (int i = 0; i < moyennes.length; i++){
            moyennes[i] = moyennes[i]/notes.length;
        }

        return moyennes;
    }

    public static int moyenneLigne(int[][] data, int numeroLigne){
        /* Stratégie
        1. INitialier le total a 0
        2. Obtenir le sous-tableau correspodnant a la ligne
        3. parcourir les elements pour en faire le total
        4. calculer et retourner la moyenne
         */

        int total = 0;
        for (int i = 0; i < data[numeroLigne].length; i++){
            total += data[numeroLigne][i];
        }

        return total/data[numeroLigne].length;
    }

    public static int moyenneColonne(int[][] data, int numeroColonne){
        /* Stratégie
        1. INitialier le total a 0
        2. OPour chacunes des lignes
            3. ajouter au total la valeur de la colonne demandée
        4. calculer et retourner la moyenne
         */

        int total = 0;
        for (int[] datum : data) {
            total += datum[numeroColonne];
        }
//        for (int ligne = 0; ligne < data.length; ligne++){
//            total += data[ligne][numeroColonne];
//        }

        return total/data.length;
    }

    public static int getCOl(int[][] data, int element){
        /* Stratégie
        1. iNitialiser l'indice à -1
        2. parcourir le tableau
        3. si trouver, retourner immédiatement le numéro de colonne
         */

        int indice = -1;

        for (int ligne = 0; ligne < data.length; ligne++){
            for (int colonne = 0; colonne < data[0].length; colonne++){
                if (data[ligne][colonne] == element){
                    indice = colonne;

                    //garantir qu'on reoturne la premiere occurence
                    return indice;
                }
            }
        }
        return indice;
    }

    /**
     * INdique si un élément donné est présent dans un tableau 2D
     * @param data données à parcourir
     * @param elemnt élément rechercher
     * @return vrai si trouvé, faux sinon
     */
    public static boolean estPresent(int[][] data, int elemnt){
        /* Stratégie
            1. Initialiser la valeur de retour a faux
            2. Pour chacune des lignes
                3. pour chacune des colonnes
                    4. COmparer les éléments
                    5. si egaux, retourner vrai
            6. retourner faux

            Rappel : la propriété "length" d,Un tableau 2D reoturne le nombre de lignes
         */
        boolean resultat = false;
        for (int ligne = 0; ligne < data.length; ligne++){
            for (int colonne = 0; colonne < data[0].length; colonne++){
                if (data[ligne][colonne] == elemnt){
                    return true;
                }
            }
        }

        return resultat;
    }

    //Switcher sur un entier
    /*
    * Produit une chaine contenan le nom du mois d'apres son numero.
    * @param numeroMois le numéro du mois à retourner.
    * @return Une chaine contenant le nmom du mois correspondant.
    *       Si le numéro est inférieur à 1 ou supérieur à 12, retourne "mois inc.onnu"
    * */

    public static String nomDuMOis(int numeroMois){
        String chaineMois = "";


        //un tableau de String est une meilleur manière de faire ceci
        switch (numeroMois){
            case 1: chaineMois = "Janvier"; break;
            case 2: chaineMois = "Fevrier"; break;
            case 3: chaineMois = "Mars"; break;
            case 4: chaineMois = "Avril"; break;
            case 5: chaineMois = "Mai"; break;
            case 6: chaineMois = "Juin"; break;
            case 7: chaineMois = "Juillet"; break;
            case 8: chaineMois = "Aout"; break;
            case 9: chaineMois = "Septembre"; break;
            case 10: chaineMois = "Octobre"; break;
            case 11: chaineMois = "Novembre"; break;
            case 12: chaineMois = "Decembre"; break;
            default: chaineMois = "Mois iconnu"; break;
        }
        return  chaineMois;
    }


    //Switcher sur une chaine
    /*
    * Produit un code de couleur à partir d'une chaine.
    * @param nomCouleur chaine contenant le nom d'une couleur;
    * IMPORTANT!!!
    * @return  le code de couleur correspondant au numéro, ou -1
    *       si le nom de cette couleur est inconnu
    * */
    public static int numeroCouleur(String nomCouleur){
        int codeCouleur = 0;

        switch (nomCouleur){
            case "Rouge": codeCouleur = 9; break;
            case "Bleu": codeCouleur = 10; break;
            case "Vert": codeCouleur = 19; break;
            default: codeCouleur = -1; break;
        }
        return  codeCouleur;
    }

    //Switcher sur un enum
    /**
     * Prdouit une chaine conteantn le nom du point cordinal en anglais.
     * @param p L'élément d'énumératino choisi.
     * @return une chaine contenant du nom point cordinal fourni en anglais.
     */
    public static String nomDirectionAnglais(PointCardinaux p){
        String chaineDirection = "";

        switch (p){
            case NORD: chaineDirection = "North"; break;
            case SUD: chaineDirection = "South"; break;
            case EST: chaineDirection = "East"; break;
            case OUEST: chaineDirection = "West"; break;
        }
        return chaineDirection;
    }

    /**
     * Produit un tableau d'occurences de lettres dans une chaine.
     * @param source La chaine source
     * @return un tableau contenant le nombre d'occurence de chacune des 26 lettres
     * dans la chaine reçu
     */
    public static int[] occurencesLettres(String source) {
        // preparer un tableau avec une case par lettre
        int[] occurence = new int[26]; //Toutes les cases contiennent 0

        //convertir en minuscule (avoir une seule casse)
        String sourceMinuscule = source.toLowerCase();

        //Parcourir chaque élément de la chaine avec charAt(i)
        for(int i = 0; i < sourceMinuscule.length(); i++){
            //verifier si c'est une lettre
            if(sourceMinuscule.charAt(i) >= 'a' && sourceMinuscule.charAt(i) <= 'z'){
                //mettre à jour le compteur pour cette lttre
                occurence[sourceMinuscule.charAt(i) - 'a']++;
            }
        }
        return occurence;
    }

    /**
     * Produit un tableau des frequences relatives des lettre dans une chaine.
     * @param occurences un tableau contenant le nombre de chacune des 26 lettres de l'alphabet
     * @return un tableau contenant la frequence relative de chacune des 26 lettres
     */
    public static double[] frequencesLettres(int[] occurences){
        double[] frequences = new double[26];
        //Obtenir le nombre total d'occurences dans le tableau
        int total = 0;
        for (int compte : occurences){
            total += compte;
        }

        //Diviser chauce des valeurs par ce total pour obtenir sa fréquence
        for (int i = 0; i < frequences.length; i++){
            frequences[i] = occurences[i] / (double) total;
        }
        return frequences;
    }

    /**
     * Affiche les résultats de l'analyse fréquentielle dans la console,.
     * @param occurences Tableau des occurences des lettres
     * @param frequences Tableau de fréquences relative des lettres
     */
    public static void afficherResultats(int[] occurences, double[] frequences){
        for (int i = 0; i < occurences.length; i++){
            char lettre = (char)('A' + i);
            System.out.printf("%c : %d\t%.3f\n", lettre, occurences[i],
                    frequences[i]);
        }
    }



}
