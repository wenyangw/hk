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
/** 
 * to-do. 
 * 
 * @author Wenyang(wenyangw@gmail.com) 
 * @version 1.0 
 */ 
public class ThdId implements java.io.Serializable{ 
	private String thdlsh;
	private String kh;
	private String spbh;
	private String spmc;
	private String spcd;
	private String jldwmc;
	private BigDecimal spsl;
	private BigDecimal spton;
	private String thsj;
	private String bz;

	/** 
	 * default constructor. 
	 */ 
	public ThdId() { 
		super(); 
	} // END: ThdId 

	public String getThdlsh() {
		return thdlsh;
	}

	public void setThdlsh(String thdlsh) {
		this.thdlsh = thdlsh;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getSpbh() {
		return spbh;
	}

	public void setSpbh(String spbh) {
		this.spbh = spbh;
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public String getSpcd() {
		return spcd;
	}

	public void setSpcd(String spcd) {
		this.spcd = spcd;
	}

	public String getJldwmc() {
		return jldwmc;
	}

	public void setJldwmc(String jldwmc) {
		this.jldwmc = jldwmc;
	}

	public BigDecimal getSpsl() {
		return spsl;
	}

	public void setSpsl(BigDecimal spsl) {
		this.spsl = spsl;
	}

	public BigDecimal getSpton() {
		return spton;
	}

	public void setSpton(BigDecimal spton) {
		this.spton = spton;
	}

	public String getThsj() {
		return thsj;
	}

	public void setThsj(String thsj) {
		this.thsj = thsj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}


	    
} // END: ThdId 
///:~

