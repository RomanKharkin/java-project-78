package hexlet.code.schemas;

import hexlet.code.tests.Test;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    private String contString;
    private int minLength;

    public StringSchema required() {
        tests.add(requiredTest());
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        tests.add(minLengthTest());
        return this;
    }



    public StringSchema contains(String subString) {
        this.contString = subString;
        tests.add(containsTest());
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
                return (Object value) -> value instanceof String && !((String) value).isEmpty();
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
                return (Object value) -> (value != null) && (value instanceof String) && (((String) value).length()
                                                                                                  >= minLength);
            }
        };
    }

    private Test containsTest() {
        return new Test() {
            @Override
            public String getName() {
                return "contains";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> (value != null) && (value instanceof String)
                                                 && ((String) value).contains(contString);
            }
        };
    }
}
