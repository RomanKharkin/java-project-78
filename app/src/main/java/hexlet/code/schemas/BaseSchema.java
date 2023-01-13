package hexlet.code.schemas;

import hexlet.code.tests.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class BaseSchema {

    protected List<Test> tests = new ArrayList();

    private List<Test> internalTests = new ArrayList();

    public boolean isValid(Object value) {
        return Stream.concat(internalTests.stream(), tests.stream()).allMatch((test) -> test.getTestFn().test(value));
    }

    protected BaseSchema required() {
        internalTests.add(nullableTest());
        return this;
    }

    private Test nullableTest() {
        return new Test() {
            @Override
            public String getName() {
                return "nullable";
            }

            @Override
            public Predicate getTestFn() {
                return (Object value) -> value != null;
            }
        };
    }
}
