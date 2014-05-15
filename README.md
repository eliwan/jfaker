jfaker
======

jFaker allows you to easily build fake objects for testing using easily configurable fake data. It can build either plain objects or mockito mocks.

Instead of doing something like

    Person person = Mockito.mock(Person.class);
    Mockito.when(person.getName()).thenReturn("John");

use

    Person person = FakerMock.withFields(Person.class, "name", "John");


Dependencies
------------

jFaker can be found on maven central.

    <dependency>
        <groupId>be.eliwan</groupId>
        <artifactId>jfaker-mockito</artifactId>
        <version>0.1</version>
    </dependency>
