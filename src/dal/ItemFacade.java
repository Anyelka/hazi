package dal;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import entity.Item;

@Stateless
public class ItemFacade extends AbstractFacade<Item>{

	@PersistenceContext
	private EntityManager em;	
		
	public ItemFacade() {				//??? -> muszáj explicit constructort megadni
		super(Item.class);				// super() -> AbstractFacade konstruktorát hívja meg 
	}
	
	@Override
	protected EntityManager em() {		//??? -> abstract method -> muszáj overrideolni 
		return em;
	}
	
//	if(getQuantity == 0) {
//		setSoldout(true);
//	}
	
}
