package nullobject;

import java.util.Date;

public abstract class Employee {
    public abstract boolean isTimeToPay(Date time);

    public abstract void pay();

    public static final Employee NULL = new NullEmployee();

    private static class NullEmployee extends Employee {
        @Override
        public boolean isTimeToPay(Date time) {
            return false;
        }

        @Override
        public void pay() {
        }
    }
}
