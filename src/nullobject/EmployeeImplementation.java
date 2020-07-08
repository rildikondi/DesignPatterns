package nullobject;

import java.util.Date;

public class EmployeeImplementation extends Employee {
    @Override
    public boolean isTimeToPay(Date time) {
        return false;
    }

    @Override
    public void pay() {

    }
}
