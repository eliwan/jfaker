/*
 * This file is part of jFaker, a library to easily build fake objects for testing.
 * Copyright (c) Eliwan bvba, Belgium, http://eliwan.be
 *
 * The program is available in open source according to the Apache License, Version 2.0.
 * For full licensing details, see LICENSE.txt in the project root.
 */

package be.eliwan.jfaker.mockito;

import org.mockito.Mockito;

/**
 * Build fake mock objects.
 */
public final class FakerMock {

    private FakerMock() {
        // hide constructor
    }

    /**
     * Create a mock object with given field values.
     *
     * @param <T> return type
     * @param clazz mock ype
     * @param keysAndValues keys and values for the object.
     * @return mock object
     */
    public static <T> T withFields(Class<T> clazz, Object... keysAndValues) {
        return Mockito.mock(clazz, new FakerAnswer(keysAndValues));
    }

}