/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oussama Messaoudi
 */
@Entity
@Table(name = "Periodicite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodicite.findAll", query = "SELECT p FROM Periodicite p")
    , @NamedQuery(name = "Periodicite.findByIssn", query = "SELECT p FROM Periodicite p WHERE p.issn = :issn")
    , @NamedQuery(name = "Periodicite.findByTypePeriodicite", query = "SELECT p FROM Periodicite p WHERE p.typePeriodicite = :typePeriodicite")
    , @NamedQuery(name = "Periodicite.findByValeurPeriodicite", query = "SELECT p FROM Periodicite p WHERE p.valeurPeriodicite = :valeurPeriodicite")})
public class Periodicite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "issn")
    private String issn;
    @Size(max = 255)
    @Column(name = "typePeriodicite")
    private String typePeriodicite;
    @Column(name = "valeurPeriodicite")
    private Integer valeurPeriodicite;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne
    private Bulletin id;

    public Periodicite() {
    }

    public Periodicite(String issn) {
        this.issn = issn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getTypePeriodicite() {
        return typePeriodicite;
    }

    public void setTypePeriodicite(String typePeriodicite) {
        this.typePeriodicite = typePeriodicite;
    }

    public Integer getValeurPeriodicite() {
        return valeurPeriodicite;
    }

    public void setValeurPeriodicite(Integer valeurPeriodicite) {
        this.valeurPeriodicite = valeurPeriodicite;
    }

    public Bulletin getId() {
        return id;
    }

    public void setId(Bulletin id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (issn != null ? issn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodicite)) {
            return false;
        }
        Periodicite other = (Periodicite) object;
        if ((this.issn == null && other.issn != null) || (this.issn != null && !this.issn.equals(other.issn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Periodicite[ issn=" + issn + " ]";
    }

}
