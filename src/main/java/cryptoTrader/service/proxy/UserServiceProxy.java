package cryptoTrader.service.proxy;

import cryptoTrader.service.interFace.UserServiceInterFace;

public class UserServiceProxy implements UserServiceInterFace {

    @Override
    public boolean authenticate() {
        return false;
    }
}
