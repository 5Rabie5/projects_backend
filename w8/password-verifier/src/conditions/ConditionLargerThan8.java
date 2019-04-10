package conditions;

public class ConditionLargerThan8 implements Verification {

    @Override
    public Boolean condition(String password) {

        return password.length() > 8;
    }
}
