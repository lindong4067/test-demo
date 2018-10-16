package com.example.testframe.akka.getstart;

import akka.actor.UntypedAbstractActor;

public class ResponseActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String){
            String msg = "ResponseActor : Received " + message;
            getSender().tell(msg, self());
        }else {
            unhandled(message);
        }
    }
}
