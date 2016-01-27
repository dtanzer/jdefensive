package net.davidtanzer.jdefensive;

public interface Invariant {
	Invariant NONE = () -> {};

	void assertInvariant();

	static ReturnValue withInvariant(final Invariant invariant) {
		invariant.assertInvariant();
		return ReturnValue.INSTANCE;
	}
}
