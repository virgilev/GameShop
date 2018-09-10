package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Client implements Serializable {
	
	@Id
	@Column(name="pk_email")
	private String email;
	
	private String lastName;
	
	private String firstName;
	
	private String password;
	
	private String birthDate;
	
//	@Column(name="fk_cart")
//	private int cart;
	
	private Cart cart;
	
	public Client() {
		this.cart = new Cart();
	}
	
	public Client(String email, String lastName, String firstName, String password, String birthDate) {
		this.email = email;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		this.birthDate = birthDate;
		this.cart = new Cart();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

}
