package lnyswz.hk.utils;

import java.util.List;

import lnyswz.hk.bean.Xsmx;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class XsmxTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();

		List<Xsmx> lists = (List<Xsmx>)session.createQuery("from Xsmx").list();
		
		for(Xsmx xsmx : lists){
			System.out.println("xsmx's xsfplsh is " + xsmx.getId().getXsfplsh());
		}
		HibernateUtil.closeSession(session);
	}
}
