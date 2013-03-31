/* 
 * ----------------------------------------------------------- 
 * file name : srcmainjavacomisunnbeanXsmxId.java 
 * authors : Wenyang(wenyangw@gmail.com) 
 * created : 2010/3/31 16:34:00 
 * copyright : (c) 2009 Isunn Inc. All Rights Reserved. 
 * 
 * modifications: 
 * 
 * ----------------------------------------------------------- 
 */ 
package lnyswz.hk.bean; 

import java.math.BigDecimal;

import lnyswz.hk.utils.DateUtil;
/** 
 * to-do. 
 * 
 * @author Wenyang(wenyangw@gmail.com) 
 * @version 1.0 
 */ 
public class XsmxS implements java.io.Serializable{ 
	private String khbh;
	private String xsfplsh;
	private BigDecimal xsje;
	//private float hked;
	private String kpsj;
	private String hksj;
    private String bmbh;

	/** 
	 * default constructor. 
	 */ 
	public XsmxS() { 
		super(); 
	} 

	public XsmxS(Xsmx xsmx, int days){
		setBmbh(xsmx.getId().getBmbh());
		setKhbh(xsmx.getId().getKhbh());
		setKpsj(xsmx.getId().getKpsj());
		setXsfplsh(xsmx.getId().getXsfplsh());
		setXsje(xsmx.getId().getXsje());
		setHksj(DateUtil.dateIncreaseByDay(xsmx.getId().getKpsj(), DateUtil.ISO_EXPANDED_DATE_FORMAT, days));
	}
	/** 
	 * for test. 
	 * @param args commond line parameters 
	 public static void main(final String[] args) { 
	 } // END: main 
	 */ 

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
	 * Get xsje.
	 *
	 * @return xsje as BigDecimal.
	 */
	public BigDecimal getXsje() {
		return xsje;
	}

	/**
	 * Set xsje.
	 *
	 * @param xsje the value to set.
	 */
	public void setXsje(BigDecimal xsje) {
		this.xsje = xsje;
	}

	/**
	 * Get kpsj.
	 *
	 * @return kpsj as String.
	 */
	public String getKpsj() {
		return kpsj;
	}

	/**
	 * Set kpsj.
	 *
	 * @param kpsj the value to set.
	 */
	public void setKpsj(String kpsj) {
		this.kpsj = kpsj;
	}
	
	/**
	public boolean equals(Object other) {   
		if ( (this == other ) ) return true;   
		if ( (other == null ) ) return false;   
		if ( !(other instanceof XsmxId) ) return false;   
		XsmxId castOther = ( XsmxId ) other;    

		return ( (this.getKhbh()==castOther.getKhbh()) || ( this.getKhbh()!=null && castOther.getKhbh()!=null && this.getKhbh().equals(castOther.getKhbh()) ) )   
			&& ( (this.getKhmc()==castOther.getKhmc()) || ( this.getKhmc()!=null && castOther.getKhmc()!=null && this.getKhmc().equals(castOther.getKhmc()) ) )   
			&& ( (this.getXsje()==castOther.getXsje()) || ( this.getXsje()!=0 && castOther.getXsje()!=0 && this.getXsje() != castOther.getXsje() ) )   
			&& ( (this.getKpsj()==castOther.getKpsj()) || ( this.getKpsj()!=null && castOther.getKpsj()!=null && this.getKpsj().equals(castOther.getKpsj()) ) );   
	}   

	public int hashCode() {   
		int result = 17;   

		result = 37 * result + ( getKhbh() == null ? 0 : this.getKhbh().hashCode() );   
		result = 37 * result + ( getKhmc() == null ? 0 : this.getKhmc().hashCode() );   
		//result = 37 * result + ( getXsje() == 0 ? 0 : this.getXsje().hashCode() );   
		result = 37 * result + ( getKpsj() == null ? 0 : this.getKpsj().hashCode() );   
		return result;   
	}      
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
	 * Get hked.
	 *
	 * @return hked as float.
	 */
//	public float getHked() {
//	    return hked;
//	}
	
	/**
	 * Set hked.
	 *
	 * @param hked the value to set.
	 */
//	public void setHked(float hked) {
//	    this.hked = hked;
//	}
	
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
} // END: XsmxS
///:~

