import Strategies.*;
import Verification.Verification;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final Verification verification = new Verification();


    public static void main(String[] args) throws IOException {
        Enter strategy;
        while (!verification.isVerified()) {
                System.out.println("Please, select a verification method:" + "\n" +
                        "1 - Email + password" + "\n" +
                        "2 - Phone + password" + "\n" +
                        "3 - Github + secret key" + "\n" +
                        "4 - Login + password");
                String VerificationMethod = reader.readLine();
                if (VerificationMethod.equals("1")) {
                    strategy = new EnterByEmail();
                } else if(VerificationMethod.equals("2")){
                    strategy = new EnterByPhone();
                }
                else if(VerificationMethod.equals("3")){
                    strategy = new EnterByGithub();
                }
                else{
                    strategy = new EnterByLogin();
                }
                verification.Verify(strategy);
                if(strategy.getAttempts()!=1) {
                    verification.setVerified();
                }
    }
}}