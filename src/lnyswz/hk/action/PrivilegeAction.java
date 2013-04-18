package lnyswz.hk.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import lnyswz.hk.bean.Menu;
import lnyswz.hk.bean.User;
import lnyswz.hk.service.MenuService;
import lnyswz.hk.service.UserService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class PrivilegeAction extends ActionSupport {
	private MenuService menuService;
	private UserService userService;
	
	private int id;
	private List<Integer> select;
	@Override
	public String execute() throws Exception {
		//test
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Menu> allMenus = menuService.findMenus();
		
		User user = userService.getUser(id);
		Set<Menu> set = user.getMenus();
		
		request.setAttribute("all_menus", allMenus);
		request.setAttribute("user_menus", set);
		request.setAttribute("id", id);
		return SUCCESS;
	}
	
	public String change(){
		User user = userService.getUser(id);
		Set<Menu> set = new HashSet<Menu>();
		for(int i : select){
			Menu menu = menuService.getMenu(i);
			set.add(menu);
		}
		user.setMenus(set);
		userService.modifyUser(user);
		return "change";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Integer> getSelect() {
		return select;
	}

	public void setSelect(List<Integer> select) {
		this.select = select;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
