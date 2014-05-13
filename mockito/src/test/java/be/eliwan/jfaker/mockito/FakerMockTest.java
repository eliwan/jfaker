package be.eliwan.jfaker.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test for FakerMock and FakerAnswer.
 */
public class FakerMockTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testWithFields() throws Exception {
        Person person = FakerMock.withFields(Person.class,
                "name", "John Doe",
                "single", true,
                "address", "Church Street 12",
                "numberOfChildren", 2
        );

        assertThat(person.getName()).isEqualTo("John Doe");
        assertThat(person.isSingle()).isTrue();
        assertThat(person.getAddress()).isEqualTo("Church Street 12");
        assertThat(person.getNumberOfChildren()).isEqualTo(2);
        assertThat(person.getLocation()).isNull();
    }

    @Test
    public void testWithField_nameWithoutValue() throws Exception {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Odd number of parameters, incomplete set of field names and values.");

        FakerMock.withFields(Person.class, "name");
    }

    @Test
    public void testWithField_nameIsNotString() throws Exception {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key 1 is not string.");

        FakerMock.withFields(Person.class, 1, 2);
    }

}