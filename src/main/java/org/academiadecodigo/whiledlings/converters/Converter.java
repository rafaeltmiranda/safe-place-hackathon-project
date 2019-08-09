package org.academiadecodigo.whiledlings.converters;

public interface Converter<T, S> {

    T convert(S object);
}
