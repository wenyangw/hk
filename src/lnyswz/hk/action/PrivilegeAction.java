package lnyswz.hk.action;

import java.util.List;
import java.util.Set;

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
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Menu> allMenus = menuService.findMenus();
		
		User user = userService.getUser(id);
		Set<Menu> set = user.getMenus();
		
		request.setAttribute("all_menus", allMenus);
		request.setAttribute("user_menus", set);
		return SUCCESS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
