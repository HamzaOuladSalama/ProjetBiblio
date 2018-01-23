/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oussama Messaoudi
 */
@Entity
@Table(name = "bulletin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bulletin.findAll", query = "SELECT b FROM Bulletin b")
    , @NamedQuery(name = "Bulletin.findByDateParution", query = "SELECT b FROM Bulletin b WHERE b.dateParution = :dateParution")
    , @NamedQuery(name = "Bulletin.findByNumero", query = "SELECT b FROM Bulletin b WHERE b.numero = :numero")
    , @NamedQuery(name = "Bulletin.findByResume", query = "SELECT b FROM Bulletin b WHERE b.resume = :resume")
    , @NamedQuery(name = "Bulletin.findById", query = "SELECT b FROM Bulletin b WHERE b.id = :id")})
public class Bulletin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "dateParution")
    @Temporal(TemporalType.DATE)
    private Date dateParution;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 255)
    @Column(name = "resume")
    private String resume;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "id")
    private List<Periodicite> periodiciteList;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Exemplarisation exemplarisation;

    public Bulletin() {
    }

    public Bulletin(Integer id) {
        this.id = id;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Periodicite> getPeriodiciteList() {
        return periodiciteList;
    }

    public void setPeriodiciteList(List<Periodicite> periodiciteList) {
        this.periodiciteList = periodiciteList;
    }

    public Exemplarisation getExemplarisation() {
        return exemplarisation;
    }

    public void setExemplarisation(Exemplarisation exemplarisation) {
        this.exemplarisation = exemplarisation;
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
        if (!(object instanceof Bulletin)) {
            return false;
        }
        Bulletin other = (Bulletin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bulletin[ id=" + id + " ]";
    }

}
