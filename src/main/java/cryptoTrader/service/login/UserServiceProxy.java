package cryptoTrader.service.login;

public class UserServiceProxy implements UserServiceInterFace {

    @Override
    public boolean authenticate(String userName, String password) {

        UserService authen = new UserService();
        return authen.authenticate(userName, password);
    }

}
