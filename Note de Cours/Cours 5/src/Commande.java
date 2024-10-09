/**
 * Cette classe implémente une Commande.
 *
 * C'est un objet de test (simulacre ou "Mock Object") permettant de valider le fonctionnement
 * de ListeChainee, Pile et File pour des applications variées du patron Commande.
 */
public class Commande {
    private final String description;

    public Commande(String description) {
        this.description = description;
    }

    public void execute() {
        System.out.println("Execution : " + description);
    }

    public String toString() {
        return "Commande : " + description;
    }
}