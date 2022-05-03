package com.nightsky.keycache.spring.boot.autoconfigure;

import java.util.Map;

/**
 *
 * @author Chris
 */
public class KeyDictionary {

    private Map<String, Integer> keyCodes;

    private Map<String, String> keyNames;

    public KeyDictionary() {
    }

    /**
     * @return the keyCodes
     */
    public Map<String, Integer> getKeyCodes() {
        return keyCodes;
    }

    /**
     * @param keyCodes the keyCodes to set
     */
    public void setKeyCodes(Map<String, Integer> keyCodes) {
        this.keyCodes = keyCodes;
    }

    /**
     * @return the keyNames
     */
    public Map<String, String> getKeyNames() {
        return keyNames;
    }

    /**
     * @param keyNames the keyNames to set
     */
    public void setKeyNames(Map<String, String> keyNames) {
        this.keyNames = keyNames;
    }

}
