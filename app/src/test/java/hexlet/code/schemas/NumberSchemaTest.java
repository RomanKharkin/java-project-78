package hexlet.code.schemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {

    @Test
    void NumberIsValid() {

        NumberSchema schema = new NumberSchema();

// Пока не вызван метод required(), null считается валидным
        assertTrue(schema.isValid("7")); // true
        assertTrue(schema.isValid(null)); // true
        assertTrue(schema.positive().isValid(null)); // true
        assertFalse(schema.isValid("7")); // false

        schema.required();

        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid("7")); // false
        assertTrue(schema.isValid(10)); // true
        assertFalse(schema.isValid("5")); // false
        assertFalse(schema.isValid(-10)); // false
//  Ноль - не положительное число
        assertFalse(schema.isValid(0)); // false

        schema.range(5, 10);

        assertFalse(schema.isValid("7")); // false
        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(10)); // true
        assertFalse(schema.isValid(4)); // false
        assertFalse(schema.isValid(11)); // false
    }
}
