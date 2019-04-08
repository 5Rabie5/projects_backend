package conditions;

public class ConditionNotNull implements Verification {

    public ConditionNotNull() {
    }

    @Override
    public Boolean condition(String password) {
        return !password.isBlank();
    }
}
