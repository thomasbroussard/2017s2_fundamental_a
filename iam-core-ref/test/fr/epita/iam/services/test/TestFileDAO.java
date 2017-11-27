/**
 * Ce fichier est la propriété de l'agence de la Biomédecine
 * Code application :
 * Composant : 
 */
package fr.epita.iam.services.test;

import java.io.IOException;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.services.dao.IdentityFileDAO;

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
public class TestFileDAO {

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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Identity id1 = new Identity();
		id1.setEmail("tbr@tbr.com");
		id1.setUid("123");
		id1.setDisplayName("Thomas Broussard");
		System.out.println(id1);
		
		IdentityFileDAO dao = new IdentityFileDAO("/tmp/2017s2/identities.txt");
		
		dao.create(id1);
		
		
		
	}

}
