package com.cxf;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-12-8
 * Time: 下午12:42
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldImpl implements IHelloWorld {

    //http://localhost:8080/cxf-spring/webservice/cxfService?wsdl
    //http://localhost:8080/cxf-spring/webservice/cxfService/sayHello?username=123
    @Override
    public String sayHello(String username) {
        return "Hello " + username;
    }

}
