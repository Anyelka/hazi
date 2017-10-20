package dal;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class UserFacade extends AbstractFacade<User>{

	@PersistenceContext
	private EntityManager em;
	
	public UserFacade() {
		super(User.class);
	}
	
	@Override
	protected EntityManager em() {
		return em;
	}
}
