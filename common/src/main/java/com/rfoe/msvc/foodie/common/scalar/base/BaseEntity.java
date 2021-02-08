package com.rfoe.msvc.foodie.common.scalar.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rfoe.msvc.foodie.common.constant.ConstantStatus;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;


@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Integer> implements Serializable, Cloneable {

    public abstract Serializable getPk();


    @Getter @Setter
	@Column(name="STATUS",length=1,columnDefinition="CHAR(1)")
	private String status = ConstantStatus.ACTIVE;
	public String getStatusAsDisplay(){return (ConstantStatus.ACTIVE.equals(status)) ? "active" : "deleted";}
	public boolean isActive(){return ConstantStatus.ACTIVE.equals(status);}
	public void toggleStatus() {
		this.setStatus(isActive()? ConstantStatus.DELETED : ConstantStatus.ACTIVE );
	}

	//user_account id
	@Getter @Setter
	@Column(name="CREATED_BY_ID")
	private Long createdById;
	
	@Getter @Setter
	@Column(name="CREATED_DATETIME" ) //columnDefinition="DATETIME"
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateTime;
	
	//user_account id
	@Getter @Setter
	@Column(name="MODIFIED_BY_ID")
	private Long modifiedById;
	
	@Getter @Setter
	@Column(name="MODIFIED_DATETIME"  ) //columnDefinition="DATETIME"
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDateTime;
	
	
	
	// @Override
	// public Object clone() {
	//     try {
    //         return super.clone();
    //     } catch (CloneNotSupportedException e) {            
    //         e.printStackTrace();
    //         return null;
    //     }
	// }
    
	
    @Override
    public int hashCode() {        
        return getPk() != null ? getPk().hashCode() : 0;        
    }

    @Override
    public boolean equals(Object object) {    	
        if (object == null || object.getClass() != this.getClass()) return false;  
        
        BaseEntity other = (BaseEntity) object;        
        return (this.getPk() == null) ? other.getPk() == null : this.getPk().equals(other.getPk());        
    }
    
    @Override
    public String toString() {
    	try{
    		if(this != null) 
    			return this.getClass().getName() + "[PK: " + this.getPk() != null ? this.getPk().toString(): "null" + "]";
    		
    	}catch(Exception e){/*IGNORED*/}
    	return "null";
    }
    
    
    public boolean isPkSet(){
    	if(this.getId()== null) return false;
    		
    	// if(this.getId() instanceof BasePk)
    	// 	return ((BasePk)(this.getPk())).isSet();

    	return true;
    }

    public String getPkAsString(){
    	String temp = "";
    	
    	if(this.getPk() instanceof BasePk){
    		temp =  ((BasePk)(this.getPk())).getAsString();
    	}else
    		temp = (this.getPk()== null) ? "" : this.getPk().toString();
    	
    	return temp;
    }
    
    
}
