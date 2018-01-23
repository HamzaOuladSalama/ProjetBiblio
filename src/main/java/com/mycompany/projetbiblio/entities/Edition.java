/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oussama Messaoudi
 */
@Entity
@Table(name = "edition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edition.findAll", query = "SELECT e FROM Edition e")
    , @NamedQuery(name = "Edition.findByDate", query = "SELECT e FROM Edition e WHERE e.date = :date")
    , @NamedQuery(name = "Edition.findByLangue", query = "SELECT e FROM Edition e WHERE e.langue = :langue")
    , @NamedQuery(name = "Edition.findByIdEditeur", query = "SELECT e FROM Edition e WHERE e.idEditeur = :idEditeur")})
public class Edition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 255)
    @Column(name = "langue")
    private String langue;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_editeur")
    private Integer idEditeur;
    @JoinColumn(name = "id_editeur", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Editeur editeur;

    public Edition() {
    }

    public Edition(Integer idEditeur) {
        this.idEditeur = idEditeur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Integer getIdEditeur() {
        return idEditeur;
    }

    public void setIdEditeur(Integer idEditeur) {
        this.idEditeur = idEditeur;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditeur != null ? idEditeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edition)) {
            return false;
        }
        Edition other = (Edition) object;
        if ((this.idEditeur == null && other.idEditeur != null) || (this.idEditeur != null && !this.idEditeur.equals(other.idEditeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Edition[ idEditeur=" + idEditeur + " ]";
    }

}
