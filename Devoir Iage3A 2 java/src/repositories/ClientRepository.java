package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientRepository extends Database {
    private final  String SQL_SELECT_ALL="select * from nomComplet n, telephone t, email " ;
        private final  String SQL_INSERT="INSERT INTO client (nom_Complet) VALUES (?) , (telephone) VALUES (?) , (email) VALUES (?)"; 
    
       public void insertZone(Client client){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, client.getNomComplet());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<Client> getAllclients(){
            List<Client> Clients=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                Client client=new Client();
                     client.setId(rs.getInt("id_client"));
                     client.setNomComplet(rs.getString("nom_client"));
                     client.setTelephone(rs.getInt("id_client"));
                     client.setEmail(rs.getString("nom_client"));
                     Clients.add(client);
             }
             rs.close();
           closeConnexion();
        }
         catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
        }
        return Clients;
       }
    public void insertClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertClient'");
    }
    
    }
