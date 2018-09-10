package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import beans.Client;
import controllers.AbstractGestion;

@SuppressWarnings("deprecation")
public class ClientDao {
	
	public static void insert(Client client) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Transaction transaction = null;
		Session session = sessionFactory.openSession();

		try {
			transaction = session.beginTransaction();
			session.save(client);
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		
		sessionFactory.close();
	}
	
	public static int insertSQL(Client client) {		
		int result = 0;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requeteSQL = "INSERT INTO CLIENT(pk_email, lastName, firstName, password, birthDate) "
					+ "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setString(1, client.getEmail());
			ps.setString(2, client.getLastName());
			ps.setString(3, client.getFirstName());
			byte[] hash;
			String password=null;
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				hash = digest.digest(client.getPassword().getBytes(StandardCharsets.UTF_8));
				password = AbstractGestion.byteArrayToHexString(hash);
				//password = new String(hash, StandardCharsets.UTF_8);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			ps.setString(4, password);
			ps.setString(5, client.getBirthDate());
//			ps.setInt(6, client.getCart());

			result = ps.executeUpdate();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static int updateSQL(Client client) {
		int result = 0;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requeteSQL = "UPDATE utilisateurs SET lastName=?, firstName=?, password=?, birthDate=?, WHERE pk_email=?)";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setString(1, client.getLastName());
			ps.setString(2, client.getFirstName());
			ps.setString(3, client.getPassword());
			ps.setString(4, client.getBirthDate());
//			ps.setInt(5, client.getCart());
			ps.setString(6, client.getEmail());

			result = ps.executeUpdate();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static int deleteSQL(String email) {
		int result = 0;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requeteSQL = "DELETE FROM CLIENT WHERE pk_email=?";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setString(1, email);

			result = ps.executeUpdate();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<Client> findAllSQL() {
		List<Client> dataBaseClients = new ArrayList<Client>();
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requetSQL = "SELECT pk_email, lastName, firstName, password, birthDate FROM CLIENT";
			PreparedStatement ps = connection.prepareStatement(requetSQL);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				dataBaseClients.add(new Client(resultSet.getString("pk_email"), resultSet.getString("lastName"),
						resultSet.getString("firstName"), resultSet.getString("password"),
						resultSet.getString("birthDate")/*, resultSet.getInt("fk_cart")*/));
			}

			resultSet.close();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dataBaseClients;
	}

	public static Client findSQL(String email) {
		Client client = null;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requeteSQL = "SELECT lastName, firstName, password, birthDate FROM CLIENT WHERE pk_email=?";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				
				client = new Client(email, resultSet.getString("lastName"),
						resultSet.getString("firstName"), resultSet.getString("password"),
						resultSet.getString("birthDate")/*, resultSet.getInt("fk_cart")*/);
			}

			resultSet.close();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	public static List<Client> findAllSQL(int start, int nb) {
		List<Client> dataBaseClients = new ArrayList<Client>();
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requetSQL = "SELECT pk_email, lastName, firstName, password, birthDate FROM CLIENT LIMIT ?,?";
			PreparedStatement ps = connection.prepareStatement(requetSQL);
			ps.setInt(1, start);
			ps.setInt(2, nb);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				dataBaseClients.add(new Client(resultSet.getString("pk_email"), resultSet.getString("lastName"),
						resultSet.getString("firstName"), resultSet.getString("password"),
						resultSet.getString("birthDate")/*, resultSet.getInt("fk_cart")*/));
			}

			resultSet.close();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dataBaseClients;
	}

	public static int countClientsSQL() {
		int nbUsers = 0;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requeteSQL = "SELECT COUNT(*) FROM CLIENT";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				nbUsers = resultSet.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbUsers;
	}

}