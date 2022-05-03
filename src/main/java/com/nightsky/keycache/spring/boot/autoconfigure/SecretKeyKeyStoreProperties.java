package com.nightsky.keycache.spring.boot.autoconfigure;

import org.springframework.core.io.Resource;

/**
 *
 * @author Chris
 */
public class SecretKeyKeyStoreProperties {

    private Resource resource;

    private String password;

    public SecretKeyKeyStoreProperties() {
    }

    /**
     * @return the resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
