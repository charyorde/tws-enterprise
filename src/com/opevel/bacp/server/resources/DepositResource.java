/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opevel.bacp.server.resources;

import com.opevel.bacp.server.dao.CustomerDAOImpl;
import com.opevel.bacp.server.domain.Customer;
import com.opevel.bacp.server.domain.DepositEntity;
import com.sun.jersey.spi.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Path("/deposit")
@Component
public class DepositResource {

    // Inject Spring beans into jersey resource
    @Inject private DepositEntity depositentity;
    @Inject private CustomerDAOImpl customer;

    @GET
    public String get() {
        return "This is /deposit resource";
    }
    
    @PUT
    public DepositEntity AddFreshDeposit() {
        return depositentity;
    }

    @GET
    @Path("{accountNumber}")
    @Produces("text/plain")
    public Customer getAccountByAccountNumber(@PathParam("accountNumber")Integer accountNumber) {
        // With Spring @Component we will inject the CustomerDAO so we can call findCustomer
        Customer cust = customer.findCustomer(accountNumber);
        return cust;
    }


}
