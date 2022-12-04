package Strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EnterByEmail implements Enter {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private int attempts = 0;
    boolean testing = false;
    public EnterByEmail(){}
    public EnterByEmail(String a, String b){
        email = a;
        password = b;
        testing = true;
    }
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    @Override
    public void collectUserDetails() {
        if(testing){
            if (verify()){
                attempts=18;
            }
            else{
                attempts=19;
            }
        }else {
            try {
                while (!signedIn && attempts != 1) {
                    System.out.print("Enter the user's email: ");
                    email = READER.readLine();
                    System.out.print("Enter the password: ");
                    password = READER.readLine();
                    if (verify()) {
                        System.out.println("Data verification has been successful.");
                    } else {
                        System.out.println("Wrong email or password!");
                        System.out.println("Enter 1 if you want to try another type of verification");
                        attempts = Integer.parseInt(READER.readLine());
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Override
    public int getAttempts(){
        return attempts;
    }
    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}