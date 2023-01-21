package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addTest(value -> value instanceof String && ((String) value).length() > 0);
        return this;
    }

    public StringSchema minLength(Integer minLength) {
        addTest(value -> Objects.isNull(value)  || value instanceof String && ((String) value).length() >= minLength);
        return this;
    }

    public StringSchema contains(String contString) {
        addTest(value ->  Objects.isNull(value) || value instanceof String && ((String) value).contains(contString));
        return this;
    }
}
