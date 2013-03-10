package lnyswz.hk.utils;

import java.util.List;

import lnyswz.hk.bean.Hkmx;
import lnyswz.hk.bean.Sxkh;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HkmxTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();

		List<Hkmx> lists = (List<Hkmx>)session.createQuery("from Hkmx").list();
		
		for(Hkmx hkmx : lists){
			System.out.println("Hkmx's xsfplsh is " + hkmx.getXsfplsh());
		}
		HibernateUtil.closeSession(session);
	}
}
