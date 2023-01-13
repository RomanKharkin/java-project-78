package hexlet.code.tests;

import java.util.function.Predicate;

public interface Test {
    String getName();
    Predicate getTestFn();
}
