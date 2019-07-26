/*
 *         File : Document.java
 *    Classname : Document
 *    Author(s) : eznlzhi
 *      Created : 2018-06-23
 *
 *
 */

package com.example.testpatterns.abstractdocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {

    Void put(String key, Object value);

    Object get(String key);

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
