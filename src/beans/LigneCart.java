package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="LIGNE_CART")
public class LigneCart implements Serializable {
	
	@Id
	@Column(name="fk_cart")
	private int cart;
	
	@Id
	@Column(name="fk_game")
	private String game;
	
	private int quantity;
	
	public LigneCart() {
		
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

