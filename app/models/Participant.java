package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Participant extends Model {
	// 조회를 위한 Finder<Key, Data>
	private static Finder<Long,Participant> finder = new Finder<>(Long.class,Participant.class);
	@Id
	public Long id;
	// participant 입장이세는 user가 n:1 이다..
	@ManyToOne
	public User user;
	@ManyToOne
	public Task task;
	
	// id로 조회
	public static Participant findById(Long id) {
		return finder.byId(id);
	}
	

}
