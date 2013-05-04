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
public class AbstractThd implements java.io.Serializable {   
  
     private ThdId id;   
  
    // Constructors   
    /** default constructor */   
    public AbstractThd() {   
    }   
  
    /** full constructor */   
    public AbstractThd(ThdId id) {   
        this.id = id;   
    }   
      
    // Property accessors   
  
    public ThdId getId() {   
        return this.id;   
    }   
       
    public void setId(ThdId id) {   
        this.id = id;   
    }   

	/** 
	* for test. 
	* @param args commond line parameters 
	public static void main(final String[] args) { 
	} // END: main 
	*/ 
} // END: AbstractThd 
///:~

