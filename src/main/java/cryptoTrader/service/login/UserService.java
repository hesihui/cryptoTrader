package cryptoTrader.service.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserService implements UserServiceInterFace {

    @Override
    public boolean authenticate(String userName, String password) {
        String record = null;
        FileReader in = null;
        try {
            in = new FileReader("userDB.txt");
            BufferedReader br = new BufferedReader(in);

            while ((record = br.readLine()) != null) {
                // Split line by a whitespace character
                // split[0] <- username
                // split[1] <- password
                String[] split = record.split("\\s");

                if (userName.equals(split[0]) && password.equals(split[1])) {
                    return true;
                    // You found the user, exit the loop
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

}
