package com.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-12-8
 * Time: 下午12:42
 * To change this template use File | Settings | File Templates.
 */
@WebService
public interface IHelloWorld {
    @WebMethod
    public String sayHello(@WebParam(name = "username") String username);
}
