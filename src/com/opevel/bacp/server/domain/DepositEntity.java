/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opevel.bacp.server.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Administrator
 */
@Entity
public class DepositEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
