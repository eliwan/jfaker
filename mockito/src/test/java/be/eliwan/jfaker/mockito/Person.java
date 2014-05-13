/*
 * This file is part of jFaker, a library to easily build fake objects for testing.
 * Copyright (c) Eliwan bvba, Belgium, http://eliwan.be
 *
 * The program is available in open source according to the Apache License, Version 2.0.
 * For full licensing details, see LICENSE.txt in the project root.
 */

package be.eliwan.jfaker.mockito;

import lombok.Data;

/**
 * A person object for testing.
 */
@Data
public class Person {

    private String name;
    private String nameMother;
    private String nameFather;
    private String address;
    private String zip;
    private String location;
    private int age;
    private int numberOfChildren;
    private boolean single;

}
