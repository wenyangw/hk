package lnyswz.hk.utils;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @author zudajun225
 *
 */
public class PagerModel {
	
	/**
	 * 总记录数
	 */
	private int total;
	
	//当前页的结果集
	private List<Object> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * 返回Organization的集合
	 * @return List&lt;Organization&gt; (size >=0)
	 */
	public List<Object> getList() {
		return list == null? Collections.<Object>emptyList() : list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
}
