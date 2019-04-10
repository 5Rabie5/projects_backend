package conditions;

public class ConditionNotNull implements Verification {

    @Override
    public Boolean condition(String password) {

        return password != null;
    }
}
