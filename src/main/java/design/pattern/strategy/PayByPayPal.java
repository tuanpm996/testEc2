package design.pattern.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("tuanpm", "tuanpm996@gmail.com");
        DATA_BASE.put("tuansieunhan", "tuansieunhan@gmail.com");

    }

    @Override
    public boolean pay(int paymentAmount) {
        return false;
    }

    @Override
    public void collectPaymentDetails() throws IOException {
        while (!signedIn) {
            System.out.println("Enter the user's email: ");
            email = READER.readLine();
            System.out.println("Enter the password: ");
            password = READER.readLine();
            if (verify()) {
                System.out.println("Data verification has been successful");
            } else {
                System.out.println("Wrong email or password");
            }
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
