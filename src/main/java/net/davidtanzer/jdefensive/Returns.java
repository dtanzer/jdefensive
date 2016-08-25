package net.davidtanzer.jdefensive;

public class Returns {
	public static <T> T notNull(final T value) {
		Assert.is(value, v -> v != null, v -> new IllegalReturnValueException("This method must always return a non-null value!"));
		return value;
	}

	public static String notEmpty(final String value) {
		Assert.is(value, v -> v != null && !v.isEmpty(), v -> new IllegalReturnValueException("This method must always return a non-empty String, but the return value was: \""+v+"\"!"));
		return value;
	}
}
