/**
 * Ce fichier est la propriété de l'agence de la Biomédecine
 * Code application :
 * Composant : 
 */
package fr.epita.iam.services.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;

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
public class IdentityFileDAO {
	
	private String filePath;
	
	
	
	

	/**
	 * @param filePath
	 * @throws IOException 
	 */
	public IdentityFileDAO(String filePath) throws IOException {
		this.filePath = filePath;
		File file = new File(this.filePath);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		
		
		
	}

	public void create(Identity identity) {
		
	}
	
	public List<Identity> search(Identity criteria){
		List<Identity> results = new ArrayList<>();
		
		return results;
		
	}
	
	public void update(Identity identity) {
		
	}
	
	public void delete(Identity identity) {
		
	}

}
