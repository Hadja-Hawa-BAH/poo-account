package fr.afpa.account;

import java.math.BigInteger;


/**
 * Classe représentant un compte bancaire
 */
public class Account {

    // Déclaration des attributs
    private String iban;
    private int balance;
    private int overDraftAuthorisation;
    
   // private int removeBalance;
  
    // le constructeur
    public Account(String iban, int balance, int overDraftAuthorisation) {
        checkIban(iban);
    
        this.iban = iban;
        this.balance = balance;
        this.overDraftAuthorisation = overDraftAuthorisation;
    }

    // Implémentaion des getters et des setters
    public String getIban() {
        return iban;
    }

    public int getBalance() {
        return balance;
    }

    public int getOverDraftAuthorisation() {
        return overDraftAuthorisation;
    }

    public void setIban(String iban) throws Exception {

        boolean isIban = checkIban(iban);
        if (isIban){
            this.iban = iban;
        
        } else { 
            throw new Exception("L'iban est invalide");
        }

    }

    public void setBalance(int balance) throws Exception{
        if (balance < 0){
            throw new Exception("Le montant doit être positif");
        }

        this.balance = balance;          
    }

    public void setOverDraftAuthorisation(int overdraftAuthorisation) {
        this.overDraftAuthorisation = overDraftAuthorisation;
               
    }

    // Fonction/methode pour:
    public String toString() {
        return "\nAccount {"
                + "\nIban: " + getIban()
                + "\nMontant: " + getBalance()
                + "\nDécouvert: " + getOverDraftAuthorisation()
                + "}";
    }

    // Vérification de l'IBAN
    public boolean checkIban(String stringToCheck) {
        
        //Supprimer les espaces
        stringToCheck = stringToCheck.replace("\\s", "");

        //Mettre en majuscule
        stringToCheck = stringToCheck.toUpperCase();

        //déplacer les quatre premiers lettres à la fin 
        stringToCheck = stringToCheck.substring(4) + stringToCheck.substring(0,4);

        //Convertir les lettres en chiffres
        String total = "";
        for (int i = 0; i < stringToCheck.length(); i++){
            int charValue = Character.getNumericValue(stringToCheck.charAt(i));
            if (charValue < 0 || charValue > 35){
                return false;
            }
 
            total += charValue;
        }

        //faire un BigInteger et vérifer si modulo 97= 1
        BigInteger totalInt = new BigInteger(total);
        // return totalInt.mod(new BigInteger("97")).equals(BigInteger.ONE);
        int resultMod = totalInt.mod(new BigInteger("97")).intValue();
        if (resultMod == 1) {
            // c'est un IBAN -> reste == 1
            return true;
        } else {
            return false;
        }
    }

    //Fonction pour ajouter de l'argent au compte bancaire
    public double addMoney(int amount){
        if (amount > 0){
        balance +=amount;
        }
        return balance;
    }

    // Fonction pour retirer de l'argent au compte bancaire
    public double removeMoney(int amount){

        if (amount > balance - overDraftAuthorisation){
            int removeBalance = 0;

            removeBalance = balance - amount - overDraftAuthorisation;
            System.out.println("Vous n'avez pas assez d'argent sur votre compte " + removeBalance);
        } else {
            this.balance -= amount;
        }
        return this.balance;
    }

    //Fonction pour transferer de l'argent dans un deuxième compte
    public void transferMoney(Account otherAccount, int amount){
       
        if (amount > balance + overDraftAuthorisation){
            int removeBalance = 0;

            removeBalance = balance - amount + overDraftAuthorisation;
            System.out.println("Vous n'avez pas assez d'argent sur votre compte " + removeBalance);
        } else {
            this.balance -= amount;
        }
       this.removeMoney(amount);
       otherAccount.addMoney(amount);
    }
}
