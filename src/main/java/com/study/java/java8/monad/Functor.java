package com.study.java.java8.monad;

import java.util.function.Function;

/**
 * Created by yan on  12/11/2018.
 * https://dzone.com/articles/functor-and-monad-examples-in-plain-java
 */
public interface Functor <T,F extends Functor<?,?>> {
    <R> F map(Function<T,R> f);
}

class Identity<T> implements Functor<T,Identity<?>> {
    private final T value;
    Identity(T value) { this.value = value; }
    public <R> Identity<R> map(Function<T,R> f) {
        final R result = f.apply(value);
        return new Identity<>(result);
    }
}
