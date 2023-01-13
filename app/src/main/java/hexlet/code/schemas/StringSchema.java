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
        return isRequiredValid(inputString) && isContainsValid(inputString);
    }

    public boolean isValid(Object ignoredInputString) {
        return false;
    }

    private boolean isRequiredValid(String inputString) {
        if (isRequired) {
            return inputString != null && !inputString.isEmpty();
        }
        return true;
    }

    private boolean isContainsValid(String inputString) {
        return !isContains || inputString.contains(contString);
    }
}
