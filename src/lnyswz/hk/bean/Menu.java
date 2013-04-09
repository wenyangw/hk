package lnyswz.hk.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author wenyang
 * @hibernate.class table="hk_menu"
 */
public class Menu {
	private int id;
	private String cname;
	private String url;
	private Set<User> user = new HashSet<User>();
	
	/**
	 * @hibernate.id
	 * generator-class="native"
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @hibernate.property not-null="true" length="20"
	 * 
	 */
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @hibernate.property not-null="true" length="100"
	 * 
	 */
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @hibernate.set lazy="true" table="user_menu"
	 * @hibernate.collection-key column="menuId"
	 * @hibernate.collection-many-to-many class="User" column="userId"
	 */
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
}
