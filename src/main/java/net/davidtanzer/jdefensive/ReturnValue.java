package net.davidtanzer.jdefensive;

public class ReturnValue {
	public static final ReturnValue INSTANCE = new ReturnValue();

	public <T> T notNull(T value) {
		return Returns.notNull(value);
	}

	public String notEmpty(String value) {
		return Returns.notEmpty(value);
	}
}
