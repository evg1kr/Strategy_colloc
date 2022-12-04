package Tests;

import Strategies.EnterByEmail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnterByEmailTest {
    @Test
    public void TestIncorrectEmail() {
        EnterByEmail test1 = new EnterByEmail("","");
        test1.collectUserDetails();
        int e = test1.getAttempts();
        assertEquals(19,e);
    }
    @Test
    public void TestCorrectEmail() {
        EnterByEmail test2 = new EnterByEmail( "amanda@ya.com","amanda1985");
        test2.collectUserDetails();
        int e = test2.getAttempts();
        assertEquals(18 ,e);
    }
}