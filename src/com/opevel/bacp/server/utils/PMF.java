/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opevel.bacp.server.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrator
 */
public class PMF {
    public PMF() {
        emf = Persistence.createEntityManagerFactory("BusinessWorkBookPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
