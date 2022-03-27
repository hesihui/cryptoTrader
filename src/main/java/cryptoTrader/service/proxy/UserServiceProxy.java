package cryptoTrader.service.proxy;

import cryptoTrader.service.interFace.UserServiceInterFace;
import cryptoTrader.service.UserService;

public class UserServiceProxy implements UserServiceInterFace {

    @Override
    public boolean authenticate(String userName, String password) {

        UserService authen = new UserService();
        return authen.authenticate(userName, password);
    }

}
