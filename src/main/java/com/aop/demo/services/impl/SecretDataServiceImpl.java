package com.aop.demo.services.impl;

import com.aop.demo.annotations.SecureAndCache;
import com.aop.demo.aspects.CacheAspect;
import com.aop.demo.services.SecretDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecretDataServiceImpl implements SecretDataService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SecretDataServiceImpl.class);

    @SecureAndCache
    @Override
    public String getSecrets() {
        LOGGER.info("Implementing the actual method for getting secrets.");
        return "SECRETS";
    }
}
