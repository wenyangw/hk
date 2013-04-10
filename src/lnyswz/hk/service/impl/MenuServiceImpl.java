package lnyswz.hk.service.impl;

import java.util.List;

import lnyswz.hk.bean.Menu;
import lnyswz.hk.dao.MenuDAO;
import lnyswz.hk.service.MenuService;

public class MenuServiceImpl implements MenuService {
	private MenuDAO menuDAO;
	
	@Override
	public Menu getMenu(int id) {
		return menuDAO.findMenu(id);
	}
	
	@Override
	public List<Menu> findMenus() {
		return menuDAO.findMenus();
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
}
