package lnyswz.hk.utils;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AbstractPagerManager extends HibernateDaoSupport {
	
	public PagerModel searchPaginated(String hql) {
		return this.searchPaginated(hql, null, SystemContext.getOffset(), SystemContext.getPagesize());
	}
	
	public PagerModel searchPaginated(String hql, Object param) {
		return this.searchPaginated(hql, new Object[]{param}, SystemContext.getOffset(), SystemContext.getPagesize());
	}
	
	public PagerModel searchPaginated(String hql, Object[] params) {
		return this.searchPaginated(hql, params, SystemContext.getOffset(), SystemContext.getPagesize());
	}
	
	public PagerModel searchPaginated(String hql,int offset, int pagesize) {
		return this.searchPaginated(hql, null, offset, pagesize);
	}
	
	public PagerModel searchPaginated(String hql, Object obj, int offset, int pagesize) {
		return this.searchPaginated(hql, new Object[]{obj}, offset, pagesize);
	}
	
	/**
	 * 根据Hql语言进行分页
	 * @param hql HQL语句
	 * @param params HQL语句的参数
	 * @param offset 从第几条记录开始查询
	 * @param pagesize 每页显示多少条
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PagerModel searchPaginated(String hql,Object[] params, int offset, int pagesize) {
		
		//获取总记录数
		String countHql = this.getCountQuery(hql);
		Query query = this.getSession().createQuery(countHql);
		if(query != null && params != null && params.length > 0) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		
		int total = ((Long)query.uniqueResult()).intValue();
		
		//获得当前页的结果集
		query = this.getSession().createQuery(hql);
		if(query != null && params != null && params.length > 0) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult(offset);
		query.setMaxResults(pagesize);
		List<Object> list = query.list();
		
		PagerModel pm = new PagerModel();
		pm.setTotal(total);
		pm.setList(list);
		
		return pm;
		
	}
	
	private String getCountQuery(String hql) {
		int index = hql.indexOf("from");
		//过滤掉order by 内容
		int order = hql.indexOf("order by");
		
		if(index != -1){
			if(order != -1){  //有orber by存在
				return "select count(*) " + hql.substring(index, order - index);
			}else{
				return "select count(*) " + hql.substring(index);
			}
		}
		
		System.out.println("问题出了");
		throw new RuntimeException("无效的HQL查询语句！");
	}
}
