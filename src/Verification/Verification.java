package Verification;
import Strategies.Enter;
public class Verification {
    private int attempts = 0;
    private boolean isVerified = false;

    public void Verify(Enter strategy) {
        strategy.collectUserDetails();
        if(strategy.getAttempts() == 1){
            setAttempts();
        }
    }

    public void setAttempts() {
        this.attempts++;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified() {
        isVerified = true;
    }
}