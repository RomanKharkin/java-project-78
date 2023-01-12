package hexlet.code.schemas;

public class StringSchema {

    private boolean isRequired = false;
    private boolean isContains = false;
    private String contString;

    public StringSchema() {
    }

    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema contains(String subString) {
        isContains = true;
        this.contString = subString;
        return this;
    }

    public boolean isValid(String inputString) {
        if (isRequired) {
            if (inputString == null || inputString.isEmpty()) {
                return false;
            }
        }
        if (isContains && !inputString.contains(contString)) {
            return false;
        }
        return  true;
    }

    public boolean isValid(Object inputString) {
        return false;
    }
}
