package cryptoTrader.service.login;

import cryptoTrader.service.login.UserServiceInterFace;
import cryptoTrader.service.login.UserService;

public class UserServiceProxy implements UserServiceInterFace {

    @Override
    public boolean authenticate(String userName, String password) {

        UserService authen = new UserService();
        return authen.authenticate(userName, password);
    }

}
