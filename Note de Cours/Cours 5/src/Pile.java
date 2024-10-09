/**
 * Cette classe implémente une Pile
 *
 * Pile(Stack)
 *    - Dernier arrivé, premier parti
 *    - Insertion et le retrait des éléments se fait au même endoroit
 *
 * Interface d'une pile
 *    - Empiler (push)
 *    - Dépiler (pop)
 *
 * Le type de l'élément est abstrait en utilisant la classe Objet
 *
 * Cette classe dépend de la classe ListeChainee
 */
public class Pile {
    ListeChainee liste;

    public Pile() {
        liste = new ListeChainee();
    }

    // accesseurs
    public boolean estVide() { return liste.estVide(); }
    public int getTaille()   { return liste.getTaille(); }

    /**
     * Ajoute un élément sur la pile.
     * @param element l'objet à ajouter.
     */
    public void empiler(Object element) {
        liste.ajouterDebut(element);
    }

    /**
     * Retire un élément de la pile.
     * @return l'élément retiré.
     */
    public Object depiler() {
        if (liste.estVide()) {
            return null;
        } else {
            return liste.retirerDebut();
        }
    }

    public String toString() {
        return liste.toString();
    }
}