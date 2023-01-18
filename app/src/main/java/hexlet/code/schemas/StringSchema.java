package hexlet.code.schemas;

import hexlet.code.tests.Test;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    private String contString;

    private Integer minLength;

    public StringSchema required() {
        super.required();
        tests.add(requiredTest());
        return this;
    }

    public StringSchema minLength(Integer length) {
        this.minLength = length;
        tests.add(minLengthTest());
        return this;
    }

    public StringSchema contains(String cString) {
        this.contString = cString;
        tests.add(containsdTest());
        return this;
    }

    private Test requiredTest() {
        return new Test() {
            @Override
            public String getName() {
                return "required";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> value instanceof String && ((String) value).length() > 0;
            }
        };
    }

    private Test minLengthTest() {
        return new Test() {
            @Override
            public String getName() {
                return "minLength";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> value instanceof String && ((String) value).length() >= minLength;
            }
        };
    }

    private Test containsdTest() {
        return new Test() {
            @Override
            public String getName() {
                return "minLength";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> value instanceof String && ((String) value).contains(contString);
            }
        };
    }

}
