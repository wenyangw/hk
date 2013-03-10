package lnyswz.hk.utils;

import java.util.List;

import lnyswz.hk.bean.Sxkh;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SxkhTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();

		List<Sxkh> lists = (List<Sxkh>)session.createQuery("from Sxkh").list();
		
		for(Sxkh sxkh : lists){
			System.out.println("Sxkh's name is " + sxkh.getKhmc());
		}
		HibernateUtil.closeSession(session);
	}
}
