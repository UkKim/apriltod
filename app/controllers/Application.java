package controllers;

import java.util.List;

import models.Participant;
import models.Project;
import models.Task;
import models.User;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	public static Result viewParticipant(Long id) {
		Participant participant = Participant.findById(id);
		Logger.debug("Project ID = " + participant.id);
		Logger.debug("Project.task ID = " + participant.task.id);
		Logger.debug("Project.user ID = " + participant.user.id);
		return TODO;
	}
	
	public static Result newProject() {
		Project project = new Project();
		project.save();
		Logger.debug("Project ID = " + project.id);

		Task task = new Task();
		task.save();
		Logger.debug("task ID = " + task.id);
		
		User user = new User();
		user.save();
		Logger.debug("User ID = " + user.id);
		
		Participant participant = new Participant();
		participant.user = user;
		participant.task = task;
		participant.save();
		Logger.debug("Participant ID = " + participant.id);

		return TODO;
	}
	
	public static Result userList() {
		List<User> userList = User.findAll();
		Logger.debug("User List size is = " + userList.size());
		return ok(Json.toJson(userList));
	}
	
	public static Result viewUser(Long id) {
		User user = User.findById(id);
		Logger.debug("Name = " + user.name);
		return ok(Json.toJson(user));
	}
	
	public static Result newUser() {
		createUser();
		return TODO;
	}
	
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result createUser() {
    	User user = new User();
    	user.name = "scott";
    	user.email = "scott@bbb.ccc";
    	user.address = "Suwon";
    	User.create(user); // Insert
    	
    	return TODO;
    }

}
