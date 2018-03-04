package com.architect.webservice.service.cxf;

import com.architect.webservice.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by BaiYuliang on 2017/7/1.
 */
@WebService(name = "cxfJaxUserInterface", serviceName = "cxfJaxUserService")
public class CxfJaxUserService {

    @WebMethod
    public User queryUser(@WebParam(name = "name") String name) {
        User u = new User();
        u.setName(name);
        u.setAge((int) (Math.random() * 30));
        return u;
    }
}
