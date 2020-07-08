package nullobject;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class EmployeeTest {

    @Test
    public void testNull() {
        Employee e = DB.getEmployee("Bob");
        if (e.isTimeToPay(new Date()))
            Assert.fail();
        Assert.assertSame(Employee.NULL, e);
    }
}
