/* 
* ----------------------------------------------------------- 
* file name : srcmainjavacomisunnbeanSxkh.java 
* authors : Wenyang(wenyangw@gmail.com) 
* created : 2010/3/11 10:56:49 
* copyright : (c) 2009 Isunn Inc. All Rights Reserved. 
* 
* modifications: 
* 
* ----------------------------------------------------------- 
*/ 
package lnyswz.hk.bean; 

/** 
* to-do. 
* 
* @author Wenyang(wenyangw@gmail.com) 
* @version 1.0 
*/ 
public class Sxkh {
    private int id;
	private String khbh;
	private String khmc;
	private int days;
	private float balance;
	private float limit;
	private String lsh;
    private String bmbh;
    private String yjkh;
    private String ywybh;
    private String ywymc;
	/** 
	* default constructor. 
	*/ 
	public Sxkh() { 
		super(); 
	} // END: Sxkh 

	
	/** 
	* for test. 
	* @param args commond line parameters 
	public static void main(final String[] args) { 
	} // END: main 
	*/ 
	
	/**
	 * Get balance.
	 *
	 * @return balance as float.
	 */
	public float getBalance() {
	    return balance;
	}
	
	/**
	 * Set balance.
	 *
	 * @param balance the value to set.
	 */
	public void setBalance(float balance) {
	    this.balance = balance;
	}
	
	/**
	 * Get days.
	 *
	 * @return days as int.
	 */
	public int getDays() {
	    return days;
	}
	
	/**
	 * Set days.
	 *
	 * @param days the value to set.
	 */
	public void setDays(int days) {
	    this.days = days;
	}
	
	/**
	 * Get khmc.
	 *
	 * @return khmc as String.
	 */
	public String getKhmc() {
	    return khmc;
	}
	
	/**
	 * Set khmc.
	 *
	 * @param khmc the value to set.
	 */
	public void setKhmc(String khmc) {
	    this.khmc = khmc;
	}
	
	/**
	 * Get khbh.
	 *
	 * @return khbh as String.
	 */
	public String getKhbh() {
	    return khbh;
	}
	
	/**
	 * Set khbh.
	 *
	 * @param khbh the value to set.
	 */
	public void setKhbh(String khbh) {
	    this.khbh = khbh;
	}
	
	
	/**
	 * Get lsh.
	 *
	 * @return lsh as String.
	 */
	public String getLsh() {
	    return lsh;
	}
	
	/**
	 * Set lsh.
	 *
	 * @param lsh the value to set.
	 */
	public void setLsh(String lsh) {
	    this.lsh = lsh;
	}
	
	/**
	 * Get limit.
	 *
	 * @return limit as float.
	 */
	public float getLimit() {
	    return limit;
	}
	
	/**
	 * Set limit.
	 *
	 * @param limit the value to set.
	 */
	public void setLimit(float limit) {
	    this.limit = limit;
	}
    
    /**
     * Get bmbh.
     *
     * @return bmbh as String.
     */
    public String getBmbh() {
        return bmbh;
    }
    
    /**
     * Set bmbh.
     *
     * @param bmbh the value to set.
     */
    public void setBmbh(String bmbh) {
        this.bmbh = bmbh;
    }
    
    /**
     * Get yjkh.
     *
     * @return yjkh as String.
     */
    public String getYjkh()
    {
        return yjkh;
    }
    
    /**
     * Set yjkh.
     *
     * @param yjkh the value to set.
     */
    public void setYjkh(String yjkh)
    {
        this.yjkh = yjkh;
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


	public String getYwybh() {
		return ywybh;
	}


	public void setYwybh(String ywybh) {
		this.ywybh = ywybh;
	}


	public String getYwymc() {
		return ywymc;
	}


	public void setYwymc(String ywymc) {
		this.ywymc = ywymc;
	}
    
} // END: Sxkh 
///:~

