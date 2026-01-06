import java.util.Scanner;
public class TP2 {


        public static void main(String[] args)
        {
            int[] MON=new int[5];
            int[] QUE=new int[5];
            int[] LAV=new int[5];
            int[] TER=new int[5];           
            System.out.println("Paul-Edouard Cherubin TP2");
            System.out.println("");
            resultat(MON, QUE, LAV, TER);
        }
        public static void resultat(int [] MON, int []QUE, int [] LAV, int [] TER)
        {
            Scanner scan=new Scanner(System.in);
            
            System.out.println("Entrez l'equipe visiteuse");
            String sEquipeVisiteuse = scan.nextLine();
            System.out.println("Combien de buts l'equipe a t'elle scorer");
            int iButsVisiteuse = scan.nextInt();
            scan.nextLine();

            System.out.println("");

            System.out.println("Entrez l'equipe locale");
            String sEquipeLocale = scan.nextLine();
            System.out.println("Combien de buts l'equipe a t'elle scorer");
            int iButsLocale = scan.nextInt();
            scan.nextLine();
            
            int[] equipeVisiteuse = getEquipe(sEquipeVisiteuse, MON, QUE, LAV, TER);
            int[] equipeLocale = getEquipe(sEquipeLocale, MON, QUE, LAV, TER);

            equipeVisiteuse[0]++;
            equipeLocale[0]++;

            if(iButsVisiteuse<iButsLocale)
            {

            }
            else if(iButsVisiteuse>iButsLocale)
            {

            }
            else
            {

            }
        }
        public static int[] getEquipe(String nom, int[] MON, int[] QUE, int[] LAV, int[] TER) 
        {
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

        public static void afficher(int [] MOn, int []QUE, int [] LAV, int [] TER)
        {

        }
        public static void calculer(int [] MOn, int []QUE, int [] LAV, int [] TER)
        {

        }
}
