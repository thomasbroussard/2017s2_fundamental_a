/**
 * 
 * Code application :
 * Composant : 
 */
package fr.epita.bank.services.ui;

import java.util.Scanner;

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
public class ConsoleHandler {
	
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
	public static Double getDouble(Scanner scanner) {
		int counter = 0;
		while (counter < 3) {
			try {
				Double doubleValue = Double.valueOf(scanner.nextLine());
				return doubleValue;
			} catch (NumberFormatException nbe) {
				nbe.printStackTrace();
				counter ++;
				System.out.println("got an error whith your input, please retry");
			}
		
		}
		System.out.println("too much tries, your value is set to 0");
		return 0d;
	}


}
