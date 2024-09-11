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
    */

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
