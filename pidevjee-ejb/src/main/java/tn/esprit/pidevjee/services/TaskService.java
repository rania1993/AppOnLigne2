package tn.esprit.pidevjee.services;


import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidevjee.interfaces.InterfaceTaskServiceRemote;
import tn.esprit.pidevjee.persistence.Task;
import tn.esprit.pidevjee.persistence.User;


@Stateless
@LocalBean
public class TaskService implements InterfaceTaskServiceRemote    {
	
	@PersistenceContext
	 EntityManager em;
	
	@Override
	public int AddTask(Task task) {

      em.persist(task);
     
      return task.getId();
      
		
	}



	@Override
	 public List<Task> getAllTasks() {
		
		TypedQuery<Task> query = em.createQuery("select u from Task u ",Task.class);	
		 List<Task> tasks = query.getResultList();
		 return tasks;
	}

	@Override
	public void deleteTask(int taskId) {
	
		em.remove(em.find(Task.class,taskId));
		
	}

	@Override
	public void updateTask(Task task) {
		em.merge(task);
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users= em.createQuery("select u from User u ",User.class).getResultList();	
		  
		 return users;
	}



	@Override
	public List<Task> showTasksByName(String name, String description, Date deadline) {
		TypedQuery<Task> querry=em.createQuery
  ("select t from Task t where t.name=:name and t.description =:description and and t.deadline =:deadline ",Task.class);
		
		querry.setParameter("name", name);   
		querry.setParameter("description", description);
		querry.setParameter("deadline", deadline);
	
		
		return querry.getResultList();
	}



	@Override
	public List<Task> GetTasksByID() {
		 TypedQuery<Task>  query = em.createQuery("select t from Task t where t.user=3 ",Task.class);	
		 List<Task> tasksById = query.getResultList();
		 return tasksById;
	}



	@Override
	public List<User> alert() {
		
		
		
			
			return em.createQuery("Select u FROM User u, Task t where u.id = t.user.id  and t.state like 'En cours' and DATEDIFF(CURRENT_DATE,t.deadline)=0 ",User .class).getResultList();
		
		
		
	}



	

}
