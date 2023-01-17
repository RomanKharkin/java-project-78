package hexlet.code.schemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    @Test
    void stringIsValid() {
        StringSchema schema = new StringSchema();

        assertTrue(schema.isValid("")); // true
// Пока на вызван метод required(), null считается валидным
        assertTrue(schema.isValid(null)); // true

        schema.required();

        assertTrue(schema.isValid("what does the fox say")); // true
        assertTrue(schema.isValid("hexlet")); // true
        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid(8)); // false
        schema.minLength(5);
        assertFalse(schema.isValid("vor")); // false
        assertTrue(schema.isValid("hexlet")); // true

        assertTrue(schema.contains("wh").isValid("what does the fox say")); // true
        assertTrue(schema.contains("what").isValid("what does the fox say")); // true
        assertFalse(schema.contains("whatthe").isValid("what does the fox say")); // false

        assertFalse(schema.isValid("what does the fox say")); // false
    }
}


