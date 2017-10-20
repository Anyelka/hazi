package dal;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import entity.Item;

@Stateless
public class ItemFacade extends AbstractFacade<Item>{

	@PersistenceContext
	private EntityManager em;	
		
	public ItemFacade() {				//??? -> musz�j explicit constructort megadni
		super(Item.class);				// super() -> AbstractFacade konstruktor�t h�vja meg 
	}
	
	@Override
	protected EntityManager em() {		//??? -> abstract method -> musz�j overrideolni 
		return em;
	}
	
//	if(getQuantity == 0) {
//		setSoldout(true);
//	}
	
}
