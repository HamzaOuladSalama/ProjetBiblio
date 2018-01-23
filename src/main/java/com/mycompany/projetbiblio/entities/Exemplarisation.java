/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oussama Messaoudi
 */
@Entity
@Table(name = "Exemplarisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exemplarisation.findAll", query = "SELECT e FROM Exemplarisation e")
    , @NamedQuery(name = "Exemplarisation.findById", query = "SELECT e FROM Exemplarisation e WHERE e.id = :id")
    , @NamedQuery(name = "Exemplarisation.findByDisponible", query = "SELECT e FROM Exemplarisation e WHERE e.disponible = :disponible")
    , @NamedQuery(name = "Exemplarisation.findByTotal", query = "SELECT e FROM Exemplarisation e WHERE e.total = :total")})
public class Exemplarisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "disponible")
    private Integer disponible;
    @Column(name = "total")
    private Integer total;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "exemplarisation")
    private Bulletin bulletin;
    @OneToMany(mappedBy = "id")
    private List<Livre> livreList;

    public Exemplarisation() {
    }

    public Exemplarisation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    @XmlTransient
    public List<Livre> getLivreList() {
        return livreList;
    }

    public void setLivreList(List<Livre> livreList) {
        this.livreList = livreList;
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
        if (!(object instanceof Exemplarisation)) {
            return false;
        }
        Exemplarisation other = (Exemplarisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Exemplarisation[ id=" + id + " ]";
    }

}
