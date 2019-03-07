package com.example.testpractice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserManagerInterface extends Remote {
    public String getUserName() throws RemoteException;
    public Account getAdminAccount() throws RemoteException;
}
