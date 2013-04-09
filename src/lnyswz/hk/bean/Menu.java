package lnyswz.hk.bean;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author wenyang
 * @hibernate.class table="hk_menu"
 */
public class Menu {
	private int id;
	private String cname;
	private String url;
	private String logNo;
	private Set<User> users = new TreeSet<User>();
	
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
	
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}
	/**
	 * @hibernate.set lazy="true" table="user_menu"
	 * @hibernate.collection-key column="menuId"
	 * @hibernate.collection-many-to-many class="User" column="userId"
	 */
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
