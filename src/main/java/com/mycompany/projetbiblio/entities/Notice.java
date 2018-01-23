/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oussama Messaoudi
 */
@Entity
@Table(name = "notice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notice.findAll", query = "SELECT n FROM Notice n")
    , @NamedQuery(name = "Notice.findByCategorie", query = "SELECT n FROM Notice n WHERE n.categorie = :categorie")
    , @NamedQuery(name = "Notice.findByDatePublication", query = "SELECT n FROM Notice n WHERE n.datePublication = :datePublication")
    , @NamedQuery(name = "Notice.findByLangue", query = "SELECT n FROM Notice n WHERE n.langue = :langue")
    , @NamedQuery(name = "Notice.findByMotscle", query = "SELECT n FROM Notice n WHERE n.motscle = :motscle")
    , @NamedQuery(name = "Notice.findByResume", query = "SELECT n FROM Notice n WHERE n.resume = :resume")
    , @NamedQuery(name = "Notice.findBySousTitre", query = "SELECT n FROM Notice n WHERE n.sousTitre = :sousTitre")
    , @NamedQuery(name = "Notice.findByTitre", query = "SELECT n FROM Notice n WHERE n.titre = :titre")
    , @NamedQuery(name = "Notice.findByUrl", query = "SELECT n FROM Notice n WHERE n.url = :url")
    , @NamedQuery(name = "Notice.findById", query = "SELECT n FROM Notice n WHERE n.id = :id")})
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "categorie")
    private String categorie;
    @Size(max = 255)
    @Column(name = "datePublication")
    private String datePublication;
    @Size(max = 255)
    @Column(name = "langue")
    private String langue;
    @Size(max = 255)
    @Column(name = "motscle")
    private String motscle;
    @Size(max = 255)
    @Column(name = "resume")
    private String resume;
    @Size(max = 255)
    @Column(name = "sousTitre")
    private String sousTitre;
    @Size(max = 255)
    @Column(name = "titre")
    private String titre;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @ManyToMany(mappedBy = "noticeList")
    private List<Auteur> auteurList;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Livre livre;

    public Notice() {
    }

    public Notice(Integer id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getMotscle() {
        return motscle;
    }

    public void setMotscle(String motscle) {
        this.motscle = motscle;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Auteur> getAuteurList() {
        return auteurList;
    }

    public void setAuteurList(List<Auteur> auteurList) {
        this.auteurList = auteurList;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
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
        if (!(object instanceof Notice)) {
            return false;
        }
        Notice other = (Notice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Notice[ id=" + id + " ]";
    }

}
