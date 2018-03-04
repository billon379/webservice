package com.architect.webservice.service.jax;

import com.architect.webservice.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by BaiYuliang on 2017/7/1.
 */
@WebService(name = "jaxUserInterface", serviceName = "jaxUserService")
public class JaxUserService {

    @WebMethod
    public User queryUser(@WebParam(name = "name") String name) {
        User u = new User();
        u.setName(name);
        u.setAge((int) (Math.random() * 30));
        return u;
    }
}
