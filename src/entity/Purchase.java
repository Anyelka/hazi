package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p")
public class Purchase implements Serializable {
	private static final long serialVersionUID=1L;

	@Id							
	@GeneratedValue				
	private int purchaseID;
	private enum purchaseStatus {PROCESSING, PROCESSED, PMENTRECEIVED, DELIVERING, DELIVERED}

	@Temporal(TemporalType.DATE)
	private Date purchaseDate;	
	

	@ManyToOne							//a purchase mindenképpen egy userhez tartozik (egy userhez tartozhat több purchase is)
	@JoinColumn(name = "USERID")		
	private User user;
	
	@OneToMany(mappedBy = "purchase")	//a purchase-hez itemek tartoznak (akár több is)
	private List<Item> itemsPurchased;
	
	
	public Purchase() {
		
	}
	
//getters&setters	
	public int getPurchaseID() {
		return purchaseID;
	}


	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItemsPurchased() {
		return itemsPurchased;
	}

	public void setItemsPurchased(List<Item> itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}
	
	
}