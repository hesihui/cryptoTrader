package cryptoTrader.service;

import cryptoTrader.service.interFace.UserServiceInterFace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService implements UserServiceInterFace {

    @Override
    public boolean authenticate(String userName, String password) {
        String record = null;
        FileReader in = null;
        try {
            in = new FileReader("userDB.txt");
            BufferedReader br = new BufferedReader(in);
//            Scanner keyboard = new Scanner(System.in);

//            System.out.print("Username: ");
//            String user = keyboard.nextLine();
//
//            System.out.print("Password: ");
//            String pass = keyboard.nextLine();

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
