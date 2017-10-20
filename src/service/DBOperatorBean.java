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
		
		user.getItemsInCart().add(item);						//a user bevásárlókocsijába betesszük az itemet
		item.setQuantity(item.getQuantity()-quantity);			//item mennyiségét x-el csökkentjük
	}
//
	public void addPurchase(Purchase purchase, int userID) {	
			
		User user = UserFacade.find(userID);					// melyik user adta hozzá a purchase-t? 
		purchase.setUser(user);									//a purchase userét megadjuk
		user.getUserPurchases().add(purchase);					//a user purchase-eihez hozzáadjuk a mostanit
		
		purchase.purchaseStatus = 								//purchase állapota alapból feldolgozás alatt
		purchase.setPurchaseDate(new Date());					//purchase dátuma
		purchase.setItemsPurchased(user.getItemsInCart());		//a user kosarában lévõ itemeket átadjuk a purchase itemeinek
		
		purchaseFacade.create(purchase);						//purchase elkészítése

		user.setItemsInCart(null); 								//user kosarának ürítése
	}

}