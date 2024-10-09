/**
 * Cette classe implémente une File(First in, first out)
 *  - Premier arrivé, prmier parti
 *  - INsertion et le rretrit de éléments,s e fait aux ext^remes opposées
 *
 * INterface d'une file
 * - enfiler (enqueue)
 * - defiler (dequeue)
 * Le type de l'élément est abstrait en utilisant la classe Objet
 *
 * Cette classe dépend de la classe ListeChainee
 */
public class File {
    ListeChainee liste;

    public File() {
        liste = new ListeChainee();
    }

    // accesseurs
    public boolean estVide() { return liste.estVide(); }
    public int getTaille()   { return liste.getTaille(); }

    /**
     * Ajouter un élément dans la file.
     * @param element l'élément à ajouter.
     */
    public void ajouter(Object element) {
        liste.ajouterDebut(element);
    }

    /**
     * Retirer le prochain élément de la file.
     * @return l'élément retiré, null si la file est vide.
     */
    public Object retirer() {
        if (liste.estVide()) {
            return null;
        } else {
            return liste.retirerFin();
        }
    }

    public String toString() {
        return liste.toString();
    }
}