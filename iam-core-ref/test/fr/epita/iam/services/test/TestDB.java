/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.services.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public class TestDB {

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
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// testSelectQuery();

		// differenceBetweenPreparedStatementAndStatement();

		// Given
		final Connection connection = getConnection();
		final PreparedStatement pstmt = connection.prepareStatement("INSERT INTO IDENTITIES(UID, EMAIL, DISPLAY_NAME) VALUES (?, ?, ?)");
		pstmt.setString(1, "4567");
		pstmt.setString(2, "cserr@cserr.com");
		pstmt.setString(3, "Clément");

		// When
		pstmt.execute();

		// Then
		final PreparedStatement verificationStatement = connection
				.prepareStatement("SELECT DISPLAY_NAME FROM IDENTITIES WHERE DISPLAY_NAME='Clément'");
		final ResultSet resultSet = verificationStatement.executeQuery();
		resultSet.next();
		if (resultSet.getString(1).equals("Clément")) {
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}

		connection.close();
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
	private static void differenceBetweenPreparedStatementAndStatement() throws ClassNotFoundException, SQLException {
		final Connection connection = getConnection();
		final PreparedStatement prepareStatement = connection.prepareStatement("select * from IDENTITIES where DISPLAY_NAME = ?");
		// Don't do what follows, this will not be protected against SQL injections.
		// Statement statement = connection.createStatement("select * from IDENTITIES where DISPLAY_NAME = ?");
		final String parameter = " 'toto' and 1 = 1; DROP TABLE IDENTIES";
		prepareStatement.setString(1, parameter);
	}

	/**
	 * <h3>Description</h3>
	 * <p>This methods allows to ...</p>
	 *
	 * <h3>Usage</h3>
	 * <p>It should be used as follows :
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
	private static void testSelectQuery() throws ClassNotFoundException, SQLException {
		final Connection connection = getConnection();

		final PreparedStatement ptst = connection.prepareStatement("select DISPLAY_NAME from IDENTITIES");
		final ResultSet rs = ptst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(1));
		}

		System.out.println("finished");
		rs.close();
		ptst.close();
		connection.close();
	}

	/**
	 * <h3>Description</h3>
	 * <p>This methods allows to ...</p>
	 *
	 * <h3>Usage</h3>
	 * <p>It should be used as follows :
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
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		final String url = "jdbc:derby://localhost:1527/iam;create=true";
		final String password = "root";
		final String username = "root";

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		final Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
