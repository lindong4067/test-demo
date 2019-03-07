package com.example.testpractice.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // demo 1
        UserManagerInterface userManager = (UserManagerInterface) Naming.lookup("//localhost:2002/userManager");
        System.out.println("Username is: " + userManager.getUserName());
        System.out.println("Password is: " + userManager.getAdminAccount().getPassword());

        // demo 2
        Registry registry = LocateRegistry.getRegistry("localhost",2002);
        UserManagerInterface userManager2 = (UserManagerInterface) registry.lookup("userManager");
        System.out.println("Username is: " + userManager2.getUserName());
        System.out.println("Password is: " + userManager2.getAdminAccount().getPassword());

    }
}
