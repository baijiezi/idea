package com.admin.jxc.service;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {


    @Autowired
    protected MapperFacade mapper;


}
