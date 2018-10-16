package com.example.testframe.akka.getstart;

import akka.actor.*;

public class HelloActor extends UntypedAbstractActor {

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String){
            String msg = "HelloActor : Received " + message;
            getSender().tell(msg, self());
        }else {
            unhandled(message);
        }
    }
}
