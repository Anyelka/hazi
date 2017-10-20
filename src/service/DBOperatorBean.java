package service;

import java.util.Date;

import entity.Item;
import entity.Purchase;
import entity.User;
import exception.NotEnoughItemsException;

//import dal.PurchaseFacade;
//import entity.Purchase;

@Stateless
public class DBOperatorBean {

	@EJB
	private PurchaseFacade purchaseFacade;

	

	
	public void createUser() {
		
	}
	
//	
	public void addItemToCart(Item item, int userID ,int  quantity) throws NotEnoughItemsException {
		if(quantity > item.getQuantity())
			throw NotEnoughItemException("There are not enough items left");
		
		User user = UserFacade.find(userID);
		
		user.getItemsInCart().add(item);						//a user bev�s�rl�kocsij�ba betessz�k az itemet
		item.setQuantity(item.getQuantity()-quantity);			//item mennyis�g�t x-el cs�kkentj�k
	}
//
	public void addPurchase(Purchase purchase, int userID) {	
			
		User user = UserFacade.find(userID);					// melyik user adta hozz� a purchase-t? 
		purchase.setUser(user);									//a purchase user�t megadjuk
		user.getUserPurchases().add(purchase);					//a user purchase-eihez hozz�adjuk a mostanit
		
		purchase.purchaseStatus = 								//purchase �llapota alapb�l feldolgoz�s alatt
		purchase.setPurchaseDate(new Date());					//purchase d�tuma
		purchase.setItemsPurchased(user.getItemsInCart());		//a user kosar�ban l�v� itemeket �tadjuk a purchase itemeinek
		
		purchaseFacade.create(purchase);						//purchase elk�sz�t�se

		user.setItemsInCart(null); 								//user kosar�nak �r�t�se
	}

}