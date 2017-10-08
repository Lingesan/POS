package com.pos.hibernate.beans;
// Generated Oct 8, 2017 11:43:55 AM by Hibernate Tools 5.2.5.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Inventory generated by hbm2java
 */
@Entity
@Table(name="inventory"
    ,catalog="pos"
)
public class Inventory  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 7306768160441899391L;
	private Integer id;
     private Battery battery;
     private int count;
     private Set<Purchase> purchases = new HashSet<Purchase>(0);

    public Inventory() {
    }

	
    public Inventory(Battery battery, int count) {
        this.battery = battery;
        this.count = count;
    }
    public Inventory(Battery battery, int count, Set<Purchase> purchases) {
       this.battery = battery;
       this.count = count;
       this.purchases = purchases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="battery", nullable=false)
    public Battery getBattery() {
        return this.battery;
    }
    
    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    
    @Column(name="count", nullable=false)
    public int getCount() {
        return this.count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="inventory")
    public Set<Purchase> getPurchases() {
        return this.purchases;
    }
    
    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }




}


