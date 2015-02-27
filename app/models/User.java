package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.Logger;
import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class User extends Model {
	// 조회를 위한 Finder<Key, Data>
	private static Finder<Long,User> finder = new Finder<>(Long.class,User.class);
	
	@Id
	public Long id;
	@Constraints.Required
	public String email;
	public String name;
	public String password;
	public String address;
	// user 입장에서는 1:n 이다..
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	public List<Participant> participants;
	
	public static void create(User user) {
		user.save();
		Logger.debug("User id = " + user.id);
	}

	public static void update(User user) {
		user.update();
	}
	
	public static void delete(User user) {
		user.delete();
	}
	
	// id로 조회
	public static User findById(Long id) {
		return finder.byId(id);
	}
	
	// 전체 List로 조회
	public static List<User> findAll() {
		return finder.all();
		
	}
	
	// email 로 검색
	public static User findByEmail(String email) {
		return finder.where().eq("email", email).findUnique();
	}
	
	// like 조건
	public static List<User> findByName(String name) {
		return finder.where().like("%name%", name).findList();
	}
	
	// 정렬
	public static List<User> findByName(String name, String order) {
		return finder.where().like("%name%", name).orderBy("name " + order).findList();
	}

}
