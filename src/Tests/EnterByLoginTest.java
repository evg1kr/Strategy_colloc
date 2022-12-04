package Tests;

import Strategies.EnterByLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EnterByLoginTest {
    @Test
    public void TestIncorrectLogin() {
        EnterByLogin test1 = new EnterByLogin("","");
        test1.collectUserDetails();
        int e = test1.getAttempts();
        assertEquals(19,e);
    }
    @Test
    public void TestCorrectLogin() {
        EnterByLogin test2 = new EnterByLogin("napkin" , "superpassword123");
        test2.collectUserDetails();
        int e = test2.getAttempts();
        assertEquals(18 ,e);
    }
}