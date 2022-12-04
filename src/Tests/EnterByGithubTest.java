package Tests;

import Strategies.EnterByGithub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnterByGithubTest {

    @Test
    public void TestIncorrectGit() {
        EnterByGithub test1 = new EnterByGithub("","");
        test1.collectUserDetails();
        int e = test1.getAttempts();
        assertEquals(19,e);
    }
    @Test
    public void TestCorrectGit() {
        EnterByGithub test2 = new EnterByGithub( "glebgol","15");
        test2.collectUserDetails();
        int e = test2.getAttempts();
        assertEquals(18 ,e);
    }
}