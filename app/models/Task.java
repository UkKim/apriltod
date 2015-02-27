package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Task extends Model {
	@Id
	public Long id;
	@OneToMany(mappedBy="task",cascade=CascadeType.ALL)
	public List<Participant> participants;
	@ManyToOne
	public Project project;

}
