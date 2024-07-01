package fr.afpa.account;

import java.util.ArrayList;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class AccountMain {
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classes \"Account\" & \"Customer\" -----");

		// Instanciation des objets de la classe Account/Création des comptes
		Account account1 = new Account("FR7642559000011234567890121", 420, 700);
		Account account2 = new Account("FR7642559000011234567890122", 220, 200);
		Account account3 = new Account("FR7642559000011234567890123", 320, 300);
		System.out.println(account1);
		

		// Gestion des exceptions pour l'iban
		try {

			account1.setIban("FR7642559000011234567890121");
			System.out.println("\nL'iban est: " + account1.getIban());

		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			System.out.println(exceptionMessage);

		}

		// Solde initial
		try {
			account1.setBalance(3100);
			System.out.println("\nLe solde initial est: " + account1.getBalance());

		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			System.out.println(exceptionMessage);

		}
		
		// Ajout d'argent
		try {
			account1.addMoney(300);
			System.out.println("\nLe solde après dépôt est: " + account1.getBalance());

		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			System.out.println(exceptionMessage);

		}

		// retrait d'argent
		try {
			account1.removeMoney(600);
			System.out.println("\nLe solde après le retrait est:" + account1.getBalance());

		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			System.out.println(exceptionMessage);

		}

		// transfert d'argent
		try {
			account1.transferMoney(account1,100);
			System.out.println("\nLe solde après le transfert est:" + account1.getBalance());

		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			System.out.println(exceptionMessage);

		}
		
		//Instanciation des objets de la calsse Customer/création des clients
		Customer customer1 = new Customer(1, "John", "Happy");
		Customer customer2 = new Customer(2, "Lyly", "Jack");
		Customer customer3 = new Customer(3, "Tata", "Toto");

		//Ajout des comptes aux clients
		customer1.addAccount(account1);
		customer2.addAccount(account2);
		customer3.addAccount(account3);

		try {
			if (customer1.addAccount(account1)){
			System.out.println("\nLe compte client1 a été crée avec succès");
			
			} else {
				System.out.println("Le compte client existe déjà.");
			}

		} catch (Exception e) {
			String exceptionMessage = e.getMessage();
			System.out.println(exceptionMessage);

		}

		//Liste de tous les employés
		ArrayList<Customer> list = new ArrayList<Customer>();

		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
			
		//Affichage de la liste des employés
		System.out.println("\nLa liste des employés est : " );
		for (Customer customer: list){
			System.out.println(customer);
		}
	}
}
