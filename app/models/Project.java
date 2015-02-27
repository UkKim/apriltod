package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Project extends Model{
	@Id
	public Long id;
	@OneToMany(mappedBy="project",cascade=CascadeType.ALL)
	public List<Task> tasks;

}
