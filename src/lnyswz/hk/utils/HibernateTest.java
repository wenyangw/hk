package lnyswz.hk.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lnyswz.hk.bean.Menu;
import lnyswz.hk.bean.User;

public class HibernateTest {
	public static void main(String[] args) {
		User user = null;
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
//		User user = new User();
//		user.setName("王文阳");
//		user.setUsername("wwy");
//		user.setPassword("123456");
//		user.setOrg("01");
//		user.setUsed(true);
//		
//		Menu menu1 = new Menu();
//		menu1.setCname("用户管理");
//		menu1.setUrl("user.action");
//		
//		Set<Menu> set = new TreeSet<Menu>();
//		set.add(menu1);
//		
//		user.setMenus(set);
		
		//Set<Menu> set = new HashSet<Menu>();
		//set.remove(menu)
		
		user = (User)session.get(User.class, 12);
		
		try{
			session.save(user);
			tx.commit();
		}catch(Exception ex){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			HibernateUtil.closeSession(session);
		}
		System.out.println(user.getMenus().size());
	}
}
