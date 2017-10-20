package dal;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import entity.Purchase;

@Stateless
public class PurchaseFacade extends AbstractFacade<Purchase>{
	
	@PersistenceContext
	private EntityManager em;

	public PurchaseFacade() {
		super(Purchase.class);
	}
		
	@Override
	protected EntityManager em() {		
		return em;
	}
	
}
