/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.iam.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;

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
public class IdentityJDBCDAO implements IdentityDAO {

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#create(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void create(Identity identity) {
		Connection connection = null;
		try {
			connection = getConnection();
			final PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO IDENTITIES(UID, EMAIL, DISPLAY_NAME) VALUES (?, ?, ?)");
			pstmt.setString(1, identity.getUid());
			pstmt.setString(2, identity.getEmail());
			pstmt.setString(3, identity.getDisplayName());
			pstmt.execute();
		} catch (final Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (final SQLException e) {
					// can do nothing here, except logging maybe?
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#search(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public List<Identity> search(Identity criteria) {
		final List<Identity> results = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			final String sqlString = "SELECT DISPLAY_NAME, EMAIL, UID FROM IDENTITIES " + "WHERE (? IS NULL OR DISPLAY_NAME LIKE ?) "
					+ "AND (? IS NULL OR EMAIL LIKE ?) " + "AND (? IS NULL OR UID = ?)";
			final PreparedStatement preparedStatement = connection.prepareStatement(
					sqlString);

			preparedStatement.setString(1, criteria.getDisplayName());
			preparedStatement.setString(2, criteria.getDisplayName() + "%");
			preparedStatement.setString(3, criteria.getEmail());
			preparedStatement.setString(4, criteria.getEmail() + "%");
			preparedStatement.setString(5, criteria.getUid());
			preparedStatement.setString(6, criteria.getUid());
			final ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				final Identity currentIdentity = new Identity();
				// How to select the right index?
				currentIdentity.setDisplayName(rs.getString("DISPLAY_NAME"));
				currentIdentity.setEmail(rs.getString("EMAIL"));
				currentIdentity.setUid(rs.getString("UID"));

				results.add(currentIdentity);
			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#update(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void update(Identity identity) {

	}

	/*
	 * (non-Javadoc)
	 * @see fr.epita.iam.services.dao.IdentityDAO#delete(fr.epita.iam.datamodel.Identity)
	 */
	@Override
	public void delete(Identity identity) {

	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO make this variable through configuration
		final String url = "jdbc:derby://localhost:1527/iam;create=true";
		final String password = "root";
		final String username = "root";

		Class.forName("org.apache.derby.jdbc.ClientDriver");

		final Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
