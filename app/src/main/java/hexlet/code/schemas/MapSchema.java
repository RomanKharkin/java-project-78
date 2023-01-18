package hexlet.code.schemas;

import hexlet.code.tests.Test;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    private Integer sizeof;

    public MapSchema required() {
        super.required();
        tests.add(requiredTest());
        return this;
    }

    public MapSchema sizeof(Integer length) {
        this.sizeof = length;
        tests.add(sizeofTest());
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
                return (Object value) -> value instanceof Map;
            }
        };
    }

    private Test sizeofTest() {
        return new Test() {
            @Override
            public String getName() {
                return "sizeof";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> value instanceof Map && ((Map) value).size() == sizeof;
            }
        };
    }
}

