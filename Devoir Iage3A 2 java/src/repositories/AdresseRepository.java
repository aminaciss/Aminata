package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Adresse;
import entities.Client;

public class AdresseRepository  extends Database{
    private final  String SQL_SELECT_ALL="select * from adresse a, client c where a.client_id=c.id_client" ;
    private final  String SQL_INSERT="INSERT INTO `adresse` (`ville`, `quartier`, `numvilla`, `client_id`) VALUES (?,?,?,?)";
    public void insertAdresse(Adresse adresse){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, adresse.getVille());
                statement.setString(2, adresse.getQuartier());
                statement.setInt(3, adresse.getNumvilla());
                statement.setInt(4, adresse.getClient().getId());

                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<Adresse> getAllAdresses(){
            List<Adresse> Adresses=new ArrayList<>();
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
                     
                     Adresse adresse=new Adresse();
                     adresse.setId(rs.getInt("id_adresse"));
                     adresse.setVille(rs.getString("ville"));
                     adresse.setQuartier(rs.getString("quartier"));
                     adresse.setClient(client);
                     adresse.setNumvilla(rs.getInt("Numvilla"));
                     Adresses.add(adresse);
                     

                    
             }
             rs.close();
            closeConnexion();
          }
          catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
         }
         return Adresses;
         
       }
}