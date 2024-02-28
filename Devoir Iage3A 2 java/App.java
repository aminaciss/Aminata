import java.util.List;
import java.util.Scanner;

import entities.Adresse;
import entities.Client;
import services.AdresseService;
import services.ClientService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        ClientService clientService=new ClientService();
        AdresseService AdresseService=new AdresseService();
       
        do {
            System.out.println("1-Créer un Client");
            System.out.println("2-Lister les Clients"); 
            System.out.println("3-Ajouter une adresse et lui associe un client"); 
            System.out.println("4-Lister les adresse en affichant le nom du client");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer le nom du client");
                     String nomClient=sc.nextLine(); 
                     Client client=new Client();
                     client.setNomComplet(nomClient);
                     clientService.ajouterClient(client);
                    break;
                case 2:
                    List<Client> clients= clientService.listerClient();
                    for (Client cl : clients) {
                        System.out.println("ID : "+cl.getId() ); 
                        System.out.println("NOM : "+cl.getNomComplet() ); 
                        System.out.println("TEL : "+cl.getTelephone() ); 
                        System.out.println("NOM : "+cl.getEmail() );     
                    }
                  
                    break; 
                    
              case 3:
                     System.out.println("Ajouter une adresse");
                     String ville=sc.nextLine(); 
                     System.out.println("Entrer la ville de l'adresse");  
                     clients= clientService.listerClient(); 
                        for (Client cl : clients) {
                            System.out.println(cl.getId()+"-"+cl.getNomComplet());   
                        }
                       System.out.println("Entrer Id d'un client");
                       int idClient=sc.nextInt();
                       client=new Client();
                       client.setId(idClient);
                       Adresse adresse =new Adresse();
                       adresse.setVille(ville);
                       adresse.setQuartier(ville);
                       adresse.setNumvilla(choix);
                       adresse.setClient(client);
                       AdresseService.ajouterAdresse(adresse);
                   break;

                   case 4:
                   List<Adresse> adresses= AdresseService.listerAdresse();
                   for (Adresse a : adresses) {
                       System.out.println("ID : "+a.getId() ); 
                       System.out.println("Ville : "+a.getVille() ); 
                       System.out.println("Quartier : "+a.getQuartier() ); 
                       System.out.println("numVilla : "+a.getClient().getNomComplet() ); 
                       System.out.println("------------------------------------");      
                   }
                 
                   break; 
                    
            }
          } while (choix!=5);
    }
}
