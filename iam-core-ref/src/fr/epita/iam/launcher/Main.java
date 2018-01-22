/**
 *
 * Code application : Composant :
 */
package fr.epita.iam.launcher;

import fr.epita.iam.datamodel.Identity;

/**
 * <h3>Description</h3>
 * <p>
 * Cette classe permet de ...
 * </p>
 *
 * <h3>Utilisation</h3>
 * <p>
 * Elle s'utilise de la manière suivante :
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Main {

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This method allows to launch the program
	 * </p>
	 *
	 * <h3>Utilisation</h3>
	 * <p>
	 * The first argument is the file path to the configuration file
	 * </p>
	 * <p>
	 *
	 * <pre>
	 * <code>
	 * java -Dconf=${configLocation} -jar ${jarName}
	 *</code>
	 * </pre>
	 * </p>
	 *
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 */
	public static void main(String[] args) {
		final String confFileLocation = args[0];
		if (confFileLocation == null || confFileLocation.isEmpty()) {
			// no configuration, trying default
			System.out.println("no configuration file argument");
		} else {

			// TODO load the configuration thanks to the configuration service

		}

		final Identity id1 = new Identity();
		id1.setEmail("tbr@tbr.com");
		id1.setUid("123");
		id1.setDisplayName("Thomas Broussard");
		System.out.println(id1);
	}

}
