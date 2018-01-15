/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.services.dao;

import java.util.List;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public interface IdentityDAO {

	public static final Integer number = 0;

	public void create(Identity identity);

	public List<Identity> search(Identity criteria);

	public void update(Identity identity);

	public void delete(Identity identity);

}
