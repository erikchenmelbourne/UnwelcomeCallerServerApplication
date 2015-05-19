/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.erikchenmelbourne.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaikisaragi
 */
@Entity
@Table(name = "caller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caller.findAll", query = "SELECT c FROM Caller c"),
    @NamedQuery(name = "Caller.findById", query = "SELECT c FROM Caller c WHERE c.id = :id"),
    @NamedQuery(name = "Caller.findByNumber", query = "SELECT c FROM Caller c WHERE c.number = :number"),
    @NamedQuery(name = "Caller.findByInformation", query = "SELECT c FROM Caller c WHERE c.information = :information")})
public class Caller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "information")
    private String information;

    public Caller() {
    }

    public Caller(Integer id) {
        this.id = id;
    }

    public Caller(Integer id, String number, String information) {
        this.id = id;
        this.number = number;
        this.information = information;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
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
        if (!(object instanceof Caller)) {
            return false;
        }
        Caller other = (Caller) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erikchenmelbourne.entities.Caller[ id=" + id + " ]";
    }
    
}
