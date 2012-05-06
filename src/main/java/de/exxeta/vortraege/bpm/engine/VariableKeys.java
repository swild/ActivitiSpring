package de.exxeta.vortraege.bpm.engine;

public enum VariableKeys {

    TWITTER_MESSAGE("twitterMessage");

    private String key;

    private VariableKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
