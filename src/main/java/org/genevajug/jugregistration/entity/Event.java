/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

/**
 *
 * @author codingdojo
 */
@Entity
public class Event implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(min=3, max=100)
    private String name;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Future
    private Date date;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date openRegistrationDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date closeRegistrationDate;
    
    private int seatNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCloseRegistrationDate() {
        return closeRegistrationDate;
    }

    public void setCloseRegistrationDate(Date closeRegistrationDate) {
        this.closeRegistrationDate = closeRegistrationDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpenRegistrationDate() {
        return openRegistrationDate;
    }

    public void setOpenRegistrationDate(Date openRegistrationDate) {
        this.openRegistrationDate = openRegistrationDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genevajug.jugregistration.entity.Event[ id=" + id + " ]";
    }
    
}
