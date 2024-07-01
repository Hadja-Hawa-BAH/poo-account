package fr.afpa.account;

import java.util.ArrayList;

/**
 * Classe qui représente un client, propriétaire de comptes bancaires
 */
public class Customer {

    // Déclaration des attibuts
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;     

    // Constructeur
    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    //getters
    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public ArrayList<Account> getccounts(){
        return accounts;
    }
   
    //Setters
    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName){
       this.firstName = firstName;
    }

    public void setLastName(String lastName){
       this.lastName = lastName;
    }
    
    //Fonction to string
    public String toString(){
        return "\nCustomer {"
        + "\nIdenfiant: " + getId()
        + "\nNom: " + getFirstName()
        + "\nPrénom: " + getLastName()
        + "\nCompte client: " + getccounts()
        + "}";
      
    }
 
    //Fonction pour ajouter de l'argent au compte client
    public boolean addAccount(Account account){
        // Si le compte existe déjà
        if (accounts.contains(account)){
            return false;
        } else {
            //Ajout du compte
            accounts.add(account);
            return true;
        }

    }

    // Fonction pour retirer de l'argent au compte bancaire
    public boolean removeMoney(Account account){
        return accounts.remove(account);

    }

}
