package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Cart;

public class CartDao {
	
	public static int insertSQL(Cart cart) {		
		int result = 0;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requeteSQL = "INSERT INTO CART() "
					+ "VALUES()";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);

			result = ps.executeUpdate();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static int findLastCart() {
		int result = 0;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requetSQL = "SELECT pk_id from CART ORDER BY pk_id DESC LIMIT 1;";
			PreparedStatement ps = connection.prepareStatement(requetSQL);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				result = resultSet.getInt("pk_id");
			}

			resultSet.close();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static int deleteCart(int id_cart) {
		int result = 0;
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();

			String requeteSQL = "DELETE FROM CART WHERE pk_id=?";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setInt(1, id_cart);

			result = ps.executeUpdate();

			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
