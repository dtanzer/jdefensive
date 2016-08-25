package net.davidtanzer.jdefensive;

import java.util.function.Predicate;

public interface ReportingPredicate<T> extends Predicate<T> {
	default RuntimeException reportError(T value) {
		return new RuntimeException("The value \""+value+"\" does not fulfill this predicate.");
	}
}
