import java.util.Scanner;  // Import the Scanner class
import java.util.Random;

public class Lab1 {

    /* EXERCICE 3.2
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Entrez une température en degrés Celsius : ");

        double tempCelcius = myObj.nextDouble();

        double tempFarenheit = (tempCelcius * 1.8) + 32;

        System.out.println(tempCelcius + " C = " + tempFarenheit + " F");
    }


    CORRIGÉ
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Entre numéro :" )
        double celcius = in.nextDouble();

        double farenheit = celcius * (9.0/5.0) + 32.0;

    }

    */

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Entre numéro :" );

        //TOUJOURS traité les erreures potentiel, ici l'erreur potentiel c'est
        //si l'utilisatuer tape quelquchose qui n'est pas un double
        /*
        if (in.hasNextDouble()){
            double celcius = in.nextDouble();
            double farenheit = celcius * (9.0/5.0) + 32.0;
            System.out.printf("%.1f C = %.1f F\n", celcius, farenheit);
        }
        else {
            System.out.println("Entree invalide");
        }

        Maybe try to do it in a loop
        So that it always searches for the right input

        */

    }

    /* EXERCICE 3.3
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Entrez un nombre : ");

        int nbSaisis = myObj.nextInt();
        int heure = nbSaisis / 3600;
        int minutes = (nbSaisis % 3600) / 60;
        int secondes = nbSaisis % 60;

        System.out.print( nbSaisis + " secondes = " + heure + " heure(s), " + minutes + " minutes et " + secondes + " secondes");

    }
    */

    /* EXERCICE 3.3
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Je pense à un nombre entre 1 et 100 (les deux inclus). \nPouvez-vous deviner ce que c'est ?" );

        Random nbAleatoire = new Random();
        int nbRandom = nbAleatoire.nextInt(100) + 1;

        System.out.print("Tapez un nombre : ");
        int nbFourni = myObj.nextInt();
        System.out.print("Votre estimation est de : " +  nbFourni + "\nLe nombre auquel je pensais est : " + nbRandom + "\n");

        if(nbRandom != nbFourni){
            int difference = Math.abs(nbRandom - nbFourni);
            System.out.print("Vous vous êtes trompé de : " + difference);
        }else {
            System.out.print("Vous aviez bien devinez!");
        }
    }

    */

}
