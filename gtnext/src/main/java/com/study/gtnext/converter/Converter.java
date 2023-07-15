package com.study.gtnext.converter;

public interface Converter<E,D> {
    E convert(D u);
    D reverseConvert(E i);
}
