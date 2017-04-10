package br.com.webaplication.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webaplication.model.User;

@Repository
@Transactional
public class CreateUserDAO {

	@PersistenceContext
	private EntityManager manager;

	public void createUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePass = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePass);

		manager.persist(user);

	}

	public void UsuarioRole(User user) {
		manager.createNativeQuery("insert into user_role(User_email, role_roleName) "
				+ "values('"+ user.getEmail()+"', 'ROLE_USER')").executeUpdate();
	}
	
	public User find(String email) {
		return manager.createQuery("select u from User u where u.email = :email", User.class)
					.setParameter("email", email).getSingleResult();

	}

	
}
