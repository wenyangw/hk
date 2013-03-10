/* 
* ----------------------------------------------------------- 
* file name : srcmainjavacomisunnbeanAbstractXsmx.java 
* authors : Wenyang(wenyangw@gmail.com) 
* created : 2010/4/1 14:53:44 
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
public class AbstractXsmx implements java.io.Serializable {   
  
     private XsmxId id;   
  
    // Constructors   
    /** default constructor */   
    public AbstractXsmx() {   
    }   
  
    /** full constructor */   
    public AbstractXsmx(XsmxId id) {   
        this.id = id;   
    }   
      
    // Property accessors   
  
    public XsmxId getId() {   
        return this.id;   
    }   
       
    public void setId(XsmxId id) {   
        this.id = id;   
    }   

	/** 
	* for test. 
	* @param args commond line parameters 
	public static void main(final String[] args) { 
	} // END: main 
	*/ 
} // END: AbstractXsmx 
///:~

