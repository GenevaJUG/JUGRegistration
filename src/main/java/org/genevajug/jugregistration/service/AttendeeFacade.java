/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genevajug.jugregistration.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.genevajug.jugregistration.entity.Attendee;

/**
 *
 * @author codingdojo
 */
@Stateless
public class AttendeeFacade extends AbstractFacade<Attendee> {
    @PersistenceContext(unitName = "org.genevajug_JUGRegistration_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AttendeeFacade() {
        super(Attendee.class);
    }
    
}
