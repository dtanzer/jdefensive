package net.davidtanzer.jdefensive;

import java.util.function.Function;
import java.util.function.Predicate;

public class Assert {
	public static <T, E extends Throwable> void is(T value, Predicate<T> predicate, Function<T, E> error) throws E {
		if(!predicate.test(value)) {
			throw error.apply(value);
		}
	}
	
	public static <T> ReportingPredicate<T> notNull(final String valueName) {
		return new ReportingPredicate<T>() {
			@Override
			public boolean test(final T value) {
				return value != null;
			}
			
			@Override
			public RuntimeException reportError(final T value) {
				return new RuntimeException("Expected \""+valueName+"\" to be not null, but was null");
			}
		};
	}
	
	public static <T extends String> ReportingPredicate<T> notEmpty(final String valueName) {
		return new ReportingPredicate<T>() {
			@Override
			public boolean test(final T value) {
				return value != null && value.length() > 0;
			}
			
			@Override
			public RuntimeException reportError(final T value) {
				return new RuntimeException("Expected \""+valueName+"\" to be not empty, but was \""+value+"\".");
			}
		};
	}
	
	public static <T> RunnableAction when(T value, ReportingPredicate<T> predicate) {
		return new RunnableAction(value, predicate);
	}
}
