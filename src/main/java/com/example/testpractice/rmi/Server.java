package com.example.testpractice.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        UserManagerImp userManagerImp = new UserManagerImp();
        UserManagerInterface userManagerInterface = (UserManagerInterface) UnicastRemoteObject.exportObject(userManagerImp, 0);
        Registry registry = LocateRegistry.createRegistry(2002);

        registry.rebind("userManager", userManagerInterface);
        System.out.println("Server is ready...");
    }
}
