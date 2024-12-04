import java.util.Scanner;

public class main {
    private static etudiant[] etudiants= new etudiant[0];
    public static void main(String[] args) {
        boolean continuer = true;
        while(continuer){
            System.out.println("Menu: ");
            System.out.println("1- Ajouter un étudiant");
            System.out.println("2- Supprimer un étudiant");
            System.out.println("3- Afficher les étudiants");
            System.out.println("4- Rechercher un étudiant");
            System.out.println("5- trier les étudiants");
            System.out.println("6- Afficher la moyenne des étudiants");
            System.out.println("7- Quitter");
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    ajouteretudiant();
                    break;
                case 2:
                    supprimeretudiant();
                    break;
                case 3:
                    afficherEtudiants();
                    break;
                case 4:
                    searchEtudiant();
                    break;
                case 5:
                    trierEtudiants();
                case 6:
                    System.out.println("La moyenne des étudiants est: " + moyenneEtudiants());
                    break;
                case 7:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
        System.out.println("Au revoir");


    }


    public static double moyenneEtudiants() {
        double moyenne = 0;
        for (int i = 0; i < main.etudiants.length; i++) {
            moyenne += main.etudiants[i].moyenne();
        }
        return moyenne / main.etudiants.length;
    }
    public static void ajouteretudiant() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de l'étudiant: ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le prénom de l'étudiant: ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez l'âge de l'étudiant: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le numéro d'inscription de l'étudiant: ");
        String numeroInscription = scanner.nextLine();

        modules[] modules = new modules[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Entrez le nom du module " + (i + 1) + ": ");
            String nomModule = scanner.nextLine();

            System.out.print("Entrez la note du module " + (i + 1) + ": ");
            int noteModule = scanner.nextInt();
            scanner.nextLine();
            modules[i] = new modules(nomModule, noteModule);
        }
        etudiant nvEtudiant = new etudiant(nom, prenom, age, numeroInscription, modules);
        etudiant[] newEtudiants = new etudiant[main.etudiants.length + 1];
        for (int i = 0; i < main.etudiants.length; i++) {
            newEtudiants[i] = main.etudiants[i];
        }
        newEtudiants[main.etudiants.length] = nvEtudiant;
        main.etudiants = newEtudiants;
    }


    public static void supprimeretudiant() {
        if (main.etudiants.length == 0) {
            System.out.println("La liste des étudiants est vide.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro d'inscription de l'étudiant à supprimer: ");
        String numeroInscription = scanner.nextLine();
        etudiant[] newEtudiants = new etudiant[main.etudiants.length - 1];
        boolean etudiantTrouve = false;
        int j = 0;
        for (int i = 0; i < main.etudiants.length; i++) {
            if (!main.etudiants[i].getCNE().equals(numeroInscription)) {
                if (etudiantTrouve || j < newEtudiants.length) {
                    newEtudiants[j] = main.etudiants[i];
                    j++;
                }
            } else {
                etudiantTrouve = true;
            }
        }
        if (etudiantTrouve) {
            System.out.println("L'étudiant a été supprimé");
            main.etudiants = newEtudiants;
        } else {
            System.out.println("L'étudiant n'existe pas dans la liste");
        }
    }
    public static void trierEtudiants() {
        for (int i = 0; i < main.etudiants.length-1; i++) {
            for (int j = i + 1; j < main.etudiants.length; j++) {
                if (main.etudiants[i].moyenne() < main.etudiants[j].moyenne()) {
                    etudiant temp = main.etudiants[i];
                    main.etudiants[i] = main.etudiants[j];
                    main.etudiants[j] = temp;
                }
            }
        }
        System.out.println("Les étudiants ont été triés par moyenne");
    }

    public static void searchEtudiant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro d'inscription de l'étudiant à rechercher: ");
        String numeroInscription = scanner.nextLine();
        for (int i = 0; i < main.etudiants.length; i++) {
            if (main.etudiants[i].getCNE().equals(numeroInscription)) {
                System.out.println("l'étudiant existe dans la liste , voici ses informations: ");
                System.out.println("Nom: " + main.etudiants[i].getNom());
                System.out.println("Prénom: " + main.etudiants[i].getPrenom());
                System.out.println("Âge: " + main.etudiants[i].getAge());
                System.out.println("Numéro d'inscription: " + main.etudiants[i].getCNE());
                System.out.println("Modules: ");
                for (int j = 0; j < main.etudiants[i].getModules().length; j++) {
                    System.out.println(main.etudiants[i].getModules()[j].getNom() + ": " + main.etudiants[i].getModules()[j].getNote());
                }
                System.out.println("Moyenne: " + main.etudiants[i].moyenne());
                System.out.println("_________________________");
            }else{
                System.out.println("l'étudiant n'existe pas dans la liste");
            }
        }
    }
    public static void afficherEtudiants() {
        for (int i = 0; i < main.etudiants.length; i++) {
            System.out.println("Nom: " + main.etudiants[i].getNom());
            System.out.println("Prénom: " + main.etudiants[i].getPrenom());
            System.out.println("Âge: " + main.etudiants[i].getAge());
            System.out.println("Numéro d'inscription: " + main.etudiants[i].getCNE());
            System.out.println("Modules: ");
            for (int j = 0; j < main.etudiants[i].getModules().length; j++) {
                System.out.println(main.etudiants[i].getModules()[j].getNom() + ": " + main.etudiants[i].getModules()[j].getNote());
            }
            System.out.println("Moyenne: " + main.etudiants[i].moyenne());
            System.out.println("_________________________");
        }
    }



}