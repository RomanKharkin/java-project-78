package hexlet.code.schemas;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected final List<Predicate> tests = new ArrayList<>();

    protected final void addTest(Predicate test) {
        tests.add(test);
    }


    public final boolean isValid(Object value) {
        return tests.stream().allMatch((predicate) -> predicate.test(value));
    }
}
