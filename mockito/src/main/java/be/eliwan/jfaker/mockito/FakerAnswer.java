/*
 * This file is part of jFaker, a library to easily build fake objects for testing.
 * Copyright (c) Eliwan bvba, Belgium, http://eliwan.be
 *
 * The program is available in open source according to the Apache License, Version 2.0.
 * For full licensing details, see LICENSE.txt in the project root.
 */

package be.eliwan.jfaker.mockito;

import org.mockito.internal.stubbing.defaultanswers.ReturnsEmptyValues;
import org.mockito.invocation.InvocationOnMock;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Fake (default) answers for the mock object.
 */
public class FakerAnswer extends ReturnsEmptyValues {

    private Map<String, Object> defaultValues = new HashMap<String, Object>();

    /**
     * Build fake answers given field name and value pairs.
     *
     * @param keysAndValues field names and values
     */
    public FakerAnswer(Object... keysAndValues) {
        if (1 == keysAndValues.length % 2) {
            throw new IllegalArgumentException("Odd number of parameters, incomplete set of field names and values.");
        }
        for (int i = 0; i < keysAndValues.length; i += 2) {
            Object value = keysAndValues[i + 1];
            if (keysAndValues[i] instanceof String) {
                defaultValues.put(getGetterName((String) keysAndValues[i], value instanceof Boolean), value);
            } else {
                throw new IllegalArgumentException("Key " + keysAndValues[i] + " is not string.");
            }
        }
    }

    private String getGetterName(String fieldName, boolean isBoolean) {
        return (isBoolean ? "is" : "get") + capitalize(fieldName);
    }

    private String capitalize(String name) {
        return name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1);
    }

    @Override
    public Object answer(InvocationOnMock invocation) {
        Object defaultValue = defaultValues.get(invocation.getMethod().getName());
        if (null == defaultValue) {
            return super.answer(invocation);
        } else {
            return defaultValue;
        }
    }

}
