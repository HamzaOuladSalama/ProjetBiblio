/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessions;

import entities.Bulletin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oussama Messaoudi
 */
@Stateless
public class BulletinFacade extends AbstractFacade<Bulletin> {

    @PersistenceContext(unitName = "biblioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BulletinFacade() {
        super(Bulletin.class);
    }

}
