package services;
import java.util.List;
import entities.Adresse;
import repositories.AdresseRepository;


public class AdresseService {
    private AdresseRepository adresseRepository=new AdresseRepository();
    public void ajouterAdresse(Adresse adresse){
        adresseRepository.insertAdresse(adresse);
    }
    public List<Adresse> listerBien(){
          return   adresseRepository.getAllAdresses();
    }
    public List<Adresse> listerAdresse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listerAdresse'");
    }
      
}
