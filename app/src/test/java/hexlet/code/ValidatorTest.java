package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator v;
    @BeforeEach
    void setup() {
        v = new Validator();
    }

    @Test
    void string() {
        Assertions.assertTrue(v.string() instanceof StringSchema);
    }

    @Test
    void number() {
        Assertions.assertTrue(v.number() instanceof NumberSchema);
    }

    @Test
    void map() {
        Assertions.assertTrue(v.map() instanceof MapSchema);
    }
}
