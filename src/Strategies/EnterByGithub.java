package Strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EnterByGithub implements Enter {
    private static final Map<String,String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String github_login;
    private int attempts = 0;
    boolean testing = false;
    public EnterByGithub(){}
    public EnterByGithub(String a, String b){
        github_login = a;
        secret_key = b;
        testing = true;
    }
    private String secret_key;
    private boolean signedIn;

    static {
        DATA_BASE.put("glebgol" , "15");
        DATA_BASE.put("superboy112" , "84");
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
                    System.out.print("Enter the user's github login: ");
                    github_login = READER.readLine();
                    System.out.print("Enter the secret key: ");
                    secret_key = READER.readLine();
                    if (verify()) {
                        System.out.println("Data verification has been successful.");
                    } else {
                        System.out.println("Wrong github login or secret key!");
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
        setSignedIn(secret_key.equals(DATA_BASE.get(github_login)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
