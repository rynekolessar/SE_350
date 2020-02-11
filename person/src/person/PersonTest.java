package person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class PersonTest {

    @Test
    void testPersonConstructorRejectsInvalidTitle() {
        try {
            Person person1 = new Person("Ryne","boss", 14.00);
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(true);
        }
        fail();
    }
}