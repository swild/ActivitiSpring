package de.exxeta.vortraege.bpm.engine;

public enum ProcessKeys {
	
	HELLO_WORLD("helloWorld"),
	TWITTER_PROCESS("twitterProcess");
	
	private String key;
	
	private ProcessKeys(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
