package entity;

import java.io.Serializable;

@Entity
@NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i" )		//???
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id							//primary key
	@GeneratedValue				//automatically allocated by ObjectDB
	private int itemID;			
	
	private String itemsTeam;
	private String itemColor;
	private enum itemha3rd{HOME, AWAY, THIRD};
//	private String itemPlayerName;
	private String itemName;

	private int quantity;
//	private boolean soldout;
	

//	
//	@ManyToOne					// az itemnek nem feltétlenül van user-e & purchase ... ?
//	@JoinColumn()
//	private User user;					// az item melyik user-hez tartozik
//	
//	@ManyToOne
//	private Purchase purchase;			// az item melyik purchase-hez tartozik
//	
//	
	
	
	public Item() {
		
	}
	
//	soldout->
//	if(quantity == 0) { 
//		soldout = true;
//	}

//getters&setters	
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean getSoldout() {
		return soldout;
	}

	public void setSoldout(boolean soldout) {
		this.soldout = soldout;
	}

	public String getItemsTeam() {
		return itemsTeam;
	}

	public void setItemsTeam(String itemsTeam) {
		this.itemsTeam = itemsTeam;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
