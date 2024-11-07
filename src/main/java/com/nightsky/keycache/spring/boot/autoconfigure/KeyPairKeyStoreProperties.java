package com.nightsky.keycache.spring.boot.autoconfigure;

import java.security.KeyPair;
import java.security.KeyStore;
import java.time.Duration;
import java.util.Map;
import org.springframework.core.io.Resource;

/**
 *
 * @author Chris
 */
public class KeyPairKeyStoreProperties {

    /**
     * The location of the {@link KeyStore} containing the
     * {@link KeyPair KeyPairs}.
     */
    private Resource resource;

    /**
     * The location of the file containing the password for accessing the
     * {@link KeyStore}. If not specified,
     * {@link KeyPairKeyStoreProperties#password password} must be set.
     */
    private Resource passwordResource;

    /**
     * The password used to access the {@link KeyStore}. If not specified,
     * {@link KeyPairKeyStoreProperties#passwordResource passwordResource}
     * must be set.
     */
    private String password;

    /**
     * A {@link Map} containing the passwords used for accessing the individual
     * keys in the {@link KeyStore}. The {@code Map} keys are the aliases of
     * the {@link KeyPair KeyPairs} in the {@link KeyStore}. The
     * {@code Map} values are the locations of the files containing the
     * passwords used for accessing the corresponding
     * {@link KeyPair KeyPairs}.
     */
    private Map<String, Resource> keyPasswords;

    /**
     * The amount of time that the {@link KeyPair KeyPairs} should be
     * cached before being refreshed.
     */
    private Duration expireAfterWrite;

    /**
     * The type of the {@link KeyStore}. Either JCEKS or BCFKS.
     */
    private String keyStoreType;

    /**
     * The expected pattern of the key aliases in the {@link KeyStore}. This
     * pattern is used to extract the name of the key and the version of key
     * from the key alias.
     */
    private String keyNamePattern;

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
