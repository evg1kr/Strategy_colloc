package Strategies;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EnterByPhone implements Enter {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String phone_number;
    private String password;
    boolean testing = false;
    public EnterByPhone(){}
    public EnterByPhone(String a, String b){
        phone_number = a;
        password = b;
        testing = true;
    }
    private int attempts = 0;
    private boolean signedIn;

    static {
        DATA_BASE.put("123456", "+375285648390");
        DATA_BASE.put("somepassword", "+375154411220");
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
                    System.out.print("Enter the user's phone: ");
                    phone_number = READER.readLine();
                    System.out.print("Enter the password: ");
                    password = READER.readLine();
                    if (verify()) {
                        System.out.println("Data verification has been successful.");
                    } else {
                        System.out.println("Wrong phone or password!");
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
        setSignedIn(phone_number.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}