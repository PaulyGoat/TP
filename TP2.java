import java.util.Scanner;
public class TP2 {


        public static void main(String[] args)
        {
            //Tableaux
            int[] MON=new int[5];
            int[] QUE=new int[5];
            int[] LAV=new int[5];
            int[] TER=new int[5];           
            System.out.println("TRAVAIL PRATIQUE #2 - Paul-Edouard Cherubin");
            System.out.println("");
            
            Scanner scan=new Scanner(System.in);
            //Tant que la personne veut continuer
            String sContinuer;
            do {
                resultat(MON, QUE, LAV, TER);
                System.out.println("Voulez-vous entrer un autre resultat? (O/N)");
                sContinuer = scan.nextLine().toUpperCase();
                afficherClassement(MON, QUE, LAV, TER);//Afficher classement

            } while (sContinuer.equals("O"));
        }
        public static void resultat(int [] MON, int []QUE, int [] LAV, int [] TER)
        {
            Scanner scan=new Scanner(System.in);

            //Entrez de l"equipe locale et buts

            System.out.println("Entrez l'equipe locale");
            String sEquipeLocale = scan.nextLine();
            System.out.println("Combien de buts l'equipe a t'elle scorer");
            int iButsLocale = scan.nextInt();
            scan.nextLine();

            System.out.println("");

            String sEquipeVisiteuse;
            //Tant que les equipes sont similaires
            do {
                    //Entrez de l"equipe visiteuse et buts
                    System.out.println("Entrez l'equipe visiteuse");
                    sEquipeVisiteuse = scan.nextLine();

                //Si noms equipes = meme 
                if (sEquipeVisiteuse.equals(sEquipeLocale)) {
                    System.out.println("Les deux equipes doivent etre differentes.");
                }
            } while (sEquipeVisiteuse.equals(sEquipeLocale));

            System.out.println("Combien de buts l'equipe a t'elle scorer");
            int iButsVisiteuse = scan.nextInt();
            scan.nextLine();

            //Associer nom equipe a equipe entrer par l'utilisateur
            int[] equipeVisiteuse = getEquipe(sEquipeVisiteuse, MON, QUE, LAV, TER);
            int[] equipeLocale = getEquipe(sEquipeLocale, MON, QUE, LAV, TER);

            //Plus de partie jouer
            equipeVisiteuse[0]++;
            equipeLocale[0]++;

            //Entrez statistiques
            if(iButsVisiteuse<iButsLocale)
            {
                equipeLocale[1]++;
                equipeVisiteuse[2]++;
                calculer(equipeLocale, equipeVisiteuse, "V");
            }
            else if(iButsVisiteuse>iButsLocale)
            {
                equipeVisiteuse[1]++;
                equipeLocale[2]++;
                calculer(equipeVisiteuse, equipeLocale, "V");
            }
            else
            {
                equipeVisiteuse[3]++;
                equipeLocale[3]++;
                calculer(equipeVisiteuse, equipeLocale, "N");
            }
                    /*
                        [0] = PJ
                        [1] = V
                        [2] = D
                        [3] = N
                        [4] = PTS
                    */
        }
        public static int[] getEquipe(String nom, int[] MON, int[] QUE, int[] LAV, int[] TER) 
        {
            // Lien entre le String equipe et le tableau des stats
            switch (nom) {
                case "MON": return MON;
                case "QUE": return QUE;
                case "LAV": return LAV;
                case "TER": return TER;
                default:
                    System.out.println("Equipe invalide");
                    return MON;
            }
        }


        public static void calculer(int[] equipe1, int[] equipe2, String resultat)
        {
            //Pointage a cause dune victoire ou defaite
            if (resultat.equals("V")) {
                equipe1[4] += 3;
            }
            else if (resultat.equals("N")) {
                equipe1[4] += 1;
                equipe2[4] += 1;
            }
        }
        public static void afficherClassement(int[] MON, int[] QUE, int[] LAV, int[] TER)
        {
            //Afficher le classement
            System.out.println();
            System.out.println("Classement");
            System.out.println();
            System.out.println("Équipe\tPJ\tV\tD\tN\tPTS");
            System.out.println("-------------------------------------------");

            afficherEquipe("MON", MON);
            afficherEquipe("QUE", QUE);
            afficherEquipe("LAV", LAV);
            afficherEquipe("TER", TER);
        }
        public static void afficherEquipe(String nom, int[] equipe)
        {
            //Mettre les stats de l'equipe dans le tableau
            System.out.println
            (
                nom + "\t" +
                equipe[0] + "\t" +  // PJ
                equipe[1] + "\t" +  // V
                equipe[2] + "\t" +  // D
                equipe[3] + "\t" +  // N
                equipe[4]           // PTS
            );
        }
        
}
