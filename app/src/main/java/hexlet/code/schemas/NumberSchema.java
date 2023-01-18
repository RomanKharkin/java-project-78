package hexlet.code.schemas;

import hexlet.code.tests.Test;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    private int limitBottom;
    private int limitTop;

    public NumberSchema required() {
        super.required();
        tests.add(requiredTest());
        return this;
    }

    public NumberSchema positive() {
        tests.add(positiveTest());
        return this;
    }

    public NumberSchema range(int limBottom, int limTop) {
        tests.add(rangeTest());
        this.limitBottom = limBottom;
        this.limitTop = limTop;
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
                return (Object value) -> value instanceof Integer;
            }
        };
    }

    private Test positiveTest() {
        return new Test() {
            @Override
            public String getName() {
                return "positive";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> value == null || (value instanceof Integer && ((Integer) value) > 0);
            }
        };
    }

    private Test rangeTest() {
        return new Test() {
            @Override
            public String getName() {
                return "range";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> (value != null) && (value instanceof Integer) && (((Integer) value)
                                                                                                   <= limitTop) && (
                        ((Integer) value) >= limitBottom);
            }
        };
    }
}

