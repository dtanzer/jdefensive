package net.davidtanzer.jdefensive;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RunnableAction<T> {
	private final T value;
	private final ReportingPredicate<T> predicate;
	
	public RunnableAction(final T value, final ReportingPredicate<T> predicate) {
		this.value = value;
		this.predicate = predicate;
	}
	
	public void then(final Consumer<T> consumer) {
		if(predicate.test(value)) {
			consumer.accept(value);
		} else {
			throw predicate.reportError(value);
		}
	}
	
	public void then(final Runnable consumer) {
		if(predicate.test(value)) {
			consumer.run();
		} else {
			throw predicate.reportError(value);
		}
	}
}
