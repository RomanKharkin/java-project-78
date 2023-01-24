package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addTest(value -> value instanceof Map);
        return this;
    }

    public MapSchema sizeof(Integer sizeof) {
        addTest(value -> ((Map) value).size() == sizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> shape) {
        addTest(value -> {
            return shape.keySet().stream()
                           .map((key) -> {
                               return shape.get(key).isValid(((Map) value).get(key)); })
                           .allMatch((isValid) -> isValid);
        });
        return this;
    }
}
