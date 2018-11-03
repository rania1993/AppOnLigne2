package tn.esprit.pidevjee.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import tn.esprit.pidevjee.persistence.Task;
import tn.esprit.pidevjee.persistence.User;
@Local
public interface InterfaceTaskServiceRemote {

	public  int AddTask(Task task);

	public List<Task> getAllTasks() ;
	public void deleteTask(int taskId);
	public void updateTask(Task task);
	public List<User>getAllUsers();
	public List<Task>showTasksByName(String name ,String description,Date deadline);
	public List<Task>GetTasksByID();
    public List<User> alert()	;
	
	
	
}
