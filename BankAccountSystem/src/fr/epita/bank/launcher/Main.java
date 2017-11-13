/**
 * 
 * Code application :
 * Composant : 
 */
package fr.epita.bank.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;

/** 
 * <h3>Description</h3>  
 * <p>Cette classe permet de ...</p>
 *
 * <h3>Utilisation</h3>
 * <p>Elle s'utilise de la manière suivante :
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *  
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class Main {

	/** 
	 * <h3>Description</h3>  
	 * <p>Cette méthode permet de ...</p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>Elle s'utilise de la manière suivante :
	 *   
	 * <pre><code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code></pre>
	 * </p>
	 *  
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 * ${tags}
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the bank system program");
	
		Customer customer1 =  new Customer();
		customer1.setName("tom");
		System.out.println("the program created a customer with name :" + customer1.getName());
		
		InvestmentAccount investmentAccount = new InvestmentAccount();
		investmentAccount.setBalance(20.5d);
		
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.setBalance(5000d);
		
		
		
		customer1.setInvestmentAccounts(Arrays.asList(investmentAccount));
		
		customer1.setSavingsAccounts(Arrays.asList(savingsAccount));
		
		List<SavingsAccount> savingsAccountList= new ArrayList<>();
		savingsAccountList.add(savingsAccount);
		customer1.setSavingsAccounts(savingsAccountList);
		
		System.out.println("customer1 content : "+ customer1);
		
		
		System.out.println("End of program");
	}

}
