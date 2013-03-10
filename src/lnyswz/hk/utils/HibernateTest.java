package lnyswz.hk.utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lnyswz.hk.bean.User;

public class HibernateTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setUsername("wwy");
		user.setPassword("123456");
		user.setName("ÍõÎÄÑô");
		user.setOrg("01");
		user.setUsed(true);
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
	}
}
