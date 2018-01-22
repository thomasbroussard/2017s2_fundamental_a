/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Logger {

	// TODO makes it configurable!
	private static final String logPath = "/tmp/application.log";
	private static PrintWriter pw;

	private static final String ERROR = "ERROR";
	private static final String INFO = "INFO";

	static {
		try {
			pw = new PrintWriter(new FileOutputStream(new File(logPath), true));
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private final Class<?> cls;

	public Logger(Class<?> cls) {
		this.cls = cls;

	}

	public void error(String message) {
		printMessage(message, ERROR);
	}

	public void info(String message) {
		printMessage(message, INFO);
	}

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to ...
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * 
	 * <pre>
	 * <code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
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
	private void printMessage(String message, String Level) {
		final String completeMessage = getTimeStamp() + " - " + Level + " - " + cls.getCanonicalName() + " " + message;
		pw.println(completeMessage);
		pw.flush();
	}

	private static String getTimeStamp() {
		final Date date = new Date();

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		return sdf.format(date);
	}

}
