package br.com.webaplication.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.webaplication.model.User;

@Repository
public class UserDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> user = manager.createQuery("select u from User u where u.email =:email", User.class)
				.setParameter("email", username).getResultList();
		if (user.isEmpty())
			throw new UsernameNotFoundException("Usuario invalido");

		return user.get(0);
	}

}
