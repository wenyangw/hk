/* 
* ----------------------------------------------------------- 
* file name : srcmainjavacomisunnbeanHkmx.java 
* authors : Wenyang(wenyangw@gmail.com) 
* created : 2010/3/11 16:02:51 
* copyright : (c) 2009 Isunn Inc. All Rights Reserved. 
* 
* modifications: 
* 
* ----------------------------------------------------------- 
*/ 
package lnyswz.hk.bean; 

import java.math.BigDecimal;

/** 
* to-do. 
* 
* @author Wenyang(wenyangw@gmail.com) 
* @version 1.0 
*/ 
public class Hkmx { 
	private int id;
	private String xsfplsh;
	private BigDecimal hkje;
	private String hksj;
	private String completed;

	/** 
	* default constructor. 
	*/ 
	public Hkmx() { 
		super(); 
	} // END: Hkmx 

	
	/** 
	* for test. 
	* @param args commond line parameters 
	public static void main(final String[] args) { 
	} // END: main 
	*/ 
	
	
	/**
	 * Get xsfplsh.
	 *
	 * @return xsfplsh as String.
	 */
	public String getXsfplsh() {
	    return xsfplsh;
	}
	
	/**
	 * Set xsfplsh.
	 *
	 * @param xsfplsh the value to set.
	 */
	public void setXsfplsh(String xsfplsh) {
	    this.xsfplsh = xsfplsh;
	}
	
	/**
	 * Get hkje.
	 *
	 * @return hkje as BigDecimal.
	 */
	public BigDecimal getHkje() {
	    return hkje;
	}
	
	/**
	 * Set hkje.
	 *
	 * @param hkje the value to set.
	 */
	public void setHkje(BigDecimal hkje) {
	    this.hkje = hkje;
	}
	
	/**
	 * Get completed.
	 *
	 * @return completed as String.
	 */
	public String getCompleted() {
	    return completed;
	}
	
	/**
	 * Set completed.
	 *
	 * @param completed the value to set.
	 */
	public void setCompleted(String completed) {
	    this.completed = completed;
	}
	
	/**
	 * Get hksj.
	 *
	 * @return hksj as String.
	 */
	public String getHksj() {
	    return hksj;
	}
	
	/**
	 * Set hksj.
	 *
	 * @param hksj the value to set.
	 */
	public void setHksj(String hksj) {
	    this.hksj = hksj;
	}
	
	/**
	 * Get id.
	 *
	 * @return id as int.
	 */
	public int getId() {
	    return id;
	}
	
	/**
	 * Set id.
	 *
	 * @param id the value to set.
	 */
	public void setId(int id) {
	    this.id = id;
	}
} // END: Hkmx 
///:~

