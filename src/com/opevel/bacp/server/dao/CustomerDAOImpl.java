/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opevel.bacp.server.dao;

import com.opevel.bacp.server.domain.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.transaction.annotation.Transactional;


/**
 * Spring-enabled DAO to handle all transactional data access
 * 
 * @author Administrator
 */
//@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    // We will use the @PersistenceContext if we define jpa configs in Spring bean.
    // For now, let's do it the traditional way
    /*@PersistenceContext
	private EntityManager em;*/

    public CustomerDAOImpl() {
        emf = Persistence.createEntityManagerFactory("BACP-PU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public Customer findCustomer(Integer id) {
       EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }
}
