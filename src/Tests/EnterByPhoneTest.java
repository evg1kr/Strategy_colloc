package Tests;

import Strategies.EnterByPhone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnterByPhoneTest {

    @Test
    public void TestIncorrectPhone() {
        EnterByPhone test1 = new EnterByPhone("","");
        test1.collectUserDetails();
        int e = test1.getAttempts();
        assertEquals(19,e);
    }
    @Test
    public void TestCorrectPhone() {
        EnterByPhone test2 = new EnterByPhone( "+375285648390","123456");
        test2.collectUserDetails();
        int e = test2.getAttempts();
        assertEquals(18 ,e);
    }
}