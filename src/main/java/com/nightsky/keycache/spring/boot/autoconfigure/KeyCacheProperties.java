package com.nightsky.keycache.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Chris
 */
@ConfigurationProperties(prefix = "keycache")
public class KeyCacheProperties {

    private SecretKeyKeyStoreProperties secretKeyKeyStore;

    private KeyPairKeyStoreProperties keyPairKeyStore;

    public KeyCacheProperties() {
    }

    /**
     * @return the secretKeyKeyStore
     */
    public SecretKeyKeyStoreProperties getSecretKeyKeyStore() {
        return secretKeyKeyStore;
    }

    /**
     * @param secretKeyKeyStore the secretKeyKeyStore to set
     */
    public void setSecretKeyKeyStore(SecretKeyKeyStoreProperties secretKeyKeyStore) {
        this.secretKeyKeyStore = secretKeyKeyStore;
    }

    /**
     * @return the keyPairKeyStore
     */
    public KeyPairKeyStoreProperties getKeyPairKeyStore() {
        return keyPairKeyStore;
    }

    /**
     * @param keyPairKeyStore the keyPairKeyStore to set
     */
    public void setKeyPairKeyStore(KeyPairKeyStoreProperties keyPairKeyStore) {
        this.keyPairKeyStore = keyPairKeyStore;
    }

}
