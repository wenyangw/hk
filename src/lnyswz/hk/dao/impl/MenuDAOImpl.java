package lnyswz.hk.dao.impl;

import java.util.List;

import lnyswz.hk.bean.Menu;
import lnyswz.hk.dao.MenuDAO;
import lnyswz.hk.utils.AbstractPagerManager;

public class MenuDAOImpl extends AbstractPagerManager implements MenuDAO {

	public void addMenu(Menu menu) {
		this.getHibernateTemplate().save(menu);
	}

	public void deleteMenu(int menuId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Menu.class, menuId));
	}

	public void modifyMenu(Menu menu) {
		this.getHibernateTemplate().update(menu);
	}

	public Menu findMenu(int menuId) {
		return (Menu)this.getHibernateTemplate().load(Menu.class, menuId);
	}
	
	public List<Menu> findMenus() {
		return this.getHibernateTemplate().find("from Menu");
	}
	
}
