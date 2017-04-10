package br.com.webaplication.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.webaplication.model.Task;

@Repository
@Transactional
public class TaskDAO {

	@PersistenceContext
	private EntityManager manager;

	public Task find(long id) {
		return manager.createQuery("select t from Task t where t.id = :id", Task.class).setParameter("id", id)
				.getSingleResult();
	}

	public List<Task> list(String email) {
		return manager.createQuery("select t from Task t join fetch t.user u where u.email = :email", Task.class)
				.setParameter("email", email).getResultList();
	}

	public void createNewTask(Task task) {
		manager.createNativeQuery("insert into Task(date, taskName, user_email) values('" + task.getDate() + "','"
				+ task.getTaskName() + "','" + task.getUser() + "')").executeUpdate();
	}

}
