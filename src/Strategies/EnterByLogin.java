package Strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class EnterByLogin implements Enter {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String login;
    private String password;
    boolean testing = false;
    public EnterByLogin(){
    }
    public EnterByLogin(String a, String b){
        login = a;
        password = b;
        testing = true;
    }
    private int attempts = 0;
    private boolean signedIn;

    static {
        DATA_BASE.put("superpassword123", "napkin");
        DATA_BASE.put("Unbreakable", "dinosaur");
    }
    @Override
    public void collectUserDetails() {
        if(testing){
            if (verify()){
                attempts = 18;
            }
            else{
                attempts = 19;
            }
        }
        else{
        try {
            while (!signedIn && attempts != 1) {
                System.out.print("Enter the user's login: ");
                login = READER.readLine();
                System.out.print("Enter the password: ");
                password = READER.readLine();
                if (verify()) {
                    System.out.println("Data verification has been successful.");
                } else {
                    System.out.println("Wrong login or password!");
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
        setSignedIn(login.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}