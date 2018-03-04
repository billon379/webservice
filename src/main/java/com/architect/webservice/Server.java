package com.architect.webservice;

import com.architect.webservice.service.cxf.CxfJaxUserService;
import com.architect.webservice.service.cxf.CxfRestUserService;
import com.architect.webservice.service.jax.JaxUserService;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.xml.ws.Endpoint;

/**
 * webservice server
 */
public class Server {
    public static void main(String[] args) {
        publishJaxEndpoint(); //使用JAX-WS的Endpoint发布webservice
        publishCxfJaxWs(); //使用CXF JAX-WS发布webservice
        publishCxfJaxRs(); //使用CXF JAX-RS发布webservice
    }

    /**
     * 使用JAX-WS的Endpoint发布webservice
     */
    public static void publishJaxEndpoint() {
        Endpoint.publish("http://127.0.0.1:10000/jax/user", new JaxUserService());
        System.out.println("publishJaxEndpoint ====> http://127.0.0.1:10000/jax/user?wsdl");
    }

    /**
     * 使用CXF JAX-WS发布webservice
     */
    public static void publishCxfJaxWs() {
        JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
        jaxWsServerFactoryBean.setServiceClass(CxfJaxUserService.class);
        jaxWsServerFactoryBean.setAddress("http://127.0.0.1:10000/cxf/jax/user");
        org.apache.cxf.endpoint.Server server = jaxWsServerFactoryBean.create();
        server.start();
        System.out.println("publishCxfJaxWs ====> http://127.0.0.1:10000/cxf/jax/user?wsdl");
    }

    /**
     * 使用CXF JAX-RS发布webservice
     */
    public static void publishCxfJaxRs() {
        JAXRSServerFactoryBean jaxrsServerFactoryBean = new JAXRSServerFactoryBean();
        jaxrsServerFactoryBean.setAddress("http://127.0.0.1:10000/cxf/rest/");
        jaxrsServerFactoryBean.setResourceClasses(CxfRestUserService.class);
        jaxrsServerFactoryBean.setServiceBean(new CxfRestUserService());
        jaxrsServerFactoryBean.create();
        System.out.println("publishCxfJaxRs ====> http://127.0.0.1:10000/cxf/rest/");
    }
}
