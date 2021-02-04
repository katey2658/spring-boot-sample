package com.busyzero.demo.consul.service.impl;

import com.busyzero.demo.stream.service.OrganizationService;
import com.busyzero.demo.stream.stream.SimpleSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private SimpleSourceBean simpleSourceBean;

    public void sendMessage(String message) {
        simpleSourceBean.publishOrgChange("send", message);
    }
}
