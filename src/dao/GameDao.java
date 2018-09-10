package dao;

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

import beans.Game;
import beans.Type;

@SuppressWarnings("deprecation")
public class GameDao {

	public static final String GAME_TABLE = "GAME";
	public static final String GAME_TYPE_TABLE = "GAME_TYPE";
	public static final String TYPE_TABLE = "TYPE";

	public static final String GAME_TITLE = "pk_title";
	public static final String GAME_CONSOLE = "fk_console";
	public static final String GAME_PRICE = "price";
	public static final String GAME_DESCRIPTION = "description";
	
	
	public static final String GAME_TYPE_TYPE = "fk_type";
	public static final String GAME_TYPE_GAME = "fk_game";

	public static final String TYPE_TYPE = "pk_type";
	


	public static void insert(Game game) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Transaction transaction = null;
		Session session = sessionFactory.openSession();

		try {
			transaction = session.beginTransaction();
			session.save(game);
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}

		sessionFactory.close();
	}

	@SuppressWarnings("unchecked")
	public static List<Game> findAll() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		// List personnes = null;
		List<Game> dataBaseGames = new ArrayList<Game>();
		
		dataBaseGames = session.createCriteria(Game.class).list();
		
		session.close();
		sessionFactory.close();
		return dataBaseGames;
	}

	public static List<Game> findAllSQL() {

		List<Game> dataBaseGames = new ArrayList<Game>();
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();
			// or Class.forName(com.mysql.jdbc.Driver.class.getName());

			String requeteSQL = "SELECT " + "* FROM " + GAME_TABLE;
			PreparedStatement ps = connection.prepareStatement(requeteSQL);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				dataBaseGames.add(new Game(resultSet.getString(GAME_TITLE), resultSet.getString(GAME_CONSOLE),
						resultSet.getDouble(GAME_PRICE), resultSet.getString(GAME_DESCRIPTION)));
			}
			resultSet.close();
			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dataBaseGames;
	}

	public static Game findSQL(String name, String console) {
		Game game = null;

		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();
			String requeteSQL = "SELECT " + GAME_TITLE + "," + GAME_CONSOLE + "," + GAME_PRICE + "," + GAME_DESCRIPTION + " FROM " + GAME_TABLE
					+ " WHERE " + GAME_TITLE + "=?"+ " AND " + GAME_CONSOLE + "=?";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setString(1, name);
			ps.setString(2, console);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				game = new Game(resultSet.getString(GAME_TITLE), resultSet.getString(GAME_CONSOLE),
						resultSet.getDouble(GAME_PRICE), resultSet.getString(GAME_DESCRIPTION));
			}
			resultSet.close();
			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}
	
	public static Type findGameTypeSQL(String name) {
		Type type = null;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();
			String requeteSQL = "SELECT " + TYPE_TYPE 
					+ " FROM " + GAME_TABLE + "," + GAME_TYPE_TABLE + "," + TYPE_TABLE
					+ " WHERE " + GAME_TABLE + "." + GAME_TITLE + "=" + GAME_TYPE_TABLE + "." + GAME_TYPE_GAME + "=" + GAME_TYPE_TABLE + "." + GAME_TYPE_GAME
					+ " AND " + GAME_TYPE_TABLE + "." + GAME_TYPE_TYPE + "=" + TYPE_TABLE + "." + TYPE_TYPE + " AND " + GAME_TITLE + "=?" ;
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setString(1, name);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				//game = new Game(resultSet.getString(GAME_TITLE), resultSet.getString(GAME_CONSOLE),
				//		resultSet.getDouble(GAME_PRICE));
				type = new Type(resultSet.getString(TYPE_TYPE));
			}
			resultSet.close();
			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

}