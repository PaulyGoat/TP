import java.util.Scanner;

public class TP3 {
    
    // [i][0] → titre
    // [i][1] → auteur
    // [i][2] → catégorie
    // [i][3] → année
    // [i][4] → réservé (true / false)
    static Scanner scan = new Scanner(System.in);

    static final int iMAX = 100; // Nombres maximal de livres
    static String[][] sLivres = new String[iMAX][5]; //Tableau pour les 100 livres et leurs categories
    static int iNbLivres = 0; // Compteur de livres

    public static void main(String[] args)
    {
        int iChoix;
        do {
            afficherMenu();
            iChoix = scan.nextInt();
            scan.nextLine();
            
            switch (iChoix) {
                case 1:
                    ajouterLivre();
                    break;

                case 2:
                    afficherLivres();
                    break;

                case 3:
                    rechercherParTitre();
                    break;

                case 4:
                    supprimerLivre();
                    break;

                case 5:
                    afficherParCategorie();
                    break;

                case 6:
                    reserverLivre();
                    break;

                case 7:
                    retournerLivre();
                    break;

                case 0:
                    System.out.println("Fermeture du programme");
                    break;

                default:
                    System.out.println("Entrez un chiffre entre 1 et 7!");
            }

        } while (iChoix != 0);
    }

    public static void afficherMenu()
    {
        //Menu
        System.out.println("\nBiblio Numérique TP3");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Afficher tous les livres");
        System.out.println("3. Rechercher un livre par titre");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. Afficher les livres par catégorie");
        System.out.println("6. Réserver un livre");
        System.out.println("7. Retourner un livre");
        System.out.println("0. Quitter");
        System.out.println("Entrez votre choix: ");
    }

    public static void ajouterLivre() 
    {
        //Si le nombre de livres atteint le max, donc 100 message d'erreur
        if (iNbLivres == iMAX) 
        {
            System.out.println("");
            System.out.println("La biblio est pleine !");
            return;
        }
        System.out.println("");
        System.out.println("Entrez le Titre: ");
        String sTitre = scan.nextLine();

        //Si sa donne -1 sa veut dire que livre existe deja
        if (chercherIndex(sTitre) != -1) 
        {
            System.out.println("");
            System.out.println("Ce livre existe deja !");
            return;
        }

        // [i][0] → titre
        // [i][1] → auteur
        // [i][2] → catégorie
        // [i][3] → année
        // [i][4] → réservé (true / false)

        //Entrez des données du livre
        System.out.println("Auteur: ");
        sLivres[iNbLivres][1] = scan.nextLine();

        System.out.println("Catégorie: ");
        sLivres[iNbLivres][2] = scan.nextLine();

        System.out.print("Année: ");
        sLivres[iNbLivres][3] = scan.nextLine();

        sLivres[iNbLivres][0] = sTitre;
        sLivres[iNbLivres][4] = "false";

        iNbLivres++;//Ajout dans le nombre de livres
        System.out.println("Livre ajouté");
    }

    public static void afficherLivres()
    {
        if (iNbLivres == 0) {
            System.out.println("La biblio est vide");
            return;
        }

        for (int i=0; i<iNbLivres; i++) //Tant que i est plus petit que le nombre de livres dans le tableau
        { 
            afficherLivre(i);
        }
    }

    public static void rechercherParTitre()
    {
        System.out.println("Titre du livre a rechercher? ");
        String sTitre = scan.nextLine();
        int iIndex = chercherIndex(sTitre);
        //Si le livre existe
        if (iIndex != -1) 
        {
            afficherLivre(iIndex);
        }
        else 
        {
            System.out.println("Le livre n'existe pas");
        }
    }

    public static void supprimerLivre() 
    {
        System.out.println("Titre a supprimer: ");
        String sTitre = scan.nextLine();
        int iIndex = chercherIndex(sTitre);

        //Livre introuvable
        if (iIndex == -1) {
            System.out.println("Livre inexistant");
            return;
        }
        // Quand un livre est supprimer tout les livres a sa droites "avancent" de 1 dans la liste de livre car il est supprimer
        for (int i=iIndex; i<iNbLivres-1; i++) {
            sLivres[i] = sLivres[i + 1];
        }

        iNbLivres--;
        System.out.println("Livre supprimé");
    }

    public static void afficherParCategorie()
    {
        System.out.print("Catégorie: ");
        String sCategorie = scan.nextLine();
        boolean bTrouve = false;

        //On parcourt tous les livres dans la biblio et on affiche ceux qui la catégorie correspond à celle demandée
        for (int i =0; i < iNbLivres; i++) {
            if (sLivres[i][2].equalsIgnoreCase(sCategorie)) {
                afficherLivre(i);
                bTrouve = true;
            }
        }

        if (!bTrouve) {
            System.out.println("Aucun livre est trouver dans cette catégorie.");
        }
    }
    public static void reserverLivre() 
    {
        System.out.print("Quel livre voulez vous réserver: ");
        String sTitre = scan.nextLine();

        int iIndex = chercherIndex(sTitre);
        if (iIndex == -1)
        {
            System.out.println("Livre introuvable.");
        } 
        else if (sLivres[iIndex][4].equals("true"))//Empecher une deuxieme reservation
        {
            System.out.println("Le livre est déja réservé.");
        } 
        else 
        {
            sLivres[iIndex][4] = "true";
            System.out.println("Livre réservé.");
        }
    }

    public static void retournerLivre() 
    {
        System.out.print("Livre à retourner: ");
        String titre = scan.nextLine();
        int iIndex = chercherIndex(titre);

        if (iIndex == -1)
        {
            System.out.println("Le livre est introuvable.");
        }
        else 
        {
            sLivres[iIndex][4] = "false";
            System.out.println("Le livre est retourner");
        }
    }

    public static int chercherIndex(String sTitre) 
    {
        //Cette méthode parcourt le tableau des livres et retourne l’index du livre si le titre est trouvé, sinon elle retourne -1.
        for (int i = 0; i < iNbLivres; i++)
        {
            if (sLivres[i][0].equalsIgnoreCase(sTitre)) 
            {
                return i;
            }
        }
        return -1;
    }
    public static void afficherLivre(int i) 
    {
        // [i][0] → titre
        // [i][1] → auteur
        // [i][2] → catégorie
        // [i][3] → année
        // [i][4] → réservé (true / false)
        System.out.println("Titre: " + sLivres[i][0]);
        System.out.println("Auteur: " + sLivres[i][1]);
        System.out.println("Catégorie: " + sLivres[i][2]);
        System.out.println("Année: " + sLivres[i][3]);
        System.out.println("Statut: " +
                (sLivres[i][4].equals("true") ? "Réservé" : "Disponible"));
        System.out.println("------------------------");
    }
}
