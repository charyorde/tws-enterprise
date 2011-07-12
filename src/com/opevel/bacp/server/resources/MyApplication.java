/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opevel.bacp.server.resources;

import com.sun.jersey.api.core.PackagesResourceConfig;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author Administrator
 */
@ApplicationPath("resources")
public class MyApplication extends PackagesResourceConfig{

    public MyApplication() {
        super("com.opevel.bacp.server.resources");
    }
}
