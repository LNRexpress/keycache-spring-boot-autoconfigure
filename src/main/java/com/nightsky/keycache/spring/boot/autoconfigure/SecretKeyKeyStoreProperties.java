package com.nightsky.keycache.spring.boot.autoconfigure;

import java.time.Duration;
import java.util.Map;
import org.springframework.core.io.Resource;

/**
 *
 * @author Chris
 */
public class SecretKeyKeyStoreProperties {

    private Resource resource;

    private Resource passwordResource;

    private String password;

    private Map<String, Resource> keyPasswords;

    private Duration expireAfterWrite;

    private String keyStoreType;

    private String keyNamePattern;

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
     * @return the passwordResource
     */
    public Resource getPasswordResource() {
        return passwordResource;
    }

    /**
     * @param passwordResource the passwordResource to set
     */
    public void setPasswordResource(Resource passwordResource) {
        this.passwordResource = passwordResource;
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

    /**
     * @return the expireAfterWrite
     */
    public Duration getExpireAfterWrite() {
        return expireAfterWrite;
    }

    /**
     * @param expireAfterWrite the expireAfterWrite to set
     */
    public void setExpireAfterWrite(Duration expireAfterWrite) {
        this.expireAfterWrite = expireAfterWrite;
    }

    /**
     * @return the keyStoreType
     */
    public String getKeyStoreType() {
        return keyStoreType;
    }

    /**
     * @param keyStoreType the keyStoreType to set
     */
    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    /**
     * @return the keyNamePattern
     */
    public String getKeyNamePattern() {
        return keyNamePattern;
    }

    /**
     * @param keyNamePattern the keyNamePattern to set
     */
    public void setKeyNamePattern(String keyNamePattern) {
        this.keyNamePattern = keyNamePattern;
    }

}
