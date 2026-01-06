import java.util.Scanner;

public class TP1 {
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        
        System.out.println("TRAVAIL PRATIQUE #1 - Paul-Édouard");
        System.out.println("-----------------------------------");
        System.out.println("1) Transformer $$$ en monnaie");
        System.out.println("2) Jeu trouver un nombre mystère");
        System.out.println("3) Quitter");
        System.out.println("");
        System.out.println("Choix : ");        
        double dChoix =scan.nextDouble();

        if(dChoix==1)
        {
            System.out.println("Entrez un montant :");
            double montant = scan.nextDouble();
            int [] valeurs ={100,50,30,5,2,1};
            double [] pieces = {0.25, 0.10, 0.05, 0.01};

            for(int i: valeurs)
            {
                int nb =(int)(montant /i);
                if(nb>0)
                {
                    System.out.println("Vous recevez :");
                    System.out.println(nb+"x"+ i +"$");
                    montant-= nb*i;
                }
            }

            for(double p: pieces)
            {
                int nb =(int)Math.floor(montant /p);
                if(nb>0)
                {
                    System.out.println("Vous recevez :");
                    System.out.println(nb+"x"+ p +"$");
                    montant-= nb*p;
                }
            }
        }
        if(dChoix==2)
        {
            int iRandom = (int)(Math.random() * 20) + 1;
            int iNbEssais=0;
            boolean trouver = false;

            while(iNbEssais<=7 && !trouver)
            {
                System.out.println("Entrez un nombre entrez 1 et 20");
                int iNombre=scan.nextInt();
                iNbEssais++;

                if(iNombre>iRandom)
                {
                    System.out.println("Votre chiffre est plus grand que le nombre mystere");
                    System.out.println("");
                }
                else if(iNombre<iRandom)
                {
                    System.out.println("Votre chiffre est plus petit que le nombre mystere");
                    System.out.println("");
                }
                else
                {
                    System.out.println("");
                    System.out.println("Vous avez reussi!");
                    trouver=true;
                }
            }
            if(!trouver)
            {
                System.out.println("Vous avez perdu, le chiffre mystere etait, "+iRandom);
            }
        }
        else if(dChoix==3)
        {
            return;
        }

        scan.close();
    }
}
