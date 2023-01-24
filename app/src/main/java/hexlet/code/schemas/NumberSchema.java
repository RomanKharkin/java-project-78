package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addTest(value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addTest(value -> Objects.isNull(value) || (value instanceof Integer && ((Integer) value) > 0));
        return this;
    }

    public NumberSchema range(int min, int max) {
        addTest(value -> ((Integer) value <= max) && ((Integer) value) >= min);
        return this;
    }
}
