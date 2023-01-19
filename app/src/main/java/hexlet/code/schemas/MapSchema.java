package hexlet.code.schemas;

import hexlet.code.tests.Test;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    private Integer sizeof;
    private Map<String, BaseSchema> shape;

    public MapSchema required() {
        tests.add(requiredTest());
        return this;
    }

    public MapSchema sizeof(Integer length) {
        this.sizeof = length;
        tests.add(sizeofTest());
        return this;
    }

    public MapSchema shape(Map inputShape) {
        this.shape = inputShape;
        tests.add(shapeTest());
        return this;
    }

    private Test shapeTest() {
        return new Test() {
            @Override
            public String getName() {
                return "shapeTest";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> {
                    return value instanceof Map && shape.keySet().stream()
                                                           .map((key) -> {
                                                               return shape.get(key).isValid(((Map) value).get(key));
                                                           })
                                                           .allMatch((isValid) -> isValid);
                };
            }
        };
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
