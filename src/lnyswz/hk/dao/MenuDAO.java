package lnyswz.hk.dao;

import java.util.List;

import lnyswz.hk.bean.Menu;

public interface MenuDAO {
	public void addMenu(Menu menu);
	
	public void deleteMenu(int menuId);
	
	public void modifyMenu(Menu menu);
	
	public Menu findMenu(int menuId);
	
	public List<Menu> findMenus();
}
