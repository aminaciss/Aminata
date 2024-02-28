package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String nomComplet;
    private int telephone;
    private String email;
    List<Adresse> adresses=new ArrayList<>();

    public List<Adresse> getAdresses() {
        return adresses;
    }
    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClient'");
    }
    
}
