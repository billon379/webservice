package com.architect.webservice.service.cxf;

import com.architect.webservice.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by BaiYuliang on 2017/7/1.
 */
@Path("/user")
@Produces("application/json;charset=utf-8")
public class CxfRestUserService {

    @GET
    @Path("/{name}")
    public User queryUser(@PathParam("name") String name) {
        User u = new User();
        u.setName(name);
        u.setAge((int) (Math.random() * 30));
        return u;
    }
}
