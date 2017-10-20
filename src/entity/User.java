package entity;

import java.io.Serializable;
import java.util.List;


@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID=1L;

	@Id							
	@GeneratedValue				
	private int userID;
	
	private String username;
	private String password;
	private enum userType {CUSTOMER, ADMIN};
	private String email;
	

	@OneToMany(mappedBy = "user")
	private List<Item> itemsInCart;
	
	@OneToMany(mappedBy = "user")
	private List<Purchase> userPurchases;

	

	
	public User() {
		
	}
	
	
	
//getters&setters	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Item> getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(List<Item> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}

	public List<Purchase> getUserPurchases() {
		return userPurchases;
	}

	public void setUserPurchases(List<Purchase> userPurchases) {
		this.userPurchases = userPurchases;
	}

	
	
}