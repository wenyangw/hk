package lnyswz.hk.bean;

import java.util.Set;
import java.util.TreeSet;


/**
 * 
 * @author wenyang
 * @hibernate.class table="hk_user"
 */
public class User{
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String org;
	
	private String name;
	
	private boolean used;
	
	private Set<Menu> menus = new TreeSet<Menu>();
	
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
	 * @hibernate.property not-null="true" length="12"
	 * 
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @hibernate.property length="8"
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @hibernate.property not-null="true" length="30"
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @hibernate.property not-null="true" length="2"
	 */
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	/**
	 * @hibernate.property not-null="true"
	 */
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	/**
	 * @hibernate.set table="user_menu"
	 * @hibernate.collection-key column="userId"
	 * @hibernate.collection-many-to-many class="Menu" column="menuId"
	 */
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
}
