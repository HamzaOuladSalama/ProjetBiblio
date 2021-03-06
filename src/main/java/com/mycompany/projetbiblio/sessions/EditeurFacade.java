/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessions;

import entities.Editeur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oussama Messaoudi
 */
@Stateless
public class EditeurFacade extends AbstractFacade<Editeur> {

    @PersistenceContext(unitName = "biblioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EditeurFacade() {
        super(Editeur.class);
    }

}
