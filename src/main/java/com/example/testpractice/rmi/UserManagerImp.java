package com.example.testpractice.rmi;

import java.rmi.RemoteException;

public class UserManagerImp implements UserManagerInterface {

    private static final long serialVersionUID = -3111492742628447261L;

    public UserManagerImp() throws RemoteException{
    }

    @Override
    public String getUserName() throws RemoteException {
        return "TT";
    }

    @Override
    public Account getAdminAccount() throws RemoteException {
        Account account = new Account();
        account.setUsername("TT");
        account.setPassword("123456");
        return account;
    }
}
