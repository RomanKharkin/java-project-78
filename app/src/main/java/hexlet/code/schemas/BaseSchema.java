package hexlet.code.schemas;

import hexlet.code.tests.Test;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema {

    protected final List<Test> tests = new ArrayList();

    public final boolean isValid(Object value) {
        return tests.stream().allMatch((test) -> test.getTestFn().test(value));
    }
}
