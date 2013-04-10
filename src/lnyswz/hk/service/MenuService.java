package lnyswz.hk.service;

import java.util.List;

import lnyswz.hk.bean.Menu;

public interface MenuService {
	public Menu getMenu(int id);
	public List<Menu> findMenus();
	
}
