package com.nightsky.keycache.spring.boot.autoconfigure;

import java.util.Map;
import org.springframework.core.io.Resource;

/**
 *
 * @author Chris
 */
public class SecretKeyKeyStoreProperties {

    private Resource resource;

    private String password;

    private Map<String, Resource> keyPasswords;

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

    /**
     * @return the keyPasswords
     */
    public Map<String, Resource> getKeyPasswords() {
        return keyPasswords;
    }

    /**
     * @param keyPasswords the keyPasswords to set
     */
    public void setKeyPasswords(Map<String, Resource> keyPasswords) {
        this.keyPasswords = keyPasswords;
    }

}
