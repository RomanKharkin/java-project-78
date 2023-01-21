package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    void setupSchema() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    void stringIsValid() {
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

    @Test
    @DisplayName("Проверка валидатора minLength")
    void minLegthTest() {
        schema.minLength(5);

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("hello"));
        assertTrue(schema.isValid("eleven"));

        assertFalse(schema.isValid(5));
        assertFalse(schema.isValid("six"));
    }

    @Test
    @DisplayName("Проверка валидатора contains")
    void containsTest() {
        schema.contains("ll");

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("hello"));
        assertTrue(schema.isValid("elleven"));

        assertFalse(schema.isValid(5));
        assertFalse(schema.isValid("six"));
    }
}

